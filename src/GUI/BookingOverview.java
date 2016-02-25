package GUI;

import Classes.Booking;
import Classes.Person;
import Data.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.print.Book;
import java.sql.SQLException;

public class BookingOverview
{

    public static VBox getView() throws SQLException
    {

        TableView tableBookings = new TableView();

        TextField textFieldSearch = new TextField("Insert phone number");
        Button buttonFind = new Button("Find");
        buttonFind.setOnAction(e->
        {
            try
            {
                ObservableList<Booking> observableListBookings = FXCollections.observableArrayList(DB.getInstance().getBookingByPhoneNo(textFieldSearch.getText()));
                //System.out.println(observableListBookings.get(0).getfName());
                tableBookings.setItems(observableListBookings);
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        });


        Label labelBookingOverview = new Label("Booking Overview");


        HBox hBoxSearchByPhoneNumber = new HBox(textFieldSearch, buttonFind);
        hBoxSearchByPhoneNumber.setPadding(new Insets(10, 10, 10, 10));
        hBoxSearchByPhoneNumber.setSpacing(5);

        tableBookings.setEditable(true);

        TableColumn tcBookingID = new TableColumn("BookingID");
        tcBookingID.setCellValueFactory(
                new PropertyValueFactory<Booking, Integer>("bookingID"));

        TableColumn tcScreening = new TableColumn("ScreeningID");
        tcScreening.setCellValueFactory(
                new PropertyValueFactory<Booking, Integer>("screeningID"));

        TableColumn tcFName = new TableColumn("First Name");
        tcFName.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("fName"));

        TableColumn tcLName = new TableColumn("Last Name");
        tcLName.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("lName"));

        TableColumn tcRow = new TableColumn("row");
        tcRow.setCellValueFactory(
                new PropertyValueFactory<Booking, Integer>("row"));

        TableColumn tcSeats = new TableColumn("seat");
        tcSeats.setCellValueFactory(
                new PropertyValueFactory<Booking, Integer>("seat"));

        TableColumn tcShowtime = new TableColumn("Date/Time");
        tcShowtime.setCellValueFactory(
                new PropertyValueFactory<Booking, Long>("showtime"));

        TableColumn tcBookingStatus = new TableColumn("Booking Status");
        tcBookingStatus.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("bookingStatus"));


        Button buttonDelete = new Button("Delete");
        buttonDelete.setOnAction(e ->
        {
            Booking ix = (Booking) tableBookings.getSelectionModel().getSelectedItem();

            try {
                DB.getInstance().deleteBooking(ix);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }

            tableBookings.getColumns().clear();
            tableBookings.getColumns().addAll(tcBookingID, tcFName, tcLName, tcScreening, tcRow, tcSeats, tcShowtime, tcBookingStatus);

            ObservableList<Booking> list = null;
            try {
                list = FXCollections.observableArrayList(DB.getInstance().getBookingByPhoneNo(textFieldSearch.getText()));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            tableBookings.setItems(list);
        });

        tableBookings.getColumns().addAll(tcBookingID, tcFName, tcLName, tcScreening, tcRow, tcSeats, tcShowtime, tcBookingStatus);

        VBox vBoxBookingOverview = new VBox(labelBookingOverview, hBoxSearchByPhoneNumber, tableBookings, buttonDelete);

        return vBoxBookingOverview;
    }
}
