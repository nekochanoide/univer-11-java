package org.example.domain;

import org.example.services.DistrictService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "districts")
@Entity
public class District {
    @Id
    @GeneratedValue
    public int id;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    public List<Address> addresses = new ArrayList<Address>();

    public void Save() {
        new DistrictService().saveDistrict(this);
    }
}
