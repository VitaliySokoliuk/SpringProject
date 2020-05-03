package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.TheDepartmentsOfTheFaculty;

@Repository
public interface TheDepartmentsOfTheFacultyRepo extends CrudRepository<TheDepartmentsOfTheFaculty, Integer> {

}
