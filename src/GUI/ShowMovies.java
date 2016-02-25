package GUI;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Created by Hans on 23-02-2016.
 */
public class ShowMovies
{

    private static Double movieBoxWidth = 300.0;
    private static Double movieBoxHeight = 400.0;

    private static Double movieInfoHeight = 100.0;

    private static Double movieBoxInfoLeft = 120.0;
    private static Double movieBoxInfoRight = movieBoxWidth - movieBoxInfoLeft;

    private static int moviesPerRow = 3;
    private static Pos rowAlignment = Pos.TOP_CENTER;


    public static VBox getHBox() {
        VBox layout = new VBox();

        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("BookingHBox");

        int temporarySize = 12;
        int gap = 10;

        // BOOKING TITEL

        Text titleText = new Text("Vælg Titel");
        layout.getChildren().add(titleText);

        VBox column = new VBox(gap);

        column.widthProperty().addListener(e -> {
            System.out.println(column.getWidth());
        });

        //column.getStyleClass().add("v-box");
        HBox row = new HBox(gap);
        row.setAlignment(rowAlignment);
        column.setAlignment(Pos.CENTER);

        for (int i = 0; i < temporarySize; i++) {

            VBox movieBox = new VBox();


            Text movieTitle = new Text("Film Titel");
            HBox moviePosterBox = new HBox();
            HBox movieInfoBox = new HBox(10);
            VBox movieInfoLeftBox = new VBox();
            VBox movieInfoRightBox = new VBox();

            movieInfoLeftBox.setPrefWidth(movieBoxWidth);
            movieInfoRightBox.setPrefWidth(movieBoxInfoRight);
            //
            Label movieLabelYear = new Label("Year");
            Label movieLabelAgeRestriction = new Label("Age");
            Label movieLabelGenre = new Label("Genre");
            Label movieLabelPlayingTime = new Label("Playtime");
            Label movieLabelPrice = new Label("Price");
            Label movieLabelDescription = new Label("Description");

            Text movieTextYear = new Text("1994");
            Text movieTextAgeRestriction = new Text("30");
            Text movieTextGenre = new Text("Hørrer");
            Text movieTextPlayingTime = new Text("2:30");
            Text movieTextPrice = new Text("430 kr");
            Text movieTextDescription = new Text("OH MY GAWD!!! IT IS AWESOME!! OH MY GAWD!!! IT IS AWESOME!! OH MY GAWD!!! IT IS AWESOME!! OH MY GAWD!!! IT IS AWESOME!! OH MY GAWD!!! IT IS AWESOME!!");

            movieTextDescription.setWrappingWidth(movieBoxInfoRight);

            movieTextDescription.getStyleClass().add("infoText");
            movieTextYear.getStyleClass().add("infoText");

            ColumnConstraints labels = new ColumnConstraints();
            labels.setHalignment(HPos.LEFT);
            labels.setPrefWidth(movieBoxWidth * 0.25);
            ColumnConstraints fields = new ColumnConstraints();
            fields.setHalignment(HPos.LEFT);
            fields.setPrefWidth(movieBoxWidth * 0.75);

            GridPane infoGrid = new GridPane();
            infoGrid.setPrefWidth(movieBoxWidth);

            infoGrid.getColumnConstraints().addAll(labels,fields);
            infoGrid.add(movieLabelYear, 0, 0);
            infoGrid.add(movieTextYear, 1, 0);
            infoGrid.add(movieLabelGenre, 0, 1);
            infoGrid.add(movieTextGenre, 1, 1);
            infoGrid.add(movieLabelAgeRestriction, 0, 2);
            infoGrid.add(movieTextAgeRestriction, 1, 2);
            infoGrid.add(movieLabelPlayingTime, 0, 3);
            infoGrid.add(movieTextPlayingTime, 1, 3);
            infoGrid.add(movieLabelPrice, 0, 4);
            infoGrid.add(movieTextPrice, 1, 4);
            infoGrid.add(movieLabelDescription, 0, 5);
            infoGrid.add(movieTextDescription, 1, 5);

            movieInfoLeftBox.getChildren().addAll(infoGrid);
            //movieInfoRightBox.getChildren().addAll(movieLabelDescription, movieTextDescription);

            moviePosterBox.getChildren().add(movieTitle);
            moviePosterBox.setAlignment(Pos.BOTTOM_LEFT);

            moviePosterBox.setPrefSize(movieBoxWidth, movieBoxHeight);
            moviePosterBox.setStyle("-fx-background-color: darkslategrey");

            movieInfoBox.setPrefSize(movieBoxWidth, movieInfoHeight);
            movieInfoBox.setStyle("-fx-background-color: grey;");

            movieInfoBox.getChildren().addAll(movieInfoLeftBox);

            //Label test = new Label("Test LAbel " + i % moviesPerRow);

            movieBox.getChildren().addAll(moviePosterBox, movieInfoBox);

            row.getChildren().add(movieBox);
            if (i % moviesPerRow == 2) {
                column.getChildren().add(row);
                row = new HBox(gap);
                row.setAlignment(rowAlignment);
            }

            if (i == temporarySize-1) {
                if (i % moviesPerRow != 0) {
                    column.getChildren().add(row);
                }
            }
        }

        layout.getChildren().add(column);

        /*
        for (dbSubKategori s : data)
        {

            Button current = new Button(s.getNavn());
            current.getStyleClass().add("button-middle");
            current.setOnAction(e -> {
                Sunbeam2.setMain(SubFiler(s.getNavn(), _title, _id, s.getSubId()));
            });

            // Vi vil gerne vise knapperne i rækker, med max 3 i én række.
            // Nedenunder kigger den på hvor mange objekter den allerede har sat ind
            // og laver en ny HBox (ny række) ved hvert 3. objekt

            row.getChildren().add(current);
            if (iterator % 3 == 2)
            {
                column.getChildren().add(row);
                row = new HBox(gap);
                row.setAlignment(Pos.CENTER);
            }

            iterator++;
        }

        if (iterator % 3 != 0)
        {
            column.getChildren().add(row);
        }
        */


        return layout;
    }
}
