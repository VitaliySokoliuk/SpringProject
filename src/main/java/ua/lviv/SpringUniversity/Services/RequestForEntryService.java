package ua.lviv.SpringUniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringUniversity.Repositories.RequestForEntryRepo;

@Service
public class RequestForEntryService {

    private RequestForEntryRepo requestForEntryRepo;

    @Autowired
    public RequestForEntryService(RequestForEntryRepo requestForEntryRepo) {
        this.requestForEntryRepo = requestForEntryRepo;
    }
}
