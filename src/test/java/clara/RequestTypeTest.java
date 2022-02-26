package clara;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RequestTypeTest {
    @Test
    public void testFromCharId() {
        assertEquals(RequestType.GET, RequestType.fromCharId('g'));
        assertEquals(RequestType.POST, RequestType.fromCharId('p'));
        assertEquals(RequestType.DELETE, RequestType.fromCharId('d'));
        assertEquals(RequestType.INFO, RequestType.fromCharId('i'));
        assertEquals(RequestType.TRACE, RequestType.fromCharId('t'));
        assertEquals(RequestType.CANCEL, RequestType.fromCharId('c'));

        assertEquals(RequestType.UNKNOWN, RequestType.fromCharId('a'));
        assertEquals(RequestType.UNKNOWN, RequestType.fromCharId('b'));
        assertEquals(RequestType.UNKNOWN, RequestType.fromCharId('z'));
        assertEquals(RequestType.UNKNOWN, RequestType.fromCharId('o'));
    }

    @Test
    public void testFromCode() {
        assertEquals(RequestType.GET, RequestType.fromCode(100));
        assertEquals(RequestType.POST, RequestType.fromCode(200));
        assertEquals(RequestType.DELETE, RequestType.fromCode(300));
        assertEquals(RequestType.INFO, RequestType.fromCode(400));
        assertEquals(RequestType.TRACE, RequestType.fromCode(500));
        assertEquals(RequestType.CANCEL, RequestType.fromCode(600));

        assertEquals(RequestType.UNKNOWN, RequestType.fromCode(2));
        assertEquals(RequestType.UNKNOWN, RequestType.fromCode(0));
        assertEquals(RequestType.UNKNOWN, RequestType.fromCode(5000));
        assertEquals(RequestType.UNKNOWN, RequestType.fromCode(-1234));
    }

    @Test
    public void testFromName() {
        assertEquals(RequestType.GET, RequestType.fromName("gEt"));
        assertEquals(RequestType.POST, RequestType.fromName("POST"));
        assertEquals(RequestType.DELETE, RequestType.fromName("delete"));
        assertEquals(RequestType.INFO, RequestType.fromName("infO"));
        assertEquals(RequestType.TRACE, RequestType.fromName("Trace"));
        assertEquals(RequestType.CANCEL, RequestType.fromName("cAnCEL"));

        assertEquals(RequestType.UNKNOWN, RequestType.fromName(""));
        assertEquals(RequestType.UNKNOWN, RequestType.fromName("cat"));
        assertEquals(RequestType.UNKNOWN, RequestType.fromName("DOG"));
        assertEquals(RequestType.UNKNOWN, RequestType.fromName("Cat Dog"));
        assertEquals(RequestType.UNKNOWN, RequestType.fromName("Cat-Dog"));
        assertEquals(RequestType.UNKNOWN, RequestType.fromName("***-Dog"));
    }
}
