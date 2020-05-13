package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.Entrant;

@Repository
public interface EntrantRepo extends CrudRepository<Entrant, Integer> {

    boolean existsByEmail(String email);

    Entrant getByEmail(String email);

    @Query("select e.photo from Entrant e where e.entrantId = :id")
    byte[] getPhoto(@Param("id") int id);
}
