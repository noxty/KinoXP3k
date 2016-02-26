package Controller;

import Classes.Booking;
import Data.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.LinkedHashMap;

public class BookingController
{
    ObservableList<Booking> bookings = FXCollections.observableArrayList();
    DB db = DB.getInstance();

    public ObservableList<Booking> createBooking(int bookingID, int screeningID, String fName, String lName, int row, int seat, String bookingStatus, String showtime) throws SQLException
    {
        Booking booking = new Booking(bookingID, screeningID, fName, lName, row, seat, bookingStatus, showtime);
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();

        lhm.put(1, Integer.toString(booking.getBookingID()));
        lhm.put(2, Integer.toString(booking.getScreeningID()));
        lhm.put(3, booking.getFName());
        lhm.put(4, booking.getLName());
        lhm.put(5, Integer.toString(booking.getRow()));
        lhm.put(6, Integer.toString(booking.getSeat()));
        lhm.put(7, booking.getBookingStatus());
        lhm.put(8, booking.getShowtime());

        db.executeQuery("INSERT INTO Booking VALUES(?,?,?,?,?,?,?,?)", lhm);

        bookings.add(new Booking(booking.getBookingID(),
                booking.getScreeningID(),
                booking.getFName(),
                booking.getLName(),
                booking.getRow(),
                booking.getSeat(),
                booking.getBookingStatus(),
                booking.getShowtime()));

        return createBooking(bookingID, screeningID, fName, lName, row, seat, bookingStatus, showtime);
    }

   /* public ObservableList<Booking> findBookingByPhoneNo(int bookingID, int screeningID, int customerID, int row, int seat, int status)
    {

    }*/

}
