/**
 * Created by oelsner on 22/02/16.
 */
public class Movie
{
    private String title;
    private String rating;
    private String description;

    public Movie(String title, String rating, String description)
    {
        this.title = title;
        this.rating = rating;
        this.description = description;
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
