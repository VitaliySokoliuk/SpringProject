package ua.lviv.SpringUniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.SpringUniversity.Entities.Entrant;
import ua.lviv.SpringUniversity.Entities.Enums.EntrantsStatus;
import ua.lviv.SpringUniversity.Entities.RequestForEntry;
import ua.lviv.SpringUniversity.Entities.Students;
import ua.lviv.SpringUniversity.Services.EntrantService;
import ua.lviv.SpringUniversity.Services.RequestForEntryService;
import ua.lviv.SpringUniversity.Services.StudentsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin_page")
public class FinishEntryController {

    private RequestForEntryService requestForEntryService;
    private StudentsService studentsService;
    private EntrantService entrantService;

    @Autowired
    public FinishEntryController(RequestForEntryService requestForEntryService,
                                 StudentsService studentsService,
                                 EntrantService entrantService) {
        this.requestForEntryService = requestForEntryService;
        this.studentsService = studentsService;
        this.entrantService = entrantService;
    }

    @GetMapping("/finish_entry")
    public String finish_entry(HttpServletRequest req){

        req.setAttribute("students", studentsService.getAll());

        return "finish_entry";
    }

    @GetMapping("/finish")
    public String finish(HttpServletRequest req){

        calculate();

        return "redirect:finish_entry";
    }

    public void calculate(){
        List<RequestForEntry> allByRatingScore = requestForEntryService.getAllByRatingScore();

        while (!allByRatingScore.isEmpty()){
            int id = allByRatingScore.get(0).getEntrant().getEntrantId();
            Entrant entrant = allByRatingScore.get(0).getEntrant();
            List<RequestForEntry> entrantRequests = requestForEntryService.getByEntrantId(id);

            int counter = 0;
            for(int i = 0; i < entrantRequests.size(); i++){
                int departmentId = entrantRequests.get(i).getDepartment().getDepartment().getDepartmentId();
                int countStudentsInDep = requestForEntryService.countStudentsInDep(departmentId);
                int maxNumberOfStudents = entrantRequests.get(i).getDepartment().getDepartment().getMaxNumberOfStudents();

                if(countStudentsInDep < maxNumberOfStudents){
                    Students s = new Students(entrantRequests.get(i));
                    studentsService.save(s);
                    allByRatingScore = deleteById(allByRatingScore, id);
                    entrant.setStatus(EntrantsStatus.ACCEPTED);
                    entrantService.save(entrant);
                    break;
                }
                counter++;
            }
            if(counter == entrantRequests.size()){
                entrant.setStatus(EntrantsStatus.CANCELED);
                entrantService.save(entrant);
                allByRatingScore = deleteById(allByRatingScore, id);
            }

        }
    }

    public List<RequestForEntry> deleteById(List<RequestForEntry> list, int entrantId){
        List<RequestForEntry> entryList = list.stream().filter(x -> x.getEntrant().getEntrantId() != entrantId)
                .collect(Collectors.toList());
        return entryList;
    }

}
