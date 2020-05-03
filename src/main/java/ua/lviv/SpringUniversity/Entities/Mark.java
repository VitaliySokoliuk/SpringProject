package ua.lviv.SpringUniversity.Entities;

import ua.lviv.SpringUniversity.Entities.CompositsKeys.CompositKeyForMark;

import javax.persistence.*;

@Entity
@Table(name = "mark")
@IdClass(value = CompositKeyForMark.class)
public class Mark {

    @Id
    @ManyToOne
    @JoinColumn(name = "entrant_id")
    private Entrant entrant;
    @Id
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Column(nullable = false)
    private double score;

}
