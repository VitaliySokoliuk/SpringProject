package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.Entrant;

@Repository
public interface EntrantRepo extends CrudRepository<Entrant, Integer> {

}
