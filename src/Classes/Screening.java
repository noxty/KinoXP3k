package Classes;

import Data.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;



public class Screening
{
    private int screeningID;
    private int movieID;
    private int theatreID;
    private String showtime;
    private String title;
    private String theatreName;

    public Screening(int screeningID, int movieID, int theatreID, String showtime)
    {
        this.screeningID = screeningID;
        this.movieID = movieID;
        this.theatreID = theatreID;
        this.showtime = showtime;
    }

    public Screening(int screeningID,String title, String theatreName, String showtime )
    {
        this.screeningID = screeningID;
        this.showtime = showtime;
        this.title = title;
        this.theatreName = theatreName;

    }


    public int getScreeningID()
    {
        return screeningID;
    }

    public void setScreeningID(int screeningID)
    {
        this.screeningID = screeningID;
    }

    public int getMovieID()
    {
        return movieID;
    }

    public void setMovieID(int movieID)
    {
        this.movieID = movieID;
    }

    public int getTheatreID()
    {
        return theatreID;
    }

    public void setTheatreID(int theatreID)
    {
        this.theatreID = theatreID;
    }

    public String getShowtime()
    {
        return showtime;
    }

    public void setShowtime(String showtime)
    {
        this.showtime = showtime;
    }

    public String getTitle()
    {
        return title;
    }

    public String getTheatreName()
    {
        return theatreName;
    }

    public static ObservableList<Screening> getScreening(String string)
    {
        ObservableList<Screening> screenings = FXCollections.observableArrayList();
        try
        {
            DB db = DB.getInstance();

            Statement stmt = db.getConnection().createStatement();
            ResultSet rs;

            String sqlString = string;
            rs = stmt.executeQuery(sqlString);


            while (rs.next())
            {
                screenings.add(new Screening(rs.getInt("screeningID"), rs.getString("title"), rs.getString("theatreName"),rs.getString("showtime")));

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return screenings;
    }
}