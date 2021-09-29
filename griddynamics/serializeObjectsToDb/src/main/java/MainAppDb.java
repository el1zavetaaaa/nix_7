import service.ConnectionToSql;

public class MainAppDb {
    public static void main(String[] args) {
        ConnectionToSql connectionToSql = new ConnectionToSql();
        connectionToSql.minimalDistance();
    }
}
