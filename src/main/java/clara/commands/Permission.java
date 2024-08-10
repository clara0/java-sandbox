package clara.commands;

/**
 * Represents permission for a subject to perform a certain action on a certain resource
 * */
public record Permission(String subject, String resource, String action, boolean allow) {

    /**
     * Checks if two Permissions have the same subject, resource, and action
     * */
    public boolean equals(Permission other) {
        return other.subject.equals(subject) &&
                other.resource.equals(resource) &&
                other.action.equals(action);
    }

    public String toString() {
        return subject + (allow ? " can " : " cannot ") + action + " " + resource;
    }
}
