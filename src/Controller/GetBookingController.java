package Controller;

import Classes.Booking;
import Data.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Claes Gottlieb on 02/03/16.
 */
public class GetBookingController
{
    private static ObservableList bookingList;

    public static ObservableList<Booking> getBooking()
    {
        return bookingList;
    }

    public static ObservableList<Booking> getBookingOnLaunch()
    {
        try
        {
            DB db = DB.getInstance();

            Statement stmt = db.getConnection().createStatement();
            ResultSet rs;

            bookingList = FXCollections.observableArrayList();


            String sqlString = "SELECT * FROM booking";
            rs = stmt.executeQuery(sqlString);

            while (rs.next())
            {
                bookingList.add(new Booking(rs.getInt("bookingID"), rs.getInt("screeningID"), rs.getInt("customerID"), rs.getInt("row"), rs.getInt("seat"), rs.getString("bookingStatus")));
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return bookingList;
    }
}
