package GUI;

import Controller.CreateMovieController;
import Controller.TimeController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Map;


public class AddMovieView
{
    private static String poster;

    public static VBox getView()
    {
        VBox layout = new VBox();
        GridPane layoutGrid = new GridPane();
        int gaps = 10;

        poster = "";
        layoutGrid.setHgap(gaps);
        layoutGrid.setVgap(gaps);

        // Search
        Label labelSearchTitle = new Label("Search");
        Label labelSearchYear = new Label("Year");

        TextField fieldSearchTitle = new TextField();
        TextField fieldSearchYear = new TextField();

        Button buttonSearch = new Button("Search");
        buttonSearch.setStyle("-fx-background-color: pink;-fx-box-shadow:10px 10px 10px 10px");

        HBox searchBox = new HBox(gaps);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        searchBox.getChildren().addAll(fieldSearchTitle, labelSearchYear, fieldSearchYear, buttonSearch);

        // Buttons
        Button buttonAdd = new Button("Add Movie");
        buttonAdd.setStyle("-fx-background-color: pink;-fx-box-shadow:10px 10px 10px 10px");

        Button buttonClear = new Button("Clear All");
        buttonClear.setStyle("-fx-background-color: pink;-fx-box-shadow:10px 10px 10px 10px");

        HBox buttonBox = new HBox(gaps);
        buttonBox.getChildren().addAll(buttonAdd, buttonClear);

        // Standard Formula
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


        buttonSearch.setOnMouseClicked(e -> {
            Controller.imdbReader reader = new Controller.imdbReader();
            int year = 0;
            try
            {
                year = Integer.parseInt(fieldSearchYear.getText());
            } catch (NumberFormatException nfe)
            {
                // Do nothing
            }
            Map<String, String> info = reader.getInfo(fieldSearchTitle.getText(), year);

            if (info.containsKey("error"))
            {
                fieldTitle.setText(info.get("error"));
                fieldDescription.setText("");
                fieldGenre.setText("");
                fieldAgeRestriction.setText("");
                fieldPlaytime.setText("");
                fieldPremiere.setText("");
                fieldPrice.setText("");
            } else
            {
                fieldTitle.setText(info.get("title") + " (" + info.get("year") + ")");
                fieldDescription.setText(info.get("description") + "\n" + "Director: " + info.get("director") + "\n" + "Actors: " + info.get("actors"));
                fieldGenre.setText(info.get("genre"));
                fieldAgeRestriction.setText("Rating: " + info.get("rating"));
                fieldPlaytime.setText(info.get("playtime"));
                fieldPremiere.setText(info.get("release"));
                poster = info.get("poster");
            }
        });

        buttonAdd.setOnMouseClicked(e -> {
            Data.DB database = Data.DB.getInstance();

            int ageRestrict = 0;
            try
            {
                ageRestrict = Integer.parseInt(fieldAgeRestriction.getText());
            } catch (NumberFormatException nfe)
            {
                // do nothing
            }

            int playTime = 0;
            try
            {
                playTime = Integer.parseInt(fieldPlaytime.getText());
            } catch (NumberFormatException nfe)
            {
                // do nothing
            }

            int price = 0;
            try
            {
                price = Integer.parseInt(fieldPrice.getText());
            } catch (NumberFormatException nfe)
            {
                // do nothing
            }

            long ts = TimeController.getUnixTime(fieldPremiere.getText());

            CreateMovieController cmc = CreateMovieController.getInstance();

            cmc.createMovie(fieldTitle.getText(), fieldDescription.getText(), ageRestrict, playTime, TimeController.formatForDB(ts), true, price, poster);


            // public void createMovie(String title, String description, int ageRestriction, int playingTime, long premiere, boolean movieStatus, double price)
        });

        layout.getChildren().add(layoutGrid);
        return layout;
    }
}
