package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkService {

    private MarkService markService;

    @Autowired
    public MarkService(MarkService markService) {
        this.markService = markService;
    }
}
