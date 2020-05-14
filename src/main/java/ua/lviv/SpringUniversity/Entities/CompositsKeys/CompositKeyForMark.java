package ua.lviv.SpringUniversity.Entities.CompositsKeys;

import ua.lviv.SpringUniversity.Entities.Entrant;
import ua.lviv.SpringUniversity.Entities.Enums.Subjects;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompositKeyForMark implements Serializable {

    private Entrant entrant;
    private Subjects subject;

}
