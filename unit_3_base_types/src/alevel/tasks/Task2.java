package alevel.tasks;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task2 {
    public static void task2() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("String: ");
            String str = scanner.nextLine();
            String test = str.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "");
            if ("".equals(test))
                break;

            Map<Character, Integer> map = new TreeMap<Character, Integer>();
            for (char c : test.toCharArray())
                map.put(c, (map.containsKey(c)) ? map.get(c) + 1 : 1);

            StringBuilder sb = new StringBuilder();
            for (char c : map.keySet())
                sb.append(c);
            System.out.println("Unique characters: \"" + sb.toString() + "\"");
            for (char c : map.keySet())
                System.out.printf("'%c'\t%d\n", c, map.get(c));

            System.out.println();
        }
    }

}
