package DataLogic;

import DataLogic.Interfaces.IStepCounter;
import DataLogic.Interfaces.IUserDataLogic;

public class StepCounter implements IStepCounter{
    private IUserDataLogic _uDataLogic;

    public StepCounter()
    {
        
    }

    public boolean inMotion()
    {
        return true;
    }

    public void start()
    {

    }

    public void stop()
    {

    }

    public void reset()
    {

    }

    public int getTotal()
    {
        return 0;
    }
}
