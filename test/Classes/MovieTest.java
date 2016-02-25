package Classes;


import junit.framework.TestCase;
import org.junit.*;
import org.junit.Test;

/**
 * Created by oelsner on 25/02/16.
 */
public class MovieTest extends TestCase
{
    @Before
    public void setUp() throws Exception
    {
        super.setUp();

    }

    @Test
    public final void testMovieGetTitle() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        String expResult = "Titanic";
        String result = movie.getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieSetTitle() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        movie.setTitle("ok");
        String expResult = "ok";
        String result = movie.getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieGetDescription() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        String expResult = "Drama";
        String result = movie.getDescription();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieSetDescription() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        movie.setDescription("ok");
        String expResult = "ok";
        String result = movie.getDescription();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieGetAgeRestriction() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        int expResult = 1;
        int result = movie.getAgeRestriction();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieSetAgeRestriction() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        movie.setAgeRestriction(2);
        int expResult = 2;
        int result = movie.getAgeRestriction();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieGetPlayingtime() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        int expResult = 1;
        int result = movie.getPlayingtime();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieSetPlayingtime() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        movie.setPlayingtime(2);
        int expResult = 2;
        int result = movie.getPlayingtime();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieGetPremiere() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        long expResult = 1;
        long result = movie.getPremiere();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieSetPremiere() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        movie.setPremiere(2);
        long expResult = 2;
        long result = movie.getPremiere();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieIsStatus() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        boolean expResult = false;
        boolean result = movie.isStatus();
        assertEquals(expResult, result);

    }

    @Test
    public void testMovieSetStatus() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        movie.setStatus(true);
        boolean expResult = true;
        boolean result = movie.isStatus();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieGetPrice() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        double expResult = 1.0;
        double result = movie.getPrice();
        assertEquals(expResult, result);
    }

    @Test
    public void testMovieSetPrice() throws Exception
    {
        Movie movie = new Movie(1, "Titanic", "Drama", 1, 1, 1, false, 1.0);
        movie.setPrice(2.0);
        double expResult = 2.0;
        double result = movie.getPrice();
        assertEquals(expResult, result);
    }
}