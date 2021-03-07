package clara;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class TimeTest {

    @Test
    public void getterSetterTest() {
        Time time = new Time(12, 24, 13, 98);

        assertEquals(12, time.getHours());
        assertEquals(24, time.getMinutes());
        assertEquals(13, time.getSeconds());
        assertEquals(98, time.getMilliseconds());

        int newHours = 23;
        time.setHours(newHours);
        assertEquals(newHours, time.getHours());

        int newMinutes = 54;
        time.setMinutes(newMinutes);
        assertEquals(newMinutes, time.getMinutes());

        int newSeconds = 41;
        time.setSeconds(newSeconds);
        assertEquals(newSeconds, time.getSeconds());

        int newMilliseconds = 190;
        time.setMilliseconds(newMilliseconds);
        assertEquals(newMilliseconds, time.getMilliseconds());

        try {
            time.setMinutes(-23);
            fail("Unexpected argument: " + -23);
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            time.setMinutes(-32);
            fail("Unexpected argument: " + -32);
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            time.setSeconds(-24);
            fail("Unexpected argument: " + -24);
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            time.setMilliseconds(-9);
            fail("Unexpected argument: " + -9);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void currentTimeTest() {
        Calendar calendar = GregorianCalendar.getInstance();
        LocalDateTime currentTime = LocalDateTime.now();
        Time time = new Time(currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond(), calendar.get(Calendar.MILLISECOND));
        Time currentTime1 = Time.getCurrentTime();
        assertEquals(time.getHours(), currentTime1.getHours());
        assertEquals(time.getMinutes(), currentTime1.getMinutes());
        assertEquals(time.getSeconds(), currentTime1.getSeconds());
    }

    @Test
    public void addTest() {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        TimeZone gmt = TimeZone.getTimeZone("GMT");
        Time time = new Time(10, 20, 98, 987, utc);
        Time time1 = new Time(22, 16, 23, 180);
        Time time2 = new Time(32, 38, 2, 167, utc);
        Time time3 = new Time(32, 38, 2, 167, gmt);
        Time time4 = new Time(22, 16, 23, 180, gmt);

        try {
            assertEquals(time2, time.add(time1));
        } catch (AssertionError e) {
            assertEquals(time3, time.add(time1));
        }

        time.setHours(0);
        time.setMinutes(0);
        time.setSeconds(0);
        time.setMilliseconds(0);
        time1.setHours(22);
        time1.setMinutes(16);

        try {
            assertEquals(time1, time.add(time1));
        } catch (AssertionError e) {
            assertEquals(time4, time.add(time1));
        }
    }

    @Test
    public void subtractTest() {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        TimeZone newYork = TimeZone.getTimeZone("America/New_York");
        Time time = new Time(13, 22, 90, 7, newYork);
        Time time1 = new Time(33, 21, 9, 34, utc);

        assertEquals(-53859027, time.subtract(time1));

        time.setHours(43);
        assertEquals(54140973, time.subtract(time1));
    }
}
