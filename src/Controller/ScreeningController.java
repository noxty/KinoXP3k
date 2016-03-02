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
    public void createScreening(int movieID, int theatreID, String showtime)
    {
        try
        {
            PreparedStatement prepStmt;

            String sqlString = "INSERT INTO screening(movieID, theatreID, showtime) VALUES(?, ?, ?)";

            prepStmt = db.getConnection().prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);

            //prepStmt.setInt(1, screeningID);
            prepStmt.setInt(1, movieID);
            prepStmt.setInt(2, theatreID);
            prepStmt.setString(3, showtime);

            prepStmt.executeUpdate();

            ResultSet rs = prepStmt.getGeneratedKeys();
            int id = 0;
            if (rs.next())
            {
                id = rs.getInt(1);
            }

            addScreening(new Screening(id, movieID, theatreID, showtime));

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addScreening(Screening s) {
        db.getScreenings().add(s);
    }
}
