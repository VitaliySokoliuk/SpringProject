package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.SpringUniversity.Entities.TheDepartmentsOfTheFaculty;
import ua.lviv.SpringUniversity.Repositories.TheDepartmentsOfTheFacultyRepo;

import java.util.List;

@Service
public class TheDepartmentsOfTheFacultyService {

    private TheDepartmentsOfTheFacultyRepo theDepartmentsOfTheFacultyRepo;

    @Autowired
    public TheDepartmentsOfTheFacultyService(TheDepartmentsOfTheFacultyRepo theDepartmentsOfTheFacultyRepo) {
        this.theDepartmentsOfTheFacultyRepo = theDepartmentsOfTheFacultyRepo;
    }

    public void save(TheDepartmentsOfTheFaculty theFaculty) {
        theDepartmentsOfTheFacultyRepo.save(theFaculty);
    }

    public List<Integer> getFacOnDep(int id){
        return theDepartmentsOfTheFacultyRepo.getFacOnDep(id);
    }

    @Transactional
    public void deleteByDepartmentIdAndFacultyId(int d_id, int f_id){
        theDepartmentsOfTheFacultyRepo.deleteByDepartmentIdAndFacultyId(d_id, f_id);
    }

}
