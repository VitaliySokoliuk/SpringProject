package ua.lviv.SpringUniversity.entities;

import javax.persistence.*;

@Entity
@Table(name = "the_departments_of_the_faculty")
public class TheDepartmentsOfTheFaculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "departments_code")
    private int departmentsCode;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public TheDepartmentsOfTheFaculty(int departmentsCode, Department department, Faculty faculty) {
        this.departmentsCode = departmentsCode;
        this.department = department;
        this.faculty = faculty;
    }

    public TheDepartmentsOfTheFaculty() {
    }

    public int getDepartmentsCode() {
        return departmentsCode;
    }

    public void setDepartmentsCode(int departmentsCode) {
        this.departmentsCode = departmentsCode;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "TheDepartmentsOfTheFaculty{" +
                "departmentsCode=" + departmentsCode +
                ", department=" + department +
                ", faculty=" + faculty +
                '}';
    }
}
