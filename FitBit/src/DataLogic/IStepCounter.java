package DataLogic;

public interface IStepCounter {
    Boolean inMotion();
    void start();
    void stop();
    void reset();
    int getTotal();

}
