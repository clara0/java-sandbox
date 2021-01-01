package clara;

import java.util.Objects;

public class EmailAddress {
    private String username;
    private String domain;

    @Override
    public String toString() {
        return "Username: " + this.username + ", Domain: " + this.domain;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EmailAddress) {
            EmailAddress otherEmail = (EmailAddress) other;
            return Objects.equals(this.username, otherEmail.username) &&
                    this.domain.equals(otherEmail.domain);
        }
        return false;
    }

    public EmailAddress() {
    }

    public EmailAddress(String username, String domain) {
        this.username = username;
        this.domain = domain;
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public static String getEmail(String username, String domain) {
        if (!domain.contains(".") || domain.endsWith(".") || domain.contains(" ") || domain.contains("@")
        || username.contains(" ") || username.contains("@")) {
            throw new IllegalArgumentException("Illegal Arguments:" + username + ", " + domain);
        }

        return username + "@" + domain;
    }
}
