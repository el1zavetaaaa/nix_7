package alevel.tasks;

import java.util.Scanner;

public class SumofNumbersinString {

    public static void sumofnumbersinstring() {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = in.nextLine();
        int a[] = new int[100];
        int number = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                number = Integer.valueOf(str.substring(i, i + 1)).intValue();
                a[i] = number;
                result += a[i];
            }


        }

        System.out.println(result);


    }
}