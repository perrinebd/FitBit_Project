package Models;

public class StepCounter {
    private int totalSteps;
    private int displaySteps;
    private int currSteps;

    public int getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    public void logCurrSteps(){
        totalSteps += currSteps;
    }

    public int getCurrSteps() {
        return currSteps;
    }

    public void setCurrSteps(int currSteps) {
        this.currSteps = currSteps;
    }

    public void addSteps(){
        currSteps++;
    }

    public int getDisplaySteps() {
        return displaySteps;
    }

    public void setDisplaySteps(int displaySteps) {
        this.displaySteps = displaySteps;
    }
}
