package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Util {
    public static long readLong(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String text = bufferedReader.readLine();
            try {
                return Integer.parseInt(text.trim());
            } catch (NumberFormatException e) {
                System.out.println("Only long type allowed");
            }
        }
    }

    public static long chooseAccount(BufferedReader bufferedReader, List<Long> accountID) throws IOException {
        while (true) {
            long id = readLong(bufferedReader);
            if (accountID.contains(id)) {
                return id;
            } else {
                System.out.println("User doesn't have any accounts");
            }
        }
    }

    public static Timestamp readDate(BufferedReader bufferedReader) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Timestamp date;
        while (true) {
            try {
                Date dateRead = dateFormat.parse(bufferedReader.readLine());
                date = new Timestamp(dateRead.getTime());
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date");
            }
        }
        return date;
    }
}
