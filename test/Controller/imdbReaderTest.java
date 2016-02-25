package Controller;

import junit.framework.TestCase;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by oelsner on 25/02/16.
 */
public class imdbReaderTest extends TestCase
{
    Map<String, String> map = new HashMap<>();
    Map<String, String> mapTest = new HashMap<>();

    @Before
    public void setUp() throws Exception
    {
        String query = "Titanic";
        int year = 1997;

        String input = apiToString("http://www.omdbapi.com/?t=" + URLEncoder.encode(query, "UTF-8") + "&y=" + year + "&plot=short&r=json");
        JSONObject movie = new JSONObject(input);

        int movieYear = movie.getInt("Year");
        String movieRelease = movie.getString("Released");
        String moviePlot = movie.getString("Plot");
        String movieDirector = movie.getString("Director");
        String movieTitle = movie.getString("Title");
        String movieActors = movie.getString("Actors");
        String moviePlaytime = movie.getString("Runtime");
        String movieRating = movie.getString("Rated");
        String moviePoster = movie.getString("Poster");
        String movieGenre = movie.getString("Genre");



        map.put("title", movieTitle);
        map.put("year", String.valueOf(movieYear));
        map.put("release", movieRelease);
        map.put("description", moviePlot);
        map.put("director", movieDirector);
        map.put("actors", movieActors);
        map.put("genre", movieGenre);
        map.put("playtime", String.valueOf(moviePlaytime));
        map.put("rating", movieRating);
        map.put("poster", moviePoster);

        //mapTest.put("title", "Titanic");
        mapTest.put("year", "1997");
        mapTest.put("release", "19 Dec 1997");
        mapTest.put("description", "A seventeen-year-old aristocrat falls in love with a kind, but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.");
        mapTest.put("director", "James Cameron");
        mapTest.put("actors", "Leonardo DiCaprio, Kate Winslet, Billy Zane, Kathy Bates");
        mapTest.put("genre", "Drama, Romance");
        mapTest.put("playtime", "194 min");
        mapTest.put("rating", "PG-13");
        mapTest.put("poster", "http://ia.media-imdb.com/images/M/MV5BMjExNzM0NDM0N15BMl5BanBnXkFtZTcwMzkxOTUwNw@@._V1_SX300.jpg");

    }

    @Test
    public final void testImdbReaderGetInfo() throws Exception
    {
        for(Map.Entry s : map.entrySet() )
        {
            assertEquals(s.getValue(), mapTest.containsValue(s.getValue()));
        }
    }

    private String apiToString(String in) throws IOException
    {
        URL url = new URL(in);

        BufferedReader streamReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

        //System.out.println(streamReader);

        StringBuilder responseStrBuilder = new StringBuilder();

        String inputStr;
        while ((inputStr = streamReader.readLine()) != null)
        {
            responseStrBuilder.append(inputStr);
        }

        String input = responseStrBuilder.toString();

        streamReader.close();

        return input;
    }
}