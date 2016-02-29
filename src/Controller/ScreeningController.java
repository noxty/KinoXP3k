package Controller;

import Classes.Screening;
import Data.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;

/**
 * Created by Claes Gottlieb on 26/02/16.
 */
public class ScreeningController
{
    private static ScreeningController Instance = new ScreeningController();
    public static ScreeningController getInstance()
    {
        return Instance;
    }

    DB db = DB.getInstance();
    public void createScreening(int screeningID, int movieID, int theatreID, String showtime)
    {
        try
        {
            PreparedStatement prepStmt;

            String sqlString = "INSERT INTO screening(screeningID, movieID, theatreID, showtime) VALUES(?, ?, ?, ?)";

            prepStmt = db.getConnection().prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);

            prepStmt.setInt(1, screeningID);
            prepStmt.setInt(2, movieID);
            prepStmt.setInt(3, theatreID);
            prepStmt.setString(4, showtime);

            prepStmt.executeUpdate();

            ResultSet rs = prepStmt.getGeneratedKeys();
            int id = 0;
            if (rs.next())
            {
                id = rs.getInt(1);
            }

            addScreening(new Screening(screeningID, movieID, theatreID, showtime));

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addScreening(Screening s) {
        db.getScreenings().add(s);
    }
    public void testScreening()
    {
        try
        {
            // denne laver en forestilling klokken 15:00 idag med screeningID 1, movieId 1, theatreID 1
            createScreening(0,34,1,String.valueOf(TimeController.getTimeOfDay("15:00", 0)));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
