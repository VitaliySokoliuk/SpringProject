package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.Department;
import ua.lviv.SpringUniversity.Entities.Faculty;
import ua.lviv.SpringUniversity.Entities.TheDepartmentsOfTheFaculty;

import java.util.List;

@Repository
public interface TheDepartmentsOfTheFacultyRepo extends CrudRepository<TheDepartmentsOfTheFaculty, Integer> {

    @Query(value = "select faculty_id from the_departments_of_the_faculty where department_id = ?1",
            nativeQuery = true)
    List<Integer> getFacOnDep(int id);

    @Modifying
    @Query(value = "delete from the_departments_of_the_faculty where department_id = ?1 and faculty_id = ?2",
            nativeQuery = true)
    void deleteByDepartmentIdAndFacultyId(int d_id, int f_id);

}
