package ua.lviv.SpringUniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.SpringUniversity.Entities.Entrant;
import ua.lviv.SpringUniversity.Entities.RequestForEntry;
import ua.lviv.SpringUniversity.Services.EntrantService;
import ua.lviv.SpringUniversity.Services.RequestForEntryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin_page")
public class AdminEntrantsController {

    private EntrantService entrantService;
    private RequestForEntryService requestForEntryService;
    private int entrantId;

    @Autowired
    public AdminEntrantsController(EntrantService entrantService, RequestForEntryService requestForEntryService) {
        this.entrantService = entrantService;
        this.requestForEntryService = requestForEntryService;
    }

    @GetMapping("/admin_entrants")
    public String f_d_menu(HttpServletRequest req){
        List<Entrant> entrantList = entrantService.findAll();

        req.setAttribute("mode", "ALL_ENTRANTS");
        req.setAttribute("allEntrant", entrantList);

        return "admin_entrants";
    }

    @GetMapping("/update_entrant")
    public String update_entrant(@RequestParam int ent_id, HttpServletRequest req){
        req.setAttribute("mode", "UPDATE_ENTRANT");

        Optional<Entrant> entrant = entrantService.findById(ent_id);
        req.setAttribute("entrant", entrant.get());
        return "admin_entrants";
    }

    @PostMapping("/update_entrant")
    public String update_entrant(@RequestParam String firstName, @RequestParam String lastName,
                                 @RequestParam String phoneNumber, @RequestParam int entrantId, HttpServletRequest req){

        Entrant entrant = entrantService.findById(entrantId).get();
        entrant.setFirstName(firstName);
        entrant.setLastName(lastName);
        entrant.setPhoneNumber(phoneNumber);
        entrantService.save(entrant);

        return "redirect:admin_entrants";
    }

    @GetMapping("/update_requests")
    public String update_requests(@RequestParam int ent_id, HttpServletRequest req){
        req.setAttribute("mode", "UPDATE_ENTRANT_REQUESTS");
        List<RequestForEntry> requestList = requestForEntryService.getByEntrantId(ent_id);
        req.setAttribute("requests", requestList);
        entrantId = ent_id;
        return "admin_entrants";
    }

    @GetMapping("/delete_requests")
    public String delete_requests(@RequestParam int req_id, HttpServletRequest req){
        requestForEntryService.delete(req_id);

        return "redirect:update_requests?ent_id=" + entrantId;
    }

}
