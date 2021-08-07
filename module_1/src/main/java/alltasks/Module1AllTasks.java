package alltasks;

import level1.tasks.Level1AllTasks;
import level2.tasks.Task2VerificationOfString;
import level3.tasks.GameOfLife;

import java.util.Scanner;

public class Module1AllTasks {

    public static void main(String[] args) {
        while (true) {
            System.out.println("1.Level 1.All Tasks.");
            System.out.println("2.Level 2.Verification of string.");
            System.out.println("3.Level 3.The game of life.");
            System.out.println("4.Exit . ");
            System.out.print("Press any number:");
            int number;
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
            boolean shouldBreak = false;

            switch (number) {

                case (1):
                    Level1AllTasks.run();
                    break;
                case (2):
                    Task2VerificationOfString.run();
                    break;
                case (3):
                    GameOfLife.run();
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