package clara;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RequestTypeTest {
    @Test
    public void testRequestTypeId() {
        assertEquals(RequestType.GET, RequestType.getRequestType('g'));
        assertEquals(RequestType.POST, RequestType.getRequestType('p'));
        assertEquals(RequestType.DELETE, RequestType.getRequestType('d'));
        assertEquals(RequestType.INFO, RequestType.getRequestType('i'));
        assertEquals(RequestType.TRACE, RequestType.getRequestType('t'));
        assertEquals(RequestType.CANCEL, RequestType.getRequestType('c'));

        assertEquals(RequestType.UNKNOWN, RequestType.getRequestType('a'));
        assertEquals(RequestType.UNKNOWN, RequestType.getRequestType('b'));
        assertEquals(RequestType.UNKNOWN, RequestType.getRequestType('z'));
        assertEquals(RequestType.UNKNOWN, RequestType.getRequestType('o'));
    }

    @Test
    public void testRequestTypeCode() {
        assertEquals(RequestType.GET, RequestType.getRequestType(100));
        assertEquals(RequestType.POST, RequestType.getRequestType(200));
        assertEquals(RequestType.DELETE, RequestType.getRequestType(300));
        assertEquals(RequestType.INFO, RequestType.getRequestType(400));
        assertEquals(RequestType.TRACE, RequestType.getRequestType(500));
        assertEquals(RequestType.CANCEL, RequestType.getRequestType(600));

        assertEquals(RequestType.UNKNOWN, RequestType.getRequestType(2));
        assertEquals(RequestType.UNKNOWN, RequestType.getRequestType(0));
        assertEquals(RequestType.UNKNOWN, RequestType.getRequestType(5000));
        assertEquals(RequestType.UNKNOWN, RequestType.getRequestType(-1234));
    }
}
