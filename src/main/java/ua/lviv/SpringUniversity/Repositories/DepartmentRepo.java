package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.Department;

import java.util.List;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

    @Query(value = "select d.department_id, d.department_name, d.max_number_of_students " +
            "from department d " +
            "join the_departments_of_the_faculty dof " +
            "on d.department_id = dof.department_id " +
            "join faculty f " +
            "on dof.faculty_id = f.faculty_id " +
            "where f.faculty_id = ?1", nativeQuery = true)
    List<Department> usedDepartments(int id);
}
