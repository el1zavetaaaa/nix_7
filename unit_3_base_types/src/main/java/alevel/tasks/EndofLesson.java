package alevel.tasks;

import java.util.Scanner;

public class EndofLesson {

    public static void task3() {
        int Lesson;
        int hour;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер урока: ");
        Lesson = in.nextInt();
        int TimeofLesson = 45;
        int TimeofBreak = 15;
        int TimeofShortBreak = 5;

        hour = Lesson * TimeofLesson + (Lesson / 2) * TimeofShortBreak + ((Lesson + 1) / 2 - 1) * TimeofBreak;
        System.out.print("Этот урок заканчивается в: ");
        System.out.println(hour / 60 + 9 + ":" + hour % 60);
    }
}