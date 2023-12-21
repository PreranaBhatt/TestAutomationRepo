package Utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class DateUtils {

    public static String getCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
        return  now.toLocalDate().toString();
    }

    public static String addNumberOfDaysinDate(int numOfDay){
        return  LocalDateTime.now().toLocalDate().plusDays(numOfDay).toString();
    }
}