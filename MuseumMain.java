
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author imssbora
 */
public class MuseumMain {

    private static final String CREATE_PEOPLE_TABLE_SQL="CREATE TABLE People ("
            + "ID int NOT NULL,"
            + "Name string NOT NULL,"
            + "Age int NOT NULL)"
;
    private static final String CREATE_TIME_TABLE_SQL ="CREATE TABLE Time ("
            + "ID int NOT NULL,"
            + "Time Slot string NOT NULL)"
            ;

    public static void main(String[] args) {
        String url = "jdbc:sqlite:/Users/parkerkerth/Documents/School/Software/Mueseum/People.db";


        Connection conn = null;
        PreparedStatement stmt_people = null;
        PreparedStatement stmt_time = null;

        try {

            conn = DriverManager.getConnection(url);
            stmt_people = conn.prepareStatement(CREATE_PEOPLE_TABLE_SQL);
            stmt_time = conn.prepareStatement(CREATE_TIME_TABLE_SQL);

            stmt_people.executeUpdate();
            stmt_time.executeUpdate();


            System.out.println("Table created");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt_people != null) {
                    stmt_people.close();
                }
                if (stmt_time!= null) {
                    stmt_time.close();
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