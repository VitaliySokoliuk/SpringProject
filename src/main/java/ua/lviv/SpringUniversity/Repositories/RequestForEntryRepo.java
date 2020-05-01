package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.entities.RequestForEntry;

@Repository
public interface RequestForEntryRepo extends CrudRepository<RequestForEntry, Integer> {

}
