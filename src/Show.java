import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by oelsner on 22/02/16.
 */
public class Show
{
    ArrayList<Booking> bookings = new ArrayList<>();

    private static final int theatre1 = 12 * 20;
    private static final int theatre2 = 25 * 16;

    private int[] seats1 = new int[theatre1];
    private int[] seats2 = new int[theatre2];

    private Movie movie;

    private int hall;
    private GregorianCalendar time;

    public Show(Movie movie, GregorianCalendar time , int hall)
    {
        this.movie = movie;
        this.time = time;

        if (hall == 1)
        {
            this.hall = 1;
        }
        else
        {
            this.hall = 2;
        }
    }

    public Booking getBooking(int index)
    {
        return bookings.get(index);
    }

    public boolean addBooking(Booking booking) {
        if (this.hall == 1 && booking.getSeats() + numOccupied(seats1) > seats1.length)
        {
            return false;
        }
        else if (this.hall == 2 && booking.getSeats() + numOccupied(seats2) > seats2.length)
        {
            return false;
        }

        bookings.add(booking);
        return true;
    }

    private int numOccupied(int[] hall)
    {
        int i;

        for (i = 0; i < hall.length; i++)
        {
            if (hall[i] == 0);
            break;
        }

        return i;
    }

    public ArrayList<Booking> getBookings()
    {
        return bookings;
    }
}
