package ScheduleBasedProxy;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProxyReminder implements IReminder {
    private List<String> allowedDays = Arrays.asList("Monday", "Wednesday", "Friday");
    private String allowedTimeRange = "8,17";

    public void beginReminder(String reminderContent) throws Exception {
        if (!isWithinDateTime()) {
            throw new Exception("Fool! You've tried to access the reminder outside working of hours!.. Come back in the morning.");
        }

        ReminderText rt = new ReminderText();
        rt.beginReminder(reminderContent);
    }

    public void acknowledgeReminder() {
        System.out.println("Got it");
    }

    private Boolean isWithinDateTime() {

        // get the day of week
        String dayOfWeek = new SimpleDateFormat("EEEE").format(new Date());

        //get the current time (military)
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        int currentHour = Integer.parseInt(sdf.format(cal.getTime() ) );

        //split the member string to break the open and close time into two strings
        String[] startStopTimes = allowedTimeRange.split(",");

        // If the current day of week is M, W, F
        // AND the current hour is between 8am and 5pm (8-17 military time) return true
        if (allowedDays.contains(dayOfWeek) &&
                ( Integer.parseInt(startStopTimes[0]) <= currentHour
                        && Integer.parseInt(startStopTimes[1]) > currentHour ) ) {
            System.out.println("Day of week: " + dayOfWeek + " and hour of day: " + currentHour);
            return true;
        }

        //Current day wasn't allowed or the current time was outside of 8am to 5pm
        return false;
    }

}
