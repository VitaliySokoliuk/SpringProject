package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Entities.Department;
import ua.lviv.SpringUniversity.Repositories.DepartmentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<Department> selectAll(){
        return (List<Department>) departmentRepo.findAll();
    }

    public Optional<Department> findById(int id) {
        return departmentRepo.findById(id);
    }

    public boolean existById(int id){
        return departmentRepo.existsById(id);
    }

    public void save(Department dep) {
        departmentRepo.save(dep);
    }

    public void delete(int id) {
        departmentRepo.deleteById(id);
    }

    public List<Department> freeDepForFaculty(int id){
        List<Department> list = (List<Department>) departmentRepo.findAll();
        List<Department> list2 = departmentRepo.usedDepartments(id);
        list.removeAll(list2);
        return list;
    }

    public List<Department> usedDepartments(int id){
        return departmentRepo.usedDepartments(id);
    }

}
