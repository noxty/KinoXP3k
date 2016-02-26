package Data;
import Classes.Booking;
import Classes.Movie;
import Classes.Screening;
import Controller.TimeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        }

        catch (Exception e)
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
        ObservableList<Screening> movies =  FXCollections.observableArrayList();

        //Statement stmt;
        ResultSet rs;

        try
        {
            String sqlString = "SELECT * FROM screening";
            rs = statement.executeQuery(sqlString);

            while (rs.next())
            {
                // movies.add(new Movie(rs.getString("title"), 0, rs.getString("Description"), rs.getInt("ageRestriction"), rs.getInt("playingTime"), rs.getLong("Premiere"), rs.getBoolean("movieStatus"), rs.getDouble("Price")));
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

                "SELECT booking.bookingID, booking.screeningID, " +
                "customer.fname, customer.lname, booking.row, booking.seat, booking.bookingStatus, " +
                "screening.showtime " +
                "FROM booking " +
                "JOIN customer " +
                "ON booking.customerID = customer.customerID " +
                "JOIN screening " +
                "ON booking.screeningID = screening.screeningID " +
                "WHERE phoneNo = '"+ phoneNoInput +"'";

        resultSet = statement.executeQuery(sqlString);

        bookings = new ArrayList<>();

        try
        {
            while (resultSet.next())
            {
                System.out.println();
                bookings.add(new Booking(resultSet.getInt("bookingID"), resultSet.getInt("screeningID"), resultSet.getString("fname"), resultSet.getString("lname"), resultSet.getInt("row"), resultSet.getInt("seat"), resultSet.getString("bookingStatus"), TimeController.getDateFromTS(resultSet.getLong("showtime"))));
            }
        }

        catch (Exception e)
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
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }







    // Udfører en Query, som ikke er et SELECT, UDEN parametre
    public boolean executeQuery(String sqlString) throws SQLException
    {
        statement.executeUpdate(sqlString);
        return true;
    }

    //Udfører en Query, som ikke er en SELECT, MED parametre
    public boolean executeQuery(String sqlString, Map<Integer, String> cmdParameters) throws SQLException
    {
        preparedStatement = connection.prepareStatement(sqlString);

        for (Map.Entry<Integer, String> entry: cmdParameters.entrySet())
        {
            preparedStatement.setString(entry.getKey(), entry.getValue());
        }

        preparedStatement.executeUpdate();
        return true;
    }

    //Henter et query der ER en SELECT
    public ResultSet getResult(String sqlString) throws SQLException
    {
        statement.executeQuery(sqlString);
        resultSet = statement.getResultSet();
        return resultSet;
    }
    //Henter et query der ER en select, med parametre
    public ResultSet getResult(String sqlString, Map<Integer, String> cmdParameters) throws SQLException
    {
        preparedStatement = connection.prepareStatement(sqlString);
        for (Map.Entry<Integer, String> entry: cmdParameters.entrySet())
        {
            preparedStatement.setString(entry.getKey(), entry.getValue());
        }
        preparedStatement.executeQuery();
        return resultSet;
    }

    //Kan sikkert gøres bedre og er dum. Bliver kun brugt en enkelt gang, da det er lavet dumt.
    public ResultSet secondaryResultSet(String sqlString)
    {
        try
        {
            statement = connection.createStatement();
            statement.executeQuery(sqlString);

            return statement.getResultSet();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}