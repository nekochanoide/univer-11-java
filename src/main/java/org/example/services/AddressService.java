package org.example.services;

import org.example.domain.Address;
import org.example.domain.ParentsCouple;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressService {
    public void saveAddress(Address address) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Address> getAddresss() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Address", Address.class).list();
        }
    }

    public Address getById(int id) {
        return this.getAddresss().stream().filter(x -> x.id == id).findFirst().get();
    }
}