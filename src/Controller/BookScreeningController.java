package Controller;

import Classes.Booking;
import Classes.Movie;
import Data.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.LinkedHashMap;

/**
 * Created by Claes Gottlieb on 24/02/16.
 */
public class BookScreeningController
{

    public ObservableList<Booking> createBooking(int bookingID, int screeningID, int customerID, int row, int seat, int status) throws SQLException
    {
        ObservableList<Booking> bookings = FXCollections.observableArrayList();
        Booking booking = new Booking(bookingID, screeningID, customerID, row, seat, status);
        DB db = DB.getInstance();
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();

        lhm.put(1, Integer.toString(booking.getBookingID()));
        lhm.put(2, Integer.toString(booking.getScreeningID()));
        lhm.put(3, Integer.toString(booking.getCustomerID()));
        lhm.put(4, Integer.toString(booking.getRow()));
        lhm.put(5, Integer.toString(booking.getSeat()));
        lhm.put(6, Integer.toString(booking.getStatus()));

        db.executeQuery("INSERT INTO Booking VALUES(?,?,?,?,?,?)", lhm);

        bookings.add(new Booking
                (booking.getBookingID(),
                        booking.getScreeningID(),
                        booking.getCustomerID(),
                        booking.getRow(),
                        booking.getSeat(),
                        booking.getStatus()));

        return createBooking(bookingID, screeningID, customerID, row, seat, status);

    }
}
