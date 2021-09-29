import java.util.HashMap;
import java.util.Map;

public class GenerateRandomNumbers {


    int theAlgorithmThatGenerateRandomNumber(int min, int max) {
        return (int) ((System.currentTimeMillis() % max) + min);
    }

    public static void generationOfRandomNumber() {
        GenerateRandomNumbers randomGenerator = new GenerateRandomNumbers();
        int countValue = 0;
        int minimalValue = 1;
        int maximumValue = 25;
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        int count = minimalValue;
        int amountOfNumbers = 5;
        while (count <= amountOfNumbers) {
            countValue = randomGenerator.theAlgorithmThatGenerateRandomNumber(minimalValue, maximumValue);
            if ((hashMap.get(countValue) == null) && countValue >= minimalValue && countValue <= maximumValue) {
                System.out.print(countValue + ",");
                hashMap.put(countValue, 1);
                count++;
            }
        }
        System.out.print("\n");
        System.out.println();
    }
}





