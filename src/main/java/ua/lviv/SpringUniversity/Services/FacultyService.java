package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Entities.Faculty;
import ua.lviv.SpringUniversity.Repositories.FacultyRepo;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    private FacultyRepo facultyRepo;

    @Autowired
    public FacultyService(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }


    public List<Faculty> selectAll() {
        return (List<Faculty>) facultyRepo.findAll();
    }

    public void save(Faculty f) {
        facultyRepo.save(f);
    }

    public boolean existById(int id) {
        return facultyRepo.existsById(id);
    }

    public void delete(int id) {
        facultyRepo.deleteById(id);
    }

    public Optional<Faculty> findById(int id) {
        return facultyRepo.findById(id);
    }
}
