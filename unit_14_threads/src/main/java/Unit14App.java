import java.util.Scanner;

import static task1.HelloFromThreadPrinterTask.startTheProgramHelloFromThread;
import static task2.PrimeNumbersCounter.countOfPrimeNumbersByTwoThreads;


public class Unit14App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("1. 50 threads with a message <<Hello from thread!>> execute in order from 49 to 0.");
            System.out.println("2. 2 thread count prime numbers from List.");
            System.out.println("3.Exit.");
            System.out.print("Please, enter the number:");
            int number;
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
            boolean shouldBreak = false;

            switch (number) {

                case (1):
                    startTheProgramHelloFromThread();
                    break;
                case (2):
                    countOfPrimeNumbersByTwoThreads();
                    break;
                case (3):
                    shouldBreak = true;
                    System.out.println("Thank you for your attention!");
                    break;
            }
            if (shouldBreak) break;
        }

    }


}
