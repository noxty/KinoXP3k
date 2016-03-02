package GUI;

import Classes.Movie;
import Controller.GetMovieController;
import Controller.ScreeningController;
import Controller.TimeController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class ScreeningView
{
    public static VBox getView()
    {
        VBox layout = new VBox();
        GridPane layoutGrid = new GridPane();

        Label labelSearchTitle = new Label("Movie Title");

        Label labelTheatreID = new Label("Theatre");

        ComboBox<Movie> comboMovie = new ComboBox();

        comboMovie.getItems().addAll(GetMovieController.getMovies());
        comboMovie.setValue(comboMovie.getItems().get(0));

        ComboBox<String> comboTheater = new ComboBox<>();
        comboTheater.getItems().addAll("Den Store Sal", "Den Lille Sal");

        comboTheater.setValue(comboTheater.getItems().get(0));

        ComboBox<String> comboTime = new ComboBox<>();
        comboTime.getItems().addAll(getTimes(7));

        comboTime.setValue(comboTime.getItems().get(0));

        Button button = new Button("Create");

        button.setOnMouseClicked(e -> {
            ScreeningController sc = ScreeningController.getInstance();
            int mid = comboMovie.getSelectionModel().getSelectedItem().getId();

            int tid = 0;
            switch (comboTheater.getSelectionModel().getSelectedItem())
            {
                case "Den Store Sal":
                    tid = 0;
                    break;
                case "Den Lille Sal":
                    tid = 1;
                    break;
            }

            String time = comboTime.getSelectionModel().getSelectedItem();

            sc.createScreening(mid, tid, time);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Screening er oprettet");
            alert.setHeaderText("Din Screening er oprettet!");
            alert.setContentText
                    (
                            "Movie: " + comboMovie.getSelectionModel().getSelectedItem().getTitle() + "\n" +
                                    "Theater: " + comboTheater.getSelectionModel().getSelectedItem() + "\n" +
                                    "Time: " + time
                    );

            alert.showAndWait();

        });

        layoutGrid.add(labelSearchTitle, 0, 0);
        layoutGrid.add(comboMovie, 1, 0);
        layoutGrid.add(labelTheatreID, 0, 1);
        layoutGrid.add(comboTheater, 1, 1);
        layoutGrid.add(comboTime, 1, 2);
        layoutGrid.add(button, 1, 4);

        layout.getChildren().addAll(layoutGrid);

        return layout;
    }

    public static List<String> getTimes(int days)
    {
        List<String> times = new ArrayList<>();

        for (int i = 0; i < days; i++)
        {
            try
            {
                times.add(TimeController.getDateFromTS(TimeController.getTimeOfDay("15:00", i)));
                times.add(TimeController.getDateFromTS(TimeController.getTimeOfDay("18:00", i)));
                times.add(TimeController.getDateFromTS(TimeController.getTimeOfDay("21:00", i)));
            } catch (ParseException e)
            {
                // nothing of importance
            }
        }

        return times;
    }
}
