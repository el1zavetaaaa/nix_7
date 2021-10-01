import collect.CollectObjects;
import entity.Table;

public class Unit12App {
    public static void main(String[] args) {
        CollectObjects objects = new CollectObjects();
        Table table = objects.data();

        System.out.print(table.cell(1, "name"));
        System.out.print("," + "  ");
        System.out.print(table.cell(1, 2));
        System.out.print("," + "  ");
        System.out.print(table.cell(1, 4));
        System.out.print("," + "  ");
        System.out.println(table.cell(1, 5));

        System.out.print(table.cell(2, "name"));
        System.out.print("," + "  ");
        System.out.print(table.cell(2, 2));
        System.out.print("," + "  ");
        System.out.print(table.cell(2, 4));
        System.out.print("," + "  ");
        System.out.println(table.cell(2, 5));

        System.out.print(table.cell(3, "name"));
        System.out.print("," + "  ");
        System.out.print(table.cell(3, 2));
        System.out.print("," + "  ");
        System.out.print(table.cell(3, 4));
        System.out.print("," + "  ");
        System.out.println(table.cell(3, 5));


        System.out.println("\nHeaders: ");
        for (String s : table.getHeader()) {
            System.out.print(s + "  ");
        }

    }
}
