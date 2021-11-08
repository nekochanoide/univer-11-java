package org.example.services;

import org.example.domain.Child;
import org.example.domain.EducationalEstablishment;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EducationalEstablishmentService {
    public void saveEducationalEstablishment(EducationalEstablishment educationalEstablishment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(educationalEstablishment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<EducationalEstablishment> getEducationalEstablishments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from EducationalEstablishment", EducationalEstablishment.class).list();
        }
    }

    public EducationalEstablishment getById(int id) {
        return this.getEducationalEstablishments().stream().filter(x -> x.id == id).findFirst().get();
    }
}