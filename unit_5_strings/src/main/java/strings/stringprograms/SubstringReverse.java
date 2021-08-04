package strings.stringprograms;

import java.util.Scanner;

public class SubstringReverse {
    public static void reversesubstring(String str) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите часть строки:");
        String substring = in.nextLine();
        String reversesubstring = SimpleReverse.simplereverse(substring);
        String reversestring = str.replaceAll(substring, reversesubstring);
        System.out.println(reversestring);
    }

}
