package GUI;
import Data.DB;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Home extends Application
{
    Double sceneWidth = 1024.0;
    Double sceneHeight = 768.0;

    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage stage) {

        DB db = DB.getInstance();
        BorderPane pane = new BorderPane();

        // TOP BAR
        HBox topBar = new HBox();

        // BUTTONS FOR TOP BAR
        Button buttonBooking = new Button("Bookings");
        Button buttonAddMovie = new Button("Add Movie");
        Button buttonAddScreening = new Button("Add Screening");
        Button testingBookingOverview = new Button("Testing Booking Overview");
        //Bliver ikke brugt: Button buttonOpretForestiling = new Button("Opret Forestilling");
        //Bliver ikke brugt: Button buttonPlaceHolder = new Button("Placeholder");

        // INDSÆT KNAPPER I TOP BAR
        topBar.getChildren().addAll(buttonBooking, buttonAddMovie, buttonAddScreening, testingBookingOverview);

        // SCROLL PANE
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setFitToWidth(true);
        scrollPane.setContent(HomeView.getView());

        // INDSÆT I BORDERPANE
        pane.setTop(topBar);
        pane.setCenter(scrollPane);

        // KONTROL AF KNAPPER
        buttonAddScreening.setOnMouseClicked(actionEvent ->
        {
            pane.setCenter(ScreeningView.getView());
        });

        buttonAddMovie.setOnMouseClicked(e ->
        {
            pane.setCenter(AddMovieView.getView());
        });

        buttonBooking.setOnMouseClicked(e ->
        {
            pane.setCenter(AddBookingView.getView());
        });

        testingBookingOverview.setOnMouseClicked(e ->
        {
            pane.setCenter(BookingOverview.getView());
        });

        // SET SCENE/STAGE
        Scene scene = new Scene(pane, sceneWidth, sceneHeight);
        scene.getStylesheets().add("KinoStyle.css");
        stage.setScene(scene);
        stage.show();
    }
}