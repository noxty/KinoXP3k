import java.util.ArrayList;

/**
 * Created by oelsner on 22/02/16.
 */
public class Show
{
    ArrayList<Booking> bookings = new ArrayList<>();

    public Show()
    {

    }

    public Booking getBooking(int index)
    {
        return bookings.get(index);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }


}
