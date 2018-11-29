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


    public Boolean isActive;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +
                "\", \"orgId\": \"" + orgId +
                "\", \"name\": \"" + name.trim() +
                "\", \"address\": \"" + address.trim() +
                "\", \"phone\": \"" + phone +
                "\", \"isActive\": \"" + isActive +
                "\"}";
    }
}
