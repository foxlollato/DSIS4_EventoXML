package util;

import java.sql.Date;
import java.time.LocalDate;

public class DateUtil {
    public static Date toSqlDate(LocalDate date){
        return Date.valueOf(date);
    }
}
