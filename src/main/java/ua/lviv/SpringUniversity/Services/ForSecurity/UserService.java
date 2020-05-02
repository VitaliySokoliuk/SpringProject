package ua.lviv.SpringUniversity.Services.ForSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Repositories.UserRepo;
import ua.lviv.SpringUniversity.Entities.Enums.UsersRole;
import ua.lviv.SpringUniversity.Entities.User;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private static final UsersRole DEFAULT_USERS_ROLE = UsersRole.ADMIN;

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user){
        user.setRole(DEFAULT_USERS_ROLE);
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setRegistrationDate(new Date());
        userRepo.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepo.findByEmail(email);
    }

}
