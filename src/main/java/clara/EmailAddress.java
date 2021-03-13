package clara;

import java.util.Objects;

public class EmailAddress {
    private String username;
    private String domain;

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

    @Override
    public String toString() {
        return "EmailAddress{" +
                "username='" + username + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress that = (EmailAddress) o;
        return Objects.equals(username, that.username) && Objects.equals(domain, that.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, domain);
    }

    private boolean verifyUsername(String username) {
        return !username.contains(" ") && !username.contains("@");
    }

    private boolean verifyDomain(String domain) {
        return domain.contains(".") && !domain.contains(" ") && !domain.contains("@") && !domain.endsWith(".");
    }
}
