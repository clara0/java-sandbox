package clara;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    private long milliseconds;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Unexpected input: " + hours + "\nAmount of hours must not be negative");
        }
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Unexpected input: " + minutes + "\nAmount of minute must not be negative");
        }
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Unexpected input: " + seconds + "\nAmount of seconds must not be negative");
        }
        this.seconds = seconds;
    }

    public void setMilliseconds(int milliseconds) {
        if (milliseconds < 0) {
            throw new IllegalArgumentException("Unexpected input: " + milliseconds + "\nAmount of milliseconds must not be negative");
        }
        this.milliseconds = milliseconds;
    }

    @Override
    public String toString() {
        return "Time: " + hours + ":" + minutes + ":" + seconds + ":" + milliseconds;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Time) {
            Time otherTime = (Time) other;
            return this.hours == otherTime.hours &&
                    this.minutes == otherTime.minutes &&
                    this.seconds == otherTime.seconds &&
                    this.milliseconds == otherTime.milliseconds;
        }
        return false;
    }

    public Time(int hours, int minutes, int seconds, long milliseconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }

    public static Time getCurrentTime() {
        Calendar calendar = GregorianCalendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);
        int currentSecond = calendar.get(Calendar.SECOND);
        long currentMillisecond = calendar.get(Calendar.MILLISECOND);
        return new Time(currentHour, currentMinute, currentSecond, currentMillisecond);
    }

    public Time add(Time other) {
        long convertedMilliseconds = toMilliseconds();
        long otherConvertedMilliseconds = other.toMilliseconds();
        return convertToTime(convertedMilliseconds + otherConvertedMilliseconds);
    }

    public long subtract(Time other) {
        long convertedMilliseconds = toMilliseconds();
        long otherConvertedMilliseconds = other.toMilliseconds();
        return convertedMilliseconds - otherConvertedMilliseconds;
    }

    public long toMilliseconds() {
        long convertedHours = TimeUnit.HOURS.toMillis(hours);
        long convertedMinutes = TimeUnit.MINUTES.toMillis(minutes);
        long convertedSeconds = TimeUnit.SECONDS.toMillis(seconds);
        return convertedHours + convertedMinutes + convertedSeconds + milliseconds;
    }

    public static Time convertToTime(long milliseconds) {
        long absMilliseconds = Math.abs(milliseconds);
        int amtHours = (int) (absMilliseconds / 3600000);
        int amtMinutes = (int) ((absMilliseconds - 3600000 * amtHours) / 60000);
        int amtSeconds = (int) ((absMilliseconds - (3600000 * amtHours + 60000 * amtMinutes)) / 1000);
        long amtMilliseconds = absMilliseconds - (3600000L * amtHours + 60000L * amtMinutes + 1000L * amtSeconds);

        return new Time(amtHours, amtMinutes, amtSeconds, amtMilliseconds);
    }
}
