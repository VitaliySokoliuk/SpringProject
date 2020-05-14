package ua.lviv.SpringUniversity.Entities;

import ua.lviv.SpringUniversity.Entities.CompositsKeys.CompositKeyForMark;
import ua.lviv.SpringUniversity.Entities.Enums.Subjects;

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
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Subjects subject;
    @Column(nullable = false)
    private double score;

    public Mark(Entrant entrant, Subjects subject, double score) {
        this.entrant = entrant;
        this.subject = subject;
        this.score = score;
    }

    public Mark() {
    }

    public Entrant getEntrant() {
        return entrant;
    }

    public void setEntrant(Entrant entrant) {
        this.entrant = entrant;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "entrant=" + entrant +
                ", subject=" + subject +
                ", score=" + score +
                '}';
    }

}
