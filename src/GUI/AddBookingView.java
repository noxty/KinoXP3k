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
        Label labelSeats = new Label("Seats");
        Label labelTheater = new Label("Theater");
        Label labelPickSeats = new Label("Valgte Sæder");

        ComboBox<Integer> comboSeats = new ComboBox<>();
        comboSeats.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);

        ComboBox<String> comboTheater = new ComboBox<>();
        comboTheater.getItems().addAll("Den Store Sal", "Den Lille Sal");

        TextField fieldPickedSeats = new TextField("Placeholder for valgte sæder");


        layoutGrid.add(labelDate, 0, 0);
        layoutGrid.add(DateBox.getDateBox(), 1, 0);
        layoutGrid.add(labelSeats, 0, 1);
        layoutGrid.add(comboSeats, 1, 1);
        layoutGrid.add(labelTheater, 0, 2);
        layoutGrid.add(comboTheater, 1, 2);
        layoutGrid.add(labelPickSeats, 0, 3);
        layoutGrid.add(fieldPickedSeats, 1, 3);
        layoutGrid.add(buttonBox, 1, 4);

        layout.getChildren().add(layoutGrid);
        return layout;
    }
}
