package level1.tasks;

import java.util.Scanner;

public class KnightMove {
    public static void KnightMove() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the current position of knight:");
        System.out.println("Enter x1:");
        int x1 = in.nextInt();
        System.out.println("Enter y1:");
        int y1 = in.nextInt();
        System.out.println("Enter the place you wanna go:");
        System.out.println("Enter x2:");
        int x2 = in.nextInt();
        System.out.println("Enter y2:");
        int y2 = in.nextInt();
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);
        if (dx == 1 && dy == 2 || dx == 2 && dy == 1)
            System.out.println("Great");
        else
            System.out.println("You can't go there");

    }

}