package ua.lviv.SpringUniversity.Validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.lviv.SpringUniversity.Entities.User;
import ua.lviv.SpringUniversity.Services.ForSecurity.UserService;

@Component
public class RegistrationValidator implements Validator {

    private UserService userService;

    @Autowired
    public RegistrationValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (user.getPassword().isEmpty() || user.getFirstName().isEmpty() ||
                user.getEmail().isEmpty() || user.getLastName().isEmpty()) {
            errors.reject("Not supported empty fields");
        }
        if(userService.findByEmail(user.getEmail()).isPresent()){
            errors.reject("This email is already exist");
        }

    }
}
