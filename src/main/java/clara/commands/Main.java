package clara.commands;

import java.io.File;
import java.io.IOException;

public class Main {

    /**
     * Reads a csv file of permissions and checks if a subject has permission to perform a provided task.
     * The csv file path should be provided with either {@code --policy-file={insert file path here}} or {@code
     * --policy-file {insert file path here}} at either the beginning or end of the arguments given. The permission to
     * be checked should be provided in the order of subject, action, resource.
     * */
    public static void main(String[] args) throws IOException {
        int fileIndex = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].toLowerCase().startsWith("--policy-file")) {
                fileIndex = i;
            }
        }

        if (fileIndex == 0 || fileIndex == 3) {
            String subject, resource, action;
            if (fileIndex == 3) {
                subject = args[0];
                resource = args[2];
                action = args[1];
            } else {
                subject = args[1];
                resource = args[3];
                action = args[2];
            }

            File file = new File(args[fileIndex].substring(14));

            if (!file.exists()) {
                file = new File(args[fileIndex + 1]);

                if (fileIndex == 0) {
                    subject = args[2];
                    resource = args[4];
                    action = args[3];
                }
            }

            PolicyFile policyFile = new PolicyFile(file);
            Permission check = policyFile.createPermission(subject, resource, action, true);

            if (check != null) {
                boolean allowed = policyFile.isAllowed(check);

                if (allowed) {
                    System.out.println(check);
                } else {
                    System.out.println(subject + " cannot " + action + " " + resource);
                }
            } else {
                System.out.println("Enter a valid permission to check for.");
            }


        } else {
            System.out.println("Use --policy-file to specify location of permissions file.");
        }
    }

}