package ua.lviv.SpringUniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.SpringUniversity.Entities.Department;
import ua.lviv.SpringUniversity.Entities.Faculty;
import ua.lviv.SpringUniversity.Entities.TheDepartmentsOfTheFaculty;
import ua.lviv.SpringUniversity.Services.DepartmentService;
import ua.lviv.SpringUniversity.Services.FacultyService;
import ua.lviv.SpringUniversity.Services.TheDepartmentsOfTheFacultyService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin_page")
public class F_D_MenuController {

    public DepartmentService departmentService;
    public FacultyService facultyService;
    public TheDepartmentsOfTheFacultyService theDepartmentsOfTheFacultyService;
    public static int facultyId;

    @Autowired
    public F_D_MenuController(DepartmentService departmentService,
                              FacultyService facultyService,
                              TheDepartmentsOfTheFacultyService theDepartmentsOfTheFacultyService) {
        this.departmentService = departmentService;
        this.facultyService = facultyService;
        this.theDepartmentsOfTheFacultyService = theDepartmentsOfTheFacultyService;
    }

    @GetMapping("/f_d_menu")
    public String f_d_menu(HttpServletRequest req){
        req.setAttribute("mode", "ADMIN_CHOOSE");
        return "f_d_menu";
    }

    @GetMapping("/add_f")
    public String add_f(HttpServletRequest req){
        req.setAttribute("mode", "ADD_FACULTY");
        req.setAttribute("faculties", facultyService.selectAll());
        return "f_d_menu";
    }

    @PostMapping("/add_f")
    public String add_faculty(@RequestParam String name, @RequestParam String description, HttpServletRequest req){
        Faculty f = new Faculty(name, description);
        facultyService.save(f);
        return "redirect:add_f";
    }

    @GetMapping("/fac_delete")
    public String fac_delete(@RequestParam int id, HttpServletRequest req) {
        if(facultyService.existById(id)){
            facultyService.delete(id);
        }
        return "redirect:add_f";
    }

    @GetMapping("/fac_update")
    public String fac_update(@RequestParam int id, HttpServletRequest req) {
        Optional<Faculty> findedById = facultyService.findById(id);
        if(findedById.isPresent()){
            req.setAttribute("fac", findedById.get());
            req.setAttribute("mode", "UPDATE_FACULTY");
            req.setAttribute("used_dep", departmentService.usedDepartments(id));
            facultyId = id;
            return "f_d_menu";
        }else
            return "redirect:admin_page";
    }

    @PostMapping("/fac_update")
    public String fac_update(@RequestParam int id, @RequestParam String name, @RequestParam String description, HttpServletRequest req) {
        Optional<Faculty> findedById = facultyService.findById(id);
        if(findedById.isPresent()){
            Faculty fac = findedById.get();
            fac.setFacultyName(name);
            fac.setDescription(description);
            facultyService.save(fac);
        }
        return "redirect:add_f";
    }

    @GetMapping("del_dep_from_fac")
    public String del_dep_from_fac(@RequestParam int dep_id, HttpServletRequest req){
        theDepartmentsOfTheFacultyService.deleteByDepartmentIdAndFacultyId(dep_id, facultyId);
        return "redirect:fac_update?id=" + facultyId;
    }

    @GetMapping("/fac_add_dep")
    public String fac_add_dep(@RequestParam int id, HttpServletRequest req){
        req.setAttribute("mode", "ADD_DEPARTMENT_TO_FACULTY");
        List<Department> freeDepartments = departmentService.freeDepForFaculty(id);
        req.setAttribute("freeDepartments", freeDepartments);
        facultyId = id;
        return "f_d_menu";
    }

    @GetMapping("/add_dep_to_fac")
    public String add_dep_to_fac(@RequestParam int dep_id, HttpServletRequest req){
        Optional<Faculty> f = facultyService.findById(facultyId);
        Optional<Department> d = departmentService.findById(dep_id);
        if(d.isPresent() && f.isPresent()) {
            TheDepartmentsOfTheFaculty theFaculty = new TheDepartmentsOfTheFaculty(d.get(), f.get());
            theDepartmentsOfTheFacultyService.save(theFaculty);
        }
        return "redirect:fac_add_dep?id=" + facultyId;
    }


    @GetMapping("/add_d")
    public String add_d(HttpServletRequest req){
        req.setAttribute("mode", "ADD_DEPARTMENT");
        req.setAttribute("departments", departmentService.selectAll());
        return "f_d_menu";
    }

    @PostMapping("/add_d")
    public String add_dep(@RequestParam String name, @RequestParam int number, HttpServletRequest req){
        Department dep = new Department(name, number);
        departmentService.save(dep);
        return "redirect:add_d";
    }

    @GetMapping("/dep_update")
    public String update(@RequestParam int id, HttpServletRequest req) {
        Optional<Department> findedById = departmentService.findById(id);
        if(findedById.isPresent()){
            req.setAttribute("dep", findedById.get());
            req.setAttribute("mode", "UPDATE_DEPARTMENT");
            return "f_d_menu";
        }else
            return "redirect:admin_page";
    }

    @PostMapping("/dep_update")
    public String postUpdate(@RequestParam int id, @RequestParam String name, @RequestParam int number, HttpServletRequest req) {
        Optional<Department> findedById = departmentService.findById(id);
        if(findedById.isPresent()){
            Department dep = findedById.get();
            dep.setDepartmentName(name);
            dep.setMaxNumberOfStudents(number);
            departmentService.save(dep);
        }
        return "redirect:add_d";
    }

    @GetMapping("/dep_delete")
    public String delete(@RequestParam int id, HttpServletRequest req) {
        if(departmentService.existById(id)){
            departmentService.delete(id);
        }
        return "redirect:add_d";
    }

    @GetMapping("/dep_stat")
    public String dep_stat(@RequestParam int id, HttpServletRequest req) {
        List<Integer> facOnDep = theDepartmentsOfTheFacultyService.getFacOnDep(id);
        List<Faculty> facultyList = new ArrayList<>();
        for (Integer f : facOnDep) {
            facultyList.add(facultyService.findById(f).get());
        }
        req.setAttribute("facList", facultyList);
        req.setAttribute("mode", "STATISTICS_DEPARTMENT");
        return "f_d_menu";
    }

}
