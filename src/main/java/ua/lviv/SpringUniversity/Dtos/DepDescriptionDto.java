package ua.lviv.SpringUniversity.Dtos;

public class DepDescriptionDto {

    private int departmentsCode;
    private String facultyName;
    private String departmentName;

    public DepDescriptionDto(int departmentsCode, String facultyName, String departmentName) {
        this.departmentsCode = departmentsCode;
        this.facultyName = facultyName;
        this.departmentName = departmentName;
    }

    public DepDescriptionDto() {
    }

    public int getDepartmentsCode() {
        return departmentsCode;
    }

    public void setDepartmentsCode(int departmentsCode) {
        this.departmentsCode = departmentsCode;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "DepDescriptionDto{" +
                "departmentsCode=" + departmentsCode +
                ", facultyName='" + facultyName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

}
