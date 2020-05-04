package MuseumVolunteer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;


public class Graph extends Application {
    MuseumMain newDatabase=new MuseumMain();
    MuseumInsert newInsertion=new MuseumInsert();

    public static Connection connect() {
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

    @Override public void start(Stage stage) {
        String sql ="SELECT * FROM Joins";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            stage.setTitle("Volunteer Times");
            final CategoryAxis yAxis = new CategoryAxis();
            final NumberAxis xAxis = new NumberAxis();
            xAxis.setLabel("Time");

            final LineChart<Number, String> lineChart =
                    new LineChart<Number,String>(xAxis,yAxis);

            lineChart.setTitle("Volunteer Times");
            XYChart.Series series;

            while(rs.next()) {
                ArrayList<XYChart.Series> holdNames= new ArrayList<XYChart.Series>();
                series=new XYChart.Series();
                if(!holdNames.contains(rs.getString("Name"))){
                    holdNames.add(series);
                    series.setName(rs.getString("Name"));

                    series.getData().add(new XYChart.Data(rs.getInt("TimeStart"), rs.getString("Name")));
                    series.getData().add(new XYChart.Data(rs.getInt("TimeEnd"), rs.getString("Name")));
                }
                else{
                    series.getData().add(new XYChart.Data(rs.getInt("TimeStart"), rs.getString("Name")));
                    series.getData().add(new XYChart.Data(rs.getInt("TimeEnd"), rs.getString("Name")));
                }
                lineChart.getData().addAll(series);

            }


            Scene scene  = new Scene(lineChart,800,600);


            stage.setScene(scene);
            stage.show();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void closeStatement(Statement stmt) {
        try {
            if (null != stmt) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        Graph runGraph=new Graph();

        MuseumMain newDatabase=new MuseumMain();
        newDatabase.createDatabases();
        MuseumInsert newInsertion=new MuseumInsert();
        newInsertion.runInsert();

        launch(args);
    }
}