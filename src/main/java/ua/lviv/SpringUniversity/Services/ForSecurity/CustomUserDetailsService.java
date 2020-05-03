package ua.lviv.SpringUniversity.Services.ForSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Repositories.UserRepo;
import ua.lviv.SpringUniversity.Entities.User;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Autowired
    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userMaybe = userRepo.findByEmail(email);
        return userMaybe
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user present with email: " + email));
    }

}
