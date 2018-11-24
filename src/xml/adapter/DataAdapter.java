package xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class DataAdapter extends XmlAdapter<String, LocalDate> {

    private DateTimeFormatter formatterData = new DateTimeFormatterBuilder().appendPattern("dd/MM")
            .parseDefaulting(ChronoField.YEAR, Year.now().getValue())
            .toFormatter();

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, formatterData);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(formatterData);
    }

}