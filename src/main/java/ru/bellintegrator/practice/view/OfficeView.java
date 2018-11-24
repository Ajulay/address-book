package ru.bellintegrator.practice.view;

import ru.bellintegrator.practice.model.Organization;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

public class OfficeView {

    @NotEmpty
    public long id;

    @NotEmpty
    public long orgId;

    @NotEmpty
    public String name;

    @NotEmpty
    public String address;


    public String phone;


    public Boolean active;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +
                "\", \"orgId\": \"" + orgId +
                "\", \"name\": \"" + name +
                "\", \"address\": \"" + address +
                "\", \"phone\": \"" + phone +
                "\", \"isActive\": \"" + active +
                "\"}";
    }
}
