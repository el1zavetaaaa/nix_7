package controller;

import tasks.level1.DateConverter;
import tasks.level2.UniqueName;
import tasks.level3.PriceForRoad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AllLevelsController {

    private static final String fileDates = "src/main/resources/files/dates.txt";
    private static final String fileNames = "src/main/resources/files/names.txt";
    private static final Scanner in = new Scanner(System.in);
    private static final String fileInput = "src/main/resources/files/input.txt";


    private static final DateConverter checkDate = new DateConverter();
    private static final UniqueName uniqueName = new UniqueName();
    private static final PriceForRoad priceForRoad = new PriceForRoad();

    public static void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    break;
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void runNavigation() {
        System.out.println();
        System.out.println("if you want to work with list of dates in a list without delimiters, please enter 1");
        System.out.println("if you want to find first unique name from the list of names, please enter 2");
        System.out.println("if you want to find the cheapest way between towns, please enter 3");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private static void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1":
                FirstTaskRun();
                break;
            case "2":
                SecondTaskRun();
                break;
            case "3":
                ThirdTaskRun();
                break;
            case "0":
                System.out.println("Enter 0 one more time!");
                break;
        }
        runNavigation();
    }

    public static void FirstTaskRun() {
        System.out.println("First task");
        boolean end = true;

        while (end) {
            System.out.println("1. Take dates from file\n" +
                    "2. Enter dates by yourself\n" +
                    "For exit to main menu enter 0");
            String index = in.nextLine();
            switch (index) {
                case "1":
                    Path path = Paths.get(fileDates);
                    try {
                        List<String> dateWithDelimiters = Files.readAllLines(path);
                        dateWithDelimiters.forEach(System.out::println);

                        System.out.println("The list of formatted dates with correct first form:");
                        String[] formattedDates = checkDate.checkDateAndConvertToString(dateWithDelimiters);
                        for (String dateWithoutDelimiters : formattedDates) {
                            if (!dateWithoutDelimiters.equals("")) {
                                System.out.println(dateWithoutDelimiters);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    try {
                        List<String> dateWithDelimiters;
                        System.out.println("Enter dates by separating them in such formats as 2020/04/05 04-05-2020 05/04/2020");
                        dateWithDelimiters = List.of(in.nextLine().split(" "));
                        String[] formattedDates = checkDate.checkDateAndConvertToString(dateWithDelimiters);
                        for (String dateWithoutDelimiters : formattedDates) {
                            if (!dateWithoutDelimiters.equals("")) {
                                System.out.println(dateWithoutDelimiters);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    end = false;


            }
        }
    }

    public static void SecondTaskRun() {
        System.out.println("Second task");
        boolean isLoop = true;
        while (isLoop) {
            System.out.println("1. Take data from names.txt file\n" +
                    "2. Enter names by yourself\n" +
                    "For exit enter 0");
            switch (in.nextLine()) {
                case "1":
                    uniqueNameFromFile();
                    break;
                case "2":
                    uniqueNameFromString();
                    break;
                default: {
                    isLoop = false;
                }
            }
        }
    }

    public static void uniqueNameFromFile() {
        System.out.println();
        try {
            Path path = Paths.get(fileNames);
            ArrayList<String> namesFromFile = (ArrayList<String>) Files.readAllLines(path);
            System.out.println("The list of names from file names.txt: ");
            namesFromFile.forEach(n -> System.out.print(n + " "));

            System.out.println("First unique name from list: ");
            System.out.println(uniqueName.findFirstUnique(namesFromFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void uniqueNameFromString() {
        System.out.println();
        System.out.println("Enter names in such way: Olga Iegor Liza Maria");
        String[] names = in.nextLine().split(" ");
        ArrayList<String> listOfNames = new ArrayList<>(Arrays.asList(names));

        System.out.println("First unique name from list: ");
        System.out.println(uniqueName.findFirstUnique(listOfNames));
    }

    public static void ThirdTaskRun() throws IOException {
        System.out.println("Third task");
        Path path = Paths.get(fileInput);

        System.out.println("Input:");
        ArrayList<String> graphStringFromFile = (ArrayList<String>) Files.readAllLines(path);
        graphStringFromFile.forEach(System.out::println);
        System.out.println("-------------------------------");
        System.out.println("Output:");
        priceForRoad.findWaysInGraph(graphStringFromFile);

    }


}
