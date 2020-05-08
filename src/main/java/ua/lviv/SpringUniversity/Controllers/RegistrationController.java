package ua.lviv.SpringUniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.SpringUniversity.Entities.User;
import ua.lviv.SpringUniversity.Services.ForSecurity.UserService;

import java.util.Optional;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user){
        Optional<User> searchUser = userService.findByEmail(user.getEmail());

        if (searchUser.isPresent()){
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
