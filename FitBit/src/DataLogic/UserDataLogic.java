package DataLogic;

import DataLogic.Interfaces.IUserDataLogic;
import Models.HRMonitor;
import Models.Report;
import Models.User;

import java.util.Date;

public class UserDataLogic implements IUserDataLogic{
    private Report report;
    private User user;
    private HRMonitor hrm;
    //private UserController uController;

    public User getUserInfo(String id)
    {
        return user;
    }

    public HRMonitor getHeartRate()
    {
        return hrm;
    }

    public void viewTotalSteps(String id)
    {

    }

    public void logUserSteps(User user)
    {

    }

    public Report getReport(Date start, Date end)
    {
        return report;
    }
}
