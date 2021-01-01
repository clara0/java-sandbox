package clara;

import java.util.Objects;

public class EmailAddress {
    private String username;
    private String domain;

    @Override
    public String toString() {
        return "Email Address: Username: " + this.username + ", Domain: " + this.domain;
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

    private boolean verifyUsername(String username) {
        return !username.contains(" ") && !username.contains("@");
    }

    private boolean verifyDomain(String domain) {
        return domain.contains(".") && !domain.contains(" ") && !domain.contains("@") && !domain.endsWith(".");
    }

    public EmailAddress() {
    }

    public EmailAddress(String username, String domain) {
        if (!verifyUsername(username)) {
            throw new IllegalArgumentException("Invalid Username: " + username);
        }

        if (!verifyDomain(domain)) {
            throw new IllegalArgumentException("Invalid Domain: " + domain);
        }
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
        if (!verifyUsername(username)) {
            throw new IllegalArgumentException("Invalid Username: " + username);
        }
        this.username = username;
    }

    public void setDomain(String domain) {
        if (!verifyDomain(domain)) {
            throw new IllegalArgumentException("Invalid Domain: " + domain);
        }
        this.domain = domain;
    }

    public static String getEmail(String username, String domain) {
        EmailAddress emailAddress = new EmailAddress();
        if (!emailAddress.verifyUsername(username)) {
            throw new IllegalArgumentException("Invalid Username: " + username);
        }

        if (!emailAddress.verifyDomain(domain)) {
            throw new IllegalArgumentException("Invalid Domain: " + domain);
        }

        return username + "@" + domain;
    }
}
