package GUI;

import Classes.Screening;
import Data.DB;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by Hans on 23-02-2016.
 */
public class Home extends Application
{

    Double sceneWidth = 1024.0;
    Double sceneHeight = 768.0;

    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage stage)
    {
        BorderPane pane = new BorderPane();

        // TOP BAR
        HBox topBar = new HBox();

        // BUTTONS FOR TOP BAR
        Button buttonBooking = new Button("Bookings");
        Button buttonOpretForestiling = new Button("Opret Forestilling");
        Button buttonPlaceHolder = new Button("Placeholder");
        Button buttonAddMovie = new Button("Add Movie");
        Button buttonAddScreening = new Button("Add Screening");

        // INDSÆT KNAPPER I TOP BAR
        topBar.getChildren().addAll(buttonBooking, buttonAddMovie, buttonAddScreening);

        // SCROLL PANE
        ScrollPane scrollPane = new ScrollPane();


        scrollPane.setFitToWidth(true);
        scrollPane.setContent(HomeView.getView());

        // INDSÆT I BORDERPANE
        pane.setTop(topBar);
        pane.setCenter(scrollPane);

        // KONTROL AF KNAPPER
        buttonAddScreening.setOnMouseClicked(e -> {
            pane.setCenter(ScreeningView.getView());
        });

        buttonAddMovie.setOnMouseClicked(e -> {
            pane.setCenter(AddMovieView.getView());
        });
        buttonBooking.setOnMouseClicked(e -> {
            pane.setCenter(AddBookingView.getView());
        });

        DB db = DB.getInstance();
        db.getMoviesOnLaunch();

        Scene scene = new Scene(pane, sceneWidth, sceneHeight);
        scene.getStylesheets().add("KinoStyle.css");
        stage.setScene(scene);
        stage.show();
    }
}
