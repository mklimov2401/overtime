package until;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Helper {

    public static String getDateMinus(int day){
        return LocalDate.now().minusDays(day).format(DateTimeFormatter.ofPattern("dd.MM"));
    }
}
