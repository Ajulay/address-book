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

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
