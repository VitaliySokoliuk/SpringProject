package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Entities.Entrant;
import ua.lviv.SpringUniversity.Repositories.EntrantRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EntrantService {

    private EntrantRepo entrantRepo;

    @Autowired
    public EntrantService(EntrantRepo entrantRepo) {
        this.entrantRepo = entrantRepo;
    }

    public void save(Entrant entrant) {
        entrantRepo.save(entrant);
    }

    public boolean existByEmail(String email) {
        return entrantRepo.existsByEmail(email);
    }


    public Entrant getByEmail(String email) {
        return entrantRepo.getByEmail(email);
    }

    @Transactional
    public byte[] getPhoto(int id){
        return entrantRepo.getPhoto(id);
    }

    public List<Entrant> findAll(){
        return (List<Entrant>) entrantRepo.findAll();
    }


    public Optional<Entrant> findById(int ent_id) {
        return entrantRepo.findById(ent_id);
    }
}
