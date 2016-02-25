package Controller;


import Classes.Movie;
import Data.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

public class CreateMovieController
{
    private static CreateMovieController Instance = new CreateMovieController();
    public static CreateMovieController getInstance()
    {
        return Instance;
    }

    public void createMovie(String title, String description, int ageRestriction, int playingTime, long premiere, boolean movieStatus, double price, String poster)
    {
        DB db = DB.getInstance();

        try
        {
            PreparedStatement prepStmt;

            String sqlString = "INSERT INTO movie(title, description, ageRestriction, playingTime, premiere, movieStatus, price, poster) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            prepStmt = db.getConnection().prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);

            prepStmt.setString(1, title);
            prepStmt.setString(2, description);
            prepStmt.setInt(3, ageRestriction);
            prepStmt.setInt(4, playingTime);
            prepStmt.setLong(5, premiere);
            prepStmt.setBoolean(6, movieStatus);
            prepStmt.setDouble(7, price);
            prepStmt.setString(8, poster);

            prepStmt.executeUpdate();

            ResultSet rs = prepStmt.getGeneratedKeys();
            int id = 0;
            if (rs.next())
            {
                id = rs.getInt(1);
            }

            addMovie(new Movie(id, title, description, ageRestriction, playingTime, premiere, movieStatus, price, poster));

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addMovie(Movie m) {
        GetMovieController.getMovies().add(m);
    }
}