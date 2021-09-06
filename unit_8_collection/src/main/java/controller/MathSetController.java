package controller;

import util.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MathSetController {
    private static final MathSet<Integer> numbers = new MathSet<>();
    private static final Scanner in = new Scanner(System.in);
    private static final MathSetController mathSetController = new MathSetController();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your option");
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
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("1. Add numbers to MathSet,");
        System.out.println("2. Print the whole MathSet,");
        System.out.println("3. Sort descending,");
        System.out.println("4. Sort descending by indexes,");
        System.out.println("5. Sort descending by values of numbers,");
        System.out.println("6. Sort ascending,");
        System.out.println("7. Sort ascending by indexes,");
        System.out.println("8. Sort ascending by values of numbers,");
        System.out.println("9. Add numbers to MathSet from another MathSet,");
        System.out.println("10. Print MINIMAL value,");
        System.out.println("11. Print MAXIMUM value,");
        System.out.println("12. Print AVERAGE value,");
        System.out.println("13. Print MEDIAN value,");
        System.out.println("14. Clear MathSet,");
        System.out.println("15. Cut MathSet,");
        System.out.println("0. Exit");
        System.out.println();
    }

    private void menu(String position) {
        switch (position) {
            case "1":
                mathSetController.addNumbers(numbers);
                break;
            case "2":
                mathSetController.print();
                break;
            case "3":
                mathSetController.sortDesc();
                break;
            case "4":
                mathSetController.sortDescByIndexes();
                break;
            case "5":
                mathSetController.sortDescByNumbers();
                break;
            case "6":
                mathSetController.sortAsc();
                break;
            case "7":
                mathSetController.sortAscByIndexes();
                break;
            case "8":
                mathSetController.sortAscByNumbers();
                break;
            case "9":
                mathSetController.join();
                break;
            case "10":
                mathSetController.getMin();
                break;
            case "11":
                mathSetController.getMax();
                break;
            case "12":
                mathSetController.getAverage();
                break;
            case "13":
                mathSetController.getMedian();
                break;
            case "14":
                mathSetController.clear();
                break;
            case "15":
                mathSetController.cut();
                break;
            case "0":
                System.out.println("Have a good time!");
                break;

        }
        runNavigation();
    }

    private static void addNumbers(MathSet<Integer> mathSet) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter count of numbers:");
            String count = sc.nextLine();
            for (int i = 0; i < Integer.parseInt(count); i++) {
                System.out.print("Enter the number:");
                String s = sc.nextLine();
                Integer enteredValue = Integer.parseInt(s);
                mathSet.add(enteredValue);
            }
            printBeforeSorting();
        } catch (NumberFormatException e) {
            System.out.println("Invalid data");
        }
    }


    private static void sortDesc() {
        numbers.sortDesc();
        System.out.println("After sorting:");
        print();
    }

    private static void sortDescByIndexes() {
        printBeforeSorting();
        System.out.print("Enter the first index:");
        int firstIndex = in.nextInt();
        System.out.print("Enter the second index:");
        int secondIndex = in.nextInt();
        numbers.sortDesc(firstIndex, secondIndex);
        System.out.println("After sorting:");
        print();
    }

    private static void sortDescByNumbers() {
        printBeforeSorting();
        System.out.print("Enter number:");
        int number = in.nextInt();
        numbers.sortDesc(number);
        System.out.println("After sorting:");
        print();
    }

    private static void sortAsc() {
        numbers.sortAsc();
        System.out.println("After sorting:");
        print();
    }

    private static void sortAscByIndexes() {
        printBeforeSorting();
        System.out.print("Enter the first index:");
        int first = in.nextInt();
        System.out.print("Enter the second index:");
        int second = in.nextInt();
        numbers.sortAsc(first, second);
        System.out.println("After sorting:");
        print();
    }

    private static void sortAscByNumbers() {
        printBeforeSorting();
        System.out.print("Enter number:");
        int number = in.nextInt();
        numbers.sortAsc(number);
        System.out.println("After sorting:");
        print();
    }

    private static void join() {
        System.out.println("Create new MathSet");
        MathSet<Integer> ms = new MathSet<>();
        addNumbers(ms);
        numbers.join(new MathSet<Integer>(ms));
        print();
    }

    private static void getMin() {
        System.out.println("Minimal number from MathSet: " + numbers.getMin());
    }

    private static void getMax() {
        System.out.println("Maximal number from MathSet: " + numbers.getMax());
    }

    private static void getAverage() {
        System.out.println("Average number from MathSet: " + numbers.getAverage());
    }

    private static void getMedian() {
        numbers.sortAsc();
        System.out.println("Median number from MathSet: " + numbers.getMedian());
    }

    private static void clear() {
        numbers.clear();
        print();
    }

    private static void cut() {
        while (true) {
            try {
                printBeforeSorting();
                System.out.print("Enter the first index:");
                int firstIndex = in.nextInt();
                System.out.print("Enter the second index:");
                int secondIndex = in.nextInt();
                System.out.print("Cut set:");
                MathSet cutted = numbers.cut(firstIndex, secondIndex);
                for (int i = 0; i < cutted.size(); i++) {
                    System.out.print(" " + cutted.get(i));
                }
                System.out.println();
                break;
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Incorrect value!");
            }
        }
    }

    private static void print() {
        if (numbers.size() != 0) {
            for (int i = 0; i < numbers.size(); i++) {
                System.out.print(numbers.get(i) + " ");
            }
        } else {
            System.out.println("Set is empty!");
        }
    }

    private static void printBeforeSorting() {
        System.out.println("Your MathSet before sorting:");
        if (numbers.size() != 0) {
            for (int i = 0; i < numbers.size(); i++) {
                System.out.println(i + ":" + numbers.get(i));
            }
        } else {
            System.out.println("Set is empty!");
        }
    }


}
