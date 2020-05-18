package ua.lviv.SpringUniversity.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.SpringUniversity.Entities.Entrant;
import ua.lviv.SpringUniversity.Entities.Enums.EntrantsStatus;
import ua.lviv.SpringUniversity.Entities.User;
import ua.lviv.SpringUniversity.Services.EntrantService;
import ua.lviv.SpringUniversity.Services.ForSecurity.CustomUserDetailsService;
import ua.lviv.SpringUniversity.Services.ForSecurity.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Controller
public class EntrantController {

    private static final Logger LOG = LoggerFactory.getLogger(EntrantController.class);
    private EntrantService entrantService;
    private UserService userService;

    @Autowired
    public EntrantController(EntrantService entrantService, UserService userService) {
        this.entrantService = entrantService;
        this.userService = userService;
    }

    @GetMapping("/add_entrant")
    public String entrant(HttpServletRequest req){
        Optional<User> currentUser = CustomUserDetailsService.getCurrentUser();

        String email = currentUser.get().getEmail();
        if(entrantService.existByEmail(email)) {
            req.setAttribute("exist", true);
            req.setAttribute("entrant", entrantService.getByEmail(email));
            return "entrant";
        }
        if (currentUser.isPresent()){
            User user = currentUser.get();
            req.setAttribute("user", user);
        }
        return "entrant";
    }

    @PostMapping("/add_entrant")
    public String entrant(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNumber,
                          @RequestParam String email, @RequestParam double scoreForSpecialAchievements,
                          @RequestParam double GPAofCertificate, @RequestParam MultipartFile photo, HttpServletRequest req){

        Entrant entrant = new Entrant(firstName, lastName, phoneNumber, email, scoreForSpecialAchievements, GPAofCertificate);
        entrant.setStatus(EntrantsStatus.REGISTERED);
        try {
            String contentType = photo.getContentType();
            if (contentType != null && contentType.startsWith("image")) {
                entrant.setPhoto(photo.getBytes());
            }
        } catch (IOException e) {
            LOG.warn("Could not save file" + photo.getOriginalFilename());
            throw new RuntimeException("Could not save file" + photo.getOriginalFilename());
        }
        entrantService.save(entrant);

        return "main";
    }

    @GetMapping("download_photo")
    public ResponseEntity<Resource> downloadPhoto(@RequestParam int id) {
        byte[] photo = entrantService.getPhoto(id);
        return ResponseEntity.ok().body(new ByteArrayResource(photo));
    }

}
