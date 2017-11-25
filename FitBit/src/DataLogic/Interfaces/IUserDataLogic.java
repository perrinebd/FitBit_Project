package DataLogic.Interfaces;

import Models.*;

import java.util.Date;

public interface IUserDataLogic {
    User getUserInfo(String id);
    HRMonitor getHeartRate();
    void viewTotalSteps(String id);
    void logUserSteps(User user);
    Report getReport(Date start, Date end);
}
