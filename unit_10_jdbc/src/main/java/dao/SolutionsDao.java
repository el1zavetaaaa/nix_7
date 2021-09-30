package dao;

import entity.Solutions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SolutionsDao {
    private final Connection connection;

    private static final String INSERT = "INSERT INTO solutions (problem_id, cost) VALUES (?, ?)";

    public SolutionsDao(Connection connection) {
        this.connection = connection;
    }

    public void saveAll(List<Solutions> solutions) {

        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            for (Solutions solution : solutions) {
                statement.setInt(1, solution.getProblem_id());
                statement.setInt(2, solution.getCost());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
