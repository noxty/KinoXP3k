package Classes;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.Test;


/**
 * Created by oelsner on 25/02/16.
 */
public class BookingTest extends TestCase
{
    @Before
    public void setUp() throws Exception {}


    @Test
    public final void testBookingGetFName() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        String expResult = "Christian";
        String result = booking.getFName();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetLName() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        String expResult = "Oelsner";
        String result = booking.getLName();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetFName() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        booking.setFName("Casper");
        String expResult = "Casper";
        String result = booking.getFName();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetLName() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        booking.setLName("Martinsen");
        String expResult = "Martinsen";
        String result = booking.getLName();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetShowtime() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        long expResult = 120;
        long result = booking.getShowtime();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetShowtime() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        booking.setShowtime(150);
        long expResult = 150;
        long result = booking.getShowtime();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetBookingID() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        int expResult = 1;
        int result = booking.getBookingID();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetBookingID() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        booking.setBookingID(2);
        int expResult = 2;
        int result = booking.getBookingID();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetScreeningID() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        int expResult = 1;
        int result = booking.getScreeningID();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetScreeningID() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        booking.setScreeningID(2);
        int expResult = 2;
        int result = booking.getScreeningID();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetRow() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        int expResult = 1;
        int result = booking.getRow();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetRow() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        booking.setRow(2);
        int expResult = 2;
        int result = booking.getRow();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetSeat() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        int expResult = 1;
        int result = booking.getSeat();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetSeat() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        booking.setSeat(2);
        int expResult = 2;
        int result = booking.getSeat();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetStatus() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        String expResult = "Ledig";
        String result = booking.getBookingStatus();
        assertEquals(expResult, result);
    }

    @Test
    public final void testSetStatus() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        booking.setBookingStatus("Optaget");
        String expResult = "Optaget";
        String result = booking.getBookingStatus();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingToString() throws Exception
    {
        Booking booking = new Booking(1, 1, "Christian", "Oelsner", 1, 1, "Ledig", 120);
        String expResult = "Booking{bookingID=1, screeningID=1, customerID=1, row=1, seat=1, status=0}";
        String result = booking.toString();
        assertNotNull(result);
    }

}