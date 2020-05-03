import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class Graph extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Hours");
        yAxis.setLabel("Person");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Time Chart");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        XYChart.Series person1 = new XYChart.Series();
        person1.setName("Person1");
        person1.getData().add(new XYChart.Data(1, 23));
        person1.getData().add(new XYChart.Data(1, 23));
        person1.getData().add(new XYChart.Data(1, 23));

        XYChart.Series person2 = new XYChart.Series();
        person2.setName("Person2");
        person2.getData().add(new XYChart.Data(1, 23));
        person2.getData().add(new XYChart.Data(1, 23));
        person2.getData().add(new XYChart.Data(1, 23));

        XYChart.Series person3 = new XYChart.Series();
        person3.setName("Person3");
        person3.getData().add(new XYChart.Data(1, 23));
        person3.getData().add(new XYChart.Data(1, 23));
        person3.getData().add(new XYChart.Data(1, 23));


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}