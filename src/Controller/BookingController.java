package Controller;


        import Classes.Booking;
        import Data.DB;


        import java.sql.*;

public class BookingController
{
    private static BookingController Instance = new BookingController();
    public static BookingController getInstance()
    {
        return Instance;
    }

    public void createBooking(int bookingID, int screeningID, int customerID, int row, int seat, String bookingStatus)
    {
        DB db = DB.getInstance();

        try
        {
            PreparedStatement prepStmt;

            String sqlString = "INSERT INTO booking(screeningID, customerID, row, seat, bookingStatus) VALUES(?, ?, ?, ?, ?)";

            prepStmt = db.getConnection().prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);

            prepStmt.setInt(1, screeningID);
            prepStmt.setInt(2, customerID);
            prepStmt.setInt(3, row);
            prepStmt.setInt(4, seat);
            prepStmt.setString(5, bookingStatus);


            prepStmt.executeUpdate();

            ResultSet rs = prepStmt.getGeneratedKeys();
            int id = 0;
            if (rs.next())
            {
                id = rs.getInt(1);
            }

            addBooking(new Booking(id, screeningID, customerID, row, seat, bookingStatus));

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addBooking(Booking b)
    {
        GetBookingController.getBooking().add(b);
    }
}