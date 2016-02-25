package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class AddBookingView
{
    public static VBox getView() {
        VBox layout = new VBox();
        GridPane layoutGrid = new GridPane();
        int gaps = 10;

        layoutGrid.setHgap(gaps);
        layoutGrid.setVgap(gaps);

        // Buttons
        Button buttonAdd = new Button("Add Booking");
        Button buttonClear = new Button("Clear All");

        HBox buttonBox = new HBox(gaps);
        buttonBox.getChildren().addAll(buttonAdd, buttonClear);

        // Tid, antal sæder, sal, sæde numre;

        Label labelDate = new Label("Date");
        Label labelTheater = new Label("Theater");
        Label labelPickSeats = new Label("Valgte Sæder");

        ComboBox<String> comboTheater = new ComboBox<>();
        comboTheater.getItems().addAll("Store Sal", "Lille Sal");


        HBox fieldPickedSeats = new HBox();

        comboTheater.setOnAction(event -> {
            if(comboTheater.getValue().toString().equals("Store Sal"))
            {
                fieldPickedSeats.getChildren().clear();
                fieldPickedSeats.getChildren().addAll(TheatreMap.bigTheatre());
            }
            else if(comboTheater.getValue().toString().equals("Lille Sal"))
            {
                fieldPickedSeats.getChildren().clear();
                fieldPickedSeats.getChildren().addAll(TheatreMap.smallTheatre());
            }
        });


        fieldPickedSeats.getChildren().addAll(TheatreMap.bigTheatre());


        layoutGrid.add(labelDate, 0, 0);
        layoutGrid.add(DateBox.getDateBox(), 1, 0);
        layoutGrid.add(labelTheater, 0, 2);
        layoutGrid.add(comboTheater, 1, 2);
        layoutGrid.add(labelPickSeats, 0, 3);
        layoutGrid.add(fieldPickedSeats, 1, 3);
        layoutGrid.add(buttonBox, 1, 4);

        layout.getChildren().add(layoutGrid);
        return layout;
    }
}
