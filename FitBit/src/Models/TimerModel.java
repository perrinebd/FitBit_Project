/* Name: Team BitFit
 * Class: TimerModel.java
 * 
 * Functions as Model for a TimerModel object for StopWatch; contains all TimerModel attributes and set/get methods.
 */

package Models;

public class TimerModel {
    private float total;
    private float lap;
    private int numLaps;
    private long startTime;
    private long stopTime;
    private long minutes;
    private long seconds;
    private long hour;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getLap() {
        return lap;
    }

    public void setLap(float lap) {
        this.lap = lap;
    }

    public int getNumLaps() {
        return numLaps;
    }

    public void setNumLaps(int numLaps) {
        this.numLaps = numLaps;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void advance(){ minutes++;}

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }
    
    public long getHour() {
    	return hour;
    }
    
    public void setHour(long hour) {
    	this.hour = hour;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }
}
