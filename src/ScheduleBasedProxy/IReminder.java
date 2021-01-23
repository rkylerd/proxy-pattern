package ScheduleBasedProxy;

public interface IReminder {
    public void beginReminder(String reminderContent) throws Exception;
    public void acknowledgeReminder();
}
