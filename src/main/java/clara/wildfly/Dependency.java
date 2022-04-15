package clara.wildfly;

import java.util.Objects;

public class Dependency {
    String groupId;
    String artifactId;
    String classifier;
    String type;

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Dependency) {
            Dependency otherDependency = (Dependency) other;
            return Objects.equals(this.getGroupId(), otherDependency.getGroupId()) &&
                    Objects.equals(this.getArtifactId(), otherDependency.getArtifactId()) &&
                    Objects.equals(this.getClassifier(), otherDependency.getClassifier()) &&
                    Objects.equals(this.getType(), otherDependency.getType());
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("groupId: %s    artifactId: %s    classifier: %s    type: %s\n", groupId, artifactId,
                classifier, type);
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getClassifier() {
        return classifier;
    }

    public String getType() {
        return type;
    }

}
