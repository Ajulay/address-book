package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity
@Table(name="organization")
public class Organization {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;  //обязательный параметр

    @Column(name = "fullname", nullable = false)
    private String fullName; //обязательный параметр

    @Column(nullable = false)
    private String inn; //обязательный параметр

    @Column(nullable = false)
    private String kpp; //обязательный параметр

    @Column(nullable = false)
    private String address; //обязательный параметр

    @Column
    private String phone;

    @Column
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullname) {
        this.fullName = fullname;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
