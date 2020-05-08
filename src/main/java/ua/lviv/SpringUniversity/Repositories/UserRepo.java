package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.SpringUniversity.Entities.User;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByVerifyEmailHash(String hash);

    @Modifying
    @Query("Update User u set u.isEmailVerified = TRUE where u.userId = :id")
    void confirmEmail(@Param("id") int userId);
}
