package clara.commands;

public record Permission(String subject, String resource, String action, boolean allow) {

    public boolean equals(Permission other) {
        return other.subject.equals(subject) &&
                other.resource.equals(resource) &&
                other.action.equals(action);
    }

    public String toString() {
        return subject + (allow ? " can " : " cannot ") + action + " " + resource;
    }
}
