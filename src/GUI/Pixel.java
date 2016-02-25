package GUI;

import Classes.Seats;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;

/**
 * Created by Daniel on 25-02-2016.
 */
public class Pixel extends Pane
{
    String status;
    int x;
    int y;

    Pixel(String status, int x, int y)
    {
        this.status = status;
        this.x = x;
        this.y = y;
        setStyle("-fx-background-color: darkgrey");
        setPrefSize(10, 10);

        setOnMouseClicked(event -> {
            Seats seat = new Seats();

            if (this.status.equals("Ledig"))
            {
                setStyle("-fx-background-color: chartreuse");
                this.status = "Valgt";
                seat.addToList(this);
            } else if (this.status.equals("Valgt"))
            {
                setStyle("-fx-background-color: darkgrey");
                this.status = "Ledig";
                seat.removeFromList(this);
            }
        });



    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}
