package Controller;

import Data.DB;

import java.sql.SQLException;
import java.util.LinkedHashMap;

/**
 * Created by noxtydk on 23/02/16.
 */
public class CreateShowController
{
    public static void main(String[] args) throws SQLException
    {
        DB db = DB.getInstance();
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(1, "");
        lhm.put(2, "Braveheart");
        lhm.put(3, "Action");
        lhm.put(4, "You shall not pass");
        lhm.put(5, "16");
        lhm.put(6, "175");
        lhm.put(7, "24-02-2016");
        lhm.put(8, "1");
        lhm.put(9, "160");
        db.executeQuery("INSERT INTO Film VALUES(?,?,?,?,?,?,?,?,?)",lhm);
    }
}
