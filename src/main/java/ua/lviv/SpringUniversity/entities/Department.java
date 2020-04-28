package ua.lviv.SpringUniversity.entities;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private int departmentId;
    @Column(name = "department_name", nullable = false)
    private String departmentName;
    @Column(name = "max_number_of_students", nullable = false)
    private int maxNumberOfStudents;

    public Department(int departmentId, String departmentName, int maxNumberOfStudents) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Department() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", maxNumberOfStudents=" + maxNumberOfStudents +
                '}';
    }
}
