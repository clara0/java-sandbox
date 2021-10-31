package clara.wildfly;

import clara.util.ResourceUtils;
import clara.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Finds module.xml files in a directory recursively and dependency duplicates
 * inside each module file.
 */
public class FindModuleDuplicates {

    public static void main(String[] args) throws IOException {
        FindModuleDuplicates findModuleDuplicates = new FindModuleDuplicates();
        List<String> paths = new ArrayList<>();
        String dir = args[0];
        String fileSep = System.getProperty("file.separator");

        if (! args[0].endsWith(fileSep)) {
            dir = args[0] + fileSep;
        }

        findModuleFiles(new File(dir), paths);

        for (String s : paths) {
            File f = new File(s);
            List<String> dependencies = findModuleDuplicates.findDependencies(f);
            List<String> duplicates = StringUtils.findDuplicates(dependencies);

            if (! duplicates.isEmpty()) {
                System.out.printf("File path: %s%n", s.replace(dir, ""));
                System.out.println("Duplicates:");
                duplicates.forEach(d -> System.out.printf("%s%n%n", d));
            }
        }
    }

    /**
     * Recursively finds all files named {@code module.xml} in a directory.
     *
     * @param startingDir directory in which search starts
     */
    public static void findModuleFiles(File startingDir, List<String> paths) {

        File[] filesList = startingDir.listFiles();

        assert filesList != null;
        for (File f : filesList) {
            if (f.isFile()) {
                if (f.getName().equals("module.xml")) {
                    paths.add(f.getAbsolutePath());
                }
            } else {
                findModuleFiles(f, paths);
            }
        }

    }

    /**
     * Creates a list of dependencies in the {@code module.xml} file.
     *
     * @param moduleFile the {@code module.xml} file to be looked through
     * @return a list of strings representing dependencies
     * @throws IOException if input/output error occurs
     */
    public List<String> findDependencies(File moduleFile) throws IOException {

        List<String> dependencies = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(moduleFile);
            bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.startsWith("<module ")) {
                    int startIndex = trimmedLine.indexOf("name=\"");
                    String newLine = trimmedLine.substring(startIndex + 6);
                    int endIndex = newLine.indexOf("\"");

                    String dependency = newLine.substring(0, endIndex);
                    dependencies.add(dependency);
                }
            }

        } finally {
            ResourceUtils.closeResource(fileReader);
            ResourceUtils.closeResource(bufferedReader);
        }

        return dependencies;
    }
}
