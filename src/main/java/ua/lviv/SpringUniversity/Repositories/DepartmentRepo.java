package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.entities.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

}
