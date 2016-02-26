package GUI;

import Classes.Seats;
import javafx.scene.layout.Pane;

/**
 * Created by Daniel on 25-02-2016.
 */
public class Pixel extends Pane
{
    String status;
    int row;
    int seat;

    Pixel(String status, int row, int y)
    {
        this.status = status;
        this.row = row;
        this.seat = y;
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

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getSeat()
    {
        return seat;
    }

    public void setSeat(int seat)
    {
        this.seat = seat;
    }
}
