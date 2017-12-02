/* Name: Team BitFit
 * Class: User.java
 * 
 * Functions as Model for a User object; contains all User attributes and set/get methods.
 */

package Models;

import java.util.Date;
import java.util.Dictionary;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String password;
    private Double height;
    private Double weight;
    private int stepTotal;
    private List<Report> reports;
    private HRMonitor hrMonitor;
    private Boolean awake;
    private Dictionary<Integer, Date> dailyStepTotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getStepTotal() {
        return stepTotal;
    }

    public void setStepTotal(int stepTotal) {
        this.stepTotal = stepTotal;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public HRMonitor getHrMonitor() {
        return hrMonitor;
    }

    public void setHrMonitor(HRMonitor hrMonitor) {
        this.hrMonitor = hrMonitor;
    }

    public Boolean getAwake() {
        return awake;
    }

    public void setAwake(Boolean awake) {
        this.awake = awake;
    }

    public Dictionary<Integer, Date> getDailyStepTotal() {
        return dailyStepTotal;
    }

    // maps key/value data pairs for mapping step totals with their corresponding days
    public void setDailyStepTotal(Dictionary<Integer, Date> dailyStepTotal) {
        this.dailyStepTotal = dailyStepTotal;
    }
}