package CSTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by tarek on 5/26/17.
 */
public class DateTime implements Comparable<DateTime>, Comparator<DateTime>, Cloneable {

    private final String DEFAULT_DATE_SHORT_FORMAT = "dd/MM/yyyy";
    private final String DEFAULT_DATE_LONG_FORAMT = "dd '%s of %s' yyyy";

    public final static String DEFAULT_DATE_TIME_12_HOUR = "dd/MM/yyyy hh:mm:ss,sss a";
    public final static String DEFAULT_DATE_TIME_12_HOUR_NO_MILLIS = "dd/MM/yyyy hh:mm:ss a";
    public final static String DEFAULT_DATE_TIME_24_HOUR = "dd/MM/yyyy HH:mm:ss,sss";
    public final static String DEFAULT_DATE_TIME_24_HOUR_NO_MILLIS = "dd/MM/yyyy HH:mm:ss";
    public final static String DEFAULT_TIME_12_HOUR = "hh:mm:ss,sss a";
    public final static String DEFAULT_TIME_12_HOUR_NO_MILLIS = "hh:mm:ss a";
    public final static String DEFAULT_TIME_24_HOUR = "HH:mm:ss,sss";
    public final static String DEFAULT_TIME_24_HOUR_NO_MILLIS = "HH:mm:ss";
    public final static String DEFAULT_DATE = "dd/MM/yyyy";

    private Calendar calendar;

    String[] MONTH_NAME = new String[]{
              "January"
            , "February"
            , "March"
            , "April"
            , "May"
            , "June"
            , "July"
            , "August"
            , "September"
            , "October"
            , "November"
            , "December"
    };

    String[] DAY_NAME = new String[]{
              "Saturday"
            , "Sunday"
            , "Monday"
            , "Tuesday"
            , "Wednesday"
            , "Thursday"
            , "Friday"
    };

    enum CompareDateBy {
        Years,
        Months,
        Days,
        Hours,
        Minutes,
        Seconds,
        Milliseconds,
        Date,
        Time
    }

    /**
     * Constructor for the DateTime class
     * @param date the date and time in Date class instance
     */
    public DateTime(Date date){
        calendar = Calendar.getInstance();
        calendar.setTime(date);
    }

    /**
     * Constructor for the DateTime class
     * @param milliseconds The total date and time in milliseconds
     */
    public DateTime(long milliseconds){
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
    }

    /**
     * Constructor for the DateTime class
     * @param years The years of the date
     * @param months The months of the date
     * @param daysOfMonth the day in month of the date
     */
    public DateTime(int years, int months, int daysOfMonth){
        this.calendar = Calendar.getInstance();
        this.calendar.set(Calendar.YEAR, years);
        this.calendar.set(Calendar.MONTH, months - 1);
        this.calendar.set(Calendar.DAY_OF_MONTH, daysOfMonth);
    }

    /**
     * Constructor for the DateTime class
     * @param years The years of the date
     * @param months The months of the date
     * @param daysOfMonth the day in month of the date
     * @param hours24 the hours in 24-hour system time
     * @param minutes the minutes of the time
     * @param seconds the current seconds of the desired time
     */
    public DateTime(int years, int months, int daysOfMonth, int hours24, int minutes, int seconds){
        this.calendar = Calendar.getInstance();
        this.calendar.set(Calendar.YEAR, years);
        this.calendar.set(Calendar.MONTH, months - 1);
        this.calendar.set(Calendar.DAY_OF_MONTH, daysOfMonth);
        this.calendar.set(Calendar.HOUR_OF_DAY, hours24);
        this.calendar.set(Calendar.MINUTE, minutes);
        this.calendar.set(Calendar.SECOND, seconds);
    }

