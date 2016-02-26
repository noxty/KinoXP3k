package GUI;
import Classes.Booking;
import Data.DB;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.sql.SQLException;

public class BookingOverview
{
    // TableView Instance
    static TableView tableViewBooking;

    // TableColumns Instances
    static TableColumn tcBookingID, tcScreeningID, tcFName, tcLName, tcRow, tcSeats, tcShowtime, tcBookingStatus;

    // TextField Instance
    static TextField textFieldSearch;

    // Button Instance
    static Button buttonFind;

    // List Instance
    static ObservableList<Booking> observableListBooking;

    //HBoxes & VBoxes
    static HBox hBoxSearch;
    static VBox vBoxBookingOverview;

    // Following method assembles the tableView for bookings
    // The body contains functions for searching through- and deleting bookings

    public static VBox getView()
    {
        // TableView "tableBookings"
        tableViewBooking = new TableView();
        tableViewBooking.setEditable(true);
        tableViewBooking.getColumns().addAll(tcBookingID, tcFName, tcLName, tcScreeningID, tcRow, tcSeats, tcShowtime, tcBookingStatus);

        // TableColumns (tc)
        tcBookingID = new TableColumn("Booking ID");
        tcBookingID.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("bookingID"));

        tcScreeningID = new TableColumn("Screening ID");
        tcScreeningID.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("screeningID"));

        tcFName = new TableColumn("First Name");
         tcFName.setCellValueFactory(new PropertyValueFactory<Booking, String>("fName"));

        tcLName = new TableColumn("Last Name");
        tcLName.setCellValueFactory(new PropertyValueFactory<Booking, String>("lName"));

        tcRow = new TableColumn("Row");
        tcRow.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("row"));

        tcSeats = new TableColumn("Seat");
        tcSeats.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("seat"));

        tcShowtime = new TableColumn("Date/Time");
        tcShowtime.setCellValueFactory(new PropertyValueFactory<Booking, String>("showtime"));

        tcBookingStatus = new TableColumn("Booking Status");
        tcBookingStatus.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingStatus"));

        tableViewBooking.getColumns().addAll(tcBookingID, tcFName, tcLName, tcScreeningID, tcRow, tcSeats, tcShowtime, tcBookingStatus);

        // Search Function
        textFieldSearch = new TextField();
        textFieldSearch.setPromptText("Insert phone number..");

        buttonFind = new Button("Find");
        buttonFind.setOnAction(actionEvent ->
        {
            try
            {
                observableListBooking = FXCollections.observableArrayList(DB.getInstance().searchBookingsByPhoneNo(textFieldSearch.getText()));
                tableViewBooking.setItems(observableListBooking);
            }

            catch (SQLException e)
            {
                e.printStackTrace();
            }
        });

        // Delete Function
        Button buttonDelete = new Button("Delete");
        buttonDelete.setOnAction(actionEvent ->
        {
            Booking booking = (Booking) tableViewBooking.getSelectionModel().getSelectedItem();

            try
            {
                DB.getInstance().deleteBooking(booking);
                updateTableview();
            }

            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        });

        // Booking Overview Layout
        hBoxSearch = new HBox(textFieldSearch, buttonFind);
        hBoxSearch.setPadding(new Insets(10, 10, 10, 10));
        hBoxSearch.setSpacing(5);

        vBoxBookingOverview = new VBox(hBoxSearch, tableViewBooking, buttonDelete);
        vBoxBookingOverview.setPadding(new Insets(10, 10, 10, 10));
        vBoxBookingOverview.setSpacing(5);

        return vBoxBookingOverview;
    }

    // Update TableView
    public static void updateTableview()
    {
        tableViewBooking.getColumns().clear();
        tableViewBooking.getColumns().addAll(tcBookingID, tcFName, tcLName, tcScreeningID, tcRow, tcSeats, tcShowtime, tcBookingStatus);
        observableListBooking = null;

        try
        {
            observableListBooking = FXCollections.observableArrayList(DB.getInstance().searchBookingsByPhoneNo(textFieldSearch.getText()));
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
        tableViewBooking.setItems(observableListBooking);
    }
}
