package level1.tasks;

import java.util.Scanner;

public class TriangleArea {
    public static void TriangleArea() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter coordinates of point L - lx:");
        int lx = in.nextInt();
        System.out.println("Please enter coordinates of point L - ly:");
        int ly = in.nextInt();
        System.out.println("Please enter coordinates of point E - ex:");
        int ex = in.nextInt();
        System.out.println("Please enter coordinates of point E - ey:");
        int ey = in.nextInt();
        System.out.println("Please enter coordinates of point O - ox:");
        int ox = in.nextInt();
        System.out.println("Please enter coordinates of point O - oy:");
        int oy = in.nextInt();
        int LE = (int) Math.sqrt(Math.pow((ex - lx), 2) * Math.pow((ey - ly), 2));
        int LO = (int) Math.sqrt(Math.pow((ox - lx), 2) * Math.pow((oy - ly), 2));
        int EO = (int) Math.sqrt(Math.pow((ox - ex), 2) * Math.pow((oy - ey), 2));
        if ((LE + LO > EO) || (LO + EO > LE) || (LE + EO > LO)) {
            double area = ((lx - ex) * (oy - ey) - (ox - ex) * (ly - ey)) / 2.0;
            System.out.println("Area of triangle LEO = " + area);
        } else
            System.out.println("This triangle does not exist");
    }


}