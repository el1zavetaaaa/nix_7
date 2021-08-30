package utils;

import entity.Date;

public class CalculatorDate {
    public static long differenceBetweenDates(Date firstDate, Date secondDate) {
        long firstDateMilliseconds = ConvertToMillis.dateIntoMillis(firstDate);
        long secondDateMilliseconds = ConvertToMillis.dateIntoMillis(secondDate);
        return Math.abs(firstDateMilliseconds - secondDateMilliseconds);
    }

    public static Date addMillisecondsToDate(Date date, long added) {
        long dateMilliseconds = ConvertToMillis.dateIntoMillis(date);
        Date result = InvertFromMillis.toDate(dateMilliseconds + added);
        return result;
    }

    public static Date subtractMillisecondsFromDate(Date date, long subtracted) {
        long dateMilliseconds = ConvertToMillis.dateIntoMillis(date);
        Date result = InvertFromMillis.toDate(dateMilliseconds - subtracted);
        return result;
    }
}
