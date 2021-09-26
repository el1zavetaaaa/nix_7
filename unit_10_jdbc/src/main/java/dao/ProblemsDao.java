package dao;

import entity.Problems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemsDao {
    private final Connection connection;

    private static final String ALL = "SELECT * FROM problems LEFT JOIN solutions ON solutions.problem_id=problems.id WHERE cost is NULL";

    public ProblemsDao(Connection connection) {
        this.connection = connection;
    }


    public List<Problems> allProblems() {
        List<Problems> problems = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Problems problem = new Problems();
                problem.setId(resultSet.getInt(1));
                problem.setFrom_id(resultSet.getInt(2));
                problem.setTo_id(resultSet.getInt(3));
                problems.add(problem);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return problems;
    }
}
