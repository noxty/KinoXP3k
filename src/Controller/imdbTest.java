package Controller;

import java.util.Map;

/**
 * Created by Hans on 24-02-2016.
 */
public class imdbTest
{
    public static void main(String[] args)
    {
        imdbReader trakt = new imdbReader();
        Map<String, ?> info = trakt.getInfo("deadpool", 2016);

        System.out.println(info.get("description"));
    }
}
