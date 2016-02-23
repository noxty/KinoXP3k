import java.net.URL;

/**
 * Created by oelsner on 22/02/16.
 */
public class Booking
{
    private Movie movie;
    private Customer customer;
    private boolean isPaid;

    public Booking(Movie movie, Customer customer, boolean isPaid)
    {
        this.setMovie(movie);
        this.setCustomer(customer);
        this.setPaid(isPaid);
    }

    public String toString()
    {
        return getMovie().getTitle() + " " + getMovie().getRating() + "\n "
                + getCustomer().getFirstName() + " " + getCustomer().getLastName()  + " " + "\n"
                + getCustomer().getPhone();

    }


    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public boolean isPaid()
    {
        return isPaid;
    }

    public void setPaid(boolean paid)
    {
        isPaid = paid;
    }
}
