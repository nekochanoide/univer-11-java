package org.example.domain;

import org.example.services.EducationalEstablishmentService;

import javax.persistence.*;

@Table(name = "educationalEstablishments")
@Entity
public class EducationalEstablishment {
    @Id
    @GeneratedValue
    public int id;

    public EducationalEstablishment() {
    }

    public EducationalEstablishment(String number, Address address) {
        this.number = number;
        this.address = address;
    }

    public String number;

    @ManyToOne
    @JoinColumn(name = "addressId")
    public Address address;

    public void Save() {
        new EducationalEstablishmentService().saveEducationalEstablishment(this);
    }
}
