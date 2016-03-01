package Classes;

/*
    Booking(bookingID, screeningID, fName, lName, row, seat, status)
*/
public class Booking
{
    private int bookingID;
    private int screeningID;
    private String fName;
    private String lName;
    private int row;
    private int seat;
    private String bookingStatus;
    private String showtime;
    private String screeningName;

    public Booking(int bookingID, int screeningID, String fName, String lName, int row, int seat, String bookingStatus, String showtime, String screeningName)
    {
        this.bookingID = bookingID;
        this.screeningID = screeningID;
        this.fName = fName;
        this.lName = lName;
        this.row = row;
        this.seat = seat;
        this.bookingStatus = bookingStatus;
        this.showtime = showtime;
        this.screeningName = screeningName;
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

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
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

    public String getBookingStatus()
    {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus)
    {
        this.bookingStatus = bookingStatus;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime)
    {
        this.showtime = showtime;
    }

    public String getScreeningName()
    {
        return screeningName;
    }

    //Info om Bookingen
    @Override
    public String toString()
    {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", screeningID=" + screeningID +
                ", fName=" + fName +
                ", lName=" + lName +
                ", row=" + row +
                ", seat=" + seat +
                ", bookingStatus=" + bookingStatus +
                ", showtime=" + showtime +
                '}';
    }
}
