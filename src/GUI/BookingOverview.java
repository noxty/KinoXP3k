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
    static TableColumn tableColumnBookingID, tableColumnScreeningID, tableColumnFName, tableColumnLName, tableColumnRow, tableColumnSeats, tableColumnShowtime, tableColumnBookingStatus;

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

        // TableColumns (tc)
        tableColumnBookingID= new TableColumn("Booking ID");
        tableColumnBookingID.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("bookingID"));

        tableColumnScreeningID = new TableColumn("Screening ID");
        tableColumnScreeningID.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("screeningID"));

        tableColumnFName = new TableColumn("First Name");
        tableColumnFName.setCellValueFactory(new PropertyValueFactory<Booking, String>("fName"));

        tableColumnLName = new TableColumn("Last Name");
        tableColumnLName.setCellValueFactory(new PropertyValueFactory<Booking, String>("lName"));

        tableColumnRow = new TableColumn("Row");
        tableColumnRow.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("row"));

        tableColumnSeats = new TableColumn("Seat");
        tableColumnSeats.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("seat"));

        tableColumnShowtime = new TableColumn("Date/Time");
        tableColumnShowtime.setCellValueFactory(new PropertyValueFactory<Booking, String>("showtime"));

        tableColumnBookingStatus = new TableColumn("Booking Status");
        tableColumnBookingStatus.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingStatus"));

        tableViewBooking.getColumns().addAll(tableColumnBookingID, tableColumnFName, tableColumnLName, tableColumnScreeningID, tableColumnRow, tableColumnSeats, tableColumnShowtime, tableColumnBookingStatus);

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
        tableViewBooking.getColumns().addAll(tableColumnBookingID, tableColumnFName, tableColumnLName, tableColumnScreeningID, tableColumnRow, tableColumnSeats, tableColumnShowtime, tableColumnBookingStatus);
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
