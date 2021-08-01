package strings.stringprograms;


public class SimpleReverse {
    public static String simplereverse(String inputString) {


        char[] charArray = inputString.toCharArray();
        String resultString = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            resultString += charArray[i];

        }

        return resultString;
    }
}