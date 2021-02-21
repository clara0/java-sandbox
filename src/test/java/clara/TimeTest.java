package clara;

import org.junit.Test;

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
    public void addTest() {
        Time time = new Time(10, 20, 98, 987);
        Time time1 = new Time(21, 76, 23, 180);
        Time time2 = new Time(32, 38, 2, 167);

        assertEquals(time2, time.addTime(time1));

        time.setHours(0);
        time.setMinutes(0);
        time.setSeconds(0);
        time.setMilliseconds(0);
        time1.setHours(22);
        time1.setMinutes(16);
        assertEquals(time1, time.addTime(time1));
    }

    @Test
    public void subtractTest() {
        Time time = new Time(13, 22, 90, 7);
        Time time1 = new Time(33, 21, 9, 34);

        assertEquals(-71859027, time.subtractTime(time1));

        time.setHours(43);
        assertEquals(36140973, time.subtractTime(time1));
    }
}
