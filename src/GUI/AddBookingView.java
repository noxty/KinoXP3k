package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Hans on 24-02-2016.
 */
public class AddBookingView
{
    public static VBox getView() {
        VBox layout = new VBox();
        GridPane layoutGrid = new GridPane();
        int gaps = 10;

        layoutGrid.setHgap(gaps);
        layoutGrid.setVgap(gaps);

        // Search
        Label labelSearchTitle = new Label("Search");
        Label labelSearchYear = new Label("Year");

        TextField fieldSearchTitle = new TextField();
        TextField fieldSearchYear = new TextField();

        Button buttonSearch = new Button("Search");

        HBox searchBox = new HBox(gaps);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        searchBox.getChildren().addAll(fieldSearchTitle, labelSearchYear, fieldSearchYear, buttonSearch);

        // Buttons
        Button buttonAdd = new Button("Add Movie");
        Button buttonClear = new Button("Clear All");

        HBox buttonBox = new HBox(gaps);
        buttonBox.getChildren().addAll(buttonAdd, buttonClear);

        // Tid, antal sæder, sal, sæde numre;

        Label labelDate = new Label("Date");
        Label labelSeats = new Label("Seats");
        Label labelTheater = new Label("Theater");

        ComboBox<String> comboSeats = new ComboBox<>();


        layoutGrid.add(labelDate, 0, 0);
        layoutGrid.add(DateBox.getDateBox(), 1, 0);
        layoutGrid.add(labelSeats, 0, 1);
        layoutGrid.add(comboSeats, 1, 1);

        // Standard Formula
        /*
        Label labelTitle = new Label("Title");
        Label labelDescription = new Label("Description");
        Label labelAgeRestriction = new Label("Age Restriction");
        Label labelPlaytime = new Label("Playtime");
        Label labelPremiere = new Label("Premiere");
        Label labelPrice = new Label("Price");
        Label labelGenre = new Label("Genre");

        TextField fieldTitle = new TextField();
        TextArea fieldDescription = new TextArea();
        TextField fieldAgeRestriction = new TextField();
        TextField fieldPlaytime = new TextField();
        TextField fieldPremiere = new TextField();
        TextField fieldPrice = new TextField();
        TextField fieldGenre = new TextField();

        layoutGrid.add(labelSearchTitle, 0, 0);
        layoutGrid.add(searchBox, 1, 0);
        layoutGrid.add(labelTitle, 0, 1);
        layoutGrid.add(fieldTitle, 1, 1);
        layoutGrid.add(labelDescription, 0, 2);
        layoutGrid.add(fieldDescription, 1, 2);
        layoutGrid.add(labelGenre, 0, 3);
        layoutGrid.add(fieldGenre, 1, 3);
        layoutGrid.add(labelAgeRestriction, 0, 4);
        layoutGrid.add(fieldAgeRestriction, 1, 4);
        layoutGrid.add(labelPlaytime, 0, 5);
        layoutGrid.add(fieldPlaytime, 1, 5);
        layoutGrid.add(labelPremiere, 0, 6);
        layoutGrid.add(fieldPremiere, 1, 6);
        layoutGrid.add(labelPrice, 0, 7);
        layoutGrid.add(fieldPrice, 1, 7);
        layoutGrid.add(buttonBox, 1, 8);
        */


        layout.getChildren().add(layoutGrid);
        return layout;
    }
}
