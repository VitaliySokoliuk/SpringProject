package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

}
