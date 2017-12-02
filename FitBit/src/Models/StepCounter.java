/* Name: Team BitFit
 * Class: StepCounter.java
 * 
 * Functions as Model for a StepCounter object; contains all StepCounter attributes and set/get methods.
 */

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

    // increments total step count by current step count; returns current step count to 0 for
    // another count
    public void logCurrSteps(){
        totalSteps += currSteps;
        currSteps = 0;
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
