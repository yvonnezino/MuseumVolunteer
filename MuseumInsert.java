//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MuseumInsert {
    public MuseumInsert() {
    }

    private Connection connect() {
        String url = "jdbc:sqlite:/Users/parkerkerth/Documents/School/Software/Mueseum/People.db";
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
    public void insert_time(int ID, String time) {
        String sql_times = "INSERT INTO Time(ID,Time) VALUES(?,?)";

        try {
            Connection conn = this.connect();
            Throwable var6 = null;

            try {
                PreparedStatement pstmt_times = conn.prepareStatement(sql_times);
                Throwable var8 = null;

                try {
                    pstmt_times.setInt(1, ID);
                    pstmt_times.setString(2, time);
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




    public static void main(String[] args) {
        MuseumInsert app = new MuseumInsert();
        app.insert_people(1, "John", 50);
        app.insert_people(2, "Mary", 20);
        app.insert_people(3, "Adam", 33);

        app.insert_time(1, "9am-11am");
        app.insert_time(2, "11am-2pm");
        app.insert_time(3, "2pm-6pm");




    }
}
