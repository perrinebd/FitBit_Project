package DataLogic;

import Models.*;

import java.util.Date;

public interface IUserDataLogic {
    public User getUserInfo(String id);
    public HRMonitor getHeartRate();
    public void viewTotalSteps(String id);
    public void logUserSteps(User user);
    public Report getReport(Date start, Date end);
}
