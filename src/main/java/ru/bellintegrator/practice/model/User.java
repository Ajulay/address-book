package ru.bellintegrator.practice.model;



import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(nullable = false)
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
    private StatePaper statePaper;

    @Column(name="identified")
    private boolean isIdentified; //пример

}
