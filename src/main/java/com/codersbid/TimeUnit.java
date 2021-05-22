package com.codersbid;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Calendar;

public enum TimeUnit
{
    SECOND("second", Calendar.SECOND, 1000),
    MINUTE("minute", Calendar.MINUTE, 60 * SECOND.getMillis()),
    HOUR("HOUR", Calendar.HOUR_OF_DAY, 60 * MINUTE.getMillis()),
    DAY("day", Calendar.DATE, 24 * HOUR.getMillis()),
    BUSINESS_DAY("business day", Calendar.DATE, DAY.getMillis()),
    WEEK("week", Calendar.WEEK_OF_YEAR, 7 * DAY.getMillis()),
    MONTH("month", Calendar.MONTH, 30 * DAY.getMillis()),
    YEAR("year", Calendar.YEAR, 365 * DAY.getMillis());

    private String desc;
    private int calendarField;
    private long millis;

    TimeUnit(String desc, int calendarField, long millis)
    {
        this.desc = desc;
        this.calendarField = calendarField;
        this.millis = millis;
    }

    @XmlTransient
    public String getDesc()
    {
        return desc;
    }

    @XmlTransient
    public int getCalendarField()
    {
        return calendarField;
    }

    @XmlTransient
    public long getMillis() {
        return millis;
    }

}