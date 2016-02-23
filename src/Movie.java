/**
 * Created by oelsner on 22/02/16.
 */
public class Movie
{
    private String title;
    private String rating;

    public Movie(String title, String rating)
    {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getRating()
    {
        return rating;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }
}
