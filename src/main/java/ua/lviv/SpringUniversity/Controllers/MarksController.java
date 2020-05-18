package ua.lviv.SpringUniversity.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.SpringUniversity.Entities.Entrant;
import ua.lviv.SpringUniversity.Entities.Enums.Subjects;
import ua.lviv.SpringUniversity.Entities.Mark;
import ua.lviv.SpringUniversity.Services.EntrantService;
import ua.lviv.SpringUniversity.Services.ForSecurity.CustomUserDetailsService;
import ua.lviv.SpringUniversity.Services.MarkService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MarksController {

    private MarkService markService;
    private EntrantService entrantService;

    @Autowired
    public MarksController(MarkService markService, EntrantService entrantService) {
        this.markService = markService;
        this.entrantService = entrantService;
    }

    @GetMapping("/add_marks")
    public String add_marks(HttpServletRequest req){

        String email = CustomUserDetailsService.getCurrentUserEmail();
        if(!entrantService.existByEmail(email)) {
            req.setAttribute("exist", false);
            return "mark";
        }
        req.setAttribute("exist", true);

        Entrant entrant = entrantService.getByEmail(email);

        List<Mark> marks = markService.getAllByEntrantId(entrant.getEntrantId());
        req.setAttribute("allMarks", marks);

        Subjects[] subjects = Subjects.values();
        ArrayList<Subjects> sub = new ArrayList<>(Arrays.asList(subjects));
        List<Subjects> subjectsById = markService.getSubjectsById(entrant.getEntrantId());
        sub.removeAll(subjectsById);

        req.setAttribute("subjects", sub);

        if(subjectsById.size() == 5){
            double bal = entrant.getScoreForSpecialAchievements() / 10;
            for (Mark m : marks) {
                bal += m.getScore();
            }
            bal /= 5;
            bal += (entrant.getGPAofCertificate() * 0.35);
            entrant.setRatingPoint(bal);
            entrantService.save(entrant);

            req.setAttribute("allow", false);
            return "mark";
        }
        req.setAttribute("allow", true);

        return "mark";
    }

    @PostMapping("/add_marks")
    public String add_marks(Subjects subject, double score, HttpServletRequest req){
        String email = CustomUserDetailsService.getCurrentUserEmail();
        Entrant entrant = entrantService.getByEmail(email);
//        Mark mark = new Mark(entrant, subject, score);
//        markService.save(mark);
        markService.save(entrant.getEntrantId(), subject, score);
        return "redirect:add_marks";

    }

}
