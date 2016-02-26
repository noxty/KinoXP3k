package Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Hans on 25-02-2016.
 */
public class TimeController
{
    public static long getUnixTime(String date) {
        try
        {
            DateFormat dfm = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
            long stamp = dfm.parse(date).getTime() / 1000;
            return stamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long getScreeningDay(int _date) {
        String date = String.valueOf(_date);
        try
        {
            DateFormat dfm = new SimpleDateFormat(date, Locale.ENGLISH);
            long stamp = dfm.parse(date).getTime() / 1000;
            return stamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getDateFromTS(long ts)
    {
        java.util.Date _date = new java.util.Date(ts * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        return sdf.format(_date);
    }

    public static int formatForDB(long ts) {
        java.util.Date _date = new java.util.Date(ts * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        return Integer.parseInt(sdf.format(_date));
    }
}
