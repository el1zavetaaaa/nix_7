import java.util.Scanner;

public class SumOfTwoNumbers {



    public static void theSumOfNumbersOfAnyKind() {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("1.Cумма 2 целых чисел (Пример числа: 4).");
            System.out.println("2.Cумма 2 чисел, с плавающей точкой (Пример числа: 2,5).");
            System.out.println("3.Cумма 2 чисел: 1 - целое число (Пример числа: 4), 2 - число с плавающей точкой(Пример числа: 2,5).");
            System.out.println("4.Cумма 2 чисел: 1 - число с плавающей точкой (Пример числа: 2,5), 2 - целое число (Пример числа: 4).");
            System.out.println("5.Выход из программы. ");
            System.out.print("Введите номер задания:");
            int number;
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
            boolean shouldBreak = false;

            switch (number) {

                case (1):
                    Scanner intCase = new Scanner(System.in);
                    System.out.println("Введите первое число: ");
                    int firstNumber = intCase.nextInt();
                    System.out.println("Введите второе число: ");
                    int secondNumber = intCase.nextInt();
                    sumOfTwoIntNumbers(firstNumber, secondNumber);
                    break;
                case (2):
                    Scanner doubleCase = new Scanner(System.in);
                    System.out.println("Введите первое число: ");
                    double firstDoubleNumber = doubleCase.nextDouble();
                    System.out.println("Введите второе число: ");
                    double secondDoubleNumber = doubleCase.nextDouble();
                    sumOfTwoDoubleNumbers(firstDoubleNumber, secondDoubleNumber);
                    break;
                case (3):
                    Scanner firstIntSecondDoubleCase = new Scanner(System.in);
                    System.out.println("Введите первое число: ");
                    int firstIntNumber = firstIntSecondDoubleCase.nextInt();
                    System.out.println("Введите второе число: ");
                    double theSecondDoubleNumber = firstIntSecondDoubleCase.nextDouble();
                    sumOfTwoFirstIntAndSecondDoubleNumbers(firstIntNumber, theSecondDoubleNumber);
                    break;
                case (4):
                    Scanner secondIntFirstDoubleCase = new Scanner(System.in);
                    System.out.println("Введите первое число: ");
                    double theFirstDoubleNumber = secondIntFirstDoubleCase.nextDouble();
                    System.out.println("Введите второе число: ");
                    int secondIntNumber = secondIntFirstDoubleCase.nextInt();
                    sumOfTwoFirstDoubleAndSecondIntNumbers(theFirstDoubleNumber, secondIntNumber);
                    break;
                case (5):
                    shouldBreak = true;
                    System.out.println("Спасибо за внимание!");
                    break;
            }
            if (shouldBreak) break;
        }
    }

    public static void sumOfTwoIntNumbers(int firstIntNumber, int secondIntNumber) {
        int sumOfTwoIntNumbers = firstIntNumber + secondIntNumber;
        System.out.print("The sum of " + Integer.toString(firstIntNumber) + "  " + firstIntNumber + " ");
        System.out.println(" and " + Integer.toString(secondIntNumber) + " " + " is " + Integer.toString(sumOfTwoIntNumbers));
    }

    public static void sumOfTwoDoubleNumbers(double firstDoubleNumber, double secondDoubleNumber) {
        double sumOfTwoDoubleNumbers = firstDoubleNumber + secondDoubleNumber;
        System.out.print("The sum of " + firstDoubleNumber + "  " + firstDoubleNumber + "  " + secondDoubleNumber + " " + " is ");
        System.out.println(sumOfTwoDoubleNumbers);
    }

    public static void sumOfTwoFirstIntAndSecondDoubleNumbers(int firstIntNumber, double secondDoubleNumber) {
        double sumOfTwoFirstIntAndSecondDoubleNumbers = firstIntNumber + secondDoubleNumber;
        System.out.print("The sum of " + Integer.toString(firstIntNumber) + " ,and  " + secondDoubleNumber + " " + " is ");
        System.out.println(sumOfTwoFirstIntAndSecondDoubleNumbers);

    }

    public static void sumOfTwoFirstDoubleAndSecondIntNumbers(double firstDoubleNumber, int secondIntNumber) {
        double sumOfTwoFirstDoubleAndSecondIntNumbers = firstDoubleNumber + secondIntNumber;
        System.out.print("The sum of " + firstDoubleNumber + " ,and  " + Integer.toString(secondIntNumber) + " " + " is ");
        System.out.println(sumOfTwoFirstDoubleAndSecondIntNumbers);

    }


}
