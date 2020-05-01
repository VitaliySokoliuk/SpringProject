package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Repositories.EntrantRepo;

@Service
public class EntrantService {

    private EntrantRepo entrantRepo;

    @Autowired
    public EntrantService(EntrantRepo entrantRepo) {
        this.entrantRepo = entrantRepo;
    }
}
