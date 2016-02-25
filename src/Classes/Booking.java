package Classes;

/*
    Booking(bookingID, screeningID, customerID, row, seat, status)
*/
public class Booking
{
    private int bookingID;
    private int screeningID;
    private int customerID;
    private int row;
    private int seat;
    private int status;

    //Til at lave objecter udenom databasen da vi autogenererer vores id
    public Booking(int row, int seat, int status)
    {
        this.row = row;
        this.seat = seat;
        this.status = status;
    }

    //Constructor til at lave objecter ud fra databasen
    public Booking(int bookingID, int screeningID, int customerID, int row, int seat, int status)
    {
        this.bookingID = bookingID;
        this.screeningID = screeningID;
        this.customerID = customerID;
        this.row = row;
        this.seat = seat;
        this.status = status;
    }

    public int getBookingID()
    {
        return bookingID;
    }

    public void setBookingID(int bookingID)
    {
        this.bookingID = bookingID;
    }

    public int getScreeningID()
    {
        return screeningID;
    }

    public void setScreeningID(int screeningID)
    {
        this.screeningID = screeningID;
    }

    public int getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getSeat()
    {
        return seat;
    }

    public void setSeat(int seat)
    {
        this.seat = seat;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    //Info om Bookingen
    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", screeningID=" + screeningID +
                ", customerID=" + customerID +
                ", row=" + row +
                ", seat=" + seat +
                ", status=" + status +
                '}';
    }
}
