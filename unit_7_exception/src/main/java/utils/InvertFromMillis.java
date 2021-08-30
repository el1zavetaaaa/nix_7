package utils;

import entity.Date;

import static utils.IsLeapYear.isLeapYear;

public class InvertFromMillis {

    private static final double MILLISECONDS = 1;
    private static final double SECOND = MILLISECONDS / 1000;
    private static final double MINUTE = SECOND / 60;
    private static final double HOUR = MINUTE / 60;
    private static final double DAY = HOUR / 24;

    private static final long YEAR = 31536000000L;
    private static final long LEAP_YEAR = 31622400000L;
    private static final int[] MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static double toSeconds(long milliseconds) {
        return (SECOND * milliseconds);
    }

    public static double toMinutes(long milliseconds) {
        return (MINUTE * milliseconds);
    }

    public static double toHours(long milliseconds) {
        return HOUR * milliseconds;
    }

    public static double toDays(long milliseconds) {
        return (DAY * milliseconds);
    }

    static public double toYears(long milliseconds) {
        double years = 0;
        int count = 1;
        while (true) {
            if (milliseconds == 0) return years;
            if (isLeapYear(count)) {
                if (milliseconds >= LEAP_YEAR) {
                    milliseconds -= LEAP_YEAR;
                    years++;
                } else {
                    years += toDays(milliseconds) / 366;
                    milliseconds = 0;
                }
            } else {
                if (milliseconds >= YEAR) {
                    milliseconds -= YEAR;
                    years++;
                } else {
                    years += toDays(milliseconds) / 365;
                    milliseconds = 0;
                }
            }
            count++;
        }
    }

    public static Date toDate(long milliseconds) {
        Date date = new Date();

        long amountOfMillis = milliseconds;
        long amountOfSeconds = amountOfMillis / 1000;
        long amountOfMinutes = amountOfSeconds / 60;
        long amountOfHours = amountOfMinutes / 60;
        long amountOfDays = amountOfHours / 24;

        int amountOfMonths = 0;
        int amountOfYears = 0;
        int currentMonth = 0;
        long tempDays = amountOfDays;

        while (tempDays > MONTH_DAYS[currentMonth]) {
            tempDays -= MONTH_DAYS[currentMonth];
            if (currentMonth == 1) {
                if (isLeapYear(amountOfYears)) {
                    tempDays -= 1;
                }
            }
            currentMonth += 1;
            if (currentMonth > 11) {
                amountOfYears += 1;
                currentMonth = 0;
            }
            amountOfMonths += 1;
        }

        date.setMilliseconds((int) (amountOfMillis % 1000));
        date.setSeconds((int) (amountOfSeconds % 60));
        date.setMinutes((int) (amountOfMinutes % 60));
        date.setHours((int) (amountOfHours % 24));
        date.setDay((int) ((tempDays) % MONTH_DAYS[currentMonth]) + 1);
        date.setMonth(((amountOfMonths) % 12) + 1);
        date.setYear(amountOfYears);
        return date;
    }
}
