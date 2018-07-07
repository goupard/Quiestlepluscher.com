package com.example.armand.quiestlepluscher.sqlite.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ulyss on 13/06/2018.
 */

public class Utils {


    /**
     *
     * @param timeToFormat a date with the "yyyy-MM-dd HH:mm:ss" format.
     * @return The corresponding date
     */
    public static Date getDateFromString(String timeToFormat){
        SimpleDateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = null;
        if (timeToFormat != null) {
            try {
                date = iso8601Format.parse(timeToFormat);
            } catch (ParseException e) {
                date = null;
            }
        }

        return date;
    }

    public static Date getDateFromInt(int timeToFormat){
        return new Date(timeToFormat);
    }
}
