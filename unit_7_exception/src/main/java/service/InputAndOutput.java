package service;

import entity.Date;

public class InputAndOutput {
    private static final String[] NamesOfMonths = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    public String dateToString(Date date, String choice) {
        String stringDate = "";
        switch (choice) {
            case "1":
                System.out.println(firstTypeOutput(date, stringDate));
                break;
            case "2":
                System.out.println(secondTypeOutput(date, stringDate));
                break;
            case "3":
                System.out.println(thirdTypeOutput(date, stringDate));
                break;
            case "4":
                System.out.println(fourthTypeOutput(date, stringDate));
                break;
            default:
                System.out.println("Incorrect input");
        }
        return stringDate;
    }

    private String firstTypeOutput(Date date, String dateString) {
        if (date.getDay() == 0) {
            dateString += "1";
        }
        dateString += generateDoubleZero(date.getDay()) + "/";
        for (int i = 0; i < NamesOfMonths.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                dateString += generateDoubleZero(date.getMonth()) + "/";
            }
        }

        dateString += date.getYear() + " ";

        dateString += generateDoubleZero(date.getHours()) + ":";
        dateString += generateDoubleZero(date.getMinutes()) + ":";
        dateString += generateDoubleZero(date.getSeconds()) + ":";
        dateString += generateTripleZero(date.getMilliseconds());

