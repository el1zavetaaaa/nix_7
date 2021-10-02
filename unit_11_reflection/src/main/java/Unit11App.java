import entity.User;
import util.AppProperties;

public class Unit11App {
    public static void main(String[] args) {
        AppProperties props = new AppProperties();
        User user = props.checkIfInitialize(User.class);
        System.out.println(user);
    }
}
