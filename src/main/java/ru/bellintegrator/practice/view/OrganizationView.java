package ru.bellintegrator.practice.view;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class OrganizationView {

    @NotEmpty
    public long id;

    @NotEmpty(message = "name cannot be null")
    public String name;  //обязательный параметр

    @NotEmpty(message = "fullname cannot be null")
    public String fullName; //обязательный параметр

    @NotEmpty(message = "inn cannot be null")
    public String inn; //обязательный параметр

    @NotEmpty(message = "kpp cannot be null")
    public String kpp; //обязательный параметр

    @NotEmpty(message = "address cannot be null")
    public String address; //обязательный параметр

    public String phone;

    public Boolean active;



    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id +
                "\"; \"name\": \"" + name.trim()+
                "\"; \"fullName\": \"" + fullName.trim() +
                "\"; \"inn\": \"" + inn.trim() +
                "\"; \"kpp\": \"" + kpp.trim() +
                "\"; \"address\": \"" + address.trim() +
                "\"; \"phone: \"" + (phone == null ? "" : phone.trim()) +
                "\"; \"isActive: \"" + active +
                "\"}";
    }

}
