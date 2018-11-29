package util;

import oracle.sql.TIMESTAMP;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class DateTimeUtil {

    private static DateTimeFormatter formatterData = new DateTimeFormatterBuilder().appendPattern("dd/MM")
            .parseDefaulting(ChronoField.YEAR, Year.now().getValue())
            .toFormatter();
    private static DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");

    public static Timestamp toTimeStamp(LocalDate date, LocalTime time){
        return Timestamp.valueOf(LocalDateTime.of(date,time)); //ok
    }

    public static LocalDate toLocalDate(String date){
        return LocalDate.parse(date,formatterData); //ok
    }

    public static LocalTime toLocalTime(String time){
        return LocalTime.parse(time,formatterHora); //ok
    }
}
