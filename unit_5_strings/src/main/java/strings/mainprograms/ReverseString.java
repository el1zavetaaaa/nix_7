package strings.mainprograms;

import java.util.Scanner;

public class ReverseString {
    private ReverseString() {
    }

    public static String simplereverse(String str) {
        char[] charArray = str.toCharArray();
        String resultString = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            resultString += charArray[i];

        }

        return resultString;
    }

    public static void reversesubstring(String str) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите часть строки:");
        String substring = in.nextLine();
        String reversesubstring = ReverseString.simplereverse(substring);
        String reversestring = str.replaceAll(substring, reversesubstring);
        System.out.println(reversestring);
    }

    public static void reversebyindex(String str, int index1, int index2) {

        String indexstring = "";
        for (int i = index1; i < index2; i++) {
            indexstring = indexstring + str.charAt(i);
        }
        String reverseindexstring = ReverseString.simplereverse(indexstring);
        String reversestring = str.replaceAll(indexstring, reverseindexstring);

        System.out.println(reversestring);

    }

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
        ReverseString.reversebyindex(str, firstIndex, lastIndex);
    }
}