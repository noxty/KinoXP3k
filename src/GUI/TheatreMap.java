package GUI;

import javafx.scene.layout.GridPane;


public class TheatreMap
{


    public static GridPane bigTheatre()
    {
        GridPane grid = new GridPane();

        Pixel pixel;

        for (int i = 0; i < 25; i++)
        {
            for (int j = 0; j < 16; j++)
            {

                pixel = new Pixel("Ledig", i + 1, j + 1);
                grid.add(pixel, i, j);
            }
        }

        grid.setHgap(5);
        grid.setVgap(5);


        return grid;
    }


    public static GridPane smallTheatre()
    {
        GridPane grid = new GridPane();

        Pixel pixel;

        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                pixel = new Pixel("Ledig", i + 1, j + 1);
                grid.add(pixel, i, j);
            }
        }

        grid.setHgap(5);
        grid.setVgap(5);

        return grid;
    }


}
