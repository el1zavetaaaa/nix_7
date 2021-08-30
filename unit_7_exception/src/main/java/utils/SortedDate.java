package utils;

import entity.Date;

import java.util.ArrayList;

public class SortedDate {
    public static ArrayList<Date> sortDates(ArrayList<Date> dates, String choice) {
        boolean isSorted;
        int size = dates.size();
        switch (choice) {
            case "1":
                System.out.println("Descending sort");
                do {
                    isSorted = true;
                    for (int i = 0; i < size - 1; i++) {
                        if (ConvertToMillis.dateIntoMillis(dates.get(i)) < ConvertToMillis.dateIntoMillis(dates.get(i + 1))) {
                            Date date = dates.get(i);
                            dates.set(i, dates.get(i + 1));
                            dates.set(i + 1, date);
                            isSorted = false;
                        }
                    }
                } while (!isSorted);
                return dates;
            case "2":
                System.out.println("Ascending sort");
                do {
                    isSorted = true;
                    for (int i = 0; i < size - 1; i++) {
                        if (ConvertToMillis.dateIntoMillis(dates.get(i)) > ConvertToMillis.dateIntoMillis(dates.get(i + 1))) {
                            Date date = dates.get(i);
                            dates.set(i, dates.get(i + 1));
                            dates.set(i + 1, date);
                            isSorted = false;
                        }
                    }
                } while (!isSorted);
                return dates;
            default:
                return dates;
        }
    }
}
