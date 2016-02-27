package Controller;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by oelsner on 24/02/16.
 */
public class CreateMovieControllerTest extends TestCase
{
    @Before
    public void setUp(){}

    @Test
    public final void testCreateMovie() throws Exception
    {
        CreateMovieController createMovieController = new CreateMovieController();
        createMovieController.createMovie("Deadpool", "Meget lang beskrivelse", 99, 150, 1256953732, true, 150.0, "POSTER");

    }
}