package ScheduleBasedProxy;

//A silly class that doesn't do much.
//The begin reminder method prints a reminder and the acknowledgeReminder method does nothing
public class ReminderText implements IReminder {

    @Override
    public void beginReminder(String reminderContent) {
        System.out.println(reminderContent);
    }

    @Override
    public void acknowledgeReminder() {
        System.out.println("Got it");
    }
}
