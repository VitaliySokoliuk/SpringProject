package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.User;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
