package entity;

import static utils.IsLeapYear.isLeapYear;

public class Date {
    private int milliseconds;
    private int seconds;
    private int minutes;
    private int hours;
    private int day;
    private int month;
    private int year;

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int years) {
        this.year = years;
    }

    private static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date() {
    }

    public static boolean isValid(int year, int month, int day) {
        boolean isValid = true;
        int m = month - 1;

        if (m < 0 || m >= 12) {
            isValid = false;
            System.out.println("Date is not valid");
        }

        int maxDate = daysInMonth[m];
        if (m == 1 && isLeapYear(year)) {
            maxDate = 29;
        }

        if (day < 1 || day > maxDate) {
            isValid = false;
            System.out.println("Date is not valid, max date in this month is " + maxDate);
        }
        return isValid;
    }

}


