package Data;

import Classes.Booking;
import Classes.Screening;
import Controller.TimeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB
{
    //Hvad er der med denne???
    static private DB Instance = new DB();

    // Global Instances
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    // Instances for searchBookingsByPhoneNo()
    private List<Booking> bookings;

    // DB Constructor
    private DB()
    {
        try
        {
            String url = "jdbc:mysql://lessthan3.xyz/kino";
            connection = DriverManager.getConnection(url, "kino", "kinoxp");
            statement = connection.createStatement();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        return connection;
    }

    public static DB getInstance()
    {
        return Instance;
    }

    public ObservableList<Screening> getScreenings()
    {
        ObservableList<Screening> movies = FXCollections.observableArrayList();

        //Statement stmt;
        ResultSet rs;

        try
        {
            String sqlString = "SELECT * FROM screening";
            rs = statement.executeQuery(sqlString);

            while (rs.next())
            {
                //movies.add(new Movie(rs.getString("title"), 0, rs.getString("Description"), rs.getInt("ageRestriction"), rs.getInt("playingTime"), rs.getLong("Premiere"), rs.getBoolean("movieStatus"), rs.getDouble("Price")));
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return movies;
    }

    public List<Booking> searchBookingsByPhoneNo(String phoneNoInput) throws SQLException
    {
        String sqlString =

                "SELECT booking.bookingID, booking.screeningID,\n" +
                        "                customer.fname, customer.lname, booking.row, booking.seat, booking.bookingStatus,\n" +
                        "                screening.showtime, movie.title \n" +
                        "                FROM booking \n" +
                        "                JOIN customer \n" +
                        "                ON booking.customerID = customer.customerID \n" +
                        "                JOIN screening \n" +
                        "                ON booking.screeningID = screening.screeningID \n" +
                        "                JOIN movie \n" +
                        "                ON screening.movieID = movie.movieID\n" +
                        "                WHERE phoneNo ='" + phoneNoInput + "'";

        resultSet = statement.executeQuery(sqlString);

        bookings = new ArrayList<>();

        try
        {
            while (resultSet.next())
            {
                System.out.println();
                bookings.add(new Booking(resultSet.getInt("bookingID"), resultSet.getInt("screeningID"), resultSet.getString("fname"), resultSet.getString("lname"), resultSet.getInt("row"), resultSet.getInt("seat"), resultSet.getString("bookingStatus"), TimeController.getDateFromTS(resultSet.getLong("showtime")), resultSet.getString("title")));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Printing bookings");
        System.out.println(bookings);
        return bookings;
    }

    public void deleteBooking(Booking selectedBooking) throws ClassNotFoundException
    {
        try
        {
            String sqlString = "DELETE FROM booking WHERE bookingID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);

            int booking = selectedBooking.getBookingID();

            preparedStatement.setInt(1, booking);
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


}