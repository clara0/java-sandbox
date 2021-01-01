package clara;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailAddressTest {

    @Test
    public void emailAddress() {
        EmailAddress emailAddress = new EmailAddress();

        assertNull(emailAddress.getUsername());
        assertNull(emailAddress.getDomain());

        String newUsername = "name";
        emailAddress.setUsername(newUsername);
        assertEquals(newUsername, emailAddress.getUsername());

        String newDomain = "here.com";
        emailAddress.setDomain(newDomain);
        assertEquals(newDomain, emailAddress.getDomain());

        assertEquals("name@here.com", EmailAddress.getEmail(emailAddress.getUsername(), emailAddress.getDomain()));

        try {
            String username = "name here@";
            String domain = "ab@ c";
            EmailAddress.getEmail(username, domain);
            fail("Illegal Arguments:" + username + ", " + domain);
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    @Test
    public void emailAddress1() {
        EmailAddress emailAddress = new EmailAddress("bob.smith", "gmail.com");

        assertEquals("bob.smith", emailAddress.getUsername());
        assertEquals("gmail.com", emailAddress.getDomain());

        String newUsername = "eliza";
        emailAddress.setUsername(newUsername);
        assertEquals(newUsername, emailAddress.getUsername());

        String newDomain = "yahoo.com";
        emailAddress.setDomain(newDomain);
        assertEquals(newDomain, emailAddress.getDomain());

        assertEquals("eliza@yahoo.com", EmailAddress.getEmail(emailAddress.getUsername(), emailAddress.getDomain()));

        try {
            String username = "wrong form@t";
            String domain = "po@f.com";
            EmailAddress.getEmail(username, domain);
            fail("Illegal Arguments:" + username + ", " + domain);
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }
}
