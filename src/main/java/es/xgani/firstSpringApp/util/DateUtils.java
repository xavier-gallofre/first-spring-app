package es.xgani.firstSpringApp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    private static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public static Date parse(String date) throws ParseException {
        return sdf.parse(date);
    }
}
