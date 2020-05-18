package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.SpringUniversity.Entities.Enums.Subjects;
import ua.lviv.SpringUniversity.Entities.Mark;
import ua.lviv.SpringUniversity.Repositories.MarkRepo;

import java.util.List;

@Service
public class MarkService {

    private MarkRepo markRepo;

    @Autowired
    public MarkService(MarkRepo markRepo) {
        this.markRepo = markRepo;
    }

//    public void save(Mark mark) {
//        markRepo.save(mark);
//    }

    @Transactional
    public void save(int id, Subjects subject, double score) {
        markRepo.save(id, subject.toString(), score);
    }

    public List<Subjects> getSubjectsById(int id){
        return markRepo.getSubjectsById(id);
    }

    public List<Mark> getAllByEntrantId(int id){
        return markRepo.getAllByEntrantId(id);
    }


}
