
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author imssbora
 */
public class MuseumMain {

    private static final String CREATE_TABLE_SQL="CREATE TABLE People ("
            + "Name int NOT NULL,"
            + "Age int NOT NULL,"
;

    public static void main(String[] args) {
        String url = "jdbc:sqlite:/Users/parkerkerth/Documents/School/Software/Mueseum/People.db";


        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = DriverManager.getConnection(url);
            stmt = conn.prepareStatement(CREATE_TABLE_SQL);
            stmt.executeUpdate();

            System.out.println("Table created");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}