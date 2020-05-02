package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.Mark;

@Repository
public interface MarkRepo extends CrudRepository<Mark, Integer> {

}
