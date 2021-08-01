package strings.stringprograms;

import java.util.Scanner;

public class ReverseByChar {
    public static void reversebychar(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первый символ:");
        char firstchar = sc.next().charAt(0);
        System.out.println("Введите последний символ:");
        char lastchar = sc.next().charAt(0);
        int firstIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (firstchar == str.charAt(i))
                firstIndex = i;
        }
        for (int i = firstIndex; i < str.length(); i++) {
            if (lastchar == str.charAt(i))
                lastIndex = i;
        }
        ReverseByIndex.reversebyindex(str, firstIndex, lastIndex);
    }
}