    /**
     * Constructor for the DateTime class
     * @param years The years of the date
     * @param months The months of the date
     * @param daysOfMonth the day in month of the date
     * @param hours24 the hours in 24-hour system time
     * @param minutes the minutes of the time
     * @param seconds the current seconds of the desired time
     * @param milliseconds the current milliseconds of the desired time
     */
    public DateTime(int years, int months, int daysOfMonth, int hours24, int minutes, int seconds, int milliseconds){
        this.calendar = Calendar.getInstance();
        this.calendar.set(Calendar.YEAR, years);
        this.calendar.set(Calendar.MONTH, months - 1);
        this.calendar.set(Calendar.DAY_OF_MONTH, daysOfMonth);
        this.calendar.set(Calendar.HOUR_OF_DAY, hours24);
        this.calendar.set(Calendar.MINUTE, minutes);
        this.calendar.set(Calendar.SECOND, seconds);
        this.calendar.set(Calendar.MILLISECOND, milliseconds);
    }

    /**
     * A method that returns new instance of DateTime class
     * @return A new DateTime instance with the date and time of now
     */
    public static DateTime getNow(){
        return new DateTime(new Date());
    }

    /**
     *
     * @return the Date class instance
     */
    public Calendar getCalendar(){
        return ((Calendar)calendar.clone());
    }

    /**
     *
     * @return the total milliseconds of the DateTime class
     */
    public Long getTimeInMilliseconds(){
        return calendar.getTimeInMillis();
    }

    /**
     *
     * @return A numeric representation of the current year's number in the DateTime instance
     */
    public Integer getYears(){
        return calendar.get(Calendar.YEAR);
    }

