package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Repositories.TheDepartmentsOfTheFacultyRepo;

@Service
public class TheDepartmentsOfTheFacultyService {

    private TheDepartmentsOfTheFacultyRepo theDepartmentsOfTheFacultyRepo;

    @Autowired
    public TheDepartmentsOfTheFacultyService(TheDepartmentsOfTheFacultyRepo theDepartmentsOfTheFacultyRepo) {
        this.theDepartmentsOfTheFacultyRepo = theDepartmentsOfTheFacultyRepo;
    }
}
