package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Repositories.MarkRepo;

@Service
public class MarkService {

    private MarkRepo markRepo;

    @Autowired
    public MarkService(MarkRepo markRepo) {
        this.markRepo = markRepo;
    }
}
