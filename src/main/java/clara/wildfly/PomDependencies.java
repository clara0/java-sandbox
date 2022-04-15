package clara.wildfly;

import static clara.wildfly.FindModuleDuplicates.findFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Finds duplicate dependencies in pom.xml files.
 */
public class PomDependencies {
    public static void main(String[] args) {
        PomDependencies pomDependencies = new PomDependencies();
        List<String> paths = new ArrayList<>();
        String dir = args[0];
        String fileSep = System.getProperty("file.separator");

        if (! args[0].endsWith(fileSep)) {
            dir = args[0] + fileSep;
        }

        findFiles(new File(dir), paths, "pom.xml");

        for (String s : paths) {
            List<Dependency> duplicates = new ArrayList<>();
            File f = new File(s);
            List<List<Dependency>> fileDependencies = pomDependencies.findDependencies(f);

            for (List<Dependency> dependencyList : fileDependencies) {
                List<Dependency> dup = PomDependencies.findDuplicates(dependencyList);
                if (!dup.isEmpty()) {
                    duplicates.addAll(dup);
                }
            }
            if (!duplicates.isEmpty()) {
                System.out.printf("File path: %s%n", s.replace(dir, ""));
                System.out.println("Duplicates:");
                duplicates.forEach(d -> System.out.println(d.toString()));
            }
        }
    }

    /**
     * Finds all the dependencies in each dependencies element.
     * @param pomFile pom.xml file to be checked
     * @return list of dependencies in each dependencies element in the pom.xml file
     */
    public List<List<Dependency>> findDependencies(File pomFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<List<Dependency>> dependencyIds = new ArrayList<>();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(pomFile);
            NodeList dependenciesElements = document.getElementsByTagName("dependencies");

            for (int i = 0; i < dependenciesElements.getLength(); i++) {
                Element dependenciesElement = (Element) dependenciesElements.item(i);
                NodeList dependencies = dependenciesElement.getElementsByTagName("dependency");
                dependencyIds.add(findDependencyIds(dependencies));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dependencyIds;
    }

    /**
     * Finds each dependency's groupId, artifactId, and if applicable, classifier and type.
     * @param dependencies {@code NodeList} of dependencies
     * @return list containing strings consisting of each dependency's child elements
     */
    public List<Dependency> findDependencyIds(NodeList dependencies) {
        List<Dependency> dependenciesList = new ArrayList<>();
        for (int i = 0; i < dependencies.getLength(); i++) {
            Dependency dependency = new Dependency();
            Element currentDependency = (Element) dependencies.item(i);
            dependency.setGroupId(currentDependency.getElementsByTagName("groupId").item(0).getTextContent());
            dependency.setArtifactId(currentDependency.getElementsByTagName("artifactId").item(0).getTextContent());
            NodeList classifier = currentDependency.getElementsByTagName("classifier");
            NodeList type = currentDependency.getElementsByTagName("type");

            if (classifier.getLength() > 0) {
                if (type.getLength() > 0) {
                    dependency.setClassifier(classifier.item(0).getTextContent());
                    dependency.setType(type.item(0).getTextContent());
                } else {
                    dependency.setClassifier(classifier.item(0).getTextContent());
                }
            } else {
                if (type.getLength() > 0) {
                    dependency.setType(type.item(0).getTextContent());
                }
            }
            dependenciesList.add(dependency);
        }
        return dependenciesList;
    }

    /**
     * Finds duplicates in list of dependencies.
     * @param dependencyList list of dependencies
     * @return list of duplicate dependencies
     */
    public static List<Dependency> findDuplicates(List<Dependency> dependencyList) {
        List<Dependency> duplicates = new ArrayList<>();

        for (Dependency d : dependencyList) {
            if (dependencyList.indexOf(d) != dependencyList.lastIndexOf(d)) {
                if (! duplicates.contains(d)) {
                    duplicates.add(d);
                }
            }
        }
        return duplicates;
    }

}
