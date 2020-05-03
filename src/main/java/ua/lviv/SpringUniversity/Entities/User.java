package ua.lviv.SpringUniversity.Entities;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.lviv.SpringUniversity.Entities.Enums.UsersRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UsersRole role;
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    public User(int userId, String firstName, String lastName, UsersRole role, Date registrationDate,
                String email, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.registrationDate = registrationDate;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public UsersRole getRole() {
        return role;
    }

    public void setRole(UsersRole role) {
        this.role = role;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
