package ua.lviv.SpringUniversity.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request_for_entry")
public class RequestForEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private int requestId;

    @ManyToOne
    @JoinColumn(name = "entrant_id", nullable = false)
    private Entrant entrant;

    @ManyToOne
    @JoinColumn(name = "departments_code", nullable = false)
    private TheDepartmentsOfTheFaculty department;

    @Column(name = "rating_score", nullable = false)
    private double ratingScore;
    @Column(name = "request_time", nullable = false)
    private Date requestTime;

    public RequestForEntry(int requestId, Entrant entrant, TheDepartmentsOfTheFaculty department,
                           double ratingScore, Date requestTime) {
        this.requestId = requestId;
        this.entrant = entrant;
        this.department = department;
        this.ratingScore = ratingScore;
        this.requestTime = requestTime;
    }

    public RequestForEntry() {
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Entrant getEntrant() {
        return entrant;
    }

    public void setEntrant(Entrant entrant) {
        this.entrant = entrant;
    }

    public TheDepartmentsOfTheFaculty getDepartment() {
        return department;
    }

    public void setDepartment(TheDepartmentsOfTheFaculty department) {
        this.department = department;
    }

    public double getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(double ratingScore) {
        this.ratingScore = ratingScore;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    @Override
    public String toString() {
        return "RequestForEntry{" +
                "requestId=" + requestId +
                ", entrant=" + entrant +
                ", department=" + department +
                ", ratingScore=" + ratingScore +
                ", requestTime=" + requestTime +
                '}';
    }
}