        return dateString;
    }

    private String secondTypeOutput(Date date, String dateString) {
        if (date.getDay() == 0) {
            dateString += "1";
        }

        for (int i = 0; i < NamesOfMonths.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                dateString += date.getMonth() + "/";
            }
        }

        dateString += date.getDay() + "/";
        dateString += date.getYear() + " ";

        dateString += generateDoubleZero(date.getHours()) + ":";
        dateString += generateDoubleZero(date.getMinutes()) + ":";
        dateString += generateDoubleZero(date.getSeconds()) + ":";
        dateString += generateTripleZero(date.getMilliseconds());

        return dateString;
    }

    private String thirdTypeOutput(Date date, String dateString) {
        for (int i = 0; i < NamesOfMonths.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                dateString += NamesOfMonths[i] + " ";
            }
        }

        if (date.getDay() == 0) {
            dateString += "1";
        }
        dateString += date.getDay() + " ";
        dateString += date.getYear() + " ";

        dateString += generateDoubleZero(date.getHours()) + ":";
        dateString += generateDoubleZero(date.getMinutes()) + ":";
        dateString += generateDoubleZero(date.getSeconds()) + ":";
        dateString += generateTripleZero(date.getMilliseconds());

        return dateString;
    }

    private String fourthTypeOutput(Date date, String dateString) {
        if (date.getDay() == 0) {
            dateString += "1";
        }
        dateString += generateDoubleZero(date.getDay()) + " ";

        for (int i = 0; i < NamesOfMonths.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                dateString += NamesOfMonths[i] + " ";
            }
        }
        dateString += date.getYear() + " ";

        dateString += generateDoubleZero(date.getHours()) + ":";
        dateString += generateDoubleZero(date.getMinutes()) + ":";
        dateString += generateDoubleZero(date.getSeconds()) + ":";
        dateString += generateTripleZero(date.getMilliseconds());

        return dateString;
    }

    public Date stringToDate(String date, String choice) {
        Date myDate = new Date();
        switch (choice) {
            case "1":
                myDate = firstTypeInput(date);
                break;
            case "2":
                myDate = secondTypeInput(date);
                break;
            case "3":
                myDate = thirdTypeInput(date);
                break;
            case "4":
                myDate = fourthTypeInput(date);
                break;
            default:
                System.out.println("Incorrect input");
        }
        return myDate;
    }

    public static Date firstTypeInput(String dateString) {
        Date date = new Date();

        String delimiter;
        if (dateString.contains("/")) {
            delimiter = "/";
        } else {
            delimiter = "-";
        }

        String[] split = new String[4];
        switch (delimiter) {
            case "/":
                split = dateString.split("[/ ]", 4);
                break;
            case "-":
                split = dateString.split("[- ]", 4);
                break;
        }
        try {
            if (!split[0].equals("")) {
                date.setDay(Integer.parseInt(split[0]));
            } else {
                date.setDay(1);
            }
            if (!split[1].equals("")) {
                date.setMonth(Integer.parseInt(split[1]));
            } else {
                date.setMonth(1);
            }
            if (!split[2].equals("")) {
                date.setYear(Integer.parseInt(split[2]));
            } else {
                date.setYear(0);
            }
            if (split.length > 3) {
                setTime(date, split[3]);
            }
            return date;
        } catch (NumberFormatException e) {

            throw new NumberFormatException();
        }
    }

    public static Date secondTypeInput(String dateString) {
        Date date = new Date();

        String delimiter;
        if (dateString.contains("/")) {
            delimiter = "/";
        } else {
            delimiter = "-";
        }

        String[] split = new String[4];
        switch (delimiter) {
            case "/":
                split = dateString.split("[/ ]", 4);
                break;
            case "-":
                split = dateString.split("[- ]", 4);
                break;
        }
        try {
            if (!split[0].equals("")) {
                date.setMonth(Integer.parseInt(split[0]));
            } else {
                date.setMonth(1);
            }
            if (!split[1].equals("")) {
                date.setDay(Integer.parseInt(split[1]));
            } else {
                date.setDay(1);
            }
            if (!split[2].equals("")) {
                date.setYear(Integer.parseInt(split[2]));
            } else {
                date.setYear(0);
            }
            if (split.length > 3) {
                setTime(date, split[3]);
            }
            return date;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public static Date thirdTypeInput(String dateString) {
        Date date = new Date();

        String[] split;
        if (dateString.contains("-")) {
            split = dateString.split("[- ]", 4);
        } else {
            split = dateString.split("[ ]", 4);
        }
        try {
            int month;
            if (!split[0].equals("")) {
                for (int i = 0; i < NamesOfMonths.length; i++) {
                    if (split[0].equals(NamesOfMonths[i])) {
                        month = i + 1;
                        date.setMonth(month);
                    }
                }
            } else {
                date.setMonth(1);
            }
            if (!split[1].equals("")) {
                date.setDay(Integer.parseInt(split[1]));
            } else {
                date.setDay(1);
            }
            if (!split[2].equals("")) {
                date.setYear(Integer.parseInt(split[2]));
            } else {
                date.setYear(0);
            }

            if (split.length > 3) {
                setTime(date, split[3]);
            }
            return date;
        } catch (NumberFormatException e) {

            throw new NumberFormatException();
        }
    }

    public static Date fourthTypeInput(String dateString) {
        Date date = new Date();

        String[] split;
        if (dateString.contains("-")) {
            split = dateString.split("[- ]", 4);
        } else {
            split = dateString.split("[ ]", 4);
        }
        try {
            if (!split[0].equals("")) {
                date.setDay(Integer.parseInt(split[0]));
            } else {
                date.setDay(1);
            }
            int month;
            if (!split[1].equals("")) {
                for (int i = 0; i < NamesOfMonths.length; i++) {
                    if (split[1].equals(NamesOfMonths[i])) {
                        month = i + 1;
                        date.setMonth(month);
                    }
                }
            } else {
                date.setMonth(1);
            }
            if (!split[2].equals("")) {
                date.setYear(Integer.parseInt(split[2]));
            } else {
                date.setYear(0);
            }

            if (split.length > 3) {
                setTime(date, split[3]);
            }
            return date;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private static void setTime(Date date, String time) throws NumberFormatException {

        String[] split = time.split(":");
        try {
            for (int i = 0; i < split.length; ++i) {
                if (split[i].equals("")) {
                    split[i] = "0";
                }
                switch (i) {
                    case 0:
                        date.setHours(Integer.parseInt(split[0]));
                        break;
                    case 1:
                        date.setMinutes(Integer.parseInt(split[1]));
                        break;
                    case 2:
                        date.setSeconds(Integer.parseInt(split[2]));
                        break;
                    case 3:
                        date.setMilliseconds(Integer.parseInt(split[3]));
                        break;
                }
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid entered date");
        }
    }


    private String generateDoubleZero(int number) {
        if (number < 10) return "0" + number;
        return number + "";
    }

    private String generateTripleZero(int number) {
        if (number < 10) return "00" + number;
        if (number < 100) return "0" + number;
        return number + "";
    }
}
