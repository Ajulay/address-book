package ru.bellintegrator.practice.view;

import javax.validation.constraints.NotEmpty;

public class UserView {
    @NotEmpty
    public long id;
    @NotEmpty
    public long officeId;

    @NotEmpty
    public String firstName;

    public String secondName;

    public String middleName;

    @NotEmpty
    public String position;

    public String phone;

    public String docName;

    public String docNumber;

    public String docDate;

    public String docCode;

    public String citizenshipName;

    public String citizenshipCode;

    public Boolean isIdentified;
}
