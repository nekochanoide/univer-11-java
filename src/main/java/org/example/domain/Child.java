package org.example.domain;

import org.example.services.ChildService;

import javax.persistence.*;

@Table(name = "children")
@Entity
public class Child {
    @Id
    @GeneratedValue
    public int id;

    @ManyToOne
    @JoinColumn(name = "parentsCoupleId")
    public ParentsCouple parentsCouple;

    public String fullname;

    public Child() {
    }

    public Child(String fullname, ParentsCouple parentsCouple, int age) {
        this.fullname = fullname;
        this.parentsCouple = parentsCouple;
        this.age = age;
    }

    public int age;

    @ManyToOne
    @JoinColumn(name = "educationalEstablishmentId")
    public EducationalEstablishment educationalEstablishment;

    public void save() {
        new ChildService().saveChild(this);
    }

    public void update() {
        new ChildService().updateChild(this);
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public ParentsCouple getParentsCouple() {
//        return parentsCouple;
//    }
//
//    public void setParentsCouple(ParentsCouple parentsCouple) {
//        this.parentsCouple = parentsCouple;
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public void setFullname(String fullname) {
//        this.fullname = fullname;
//    }
}