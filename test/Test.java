import CSTime.DateTime;

import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        DateTime now = new DateTime(Calendar.getInstance());

        DateTime real = new DateTime(now.getYears(), now.getMonthNumeric(), now.getDayOfMonth());

        System.out.println(now.getDateTime(true, true));
        System.out.println(real.getDateTime(true, true));
    }
}
