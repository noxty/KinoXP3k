package Classes;

import Data.DB;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by oelsner on 23/02/16.
 */
public class Test
{
    public static void main(String[] args)
    {
        /*
        Customer customer = new Customer("Christian", "Oelsner", "12345678", 40);
        Movie movie = new Movie("Batman", "pg-13", "Action");

        ArrayList<Booking> bookings = new ArrayList<>();



        //bookings.add(booking);

        //System.out.print(bookings);

        Show show = new Show(movie, new GregorianCalendar(2016, 1, 12, 12, 1,2), 1);
        Booking booking = new Booking(movie, customer, true, 240, show);


        show.addBooking(booking);

        System.out.println(show.getBookings());
        //System.out.print(booking.toString());
        */

        ArrayList<Movie> movies = new ArrayList<>();

        DB dataBase = DB.getInstance();

        dataBase.createMovie("Krummerne", "btete", 1, 11, 121212, false, 90);

        movies = dataBase.getMovies();

        for (int i = 0; i < movies.size(); i++)
        {
            System.out.println(movies.get(i).getTitle());
        }

       // System.out.println(movies.get(0).getTitle());

    }
}
