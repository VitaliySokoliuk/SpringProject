package ua.lviv.SpringUniversity.entities;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numberOfMember;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private RequestForEntry requestId;

    public Students(int numberOfMember, RequestForEntry requestId) {
        this.numberOfMember = numberOfMember;
        this.requestId = requestId;
    }

    public Students() {
    }

    public int getNumberOfMember() {
        return numberOfMember;
    }

    public void setNumberOfMember(int numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    public RequestForEntry getRequestId() {
        return requestId;
    }

    public void setRequestId(RequestForEntry requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "Students{" +
                "numberOfMember=" + numberOfMember +
                ", requestId=" + requestId +
                '}';
    }
}
