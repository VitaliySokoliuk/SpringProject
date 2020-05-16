package ua.lviv.SpringUniversity.Services.ForSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Repositories.UserRepo;
import ua.lviv.SpringUniversity.Entities.Enums.UsersRole;
import ua.lviv.SpringUniversity.Entities.User;
import ua.lviv.SpringUniversity.Services.EmailSendingService;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private static final UsersRole DEFAULT_USERS_ROLE = UsersRole.ROLE_ADMIN;

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private EmailSendingService emailSendingService;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder, EmailSendingService emailSendingService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.emailSendingService = emailSendingService;
    }

    public void save(User user){
        user.setRole(DEFAULT_USERS_ROLE);
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setRegistrationDate(new Date());

        UUID uuid = UUID.randomUUID();
        user.setVerifyEmailHash(uuid.toString());

        userRepo.save(user);

        MyThread thread = new MyThread(emailSendingService, user, uuid);
        new Thread(thread).start();

    }

    public Optional<User> findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public void confirmEmail(String hash) {
        userRepo.findByVerifyEmailHash(hash).ifPresent(user -> userRepo.confirmEmail(user.getUserId()));
    }

}

class MyThread implements Runnable{

    EmailSendingService emailSendingService;
    User user;
    UUID uuid;

    public MyThread(EmailSendingService emailSendingService, User user, UUID uuid) {
        this.emailSendingService = emailSendingService;
        this.user = user;
        this.uuid = uuid;
    }

    @Override
    public void run() {
        emailSendingService.sendEmail(user.getEmail(), uuid.toString());
    }

}
