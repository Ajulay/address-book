package ru.bellintegrator.practice.model;



import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.Instant;
import java.util.Date;

public class StatePaper {
    @Column(name = "doc_code")
    private String docCode;

    @Column(name = "doc_name")
    private String docName;

    @Column(name="doc_number")
    private String docNumber;

    @Column(name="doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;

    @Column(name = "citizenship_code")
    private String citizenshipCode;
}
