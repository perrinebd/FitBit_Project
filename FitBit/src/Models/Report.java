/* Name: Team BitFit
 * Class: Report.java
 * 
 * Functions as Model for a Report object; contains all Report attributes and set/get methods.
 */

package Models;

import java.util.Date;
import java.util.Timer;

public class Report {
    private Date startDate;
    private Date endDate;
    private User user;
    private Timer timer;
    private String output;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
