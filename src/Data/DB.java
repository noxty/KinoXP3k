package Data;

import Classes.Movie;
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
    private static DB Instance = new DB();
    private static Connection conn;
    private PreparedStatement prepStmt;
    private Statement stmt;
    private ResultSet rs;


    private DB()
    {
        try
        {
            String url = "jdbc:mysql://lessthan3.xyz/kino";
            conn = DriverManager.getConnection(url, "kino", "kinoxp");
            stmt = conn.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static DB getInstance()
    {
        return Instance;
    }
    //Udfører en Query der ikke er en SELECT
    public boolean executeQuery(String sqlString) throws SQLException
    {
        stmt.executeUpdate(sqlString);
        return true;
    }
    //Udfører en Query der ikke er en SELECT, med parametre
    public boolean executeQuery(String sqlString, Map<Integer, String> cmdParameters) throws SQLException
    {
        prepStmt = conn.prepareStatement(sqlString);
        for (Map.Entry<Integer, String> entry: cmdParameters.entrySet())
        {
            prepStmt.setString(entry.getKey(), entry.getValue());
        }
        prepStmt.executeUpdate();

        return true;
    }
    //Henter et query der ER en select
    public ResultSet getResult(String sqlString) throws SQLException
    {
        stmt.executeQuery(sqlString);
        rs = stmt.getResultSet();
        return rs;
    }
    //Henter et query der ER en select, med parametre
    public ResultSet getResult(String sqlString, Map<Integer, String> cmdParameters) throws SQLException
    {
        prepStmt = conn.prepareStatement(sqlString);
        for (Map.Entry<Integer, String> entry: cmdParameters.entrySet())
        {
            prepStmt.setString(entry.getKey(), entry.getValue());
        }
        prepStmt.executeQuery();
        return rs;
    }
    //kan sikkert gøres bedre og er dum. Blivre kun brugt en enkelt gang fordi det er lavet dumt
    public static ResultSet secondaryResultSet(String sqlString)
    {
        try
        {
            Statement STMT = conn.createStatement();
            STMT.executeQuery(sqlString);
            return STMT.getResultSet();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Movie> getScreenings()
    {
        ArrayList<Movie> movies = new ArrayList<Movie>();

        //Statement stmt;
        ResultSet rs;

        try
        {
            String sqlString = "SELECT * FROM screening";
            rs = stmt.executeQuery(sqlString);

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
}