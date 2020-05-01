package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Repositories.StudentsRepo;

@Service
public class StudentsService {

    private StudentsRepo studentsRepo;

    @Autowired
    public StudentsService(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }
}
