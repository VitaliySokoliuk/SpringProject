package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.SpringUniversity.Dtos.DepDescriptionDto;
import ua.lviv.SpringUniversity.Entities.TheDepartmentsOfTheFaculty;
import ua.lviv.SpringUniversity.Repositories.TheDepartmentsOfTheFacultyRepo;

import java.util.List;
import java.util.Optional;

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

    public List<DepDescriptionDto> getDepDescription(){
        return theDepartmentsOfTheFacultyRepo.getDepDescription();
    }

    public Optional<TheDepartmentsOfTheFaculty> findByDepCode(int departmentCode){
        return theDepartmentsOfTheFacultyRepo.findById(departmentCode);
    }


}
