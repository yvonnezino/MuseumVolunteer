//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.sql.*;


public class MuseumInsert {
    public MuseumInsert() {
    }

    public Connection connect() {
        //String url = "jdbc:sqlite:/Users/yvonnezino/IdeaProjects/CP274Weekend1/People.db";
        String url = "jdbc:sqlite:People.db";
        //String url = "jdbc:sqlite:/Users/parkerkerth/Documents/School/Software/Mueseum/People.db";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException var4) {
            System.out.println(var4.getMessage());
        }

        return conn;
    }

    public void insert_people(int ID, String name, int age) {
        String sql_people = "INSERT INTO People(ID,Name,Age) VALUES(?,?,?)";

        try {
            Connection conn = this.connect();
            Throwable var6 = null;

            try {
                PreparedStatement pstmt_people = conn.prepareStatement(sql_people);
                Throwable var8 = null;

                try {
                    pstmt_people.setInt(1, ID);
                    pstmt_people.setString(2, name);
                    pstmt_people.setInt(3, age);

                    pstmt_people.executeUpdate();
                } catch (Throwable var33) {
                    var8 = var33;
                    throw var33;
                } finally {
                    if (pstmt_people != null) {
                        if (var8 != null) {
                            try {
                                pstmt_people.close();
                            } catch (Throwable var32) {
                                var8.addSuppressed(var32);
                            }
                        } else {
                            pstmt_people.close();
                        }
                    }

                }
            } catch (Throwable var35) {
                var6 = var35;
                throw var35;
            } finally {
                if (conn != null) {
                    if (var6 != null) {
                        try {
                            conn.close();
                        } catch (Throwable var31) {
                            var6.addSuppressed(var31);
                        }
                    } else {
                        conn.close();
                    }
                }

            }
        } catch (SQLException var37) {
            System.out.println(var37.getMessage());
        }

    }
    public void insert_time(int ID, int timeStart,int timeEnd) {
        String sql_times = "INSERT INTO Time(ID,TimeStart,TimeEnd) VALUES(?,?,?)";

        try {
            Connection conn = this.connect();
            Throwable var6 = null;

            try {
                PreparedStatement pstmt_times = conn.prepareStatement(sql_times);
                Throwable var8 = null;

                try {
                    pstmt_times.setInt(1, ID);
                    pstmt_times.setInt(2, timeStart);
                    pstmt_times.setInt(3, timeEnd);
                    pstmt_times.executeUpdate();
                } catch (Throwable var33) {
                    var8 = var33;
                    throw var33;
                } finally {
                    if (pstmt_times != null) {
                        if (var8 != null) {
                            try {
                                pstmt_times.close();
                            } catch (Throwable var32) {
                                var8.addSuppressed(var32);
                            }
                        } else {
                            pstmt_times.close();
                        }
                    }

                }
            } catch (Throwable var35) {
                var6 = var35;
                throw var35;
            } finally {
                if (conn != null) {
                    if (var6 != null) {
                        try {
                            conn.close();
                        } catch (Throwable var31) {
                            var6.addSuppressed(var31);
                        }
                    } else {
                        conn.close();
                    }
                }

            }
        } catch (SQLException var37) {
            System.out.println(var37.getMessage());
        }

    }
    public void insert_Joins(){

        String sql ="INSERT INTO Joins(ID,Age,Name,TimeStart,TimeEnd) SELECT People.ID,People.Age,People.Name,Time.TimeStart,Time.TimeEnd FROM People INNER JOIN Time ON People.ID=Time.ID " ;
        try (Connection conn = this.connect()) {
            Statement stmt = conn.createStatement();
            String query =sql;
            ResultSet rs = stmt.executeQuery(query);
        }
           catch (SQLException e) {
            System.out.println(e.getMessage());
        }

}




    //public static void main(String[] args) {
    public void runInsert(){
        String sql ="SELECT * FROM People";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            if (rs.next()) {
                return;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        MuseumInsert app = new MuseumInsert();
        app.insert_people(1, "John", 50);
        app.insert_people(2, "Mary", 20);
        app.insert_people(3, "Adam", 33);

        app.insert_time(1, 900,1100);
        app.insert_time(2, 1100,1300);
        app.insert_time(3, 1300,1500);
        app.insert_Joins();



    }
}
