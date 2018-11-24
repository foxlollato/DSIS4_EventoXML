package util;

import java.sql.Time;
import java.time.LocalTime;

public class TimeUtil {
    public static Time toSqlTime(LocalTime hora){
        return Time.valueOf(hora);
    }
}
