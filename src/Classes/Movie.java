package Classes;

/*
    Classes.Movie(movieID, title, year, description, ageRestriction, playingTime, premiere, status, price)
 */
public class Movie
{
    private String title;
    private int year;
    private String description;
    private int ageRestriction;
    private int playingtime;
    private long premiere;
    private boolean status;
    private double price;

    public Movie(String title, int year, String description, int ageRestriction, int playingtime, long premiere, boolean status, double price)
    {
        this.title = title;
        this.year = year;
        this.description = description;
        this.ageRestriction = ageRestriction;
        this.playingtime = playingtime;
        this.premiere = premiere;
        this.status = status;
        this.price = price;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
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
}
