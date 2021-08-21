import controller.AuthorBookController;
import controller.AuthorController;
import controller.BookController;

import java.util.Scanner;

public class Unit6App {
    public static void main(String[] args) {


        while (true) {
            System.out.println("1.CRUD Author.");
            System.out.println("2.CRUD Book.");
            System.out.println("3.Author and Book.");
            System.out.println("4.Stop program.");
            System.out.println("Select any number: ");
            int number;
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
            boolean shouldBreak = false;

            switch (number) {
                case (1):
                    new AuthorController().start();
                    break;
                case (2):
                    new BookController().start();
                    break;
                case (3):
                    new AuthorBookController().start();
                    break;
                case (4):
                    shouldBreak = true;
                    break;
            }
            if (shouldBreak) break;
        }

    }


}


