package Controller;

import Classes.Movie;
import Data.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Hans on 25-02-2016.
 */
public class GetMovieController
{
    private static ObservableList movieList;

    public static ObservableList<Movie> getMovies()
    {
        return movieList;
    }

    public static ObservableList<Movie> getMoviesOnLaunch()
    {
        try
        {
            DB db = DB.getInstance();

            Statement stmt = db.getConnection().createStatement();
            ResultSet rs;

            movieList = FXCollections.observableArrayList();


            String sqlString = "SELECT * FROM movie";
            rs = stmt.executeQuery(sqlString);

            while (rs.next())
            {
                movieList.add(new Movie(rs.getInt("movieid"), rs.getString("title"), rs.getString("Description"), rs.getInt("ageRestriction"), rs.getInt("playingTime"), (int) rs.getLong("Premiere"), rs.getBoolean("movieStatus"), rs.getDouble("Price"), rs.getString("poster")));
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return movieList;
    }
}
