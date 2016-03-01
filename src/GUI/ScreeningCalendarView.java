package GUI;

import Controller.TimeController;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Calendar;

public class ScreeningCalendarView
{
    public static Double dayWidth = 150.0;
    public static Double dayHeight = 600.0;
    public static int showDays = 7;

    public static HBox getView()
    {
        HBox layout = new HBox(10);

        int calDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int calMonth = Calendar.getInstance().get(Calendar.MONTH);
        int calYear = Calendar.getInstance().get(Calendar.YEAR);

        String dateToString;

        long today = TimeController.getScreeningDay(134);

        for (int i = 0; i < showDays+1; i++)
        {
            VBox day = new VBox();

        }


        return layout;
    }
}
