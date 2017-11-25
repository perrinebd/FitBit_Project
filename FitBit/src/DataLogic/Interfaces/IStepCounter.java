package DataLogic.Interfaces;

public interface IStepCounter {
    boolean inMotion();
    void start();
    void stop();
    void reset();
    int getTotal();

}
