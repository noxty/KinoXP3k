package Classes;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import java.awt.print.Book;

/**
 * Created by oelsner on 25/02/16.
 */
public class BookingTest extends TestCase
{
    @Before
    public void setUp() throws Exception {}

    @Test
    public final void testBookingGetBookingID() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        int expResult = 1;
        int result = booking.getBookingID();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetBookingID() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        booking.setBookingID(2);
        int expResult = 2;
        int result = booking.getBookingID();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetScreeningID() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        int expResult = 1;
        int result = booking.getScreeningID();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetScreeningID() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        booking.setScreeningID(2);
        int expResult = 2;
        int result = booking.getScreeningID();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetCustomerID() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        int expResult = 1;
        int result = booking.getCustomerID();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetCustomerID() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        booking.setCustomerID(2);
        int expResult = 2;
        int result = booking.getCustomerID();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetRow() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        int expResult = 1;
        int result = booking.getRow();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetRow() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        booking.setRow(2);
        int expResult = 2;
        int result = booking.getRow();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetSeat() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        int expResult = 1;
        int result = booking.getSeat();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingSetSeat() throws Exception
    {
        Booking booking = new Booking(1, 1 ,1 ,1 ,1, 0);
        booking.setSeat(2);
        int expResult = 2;
        int result = booking.getSeat();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingGetStatus() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        int expResult = 0;
        int result = booking.getStatus();
        assertEquals(expResult, result);
    }

    @Test
    public final void testSetStatus() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        booking.setStatus(2);
        int expResult = 2;
        int result = booking.getStatus();
        assertEquals(expResult, result);
    }

    @Test
    public final void testBookingToString() throws Exception
    {
        Booking booking = new Booking(1, 1, 1, 1, 1, 0);
        String expResult = "Booking{bookingID=1, screeningID=1, customerID=1, row=1, seat=1, status=0}";
        String result = booking.toString();
        assertNotNull(result);
    }

    @Test
    public final void testDefaultConstructor()
    {
        Booking booking = new Booking(1, 1, 1);
        assertNotNull(booking);
    }
}