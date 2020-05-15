package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.RequestForEntry;

import java.util.List;

@Repository
public interface RequestForEntryRepo extends CrudRepository<RequestForEntry, Integer> {

    @Query(value = "select departments_code from request_for_entry where entrant_id = ?1",
            nativeQuery = true)
    List<Integer> getDepartmentsCodeByEntrantId(int entrantId);

    @Query(value = "select r from RequestForEntry r where r.entrant.entrantId = ?1")
    List<RequestForEntry> getByEntrantId(int id);

}
