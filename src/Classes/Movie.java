package Classes;

/*
    Classes.Movie(movieID, title, year, description, ageRestriction, playingTime, premiere, status, price)
 */
public class Movie
{
    private int id;
    private String title;
    private String description;
    private int ageRestriction;
    private int playingtime;
    private long premiere;
    private boolean status;
    private double price;
    private String poster;

    public Movie(int id, String title, String description, int ageRestriction, int playingtime, int premiere, boolean status, double price, String poster)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ageRestriction = ageRestriction;
        this.playingtime = playingtime;
        this.premiere = premiere;
        this.status = status;
        this.price = price;
        this.poster = poster;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getAgeRestriction()
    {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction)
    {
        this.ageRestriction = ageRestriction;
    }

    public int getPlayingtime()
    {
        return playingtime;
    }

    public void setPlayingtime(int playingtime)
    {
        this.playingtime = playingtime;
    }

    public long getPremiere()
    {
        return premiere;
    }

    public void setPremiere(long premiere)
    {
        this.premiere = premiere;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getPoster()
    {
        return poster;
    }

    public void setPoster(String poster)
    {
        this.poster = poster;
    }

    public String toString() {
        return this.title;
    }
}
