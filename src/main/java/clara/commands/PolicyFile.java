package clara.commands;

import clara.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PolicyFile {

    // defaults for resources and actions
    private static final String[][] resources = {
            {"applications", "application", "apps", "app"},
            {"logs", "log"},
            {"clusters", "cluster"},
            {"accounts", "account", "accts", "acct"}
    };

    private static final String[] actions = {"get", "create", "update", "delete", "sync"};

    private ArrayList<Permission> permissions = new ArrayList<>();
    private HashMap<String, String> validResource = new HashMap<>();
    private ArrayList<String> validAction = new ArrayList<>();

    private File file;

    public PolicyFile(File file, String[][] validResource, String[] validAction) throws IOException {
        this.file = file;

        for (String[] resourceAlts : validResource) {
            for (String resource : resourceAlts) {
                this.validResource.put(resource, resourceAlts[0]);
            }
        }

        this.validAction.addAll(Arrays.asList(validAction));

        ReadData();
    }

    public PolicyFile(File file) throws IOException {
        this(file, resources, actions);
    }


    public void ReadData() throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] perms;

            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("p")) {
                    perms = line.split(",");
                    String subject = perms[1].toLowerCase();
                    String resource = perms[2].toLowerCase();
                    String action = perms[3].toLowerCase();
                    boolean allow = perms[4].equalsIgnoreCase("allow");

                    addPermission(subject, resource, action, allow);
                }
            }
        }
        finally {
            ResourceUtils.closeResource(fileReader);
            ResourceUtils.closeResource(bufferedReader);
        }

    }

    public boolean isAllowed(Permission check) {
        for (Permission p : permissions) {
            if (p.equals(check)) {
                return p.allow();
            }
        }

        return false;
    }

    public boolean addPermission(String subject, String resource, String action, boolean allow) {

        Permission newPerm = createPermission(subject, resource, action, allow);

        if (newPerm == null) {
            return false;
        }

        for (int i = 0; i < permissions.size(); i++) {
            Permission p = permissions.get(i);
            if (p.equals(newPerm)) {
                if (p.allow() && !newPerm.allow()) {
                    permissions.remove(i);
                    break;
                }
                return false;
            }
        }

        permissions.add(newPerm);
        return true;
    }

    public Permission createPermission(String subject, String resource, String action, boolean allow) {
        String r = validResource.get(resource);
        boolean a = validAction.contains(action);

        if (r == null || !a) {
            return null;
        }

        return new Permission(subject, r, action, allow);
    }
}