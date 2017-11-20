package DataLogic;

import Models.HRMonitor;
import Models.User;
import java.util.Timer;

public interface IHRDataLogic {
    int calculateBPM(int beatsRec, Timer timer);
    boolean isSleeping(User user);
    void reset();
    void start();
    void stop();
    HRMonitor createHRM();
}
