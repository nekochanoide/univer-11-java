package org.example.domain;

import org.example.services.AddressService;

import javax.persistence.*;

@Table(name = "addresses")
@Entity
public class Address {
    @Id
    @GeneratedValue
    public int id;

    @ManyToOne
    @JoinColumn(name = "districtId")
    public District district;

    public Address() {
    }

    public Address(String value) {
        this.value = value;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String value;

    public void Save() {
        new AddressService().saveAddress(this);
    }

//    public String getValue() {
//        return _value;
//    }
//
//    public void setValue(String value) {
//        _value = value;
//    }
}
