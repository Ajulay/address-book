package ru.bellintegrator.practice.model;



import ru.bellintegrator.practice.model.util.Country;
import ru.bellintegrator.practice.model.util.Doc;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

public class StatusUser {

    @Column(name="doc_number")
    private String docNumber;

    @Column(name="doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;

    @ManyToOne
    @JoinColumn(name="doc_id")
    private Doc doc;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
}
