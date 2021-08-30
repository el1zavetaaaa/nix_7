package utils;

import entity.Date;

import static utils.IsLeapYear.isLeapYear;

public class ConvertToMillis {

    static private final long MILLISECONDS = 1;
    static private final long SECOND = MILLISECONDS * 1000;
    static private final long MINUTE = SECOND * 60;
    static private final long HOUR = MINUTE * 60;
    static private final long DAY = HOUR * 24;

    static private final long YEAR = DAY * 365;
    static private final long LEAP_YEAR = YEAR + DAY;

    static public long secondsToMillis(long seconds) {
        return SECOND * seconds;
    }

    static public long minutesToMillis(long minutes) {
        return MINUTE * minutes;
    }

    static public long hoursToMillis(long hours) {
        return HOUR * hours;
    }

    static public long daysToMillis(long days) {
        return DAY * days;
    }

    static public long yearsToMillis(int year) {
        int leapYears = year / 4 - (year / 100) + year / 400;
        int commonYears = year - leapYears;

        long leapMilli = LEAP_YEAR * leapYears;
        long commonMilli = YEAR * commonYears;

        return commonMilli + leapMilli;
    }

    private static long monthToMillis(int numberOfMonth, int year) {

        long monthMillis = 0;
        numberOfMonth--;
        switch (numberOfMonth) {
            case 0:
                break;
            default:
                monthMillis += ConvertToMillis.daysToMillis(31);
                monthMillis += monthToMillis(numberOfMonth, year);
            case 2:
                if (isLeapYear(year)) {

                    monthMillis += ConvertToMillis.daysToMillis(29);
                } else {
                    monthMillis += ConvertToMillis.daysToMillis(28);
                }
                monthMillis += monthToMillis(numberOfMonth, year);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                monthMillis += ConvertToMillis.daysToMillis(30);
                monthMillis += monthToMillis(numberOfMonth, year);
                break;
        }


        return monthMillis;

    }

    public static long dateIntoMillis(Date date) {
        long resultMillis = 0;

        resultMillis += yearsToMillis(date.getYear());
        resultMillis += monthToMillis(date.getMonth(), date.getYear());
        resultMillis += daysToMillis(date.getDay());
        resultMillis += hoursToMillis(date.getHours());
        resultMillis += minutesToMillis(date.getMinutes());
        resultMillis += secondsToMillis(date.getSeconds());
        resultMillis += date.getMilliseconds();

        return resultMillis;
    }

}
