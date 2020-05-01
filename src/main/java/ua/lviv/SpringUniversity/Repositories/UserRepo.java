package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.entities.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

}
