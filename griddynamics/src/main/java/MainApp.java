import MassiveSorting.controller.MathSetController;
import animals.controller.AnimalController;
import encryptAndDecryptOfFile.EncryptAndDecryptFile;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("1.Task 1. Function, which calculate the sum of 2 numbers.");
            System.out.println("2.Task 2. Function, that generates random numbers.");
            System.out.println("3.Task 3. Function, that generates 10 000 random numbers and put them into txt file.");
            System.out.println("4.Task 4. Encrypt and Decrypt given txt file.");
            System.out.println("5.Task 5. Ascending sorting of the massive.");
            System.out.println("6.Task 6. Animals and OOP!");
            System.out.println("8.Выход из программы. ");
            System.out.print("Введите номер задания:");
            int number;
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
            boolean shouldBreak = false;

            switch (number) {

                case (1):
                    SumOfTwoNumbers.theSumOfNumbersOfAnyKind();
                    break;
                case (2):
                    GenerateRandomNumbers.generationOfRandomNumber();
                    break;
                case (3):
                    InputRandomNumbersToTheFile.writeGeneratedNumbersIntoTheFile();
                    break;
                case (4):
                    EncryptAndDecryptFile.start();
                    break;
                case (5):
                    new MathSetController().start();
                    break;
                case (6):
                    new AnimalController().start();
                    break;
                case (8):
                    shouldBreak = true;
                    System.out.println("Спасибо за внимание!");
                    break;
            }
            if (shouldBreak) break;
        }
    }
}
