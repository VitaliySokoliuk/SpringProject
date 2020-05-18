package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Entities.Students;
import ua.lviv.SpringUniversity.Repositories.StudentsRepo;

import java.util.List;

@Service
public class StudentsService {

    private StudentsRepo studentsRepo;

    @Autowired
    public StudentsService(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    public void save(Students s){
        studentsRepo.save(s);
    }

    public List<Students> getAll(){
        return (List<Students>) studentsRepo.findAll();
    }

}
