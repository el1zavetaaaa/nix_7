package strings.stringprograms;


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
                    Scanner console1 = new Scanner(System.in);
                    System.out.println("Введите строку:");
                    String str1 = console1.nextLine();
                    System.out.println(SimpleReverse.simplereverse(str1));
                    break;
                case (2):
                    Scanner console2 = new Scanner(System.in);
                    System.out.println("Введите строку:");
                    String str2 = console2.nextLine();
                    SubstringReverse.substringreverse(str2);
                    break;
                case (3):

                    Scanner console3 = new Scanner(System.in);
                    System.out.println("Введите строку:");
                    String str3 = console3.nextLine();
                    System.out.println("Введите первый индекс:");
                    int firstindex = console3.nextInt();
                    System.out.println("Введите последний индекс:");
                    int lastindex = console3.nextInt();
                    ReverseByIndex.reversebyindex(str3, firstindex, lastindex);
                    break;
                case (4):
                    Scanner console4 = new Scanner(System.in);
                    System.out.println("Введите строку:");
                    String str4 = console4.nextLine();
                    ReverseByChar.reversebychar(str4);
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
