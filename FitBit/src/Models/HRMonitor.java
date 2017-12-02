/* Name: Team BitFit
 * Class: HRMonitor.java
 * 
 * Functions as Model for a HRMonitor object; contains all HRMonitor attributes and set/get methods.
 */

package Models;

import java.sql.Time;

public class HRMonitor {
    private int numBeats;
    private Time time;
    private Double avg;

    public int getNumBeats() {
        return numBeats;
    }

    public void setNumBeats(int numBeats) {
        this.numBeats = numBeats;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }
}
