package GUI;
import Data.DB;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.SQLException;

public class Home extends Application
{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Double sceneWidth = screenSize.getWidth();
    Double sceneHeight = screenSize.getHeight();

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
        Button buttonHome = new Button("Home");
        Button buttonBooking = new Button("Bookings");
        Button buttonMovie = new Button("Movie");
        Button buttonScreening = new Button("Screening");
        Button buttonBookingOverview = new Button("Booking Overview");

        //Bliver ikke brugt: Button buttonOpretForestiling = new Button("Opret Forestilling");
        //Bliver ikke brugt: Button buttonPlaceHolder = new Button("Placeholder");

        // INDSÆT KNAPPER I TOP BAR
        topBar.getChildren().addAll(buttonHome,buttonBooking, buttonMovie, buttonScreening, buttonBookingOverview);

        // Set padding and spacing for topBar
        topBar.setPadding(new Insets(10, 10, 10, 10));
        topBar.setSpacing(10);
        topBar.setAlignment(Pos.CENTER);

        // SCROLL PANE
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setFitToWidth(true);
        scrollPane.setContent(ShowMovies.getHBox());

        // INDSÆT I BORDERPANE
        pane.setTop(topBar);
        pane.setCenter(scrollPane);

        // KONTROL AF KNAPPER
        buttonHome.setOnMouseClicked(actionEvent ->
        {
            scrollPane.setContent(ShowMovies.getHBox());
            pane.setCenter(scrollPane);
        });

        buttonScreening.setOnMouseClicked(actionEvent ->
        {
            pane.setCenter(SubScreening.subWindow());
        });

        buttonMovie.setOnMouseClicked(e ->
        {
            pane.setCenter(SubMovies.subWindow());
        });

        buttonBooking.setOnMouseClicked(e ->
        {
            pane.setCenter(SubBooking.subWindow());
        });

        buttonBookingOverview.setOnMouseClicked(e ->
        {
            pane.setCenter(BookingOverview.getView());
        });

        // SET SCENE/STAGE
        Scene scene = new Scene(pane, sceneWidth, sceneHeight);
        scene.getStylesheets().add("KinoStyle.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void setPane(BorderPane pane)
    {
        pane.setCenter(pane);
    }
}