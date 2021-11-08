package org.example.services;

import java.util.List;

import org.example.domain.ParentsCouple;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParentsCoupleService {
    public void saveParentsCouple(ParentsCouple parentsCouple) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(parentsCouple);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void updateParentsCouple(ParentsCouple parentsCouple) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(parentsCouple);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<ParentsCouple> getParentsCouples() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ParentsCouple", ParentsCouple.class).list();
        }
    }

    public ParentsCouple getById(int id) {
        return this.getParentsCouples().stream().filter(x -> x.id == id).findFirst().get();
    }
}