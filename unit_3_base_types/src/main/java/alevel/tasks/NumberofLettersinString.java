package alevel.tasks;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberofLettersinString {

    public static void numberoflettersinstring() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            boolean shouldBreak = false;
            System.out.print("Введите строку: ");
            String str = scanner.nextLine();
            String test = str.replaceAll("[^a-zA-Zа-яА-Я]", "");
            if ("".equals(test)) {
                break;
            }
            Map<Character, Integer> map = new TreeMap<Character, Integer>();
            for (char c : test.toCharArray()) {
                map.put(c, (map.containsKey(c)) ? map.get(c) + 1 : 1);
            }
            StringBuilder sb = new StringBuilder();
            for (char c : map.keySet()) {
                sb.append(c);
            }
            System.out.println("Unique characters: \"" + sb.toString() + "\"");
            for (char c : map.keySet()) {
                System.out.printf("'%c'\t%d\n", c, map.get(c));
            }
            System.out.println();
            if (shouldBreak) {
                break;
            }
            shouldBreak = true;
        }
    }
}
