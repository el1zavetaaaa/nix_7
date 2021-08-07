package level1.tasks;

import java.util.Scanner;

public class Level1AllTasks {

    public static void run() {

        while (true) {
            System.out.println("1.Show a number of unique symbols in the String.");
            System.out.println("2.The movement of knight.");
            System.out.println("3.Counting triangle area.");
            System.out.println("4.Exit . ");
            System.out.print("Press any number:");
            int number;
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
            boolean shouldBreak = false;

            switch (number) {

                case (1):
                    UniqueSymbols.UniqueSymbols();
                    break;
                case (2):
                    KnightMove.KnightMove();
                    break;
                case (3):
                    TriangleArea.TriangleArea();
                    break;
                case (4):
                    shouldBreak = true;
                    System.out.println("The end.");
                    break;

            }
            if (shouldBreak) break;
        }


    }

}