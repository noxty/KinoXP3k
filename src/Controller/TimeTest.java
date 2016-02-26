package Controller;

/**
 * Created by Hans on 26-02-2016.
 */
public class TimeTest
{
    public static void main(String[] args) {

        try
        {
            for (int i = 0; i < 7; i++) {
                System.out.println(TimeController.getTimeOfDay("15:00", i));
                System.out.println(TimeController.getDateFromTS(TimeController.getTimeOfDay("15:00", i)));
                System.out.println(TimeController.getDateFromTS(TimeController.getTimeOfDay("18:00", i)));
                System.out.println(TimeController.getDateFromTS(TimeController.getTimeOfDay("21:00", i)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
