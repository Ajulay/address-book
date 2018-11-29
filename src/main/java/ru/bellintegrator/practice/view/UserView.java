package ru.bellintegrator.practice.view;

import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.StatusUser;
import ru.bellintegrator.practice.model.util.Country;
import ru.bellintegrator.practice.model.util.Doc;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

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
