package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Entities.RequestForEntry;
import ua.lviv.SpringUniversity.Repositories.RequestForEntryRepo;

import java.util.List;

@Service
public class RequestForEntryService {

    private RequestForEntryRepo requestForEntryRepo;

    @Autowired
    public RequestForEntryService(RequestForEntryRepo requestForEntryRepo) {
        this.requestForEntryRepo = requestForEntryRepo;
    }

    public void save(RequestForEntry r){
        requestForEntryRepo.save(r);
    }

    public List<Integer> getDepartmentsCodeByEntrantId(int entrantId){
        return requestForEntryRepo.getDepartmentsCodeByEntrantId(entrantId);
    }

    public List<RequestForEntry> getByEntrantId(int id){
        return requestForEntryRepo.getByEntrantId(id);
    }

    public void delete(int id){
        requestForEntryRepo.deleteById(id);
    }

    public List<RequestForEntry> getAll(){
        return (List<RequestForEntry>) requestForEntryRepo.findAll();
    }

    public List<RequestForEntry> getAllByRatingScore(){
        return requestForEntryRepo.getAllByRatingScore();
    }

    public int countStudentsInDep(int dep_id){
        return requestForEntryRepo.countStudentsInDep(dep_id);
    }

}
