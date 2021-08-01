package strings.stringprograms;

import java.util.Scanner;


public class SubstringReverse {
    public static void substringreverse(String str) {

        Scanner console = new Scanner(System.in);
        System.out.println("Введите часть строки:");
        String dest = console.nextLine();
        String reversedest = SimpleReverse.simplereverse(dest);
        String reversestring = str.replaceAll(dest, reversedest);
        System.out.println(reversestring);
    }

}