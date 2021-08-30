package service;

import entity.Date;

public class DateFormat {
    private static final String[] NamesOfMonths = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    public static boolean check(String date, String choice) {
        boolean isValid = false;
        switch (choice) {
            case "1":
                isValid = firstType(date);
                break;
            case "2":
                isValid = secondType(date);
                break;
            case "3":
                isValid = thirdType(date);
                break;
            case "4":
                isValid = fourthType(date);
                break;
            default:
                System.out.println("Incorrect input");
        }
        return !isValid;
    }

    public static boolean firstType(String input) {
        try {
            if (input.contains("/") || input.contains("-")) {
                String delimiter;
                if (input.contains("/")) {
                    delimiter = "/";
                } else {
                    delimiter = "-";
                }

                String[] split = new String[4];

                switch (delimiter) {
                    case "/":
                        split = input.split("[/ ]");
                        break;
                    case "-":
                        split = input.split("[- ]");
                        break;
                }

                if (split.length >= 3) {
                    int day;
                    if (split[0].equals("")) {
                        day = 1;
                    } else {
                        day = Integer.parseInt(split[0]);
                    }

                    int month;
                    if (split[1].equals("")) {
                        month = 1;
                    } else {
                        month = Integer.parseInt(split[1]);
                    }

                    int year;
                    if (split[2].equals("")) {
                        year = 0;
                    } else {
                        year = Integer.parseInt(split[2]);
                    }

                    if ((split[0].length() == 2 || split[0].matches(""))
                            && (split[1].length() == 2 || split[1].matches(""))) {
                        if (day > 0 && month <= 12 && month >= 1 && year >= 0) {
                            return Date.isValid(year, month, day);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean secondType(String input) {
        try {
            if (input.contains("/") || input.contains("-")) {
                String delimiter;
                if (input.contains("/")) {
                    delimiter = "/";
                } else {
                    delimiter = "-";
                }

                String[] split = new String[4];

                switch (delimiter) {
                    case "/":
                        split = input.split("[/ ]");
                        break;
                    case "-":
                        split = input.split("[- ]");
                        break;
                }

                if (split.length >= 3) {
                    int day;
                    if (split[1].equals("")) {
                        day = 1;
                    } else {
                        day = Integer.parseInt(split[1]);
                    }
                    int month;
                    if (split[0].equals("")) {
                        month = 1;
                    } else {
                        month = Integer.parseInt(split[0]);
                    }

                    int year;
                    if (split[2].equals("")) {
                        year = 0;
                    } else {
                        year = Integer.parseInt(split[2]);
                    }

                    if (day > 0 && month <= 12 && month >= 1 && year >= 0) {
                        return Date.isValid(year, month, day);
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean thirdType(String input) {
        try {
            int month;
            String[] split;
            if (input.contains("-")) {
                split = input.split("[- ]");
            } else {
                split = input.split("[ ]");
            }
            if (split.length >= 3) {
                int day;
                if (split[1].equals("")) {
                    day = 1;
                } else {
                    day = Integer.parseInt(split[1]);
                }
                int year;
                if (split[2].equals("")) {
                    year = 0;
                } else {
                    year = Integer.parseInt(split[2]);
                }
                if (split[0].equals("")) {
                    month = 1;
                    return Date.isValid(year, month, day);
                } else {
                    for (int i = 0; i < NamesOfMonths.length; i++) {
                        if (split[0].equalsIgnoreCase(NamesOfMonths[i])) {
                            month = i + 1;
                            return Date.isValid(year, month, day);
                        }
                    }
                }
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean fourthType(String input) {
        try {
            String[] split;
            if (input.contains("-")) {
                split = input.split("[- ]", 4);
            } else {
                split = input.split("[ ]", 4);
            }
            if (split.length >= 3) {
                int day;
                if (split[0].equals("")) {
                    day = 1;
                } else {
                    day = Integer.parseInt(split[0]);
                }
                int year;
                if (split[2].equals("")) {
                    year = 0;
                } else {
                    year = Integer.parseInt(split[2]);
                }
                int month;
                if (split[1].equals("")) {
                    month = 1;
                    return Date.isValid(year, month, day);
                } else {
                    if (split[0].length() == 2 || split[0].matches("")) {
                        for (int i = 0; i < NamesOfMonths.length; i++) {
                            if (split[1].equalsIgnoreCase(NamesOfMonths[i])) {
                                month = i + 1;
                                return Date.isValid(year, month, day);
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkFormat(String inputString) {
        boolean endOfLoop = true;
        try {
            if (inputString.contains("/") || inputString.contains("-")) {
                String delimiter;
                if (inputString.contains("/")) delimiter = "/";
                else delimiter = "-";
                String[] split = new String[4];

                switch (delimiter) {
                    case "/":
                        split = inputString.split("[/ ]");
                        break;
                    case "-":
                        split = inputString.split("[- ]");
                        break;
                }
                if (split.length > 3) {
                    String[] splitTime = split[3].split(":");
                    if (!splitTime[0].equals("")) {
                        if (Integer.parseInt(splitTime[0]) > 23 || Integer.parseInt(splitTime[0]) < 0) {
                            endOfLoop = false;
                        }
                    }
                    if (splitTime.length > 1) {
                        if (Integer.parseInt(splitTime[1]) > 59 || Integer.parseInt(splitTime[1]) < 0) {
                            endOfLoop = false;
                        }
                    }
                    if (splitTime.length > 2) {
                        if (Integer.parseInt(splitTime[2]) > 59 || Integer.parseInt(splitTime[2]) < 0) {
                            endOfLoop = false;
                        }
                    }
                    if (splitTime.length > 3) {
                        if (Integer.parseInt(splitTime[3]) > 999 || Integer.parseInt(splitTime[3]) < 0) {
                            endOfLoop = false;
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            return true;
        }
        return !endOfLoop;
    }
}
