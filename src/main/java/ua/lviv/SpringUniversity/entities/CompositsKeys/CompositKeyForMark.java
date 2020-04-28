package ua.lviv.SpringUniversity.entities.CompositsKeys;

import ua.lviv.SpringUniversity.entities.Entrant;
import ua.lviv.SpringUniversity.entities.Subject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompositKeyForMark implements Serializable {

    private Entrant entrant;
    private Subject subject;

}
