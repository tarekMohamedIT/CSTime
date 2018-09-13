package CSTime;

/*
   Copyright 2017 Tarek Mohamed

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.
 */

/**
 * Created by tarek on 5/27/17.
 */
public class TimeSpan {

    private int totalYears;
    private int totalMonths;
    private int totalDays;
    private int totalHours;
    private int totalMinutes;
    private int totalSeconds;
    private int totalMilliSeconds;

    private int years;
    private int months;
    private int days;
    private int hours;
    private int minutes;
    private int seconds;
    private int milliSeconds;

    private TimeSpan(int totalYears, int totalMonths, int totalDays, int totalHours, int totalMinutes, int totalSeconds, int totalMilliSeconds, int years, int months, int days, int hours, int minutes, int seconds, int milliSeconds) {
        this.totalYears = totalYears;
        this.totalMonths = totalMonths;
        this.totalDays = totalDays;
        this.totalHours = totalHours;
        this.totalMinutes = totalMinutes;
        this.totalSeconds = totalSeconds;
        this.totalMilliSeconds = totalMilliSeconds;
        this.years = years;
        this.months = months;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliSeconds = milliSeconds;
    }

    public int getTotalYears() {
        return totalYears;
    }

    public int getTotalMonths() {
        return totalMonths;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public int getTotalMilliSeconds() {
        return totalMilliSeconds;
    }

    public int getYears() {
        return years;
    }

    public int getMonths() {
        return months;
    }

    public int getDays() {
        return days;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMilliSeconds() {
        return milliSeconds;
    }

    public static TimeSpan subtract(DateTime dateTime1, DateTime dateTime2){

        long totalMilliSeconds = Math.abs(dateTime1.getTimeInMilliseconds() - dateTime2.getTimeInMilliseconds());
        long totalSeconds = totalMilliSeconds / 1000;
        long totalMinutes = totalSeconds / 60;
        long totalHours = totalMinutes / 60;
        long totalDays = totalHours / 24;
        long totalMonths = subtractMonths(dateTime1, dateTime2);
        long totalYears = totalMonths / 12;

        return new TimeSpan(
                  (int)totalYears
                , (int)totalMonths
                , (int)totalDays
                , (int)totalHours
                , (int)totalMinutes
                , (int)totalSeconds
                , (int)totalMilliSeconds
                , Math.abs(dateTime1.getYears() - dateTime2.getYears())
                , Math.abs(dateTime1.getMonthNumeric() - dateTime2.getMonthNumeric())
                , Math.abs(dateTime1.getDayOfMonth() - dateTime2.getDayOfMonth())
                , Math.abs(dateTime1.getHours24() - dateTime2.getHours24())
                , Math.abs(dateTime1.getMinutes() - dateTime2.getMinutes())
                , Math.abs(dateTime1.getSeconds() - dateTime2.getSeconds())
                , Math.abs(dateTime1.getMilliseconds() - dateTime2.getMilliseconds()));
    }

    public static long subtractYears(DateTime dt1, DateTime dt2){
        return Math.abs(dt1.getYears() - dt2.getYears());
    }

    public static long subtractMonths(DateTime dt1, DateTime dt2){
        long years = Math.abs(dt1.getYears() - dt2.getYears());
        long months = 0;
        DateTime maxDate;
        DateTime minDate;

        if (dt1.compareTo(dt2) > 0){
            maxDate = dt1.clone();
            minDate = dt2.clone();
        }

        else {
            maxDate = dt2.clone();
            minDate = dt1.clone();
        }

        if (maxDate.getMonthNumeric() < minDate.getMonthNumeric()){
            years--;
            months += ((maxDate.getMonthNumeric() + 12) - minDate.getMonthNumeric());
        }
        else {
            months += (maxDate.getMonthNumeric() - minDate.getMonthNumeric());
        }

        return (months + (years * 12));
    }

}
