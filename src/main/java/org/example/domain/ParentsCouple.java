package org.example.domain;

import org.example.services.ParentsCoupleService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "parentsCouples")
@Entity
public class ParentsCouple {
    @Id
    @GeneratedValue
    public int id;
    public String dadFullname;
    public String momFullname;

    @OneToMany(mappedBy = "parentsCouple", cascade = CascadeType.ALL)
    public List<Child> children = new ArrayList<Child>();

    @ManyToOne
    @JoinColumn(name = "addressId")
    public Address address;

    public void save() {
        new ParentsCoupleService().saveParentsCouple(this);
    }

    public void update() {
        new ParentsCoupleService().updateParentsCouple(this);
    }
}