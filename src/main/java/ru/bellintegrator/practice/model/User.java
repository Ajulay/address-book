package ru.bellintegrator.practice.model;



import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Office officeId;

    @Column(name="first_name", nullable = false)
    private String firstName; //обязательный параметр

    @Column(name = "second_name")
    private String secondName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name = "pozition", nullable = false)
    private String position; //обязательный параметр

    @Column
    private String phone;

    @Embedded
    private StatusUser statusUser;

    @Column(name="identified")
    private boolean isIdentified; //пример

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Office getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Office officeId) {
        this.officeId = officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StatusUser getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(StatusUser statusUser) {
        this.statusUser = statusUser;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }
}
