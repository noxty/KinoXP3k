package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


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
        Button buttonMovie = new Button("Movie");
        Button buttonScreening = new Button("Screening");
        Button buttonHome = new Button("Home");

        // INDSÆT KNAPPER I TOP BAR
        topBar.getChildren().addAll(buttonHome, buttonBooking, buttonMovie, buttonScreening);

        // SCROLL PANE
        ScrollPane scrollPane = new ScrollPane();


        scrollPane.setFitToWidth(true);
        scrollPane.setContent(ShowMovies.getHBox());

        // INDSÆT I BORDERPANE
        pane.setTop(topBar);
        pane.setCenter(scrollPane);

        // KONTROL AF KNAPPER


        buttonHome.setOnMouseClicked(e -> {
            pane.setCenter(ShowMovies.getHBox());
        });

        buttonMovie.setOnMouseClicked(e -> {
            pane.setCenter(SubMovies.subWindow());
        });
        buttonBooking.setOnMouseClicked(e -> {
            pane.setCenter(SubBooking.subWindow());
        });

        Scene scene = new Scene(pane, sceneWidth, sceneHeight);
        scene.getStylesheets().add("KinoStyle.css");
        stage.setScene(scene);
        stage.show();
    }
}
