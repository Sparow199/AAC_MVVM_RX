package com.lahzouz.sparow.acc_rxjava.service.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by sparow on 10/31/17.
 */

public class Converters {
    @TypeConverter
    public Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }
}
