package ua.lviv.SpringUniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.lviv.SpringUniversity.Services.ForSecurity.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/main")
    public String main(HttpServletRequest req){
        return "main";
    }
    @PostMapping("/main")
    public String main2(HttpServletRequest req){

        return "main";
    }

}
