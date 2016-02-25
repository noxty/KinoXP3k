package Classes;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by oelsner on 25/02/16.
 */
public class ScreeningTest extends TestCase
{
    @Before
    public void setUp() throws Exception {}

    @Test
    public void testScreeningGetScreeningID() throws Exception
    {
        Screening screening = new Screening(1, 1, 1, 1);
        int expResult = 1;
        int result = screening.getScreeningID();
        assertEquals(expResult, result);
    }

    public void testScreeningSetScreeningID() throws Exception
    {
        Screening screening = new Screening(1, 1, 1, 1);
        screening.setScreeningID(2);
        int expResult = 2;
        int result = screening.getScreeningID();
        assertEquals(expResult, result);
    }

    public void testScreeningGetMovieID() throws Exception
    {
        Screening screening = new Screening(1, 1, 1, 1);
        int expResult = 1;
        int result = screening.getMovieID();
        assertEquals(expResult, result);
    }

    public void testScreeningSetMovieID() throws Exception
    {
        Screening screening = new Screening(1, 1, 1, 1);
        screening.setMovieID(2);
        int expResult = 2;
        int result = screening.getMovieID();
        assertEquals(expResult, result);
    }

    public void testScreeningGetTheatreID() throws Exception
    {
        Screening screening = new Screening(1, 1, 1, 1);
        int expResult = 1;
        int result = screening.getTheatreID();
        assertEquals(expResult, result);
    }

    public void testScreeningSetTheatreID() throws Exception
    {
        Screening screening = new Screening(1, 1, 1, 1);
        screening.setTheatreID(2);
        int expResult = 2;
        int result = screening.getTheatreID();
        assertEquals(expResult, result);
    }

    public void testScreeningGetTimestamp() throws Exception
    {
        Screening screening = new Screening(1, 1, 1, 1);
        long expResult = 1;
        long result = screening.getTimestamp();
        assertEquals(expResult, result);
    }

    public void testScreeningSetTimestamp() throws Exception
    {
        Screening screening = new Screening(1, 1, 1, 1);
        screening.setTimestamp(2);
        long expResult = 2;
        long result = screening.getTimestamp();
        assertEquals(expResult, result);
    }
}