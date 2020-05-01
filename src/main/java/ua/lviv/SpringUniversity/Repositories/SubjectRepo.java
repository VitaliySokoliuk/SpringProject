package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.entities.Subject;

@Repository
public interface SubjectRepo extends CrudRepository<Subject, Integer> {

}
