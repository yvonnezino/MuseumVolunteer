
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiniTests {
    Connection connection;

    @BeforeEach
    public void before() {
        connection = Graph.connect();
    }

    @AfterEach
    public void after() {
        Graph.connect();
    }
    @Test
    public void closeStatementShouldCloseStatement() throws SQLException {
        Statement statement = connection.createStatement();
        Graph.closeStatement(statement);
        assertTrue(statement.isClosed());
    }

}
