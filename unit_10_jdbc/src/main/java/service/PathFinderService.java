package service;

import dao.LocationDao;
import dao.ProblemsDao;
import dao.RouteDao;
import dao.SolutionsDao;
import entity.Problems;
import entity.Route;
import entity.Solutions;
import util.MinimalDistance;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PathFinderService {
    public void minimalDistance() {
        Properties properties = loadProperties();

        String url = properties.getProperty("url");

        try (Connection connection = DriverManager.getConnection(url, properties)) {
            LocationDao locationDao = new LocationDao(connection);
            ProblemsDao problemDao = new ProblemsDao(connection);
            RouteDao routeDao = new RouteDao(connection);
            SolutionsDao solutionDao = new SolutionsDao(connection);

            int cities = locationDao.allLocations().size();

            List<Problems> problems = problemDao.getUnsolvedProblems();

            int[][] matrix = new int[cities][cities];
            List<Route> routes = routeDao.allRoutes();
            int i, j;
            for (Route r : routes) {
                i = r.getFrom_id() - 1;
                j = r.getTo_id() - 1;
                matrix[i][j] = r.getCost();
            }

            List<Solutions> solutions = new ArrayList<>();
            MinimalDistance distances = new MinimalDistance();
            int[][] results = distances.distance(cities, matrix);
            for (Problems p : problems) {
                int id = p.getId();
                int distance = results[p.getFrom_id() - 1][p.getTo_id() - 1];
                Solutions solution = new Solutions();
                solution.setProblem_id(id);
                solution.setCost(distance);
                solutions.add(solution);
            }
            solutionDao.saveAll(solutions);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Properties loadProperties() {

        Properties props = new Properties();

        try (InputStream input = PathFinderService.class.getResourceAsStream("/jdbc.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }
}
