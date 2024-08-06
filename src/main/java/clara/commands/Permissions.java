package clara.commands;

import clara.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Permissions {

    private static File file;
    private static ArrayList<Subject> subjects = new ArrayList<>();


    public static void main(String[] args) {
        int fileIndex = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].toLowerCase().startsWith("--policy-file")) {
                fileIndex = i;
            }
        }

        if (fileIndex == 0 || fileIndex == 3) {
            String name, perm;
            if (fileIndex == 3) {
                name = args[0];
                perm = args[1] + "-" + args[2];
            } else {
                name = args[1];
                perm = args[2] + "-" + args[3];
            }

            try {
                file = new File(args[fileIndex].substring(14));

            } catch (Exception e) {
                try {
                    file = new File(args[fileIndex + 1]);
                    if (fileIndex == 0) {
                        name = args[2];
                        perm = args[3] + "-" + args[4];
                    }
                } catch (Exception e1) {
                    System.out.println("Please include a valid file path.");
                }
            }

            try {
                ReadData(file);
                boolean allowed = isAllowed(name, perm);
                if (allowed) {
                    System.out.println(name + " is allowed to " + perm.replace("-", " ") + ".");
                } else {
                    System.out.println(name + " is not allowed to " + perm.replace("-", " ") + ".");
                }
            } catch (Exception e) {
                System.out.println("File could not be found at " + file.getAbsolutePath() + ".");
            }

        } else {
            System.out.println("Please include the path of the csv file.");
        }


    }


    public static void ReadData(File file) throws IOException {
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
                    String name = perms[1];
                    String resource = perms[2];
                    String action = perms[3];
                    String allow = perms[4];
                    boolean subjExist = false;

                    for (Subject s : subjects) {
                        if (s.getName().equals(name)) {
                            s.updatePerms(action, resource, allow);
                            subjExist = true;
                            break;
                        }
                    }

                    if (!subjExist) {
                        Subject newSubj = new Subject(name);
                        newSubj.updatePerms(action, resource, allow);
                        subjects.add(newSubj);
                    }
                }
            }

        }
        finally {
            ResourceUtils.closeResource(fileReader);
            ResourceUtils.closeResource(bufferedReader);
        }

    }


    public static boolean isAllowed(String name, String perm) {
        Subject subject = null;
        for (Subject s : subjects) {
            if (s.getName().equalsIgnoreCase(name)) {
                subject = s;
            }
        }

        if (subject == null) {
            return false;
        }

        return subject.isAllowed(perm);
    }

}
