package controller;


import entity.Date;
import exception.DateException;
import service.DateFormat;
import service.InputAndOutput;
import utils.CalculatorDate;
import utils.ConvertToMillis;
import utils.InvertFromMillis;
import utils.SortedDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DateController {
    private static final Scanner scanner = new Scanner(System.in);
    public static final InputAndOutput inputAndOutput = new InputAndOutput();
    public static final DateController dateController = new DateController();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                menu(position);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                menu(position);
            }
        } catch (IOException | DateException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want to get difference between date, please enter 1");
        System.out.println("if you want to add date, please enter 2");
        System.out.println("if you want to subtract date, please enter 3");
        System.out.println("if you want to sort dates, please enter 4");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void menu(String position) throws DateException {
        switch (position) {
            case "1":
                dateController.difference();
                break;
            case "2":
                dateController.addition();
                break;
            case "3":
                dateController.subtraction();
                break;
            case "4":
                dateController.sorting();
                break;
            case "0":
                System.out.println("Have a good time!");
                break;

        }
        runNavigation();
    }

    public static void difference() {
        String type;
        do {
            dateController.inputDateTypes();
            type = scanner.nextLine();
        } while (Integer.parseInt(type) > 4 || Integer.parseInt(type) <= 0);

        System.out.println("Enter the first date");
        String firstDate;
        boolean isValid = true;
        do {
            if (!isValid) {
                System.out.println("Incorrect input, try again");
            }
            firstDate = scanner.nextLine();
            isValid = false;
        } while (DateFormat.check(firstDate, type) || DateFormat.checkFormat(firstDate));

        Date theFirstDate = null;
        try {
            theFirstDate = inputAndOutput.stringToDate(firstDate, type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Enter the second date:");
        String secondDate;

        boolean isValidValue = true;
        do {
            if (!isValidValue) {
                System.out.println("Incorrect input, try again");
            }
            secondDate = scanner.nextLine();
            isValidValue = false;
        } while (DateFormat.check(secondDate, type) || DateFormat.checkFormat(secondDate));

        Date theSecondDate = null;
        try {
            theSecondDate = inputAndOutput.stringToDate(secondDate, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long result = CalculatorDate.differenceBetweenDates(theFirstDate, theSecondDate);
        System.out.println("Result");
        System.out.println("Years: " + (int) InvertFromMillis.toYears(result));
        System.out.println("Days: " + (int) InvertFromMillis.toDays(result));
        System.out.println("Hours:" + (int) InvertFromMillis.toHours(result));
        System.out.println("Minutes:" + (int) InvertFromMillis.toMinutes(result));
        System.out.println("Seconds:" + (int) InvertFromMillis.toSeconds(result));
        System.out.println();

    }

    public static void addition() {
        String type;
        do {
            dateController.inputDateTypes();
            type = scanner.nextLine();
        } while (Integer.parseInt(type) > 4 || Integer.parseInt(type) <= 0);

        System.out.print("Enter date:");
        String inputDate;

        boolean isValidValue = true;
        do {
            if (!isValidValue) {
                System.out.println("Incorrect input, try again");
            }
            inputDate = scanner.nextLine();
            isValidValue = false;
        } while (DateFormat.check(inputDate, type) || DateFormat.checkFormat(inputDate));

        Date theInputDate = null;
        try {
            theInputDate = inputAndOutput.stringToDate(inputDate, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            boolean flag = true;
            while (flag) {
                System.out.println();
                System.out.println("Choose what do you want to add:");
                menuOfDate();
                long millis;
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        System.out.print("Enter count of years:");
                        String years = scanner.nextLine();
                        millis = ConvertToMillis.yearsToMillis(Integer.parseInt(years));
                        theInputDate = CalculatorDate.addMillisecondsToDate(theInputDate, millis);
                        printDateTypes(theInputDate);
                        break;
                    case "2":
                        System.out.print("Enter count of days:");
                        String days = scanner.nextLine();
                        millis = ConvertToMillis.daysToMillis(Integer.parseInt(days));
                        theInputDate = CalculatorDate.addMillisecondsToDate(theInputDate, millis);
                        printDateTypes(theInputDate);
                        break;
                    case "3":
                        System.out.print("Enter count of hours:");
                        String hours = scanner.nextLine();
                        millis = ConvertToMillis.hoursToMillis(Integer.parseInt(hours));
                        theInputDate = CalculatorDate.addMillisecondsToDate(theInputDate, millis);
                        printDateTypes(theInputDate);
                        break;
                    case "4":
                        System.out.print("Enter count of minutes:");
                        String minutes = scanner.nextLine();
                        millis = ConvertToMillis.minutesToMillis(Integer.parseInt(minutes));
                        theInputDate = CalculatorDate.addMillisecondsToDate(theInputDate, millis);
                        printDateTypes(theInputDate);
                        break;
                    case "5":
                        System.out.print("Enter count of seconds:");
                        String seconds = scanner.nextLine();
                        millis = ConvertToMillis.secondsToMillis(Integer.parseInt(seconds));
                        theInputDate = CalculatorDate.addMillisecondsToDate(theInputDate, millis);
                        printDateTypes(theInputDate);
                        break;
                    case "6":
                        System.out.print("Enter count of milliseconds:");
                        String milliseconds = scanner.nextLine();
                        theInputDate = CalculatorDate.addMillisecondsToDate(theInputDate, Integer.parseInt(milliseconds));
                        printDateTypes(theInputDate);
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("Incorrect input!Try again!");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Incorrect!Try again!");
        }
    }

    public static void subtraction() {
        String type;
        do {
            dateController.inputDateTypes();
            type = scanner.nextLine();
        } while (Integer.parseInt(type) > 4 || Integer.parseInt(type) <= 0);

        System.out.print("Enter date:");
        String date;

        boolean isValid = true;
        do {
            if (!isValid) {
                System.out.println("Incorrect input, try again");
            }
            date = scanner.nextLine();
            isValid = false;
        } while (DateFormat.check(date, type) || DateFormat.checkFormat(date));

        Date theInputDate = null;
        try {
            theInputDate = inputAndOutput.stringToDate(date, type);
            System.out.println(theInputDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            boolean flag = true;
            while (flag) {
                System.out.println();
                System.out.println("Choose what do you want to subtract:");
                menuOfDate();
                long mil;
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        System.out.print("Enter count of years:");
                        String years = scanner.nextLine();
                        mil = ConvertToMillis.yearsToMillis(Integer.parseInt(years));
                        theInputDate = CalculatorDate.subtractMillisecondsFromDate(theInputDate, mil);
                        printDateTypes(theInputDate);
                        break;
                    case "2":
                        System.out.print("Enter count of days:");
                        String days = scanner.nextLine();
                        mil = ConvertToMillis.daysToMillis(Integer.parseInt(days));
                        theInputDate = CalculatorDate.subtractMillisecondsFromDate(theInputDate, mil);
                        printDateTypes(theInputDate);
                        break;
                    case "3":
                        System.out.print("Enter count of hours:");
                        String hours = scanner.nextLine();
                        mil = ConvertToMillis.hoursToMillis(Integer.parseInt(hours));
                        theInputDate = CalculatorDate.subtractMillisecondsFromDate(theInputDate, mil);
                        printDateTypes(theInputDate);
                        break;
                    case "4":
                        System.out.print("Enter count of minutes:");
                        String minutes = scanner.nextLine();
                        mil = ConvertToMillis.minutesToMillis(Integer.parseInt(minutes));
                        theInputDate = CalculatorDate.subtractMillisecondsFromDate(theInputDate, mil);
                        printDateTypes(theInputDate);
                        break;
                    case "5":
                        System.out.print("Enter count of seconds:");
                        String seconds = scanner.nextLine();
                        mil = ConvertToMillis.secondsToMillis(Integer.parseInt(seconds));
                        theInputDate = CalculatorDate.subtractMillisecondsFromDate(theInputDate, mil);
                        printDateTypes(theInputDate);
                        break;
                    case "6":
                        System.out.print("Enter count of milliseconds:");
                        String milliseconds = scanner.nextLine();
                        theInputDate = CalculatorDate.subtractMillisecondsFromDate(theInputDate, Integer.parseInt(milliseconds));
                        printDateTypes(theInputDate);
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("Incorrect input!");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Incorrect!Try again!");
        }
    }

    public static void sorting() throws NumberFormatException {
        ArrayList<Date> dates = new ArrayList<>();

        String type;
        do {
            dateController.inputDateTypes();
            type = scanner.nextLine();
        } while (Integer.parseInt(type) > 4 || Integer.parseInt(type) <= 0);

        try {
            System.out.print("Enter count of dates:");
            String count = scanner.nextLine();
            for (int i = 0; i < Integer.parseInt(count); i++) {
                System.out.print("Enter date:");
                String date;

                boolean isValid = true;
                do {
                    if (!isValid) {
                        System.out.println("Incorrect input, try again");
                    }
                    date = scanner.nextLine();
                    isValid = false;
                } while (DateFormat.check(date, type) || DateFormat.checkFormat(date));

                Date theInputDate = null;
                try {
                    theInputDate = inputAndOutput.stringToDate(date, type);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dates.add(theInputDate);
            }

            System.out.println("1. Descending sort\n" + "2. Ascending sort");
            String choiceSort = scanner.nextLine();
            ArrayList<Date> sortedDates = SortedDate.sortDates(dates, choiceSort);

            System.out.println("Choose format of date\n" +
                    "1. dd/mm/yy 00:00:00:000\n" +
                    "2. m/d/yy 00:00:00:000\n" +
                    "3. Month d yyyy 00:00:00:000\n" +
                    "4. dd Month yy 00:00:00:000");
            String choiceFormat = scanner.nextLine();
            System.out.println("The dates:");
            for (Date d : sortedDates) {
                System.out.print(inputAndOutput.dateToString(d, choiceFormat));
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Incorrect!Try again!");
        }
    }


    private static void menuOfDate() {
        System.out.println("1-Years");
        System.out.println("2-Days");
        System.out.println("3-Hours");
        System.out.println("4-Minutes");
        System.out.println("5-Seconds");
        System.out.println("6-Milliseconds");
        System.out.println("0-Exit");
        System.out.println();
    }

    private static void printDateTypes(Date date) {
        System.out.println("Choose format of date\n" +
                "1. dd/mm/yy 00:00:00:000\n" +
                "2. m/d/yy 00:00:00:000\n" +
                "3. Month d yyyy 00:00:00:000\n" +
                "4. dd Month yyyy 00:00:00:000");
        String type = scanner.nextLine();
        System.out.println("The date:");
        System.out.print(inputAndOutput.dateToString(date, type));
    }

    public static void inputDateTypes() {
        System.out.println("Choose date input format\n" +
                "1. dd/mm/yy 00:00:00:000 (or dd-mm-yy)\n" +
                "2. m/d/yyyy 00:00:00:000 (or m-d-yyyy)\n" +
                "3. mmm-d-yy 00:00:00:000 (or Month d yyyy)\n" +
                "4. dd-mmm-yyyy 00:00:00:000 (or dd Month yyyy)");
    }


}
