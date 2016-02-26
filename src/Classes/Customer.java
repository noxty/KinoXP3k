package Classes;

import Data.DB;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Customer extends Person
{

    public Customer(String firstName, String lastName, int phoneNo)
    {
        super(firstName, lastName, phoneNo);
    }



    public static String getCustomerString(String string)
    {
        String value = null;
        try
        {
            DB db = DB.getInstance();

            Statement stmt = db.getConnection().createStatement();
            ResultSet rs;

            String sqlString = string;
            rs = stmt.executeQuery(sqlString);


            while (rs.next())
            {
                value = rs.getString(1);

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return value;
    }

/*
    public static int getCustomerInt(String string)
    {
        int value = 0;
        try
        {
            DB db = DB.getInstance();

            Statement stmt = db.getConnection().createStatement();
            ResultSet rs;

            String sqlString = string;
            rs = stmt.executeQuery(sqlString);


            while (rs.next())
            {
                value = rs.getInt(1);

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return value;
    }
*/
    public static List<Customer> getCustomers(String string)
    {
        List<Customer> customers = new ArrayList<>();
        try
        {
            DB db = DB.getInstance();

            Statement stmt = db.getConnection().createStatement();
            ResultSet rs;

            String sqlString = string;
            rs = stmt.executeQuery(sqlString);


            while (rs.next())
            {
                customers.add(new Customer(rs.getString("fName"), rs.getString("lName"), rs.getInt("phoneNo")));

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return customers;
    }


/*
    public static boolean ifExist(String string)
    {

        if(getCustomerInt("SELECT COUNT(*) AS countSeats FROM customer WHERE customer.phoneNo = " + string) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
*/
}
