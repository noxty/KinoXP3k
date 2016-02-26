package Controller;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;


/**
 * Created by oelsner on 25/02/16.
 */
public class imdbReaderTest extends TestCase
{
    @Before
    public void setUp() throws Exception {  }

    @Test
    public final void testImdbReaderGetInfo() throws Exception
    {
        imdbReader imdbReader = new imdbReader();
        Map map = imdbReader.getInfo("Deadpool", 2016);
    }
}