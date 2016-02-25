package Classes;

import GUI.Pixel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 25-02-2016.
 */
public class Seats
{
    private Pixel pixel;
    List list = new ArrayList<>();

    public void addToList(Pixel pixel)
    {
        list.add(pixel);
        System.out.println("Seat was added with the coords: "+ pixel.getX()+","+pixel.getY());
    }

    public void removeFromList(Pixel pixel)
    {
        list.remove(pixel);
        System.out.println("Seat was removed with the coords: " + pixel.getX() + "," + pixel.getY());
    }
}
