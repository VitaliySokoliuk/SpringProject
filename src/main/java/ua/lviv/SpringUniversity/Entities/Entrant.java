package ua.lviv.SpringUniversity.Entities;

import ua.lviv.SpringUniversity.Entities.Enums.EntrantsStatus;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "entrant")
public class Entrant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrant_id")
    private int entrantId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(unique = true, nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntrantsStatus status;
    @Column(name = "rating_point")
    private double ratingPoint;
    @Column(name = "score_for_special_achievements", nullable = false)
    private double scoreForSpecialAchievements;
    @Column(name = "GPA_of_certificate", nullable = false)
    private double GPAofCertificate;
    @Lob
    private byte[] photo;

    public Entrant() {
    }

    public Entrant(int entrantId, String firstName, String lastName, String phoneNumber, String email,
                   EntrantsStatus status, double ratingPoint, double scoreForSpecialAchievements, double GPAofCertificate) {
        this.entrantId = entrantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.ratingPoint = ratingPoint;
        this.scoreForSpecialAchievements = scoreForSpecialAchievements;
        this.GPAofCertificate = GPAofCertificate;
    }

    public Entrant(int entrantId, String firstName, String lastName, String phoneNumber, String email,
                   EntrantsStatus status, double ratingPoint, double scoreForSpecialAchievements,
                   double GPAofCertificate, byte[] photo) {
        this.entrantId = entrantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.ratingPoint = ratingPoint;
        this.scoreForSpecialAchievements = scoreForSpecialAchievements;
        this.GPAofCertificate = GPAofCertificate;
        this.photo = photo;
    }

    public Entrant(String firstName, String lastName, String phoneNumber, String email,
                   double scoreForSpecialAchievements, double GPAofCertificate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.scoreForSpecialAchievements = scoreForSpecialAchievements;
        this.GPAofCertificate = GPAofCertificate;
    }

    public Entrant(String firstName, String lastName, String phoneNumber, String email,
                   double scoreForSpecialAchievements, double GPAofCertificate, byte[] photo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.scoreForSpecialAchievements = scoreForSpecialAchievements;
        this.GPAofCertificate = GPAofCertificate;
        this.photo = photo;
    }

    public int getEntrantId() {
        return entrantId;
    }

    public void setEntrantId(int entrantId) {
        this.entrantId = entrantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EntrantsStatus getStatus() {
        return status;
    }

    public void setStatus(EntrantsStatus status) {
        this.status = status;
    }

    public double getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(double ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public double getScoreForSpecialAchievements() {
        return scoreForSpecialAchievements;
    }

    public void setScoreForSpecialAchievements(double scoreForSpecialAchievements) {
        this.scoreForSpecialAchievements = scoreForSpecialAchievements;
    }

    public double getGPAofCertificate() {
        return GPAofCertificate;
    }

    public void setGPAofCertificate(double GPAofCertificate) {
        this.GPAofCertificate = GPAofCertificate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Entrant{" +
                "entrantId=" + entrantId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", ratingPoint=" + ratingPoint +
                ", scoreForSpecialAchievements=" + scoreForSpecialAchievements +
                ", GPAofCertificate=" + GPAofCertificate +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
