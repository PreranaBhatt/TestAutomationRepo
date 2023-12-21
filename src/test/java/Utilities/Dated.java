package Utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Dated {
    public static void main(String[] args){
        LocalDateTime nowe= LocalDateTime.now();
        System.out.println(nowe.toLocalDate().getDayOfMonth());
        System.out.println(nowe.toLocalDate().plusDays(7));

    }
}
