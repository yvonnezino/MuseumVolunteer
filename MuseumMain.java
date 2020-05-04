package MuseumVolunteer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author imssbora
 */
public class MuseumMain {

    private static final String CREATE_PEOPLE_TABLE_SQL = "CREATE TABLE People ("
            + "ID INT NOT NULL,"
            + "Name STRING NOT NULL,"
            + "Age INT NOT NULL)";

    private static final String CREATE_TIME_TABLE_SQL = "CREATE TABLE Time ("
            + "ID INT NOT NULL,"
            + "TimeStart INT NOT NULL,"
            +"TimeEnd INT NOT NULL)";


    private static final String CREATE_JOIN_TABLE_SQL ="CREATE TABLE Joins ("
            + "ID INT NOT NULL,"
            + "Age INT NOT NULL,"
            + "Name STRING NOT NULL,"
            + "TimeStart INT NOT NULL,"
            + "TimeEnd INT NOT NULL)";



    //public static void main(String[] args) {
    public void createDatabases(){
        String url = "jdbc:sqlite:People.db";
        //String url = "jdbc:sqlite:/Users/parkerkerth/Documents/School/Software/Mueseum/People.db";


        Connection conn = null;
        PreparedStatement stmt_people = null;
        PreparedStatement stmt_time = null;
        PreparedStatement stmt_join = null;



        try {

            conn = DriverManager.getConnection(url);
            stmt_people = conn.prepareStatement(CREATE_PEOPLE_TABLE_SQL);
            stmt_time = conn.prepareStatement(CREATE_TIME_TABLE_SQL);
            stmt_join = conn.prepareStatement(CREATE_JOIN_TABLE_SQL);




            stmt_people.executeUpdate();
            stmt_time.executeUpdate();
            stmt_join.executeUpdate();


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
               if (stmt_join!= null) {
                  stmt_join.close();
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