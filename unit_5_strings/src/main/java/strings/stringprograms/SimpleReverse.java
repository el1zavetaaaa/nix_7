package strings.stringprograms;

import java.util.Scanner;

public class SimpleReverse {
    public static String simplereverse(String str) {
        char[] charArray = str.toCharArray();
        String resultString = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            resultString += charArray[i];

        }

        return resultString;
    }
}


