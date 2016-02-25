package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.Calendar;


public class DateBox
{
    public static TextField fieldYear;
    public static TextField fieldMonth;
    public static TextField fieldDay;
    public static TextField fieldHour;
    public static TextField fieldMinute;

    public static HBox getDateBox()
    {
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int hour = Calendar.getInstance().get(Calendar.HOUR);
        int minutes = Calendar.getInstance().get(Calendar.MINUTE);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);

        Label labelYear = new Label("Year");
        Label labelMonth = new Label("Month");
        Label labelDay = new Label("Day");
        Label labelHour = new Label("Hour");
        Label labelMinute = new Label("Min");

        fieldYear = new TextField(Integer.toString(year));
        fieldMonth = new TextField(Integer.toString(month));
        fieldDay = new TextField(Integer.toString(day));
        fieldHour = new TextField(Integer.toString(hour));
        fieldMinute = new TextField(Integer.toString(minutes));

        hbox.getChildren().addAll(labelYear, fieldYear, labelMonth, fieldMonth, labelDay, fieldDay, labelHour, fieldHour, labelMinute, fieldMinute);

        return hbox;
    }
}
