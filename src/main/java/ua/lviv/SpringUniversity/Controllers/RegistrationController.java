package ua.lviv.SpringUniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.SpringUniversity.Entities.User;
import ua.lviv.SpringUniversity.Services.ForSecurity.UserService;
import ua.lviv.SpringUniversity.Validators.RegistrationValidator;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private UserService userService;
    private RegistrationValidator registrationValidator;

    @Autowired
    public RegistrationController(UserService userService, RegistrationValidator registrationValidator) {
        this.userService = userService;
        this.registrationValidator = registrationValidator;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute @Valid User user, BindingResult bindingResult){

        registrationValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors()){
            return "registration";
        }

        userService.save(user);

        return "redirect:/login";
    }

    @GetMapping("/confirmEmail")
    public String confirmEmail(@RequestParam String hash){
        userService.confirmEmail(hash);
        System.out.println(hash);
        return "redirect:/main";
    }

}
