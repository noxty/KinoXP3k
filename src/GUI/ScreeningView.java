package GUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

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

        Label labelSearchTitle = new Label("Movie Title");


        TextField titleText = new TextField("");
        TextField theatreID = new TextField("");
        TextField year = new TextField("");
        TextField month = new TextField("");
        TextField day = new TextField("");
        TextField hour = new TextField("");
        TextField minutes = new TextField("");


        return layout;
    }

    public static HBox getDateBox()
    {

        //lol
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int hour = Calendar.getInstance().get(Calendar.HOUR);
        int minutes = Calendar.getInstance().get(Calendar.MINUTE);

        HBox hbox = new HBox();
        TextField Tyear = new TextField(Integer.toString(year));
        TextField Tmonth = new TextField(Integer.toString(month));
        TextField Tday = new TextField(Integer.toString(day));
        TextField Thour = new TextField(Integer.toString(hour));
        TextField Tminutes = new TextField(Integer.toString(minutes));

        hbox.getChildren().addAll(Tyear, Tmonth, Tday, Thour, Tminutes);

        return hbox;

    }
}
