package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.entities.Students;

@Repository
public interface StudentsRepo extends CrudRepository<Students, Integer> {

}
