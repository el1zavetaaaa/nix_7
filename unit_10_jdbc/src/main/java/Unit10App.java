import service.PathFinderService;

public class Unit10App {
    public static void main(String[] args) {
        PathFinderService connectionToSql = new PathFinderService();
        connectionToSql.minimalDistance();
    }
}
