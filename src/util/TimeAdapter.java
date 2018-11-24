package util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeAdapter extends XmlAdapter<String, LocalTime> {



    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");


    @Override
    public LocalTime unmarshal(String v) throws Exception {
        return LocalTime.parse(v, formatterHora);
    }

    @Override
    public String marshal(LocalTime v) throws Exception {
        return v.format(formatterHora);
    }
}