    /**
     *
     * @return A numeric representation of the current month's number in the DateTime instance
     */
    public Integer getMonthNumeric(){
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     *
     * @return A String representation of the current month's name in the DateTime instance
     */
    public String getMonthName(){
        return MONTH_NAME[calendar.get(Calendar.MONTH)];
    }

    /**
     *
     * @return A numeric representation of the current day's number in the year's days in the DateTime instance
     */
    public Integer getDayOfMonth(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     *
     * @return A numeric representation of the current day's number in the year's days in the DateTime instance
     */
    public Integer getMaxDayNumberOfYear(){
        return calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    /**
     *
     * @return A numeric representation of the current day's number in the year's days in the DateTime instance
     */
    public Integer getDayOfYear(){
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     *
     * @return A numeric representation of the current weeks's day number in the DateTime instance
     */
    public Integer getDayOfWeekNumeric(){
        return calendar.get(Calendar.DAY_OF_WEEK) + 1;
    }

    /**
     *
     * @return A string representation of the current week's day name in the DateTime instance
     */
    public String getDayOfWeekName(){
        return DAY_NAME[calendar.get(Calendar.DAY_OF_WEEK)];
    }

    /**
     *
     * @return A numeric representation of the current hours in 24-hour format in the DateTime instance
     */
    public Integer getHours24(){
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     *
     * @return A numeric representation of the current hours in 12-hour format in the DateTime instance
     */
    public Integer getHours12(){
        return calendar.get(Calendar.HOUR);
    }

    /**
     *
     * @return A string representation of the current AM/PM in the DateTime instance
     */
    public String getAM_PM(){
        return new SimpleDateFormat("a").format(calendar.getTime());
    }

    /**
     *
     * @return A numeric representation of the current minutes in the DateTime instance
     */
    public Integer getMinutes(){
        return calendar.get(Calendar.MINUTE);
    }

    /**
     *
     * @return A numeric representation of the current seconds in the DateTime instance
     */
    public Integer getSeconds(){
        return calendar.get(Calendar.SECOND);
    }

    /**
     *
     * @return A numeric representation of the current milliseconds in the DateTime instance
     */
    public Integer getMilliseconds(){
        return calendar.get(Calendar.MILLISECOND);
    }

    /**
     * A method used to get a formatted String of the time
     * @param hasMillis should the output string contain milliseconds?
     * @param is24Hours should the output string contain time in 24-hour format?
     * @return a string representation of the time
     */
    public String getTime(boolean hasMillis, boolean is24Hours){
        if (hasMillis && is24Hours) return new SimpleDateFormat(DEFAULT_TIME_24_HOUR).format(calendar.getTime());
        else if (!hasMillis && is24Hours) return new SimpleDateFormat(DEFAULT_TIME_24_HOUR_NO_MILLIS).format(calendar.getTime());
        else if (hasMillis && !is24Hours) return new SimpleDateFormat(DEFAULT_TIME_12_HOUR).format(calendar.getTime());
        else return new SimpleDateFormat(DEFAULT_TIME_12_HOUR_NO_MILLIS).format(calendar.getTime());

    }

    /**
     *
     * @return A string representing date in day/month/year format
     */
    public String getShortDate() {
        return new SimpleDateFormat(DEFAULT_DATE_SHORT_FORMAT).format(calendar.getTime());
    }

    /**
     *
     * @return A string representing long date format
     */
    public String getLongDate(){
        String post = "th";
        switch (getDayOfMonth()){
            case 1 :
                post = "st";
                break;
            case 2 :
                post = "nd";
                break;
            case 3 :
                post = "rd";
                break;
        }
        return String.format(new SimpleDateFormat(DEFAULT_DATE_LONG_FORAMT).format(calendar.getTime())
                ,post
                ,getMonthName());
    }

    /**
     * A method used to get a formatted String of the date and time
     * @param hasMillis should the output string contain milliseconds?
     * @param is24Hours should the output string contain time in 24-hour format?
     * @return a string representation of the date and time
     */
    public String getDateTime(boolean hasMillis, boolean is24Hours){
        if (hasMillis && is24Hours) return new SimpleDateFormat(DEFAULT_DATE_TIME_24_HOUR).format(calendar.getTime());
        else if (!hasMillis && is24Hours) return new SimpleDateFormat(DEFAULT_DATE_TIME_24_HOUR_NO_MILLIS).format(calendar.getTime());
        else if (hasMillis && !is24Hours) return new SimpleDateFormat(DEFAULT_DATE_TIME_12_HOUR).format(calendar.getTime());
        else return new SimpleDateFormat(DEFAULT_DATE_TIME_12_HOUR_NO_MILLIS).format(calendar.getTime());

    }

    /**
     * Adds years to the date of this DateTime instance
     * @param years the number of years to be added
     */
    public void addYears(int years){
        calendar.add(Calendar.YEAR, years);
    }

    /**
     * Adds months to the date of this DateTime instance
     * @param months the number of years to be added
     */
    public void addMonths(int months){
        calendar.add(Calendar.MONTH, months);
    }

    /**
     * Adds days to the date of this DateTime instance
     * @param days the number of years to be added
     */
    public void addDays(int days){
        calendar.add(Calendar.DAY_OF_YEAR, days);
    }

    /**
     * Adds hours to the date of this DateTime instance
     * @param hours the number of years to be added
     */
    public void addHours(int hours){
        calendar.add(Calendar.HOUR, hours);
    }

    /**
     * Adds minutes to the date of this DateTime instance
     * @param minutes the number of years to be added
     */
    public void addMinutes(int minutes){
        calendar.add(Calendar.MINUTE, minutes);
    }

    /**
     * Adds seconds to the date of this DateTime instance
     * @param seconds the number of years to be added
     */
    public void addSeconds(int seconds){
        calendar.add(Calendar.SECOND, seconds);
    }

    /**
     * Adds milliseconds to the date of this DateTime instance
     * @param milliseconds the number of years to be added
     */
    public void addMilliseconds(int milliseconds){
        calendar.add(Calendar.MILLISECOND, milliseconds);
    }

    /**
     * Comparing this DateTime instance to another DateTime and returns an integer :
     *
     * 7 : Years
     * 6 : Months
     * 5 : Days
     * 4 : Hours
     * 3 : Minutes
     * 2 : Seconds
     * 1 : Milliseconds
     * 0 : Identical
     *
     * @param dateTime the other DateTime instance
     * @return an integer indicating the difference between the two DateTime instances
     *  - Positive if this DateTime instance is more recent than the parameter
     *  - Negative if this DateTime instance is older than the parameter
     *  - Zero if this instance is equal to the parameter
     */
    @Override
    public int compareTo(DateTime dateTime) {

        if (this.getYears() > dateTime.getYears()) return 7;
        else if (this.getYears() < dateTime.getYears()) return -7;

        if (this.getMonthNumeric() > dateTime.getMonthNumeric()) return 6;
        else if (this.getMonthNumeric() < dateTime.getMonthNumeric()) return -6;

        if (this.getDayOfMonth() > dateTime.getDayOfMonth()) return 5;
        else if (this.getDayOfMonth() < dateTime.getDayOfMonth()) return -5;

        if (this.getHours24() > dateTime.getHours24()) return 4;
        else if (this.getHours24() < dateTime.getHours24()) return -4;

        if (this.getMinutes() > dateTime.getMinutes()) return 3;
        else if (this.getMinutes() < dateTime.getMinutes()) return -3;

        if (this.getSeconds() > dateTime.getSeconds()) return 2;
        else if (this.getSeconds() < dateTime.getSeconds()) return -2;

        if (this.getMilliseconds() > dateTime.getMilliseconds()) return 1;
        else if (this.getMilliseconds() < dateTime.getMilliseconds()) return -1;

        return 0;
    }

    /**
     * Compares this DateTime instance with another by a certain parameter
     * @param dateTime the other instance of DateTime class
     * @param compareDateBy the comparing parameter
     * @return an integer indicating the comparison's result
     *  - Positive if this DateTime instance is more recent than the parameter
     *  - Negative if this DateTime instance is older than the parameter
     *  - Zero if this instance is equal to the parameter
     */
    public int compareTo(DateTime dateTime, CompareDateBy compareDateBy) {

        switch (compareDateBy){
            case Years:
                if (this.getYears() > dateTime.getYears()) return 1;
                else return -1;

            case Months:
                if (this.getMonthNumeric() > dateTime.getMonthNumeric()) return 1;
                else return -1;

            case Days:
                if (this.getDayOfMonth() > dateTime.getDayOfMonth()) return 1;
                else return -1;

            case Hours:
                if (this.getHours24() > dateTime.getHours24()) return 1;
                else return -1;

            case Minutes:
                if (this.getMinutes() > dateTime.getMinutes()) return 1;
                else return -1;

            case Seconds:
                if (this.getSeconds() > dateTime.getSeconds()) return 1;
                else return -1;

            case Milliseconds:
                if (this.getMilliseconds() > dateTime.getMilliseconds()) return 1;
                else return -1;

            case Date:
                if (this.getYears() > dateTime.getYears()) return 1;
                else if (this.getYears() < dateTime.getYears()) return -1;

                if (this.getMonthNumeric() > dateTime.getMonthNumeric()) return 1;
                else if (this.getMonthNumeric() < dateTime.getMonthNumeric()) return -1;

                if (this.getDayOfMonth() > dateTime.getDayOfMonth()) return 1;
                else if (this.getDayOfMonth() < dateTime.getDayOfMonth()) return -1;

            case Time:
                if (this.getHours24() > dateTime.getHours24()) return 1;
                else if (this.getHours24() < dateTime.getHours24()) return -1;

                if (this.getMinutes() > dateTime.getMinutes()) return 1;
                else if (this.getMinutes() < dateTime.getMinutes()) return -1;

                if (this.getSeconds() > dateTime.getSeconds()) return 1;
                else if (this.getSeconds() < dateTime.getSeconds()) return -1;

                if (this.getMilliseconds() > dateTime.getMilliseconds()) return 1;
                else if (this.getMilliseconds() < dateTime.getMilliseconds()) return -1;
        }

        return 0;
    }

    /**
     * implementing the Comparator object to sort the DateTime instances
     * @param dateTime1 The first DateTime instance
     * @param dateTime2 The second DateTime instance
     * @return The result of comparing the first DateTime instance to the other
     */
    @Override
    public int compare(DateTime dateTime1, DateTime dateTime2) {
        return dateTime1.compareTo(dateTime2);
    }

    /**
     * Creates new DateTime clone out of this DateTime instance
     * @return a new DateTime instance with the same values
     */
    @Override
    protected DateTime clone() {
        return new DateTime(calendar.getTimeInMillis());
    }
}