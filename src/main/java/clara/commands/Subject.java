package clara.commands;

import java.util.ArrayList;

public class Subject {
    private String name;

    private ArrayList<String> perms;

    private static ArrayList<String[]> acceptedAlts;


    public Subject(String name) {
        this.name = name;

        perms = new ArrayList<>();

        acceptedAlts = new ArrayList<>();
        acceptedAlts.add(new String[]{"applications", "application", "apps", "app"});
        acceptedAlts.add(new String[]{"logs", "log"});
        acceptedAlts.add(new String[]{"clusters", "cluster"});
        acceptedAlts.add(new String[]{"accounts", "account", "accts", "acct"});
    }


    public String getName() {
        return name;
    }


    public ArrayList<String> getPerms() {
        return perms;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void updatePerms(String action, String resource, String allow) {
        String perm = standardizePerm(action.toLowerCase(), resource.toLowerCase(), allow.toLowerCase());
        addPerm(perm);
    }


    public String standardizePerm(String action, String resource, String allow) { // what if resource aint existent
        String perm = "";
        for (String[] inner : acceptedAlts) {
            for (String s : inner) {
                if (resource.equalsIgnoreCase(s)) {
                    perm = inner[0];
                    return action + "-" + perm + "-" + allow;
                }
            }
        }
        return action + "-" + resource + "-" + allow;

    }


    public void addPerm(String perm) {
        String[] parts = perm.split("-");
        String check = parts[0] + "-" + parts[1];
        boolean dontAdd = false;

        for (int i = 0; i < perms.size(); i++) {
            if (perms.get(i).equals(perm)) {
                dontAdd = true;
                break;
            } else {
                if (perms.get(i).startsWith(check)) {
                    dontAdd = true;
                    perms.remove(i);
                    break;
                }
            }
        }

        if (!dontAdd) {
            perms.add(perm);
        }
    }


    public boolean isAllowed(String perm) {
        String[] parts = perm.split("-");
        String stdPerm = standardizePerm(parts[0], parts[1], "");

        for (String p : perms) {
            if (p.startsWith(stdPerm.substring(0, stdPerm.length()-1))) {
                return !p.endsWith("deny");
            }
        }
        return false;
    }


    public String toString() {
        StringBuilder s = new StringBuilder(getName() + "\n");
        for (String p : perms) {
            s.append(p).append("\n");
        }
        return s.toString();
    }

}
