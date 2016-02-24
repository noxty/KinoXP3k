package Controller;


import Classes.Movie;
import Data.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.SQLException;
import java.util.LinkedHashMap;

public class CreateMovieController
{
    String title;
    String description;
    int ageRestriction;
    int playingtime;
    long premiere;
    boolean status;
    double price;


    public ObservableList<Movie> getMovie() throws SQLException
    {
        ObservableList<Movie> movies = FXCollections.observableArrayList();
        Movie movie = new Movie(title, description, ageRestriction, playingtime, premiere, status, price);
        DB db = DB.getInstance();
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(1, "0");
        lhm.put(2, movie.getTitle());
        lhm.put(3, movie.getDescription());
        lhm.put(4, Integer.toString(movie.getAgeRestriction()));
        lhm.put(5, Integer.toString(movie.getPlayingtime()));
        lhm.put(6, Long.toString(movie.getPremiere()));
        lhm.put(7, Boolean.toString(movie.isStatus()));
        lhm.put(8, Double.toString(movie.getPrice()));

        movies.add(new Movie
                (   movie.getTitle(),
                        movie.getDescription(),
                        movie.getAgeRestriction(),
                        movie.getPlayingtime(),
                        movie.getPremiere(),
                        movie.isStatus(),
                        movie.getPrice()));

        db.executeQuery("INSERT INTO Movie VALUES(?,?,?,?,?,?,?,?)",lhm);

        return getMovie();

    }
}