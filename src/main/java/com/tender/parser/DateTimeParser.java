package com.tender.parser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Денис on 04.01.2017.
 */
public class DateTimeParser {

    public static Date parseDate(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = date.toString();
        Date datetime = null;
        try {
            datetime = format.parse(string + " 15:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datetime;
    }
}
