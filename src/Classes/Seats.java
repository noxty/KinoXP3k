package Classes;

import GUI.Pixel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 25-02-2016.
 */
public class Seats
{
    public Pixel pixel;
    static List<Pixel> list = new ArrayList<>();

    public Seats()
    {

    }

    public void addToList(Pixel pixel)
    {
        list.add(pixel);
        System.out.println("Seat was added with row:"+ pixel.getRow()+" and seats number"+pixel.getSeat());
    }

    public void removeFromList(Pixel pixel)
    {
        list.remove(pixel);
        System.out.println("Seat was removed with row:"+ pixel.getRow()+" and seats number"+pixel.getSeat());
    }

    public int getSize()
    {
        int i = list.size();
        return i;
    }

    public Pixel getSeat(int i)
    {
        return list.get(i);
    }
}
