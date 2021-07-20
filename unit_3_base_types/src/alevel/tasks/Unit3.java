package alevel.tasks;

import java.util.Scanner;


public class Unit3 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("1.Сумма чисел в строке.");
            System.out.println("2.Вычислние вхождений каждого символа в строку.");
            System.out.println("3.Вычисление времени конца урока в школе.");
            System.out.println("4.Выход из программы ");
            System.out.print("Введите омер задания:");
            int number;
            Scanner number = new Scanner(System.in);
            number = number.nextInt();
            switch (number) {
                case 1:
                    Task1.task1();
                    break;
                case 2:
                    Task2.task2();
                    break;
                case 3:
                    Task3.task3();
                    break;
                case 4:
                    number.close();
                    System.exit(0);
                    break;
            }
        }
    }
}