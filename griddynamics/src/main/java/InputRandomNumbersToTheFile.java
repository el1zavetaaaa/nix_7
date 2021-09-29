import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InputRandomNumbersToTheFile {


    int theAlgorithmThatGenerateRandomNumber(int min, int max) {
        return (int) ((System.currentTimeMillis() % max) + min);
    }

    public static int generationOfRandomNumber() {
        GenerateRandomNumbers randomGenerator = new GenerateRandomNumbers();
        int countValue = 0;
        int minimalValue = 1;
        int maximumValue = 25;
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        int count = minimalValue;
        int amountOfNumbers = 10000;
        while (count <= amountOfNumbers) {
            countValue = randomGenerator.theAlgorithmThatGenerateRandomNumber(minimalValue, maximumValue);
            if ((hashMap.get(countValue) == null) && countValue >= minimalValue && countValue <= maximumValue) {
                hashMap.put(countValue, 1);
                count++;
            }
        }

        return countValue;
    }

    public static void writeGeneratedNumbersIntoTheFile() {
        File file = new File("griddynamics/src/main/resources/randomNumbers.txt");
        FileWriter fileWriter = null;
        int amountOfNumbersTtoWriteIntoFile = 5;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int line;
            while (amountOfNumbersTtoWriteIntoFile > 0) {
                line = generationOfRandomNumber();
                bufferedWriter.write(line + " ,");
                amountOfNumbersTtoWriteIntoFile--;
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Operation is finished! You can open a randomNumbers.txt and see the result!" +
                "\n " + "Path to the file is: griddynamics/src/main/resources/randomNumbers.txt");
        System.out.println();
    }


}
