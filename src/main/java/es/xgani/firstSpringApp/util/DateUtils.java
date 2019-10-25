package es.xgani.firstSpringApp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static Date parse(String date) throws ParseException {
        return sdf.parse(date);
    }
}
