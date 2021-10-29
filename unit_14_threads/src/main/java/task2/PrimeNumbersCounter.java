package task2;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersCounter extends Thread {

    private final List<Integer> countOfNumbers;
    int countOfPrimeNumbers = 0;
    private static final int LIST_SIZE = 10;


    public PrimeNumbersCounter(List<Integer> countOfNumbers) {
        this.countOfNumbers = countOfNumbers;
    }

    private boolean isSimpleNumber(int number) {
        if (number <= 0 || number == 1) {
            System.out.println(number + " is not a simple number!");
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.println(number + "is not a simple number!");
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        for (int numbers : countOfNumbers) {
            if (isSimpleNumber(numbers)) {
                countOfPrimeNumbers++;
            }
        }
    }

    public int getCountOfPrimeNumbers() {
        return countOfPrimeNumbers;
    }

    public static void countOfPrimeNumbersByTwoThreads() {

        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            listOfNumbers.add((int) (Math.random() * 25));
        }

        System.out.println("List of numbers: " + listOfNumbers);

        PrimeNumbersCounter primeNumbersCounter1 = new PrimeNumbersCounter(listOfNumbers.subList(0, listOfNumbers.size() / 2));
        PrimeNumbersCounter primeNumbersCounter2 = new PrimeNumbersCounter(listOfNumbers.subList(listOfNumbers.size() / 2, listOfNumbers.size()));

        Thread thread1 = new Thread(primeNumbersCounter1);
        Thread thread2 = new Thread(primeNumbersCounter2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Integer leftPartOfList = primeNumbersCounter1.getCountOfPrimeNumbers();
        Integer rightPartOfList = primeNumbersCounter2.getCountOfPrimeNumbers();
        Integer sumOfCountNumbers = leftPartOfList + rightPartOfList;

        System.out.println("In the left part of a list there are " + leftPartOfList + " prime numbers.");
        System.out.println("In the right part of a list there are " + rightPartOfList + " prime numbers.");
        System.out.println("Total number of prima numbers in a least is " + sumOfCountNumbers + ".");


    }
}
