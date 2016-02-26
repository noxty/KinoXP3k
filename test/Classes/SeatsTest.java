package Classes;

import GUI.Pixel;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oelsner on 26/02/16.
 */
public class SeatsTest extends TestCase
{
    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public final void testAddToList() throws Exception
    {
        Seats seats = new Seats();
        Pixel pixel = new Pixel("Ledig", 1 ,1);

        seats.addToList(pixel);
        List list = new ArrayList<>();

        int expResult = 0;
        int result = list.size();
        assertEquals(expResult, result);

    }

    @Test
    public final void testSRemoveFromList() throws Exception
    {
        List list = new ArrayList<>();
        Seats seats = new Seats();
        Pixel pixel = new Pixel("Ledig", 1 ,1);
        seats.addToList(pixel);
        seats.removeFromList(pixel);


        int expResult = 0;
        int result = list.size();
        assertEquals(expResult, result);
    }
}