package clara.wildfly;

import static clara.wildfly.FindModuleDuplicates.findFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import clara.util.StringUtils;
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
            List<String> duplicates = new ArrayList<>();
            File f = new File(s);
            List<List<String>> dependencies = pomDependencies.findDependencies(f);
            for (List<String> l : dependencies) {
                List<String> d = StringUtils.findDuplicates(l);
                if (!d.isEmpty())
                    duplicates.addAll(d);
            }

            if (! duplicates.isEmpty()) {
                System.out.printf("File path: %s%n", s.replace(dir, ""));
                System.out.println("Duplicates:");
                for (String str : duplicates) {
                    String[] ids = str.split(":");
                    if (ids.length > 2) {
                        if (ids.length > 3) {
                            if (Objects.equals(ids[3], "type")) {
                                System.out.printf("groupId: %s    artifactId: %s    type:%s%n",
                                        ids[0], ids[1], ids[2]);
                            } else {
                                System.out.printf("groupId: %s    artifactId: %s    classifier:%s    type:%s%n",
                                        ids[0], ids[1], ids[2], ids[3]);
                            }
                        } else {
                            System.out.printf("groupId: %s    artifactId: %s    classifier:%s%n", ids[0], ids[1], ids[2]);
                        }
                    } else {
                        System.out.printf("groupId: %s    artifactId: %s%n", ids[0], ids[1]);
                    }
                }
                System.out.printf("%n");
            }
        }
    }

    /**
     * Finds all the dependencies in each dependencies element.
     * @param pomFile pom.xml file to be checked
     * @return list of dependencies in each dependencies element in the pom.xml file
     */
    public List<List<String>> findDependencies(File pomFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<List<String>> dependencyIds = new ArrayList<>();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(pomFile);
            NodeList dependenciesElements = document.getElementsByTagName("dependencies");

            for (int i = 0; i < dependenciesElements.getLength(); i++) {
                Element dependenciesElement = (Element) dependenciesElements.item(i);
                NodeList dependencies = dependenciesElement.getElementsByTagName("dependency");
                List<String> idList = findDependencyIds(dependencies);
                dependencyIds.add(idList);
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
    public List<String> findDependencyIds(NodeList dependencies) {
        List<String> idList = new ArrayList<>();
        for (int i = 0; i < dependencies.getLength(); i++) {
            Element dependency = (Element) dependencies.item(i);
            NodeList classifier = dependency.getElementsByTagName("classifier");
            NodeList type = dependency.getElementsByTagName("type");
            if (classifier.getLength() > 0) {
                if (type.getLength() > 0) {
                    idList.add(dependency.getElementsByTagName("groupId").item(0).getTextContent() + ":" +
                            dependency.getElementsByTagName("artifactId").item(0).getTextContent() + ":" +
                            dependency.getElementsByTagName("classifier").item(0).getTextContent() + ":" +
                            dependency.getElementsByTagName("type").item(0).getTextContent());
                } else {
                    idList.add(dependency.getElementsByTagName("groupId").item(0).getTextContent() + ":" +
                            dependency.getElementsByTagName("artifactId").item(0).getTextContent() + ":" +
                            dependency.getElementsByTagName("classifier").item(0).getTextContent());
                }
            } else {
                if (type.getLength() > 0) {
                    idList.add(dependency.getElementsByTagName("groupId").item(0).getTextContent() + ":" +
                            dependency.getElementsByTagName("artifactId").item(0).getTextContent() + ":" +
                            dependency.getElementsByTagName("type").item(0).getTextContent() + ":" +
                            "type");
                } else {
                    idList.add(dependency.getElementsByTagName("groupId").item(0).getTextContent() + ":" +
                            dependency.getElementsByTagName("artifactId").item(0).getTextContent());
                }
            }
        }
        return idList;
    }

}
