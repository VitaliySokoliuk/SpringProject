package ua.lviv.SpringUniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.SpringUniversity.Dtos.DepDescriptionDto;
import ua.lviv.SpringUniversity.Entities.Entrant;
import ua.lviv.SpringUniversity.Entities.RequestForEntry;
import ua.lviv.SpringUniversity.Services.DepartmentService;
import ua.lviv.SpringUniversity.Services.EntrantService;
import ua.lviv.SpringUniversity.Services.ForSecurity.CustomUserDetailsService;
import ua.lviv.SpringUniversity.Services.RequestForEntryService;
import ua.lviv.SpringUniversity.Services.TheDepartmentsOfTheFacultyService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class RequestController {

    private RequestForEntryService requestForEntryService;
    private TheDepartmentsOfTheFacultyService theDepartmentsOfTheFacultyService;
    private EntrantService entrantService;

    @Autowired
    public RequestController(RequestForEntryService requestForEntryService,
                             TheDepartmentsOfTheFacultyService theDepartmentsOfTheFacultyService,
                             EntrantService entrantService) {
        this.requestForEntryService = requestForEntryService;
        this.theDepartmentsOfTheFacultyService = theDepartmentsOfTheFacultyService;
        this.entrantService = entrantService;
    }

    @GetMapping("/request_for_entry")
    public String requestForEntry(HttpServletRequest req){
        String email = CustomUserDetailsService.getCurrentUserEmail();

        if(!entrantService.existByEmail(email)) {
            req.setAttribute("exist", false);
            return "request_for_entry";
        }
        req.setAttribute("exist", true);
        Entrant entrant = entrantService.getByEmail(email);

        req.setAttribute("entrantId", entrant.getEntrantId());
        List<DepDescriptionDto> depDescription = theDepartmentsOfTheFacultyService.getDepDescription();
        List<Integer> departmentsCodes = requestForEntryService.getDepartmentsCodeByEntrantId(entrant.getEntrantId());

//        Iterator<DepDescriptionDto> iterator = depDescription.iterator();
//        while (iterator.hasNext()){
//            for (Integer i : departmentsCodes) {
//                if()
//            }
//        }

        List<DepDescriptionDto> depDescription2 = new ArrayList<>();

        for (DepDescriptionDto d : depDescription) {
            for (Integer i : departmentsCodes) {
                if(d.getDepartmentsCode() == i){
                    depDescription2.add(d);
                }
            }
        }
        System.out.println(depDescription);
        System.out.println(depDescription2);
        depDescription.removeAll(depDescription2);
        System.out.println(depDescription);

        req.setAttribute("depDescription", depDescription);

        req.setAttribute("nonActive", depDescription2);


        return "request_for_entry";
    }

    @GetMapping("/add_req_for_entry")
    public String add_req_for_entry(@RequestParam int depCode, HttpServletRequest req){
        String email = CustomUserDetailsService.getCurrentUserEmail();
        Entrant entrant = entrantService.getByEmail(email);
        if(entrant.getRatingPoint() == 0.0){
            return "redirect:request_for_entry";
        }
        RequestForEntry requestForEntry = new RequestForEntry();
        requestForEntry.setDepartment(theDepartmentsOfTheFacultyService.findByDepCode(depCode).get());
        requestForEntry.setEntrant(entrant);
        requestForEntry.setRatingScore(entrant.getRatingPoint());
        requestForEntry.setRequestTime(new Date());

        requestForEntryService.save(requestForEntry);

        return "redirect:request_for_entry";
    }

}
