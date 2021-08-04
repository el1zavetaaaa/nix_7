package strings.main;


import strings.lib.ReverseString;

import java.util.Scanner;

public class Unit5AllTasks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("1.Перевернутая строка.");
            System.out.println("2.Перевернутая подстрока.");
            System.out.println("3.Перевернутая часть строки по указанным индексам.");
            System.out.println("4.Перевернутая часть строки по указанным символам.");
            System.out.println("5.Выход из программы. ");
            System.out.print("Введите номер задания:");
            int number;
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
            boolean shouldBreak = false;

            switch (number) {

                case (1):
                    Scanner in1 = new Scanner(System.in);
                    System.out.println("Введите строку:");
                    String str1 = in1.nextLine();
                    System.out.println(ReverseString.simplereverse(str1));
                    break;
                case (2):
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("Введите строку:");
                    String str2 = in2.nextLine();
                    ReverseString.reversesubstring(str2);
                    break;
                case (3):
                    Scanner in3 = new Scanner(System.in);
                    System.out.println("Введите строку:");
                    String str3 = in3.nextLine();
                    System.out.println("Введите первый индекс:");
                    int index1 = in3.nextInt();
                    System.out.println("Введите последний индекс:");
                    int index2 = in3.nextInt();
                    ReverseString.reversebyindex(str3, index1, index2);
                    break;
                case (4):
                    Scanner in4 = new Scanner(System.in);
                    System.out.println("Введите строку:");
                    String str4 = in4.nextLine();
                    ReverseString.reversebychar(str4);
                    break;
                case (5):
                    shouldBreak = true;
                    System.out.println("Спасибо за внимание!");
                    break;
            }
            if (shouldBreak) break;
        }


    }

}
