package clara.wildfly;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import clara.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Finds dependencies in module.xml files using a DOM parser.
 *
 * @see FindModuleDuplicates
 */
public class FindModuleDependencies extends FindModuleDuplicates {

    public static void main(String[] args) {
        FindModuleDependencies findModuleDependencies = new FindModuleDependencies();
        List<String> paths = new ArrayList<>();
        String dir = args[0];
        String fileSep = System.getProperty("file.separator");

        if (! args[0].endsWith(fileSep)) {
            dir = args[0] + fileSep;
        }

        findFiles(new File(dir), paths, "module.xml");

        for (String s : paths) {
            File f = new File(s);
            List<String> dependencies = findModuleDependencies.findDependencies(f);
            List<String> duplicates = StringUtils.findDuplicates(dependencies);

            if (!duplicates.isEmpty()) {
                System.out.printf("File path: %s%n", s.replace(dir, ""));
                System.out.println("Duplicates:");
                duplicates.forEach(d -> System.out.printf("%s%n%n", d));
            }
        }
    }

    /**
     * Creates a list of dependencies in the {@code module.xml} file using a DOM parser.
     *
     * @param moduleFile the {@code module.xml} file to be looked through
     * @return a list of strings representing dependencies
     * @see FindModuleDuplicates#findDependencies(File moduleFile)
     */
    @Override
    public List<String> findDependencies(File moduleFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<String> dependencyNames = new ArrayList<>();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(moduleFile);
            NodeList dependencies = document.getElementsByTagName("module");

            for (int i = 0; i < dependencies.getLength(); i++) {
                Element element = (Element) dependencies.item(i);
                dependencyNames.add(element.getAttribute("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dependencyNames;
    }
}
