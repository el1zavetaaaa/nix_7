package MassiveSorting.controller;

import MassiveSorting.util.MathSet;

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
                    break;
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
        System.out.println("3. Sort ascending,");
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
                mathSetController.sortAsc();
                break;
            case "0":
                System.out.println("Thank you for your attention!");
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

    private static void print() {
        if (numbers.size() != 0) {
            for (int i = 0; i < numbers.size(); i++) {
                System.out.print(numbers.get(i) + " ");
            }
        } else {
            System.out.println("Set is empty!");
        }
    }

    private static void sortAsc() {
        numbers.sortAsc();
        System.out.println("After sorting:");
        print();
    }


}
