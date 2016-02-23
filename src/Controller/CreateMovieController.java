package Controller;


import Classes.Movie;
import Data.DB;


import java.sql.SQLException;
import java.util.LinkedHashMap;

public class CreateMovieController
{
    public  void createMovie() throws SQLException
    {
        Movie movie = new Movie();
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
        db.executeQuery("INSERT INTO Movie VALUES(?,?,?,?,?,?,?,?)",lhm);
    }
}