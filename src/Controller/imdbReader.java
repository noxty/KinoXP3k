package Controller;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hans on 24-02-2016.
 */
public class imdbReader
{

    public Map<String, String> getInfo(String query, int year) {
        Map<String, String> map = new HashMap<>();

        try
        {
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

            //System.out.println(map);

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return map;
    }


    private String apiToString(String in) throws IOException {
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
