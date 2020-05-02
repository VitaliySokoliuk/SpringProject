package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.Faculty;

@Repository
public interface FacultyRepo extends CrudRepository<Faculty, Integer> {

}
