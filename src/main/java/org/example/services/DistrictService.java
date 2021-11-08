package org.example.services;

import org.example.domain.Address;
import org.example.domain.District;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DistrictService {
    public void saveDistrict(District district) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(district);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<District> getDistricts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from District", District.class).list();
        }
    }
}