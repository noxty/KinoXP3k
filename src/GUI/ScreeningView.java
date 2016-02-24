package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Calendar;


/**
 * Created by Daniel on 24-02-2016.
 */
public class ScreeningView
{
    public static VBox getView()
    {
        VBox layout = new VBox();
        GridPane layoutGrid = new GridPane();

        Label labelSearchTitle = new Label("Movie Title:");
        TextField titleText = new TextField("");

        Label labelTheatreID = new Label("Theatre:");
        TextField theatreID = new TextField("");

        Button button = new Button("Create");


        layoutGrid.add(labelSearchTitle, 0, 0 );
        layoutGrid.add(titleText, 1, 0 );
        layoutGrid.add(labelTheatreID, 0, 1 );
        layoutGrid.add(theatreID, 1, 1 );
        layoutGrid.add(DateBox.getDateBox(),1,2);
        layoutGrid.add(button, 1,4);

        layout.getChildren().addAll(layoutGrid);

        return layout;
    }
}
