package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Entities.Entrant;
import ua.lviv.SpringUniversity.Entities.Enums.EntrantsStatus;
import ua.lviv.SpringUniversity.Repositories.EntrantRepo;

import javax.transaction.Transactional;

@Service
public class EntrantService {

    private EntrantRepo entrantRepo;

    @Autowired
    public EntrantService(EntrantRepo entrantRepo) {
        this.entrantRepo = entrantRepo;
    }

    public void save(Entrant entrant) {
        entrant.setStatus(EntrantsStatus.REGISTERED);
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
}
