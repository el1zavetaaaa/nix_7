package level1.tasks;

import java.util.Scanner;

public class UniqueSymbols {
    public static void UniqueSymbols() {
        System.out.println("Enter your string: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.toLowerCase();
        int uniqueChars = 0;
        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) != str.charAt(i+1 ))
                uniqueChars++;
        }
        System.out.println("There are " + uniqueChars + " unique characters in your string.");
    }


}