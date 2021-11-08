package org.example.services;

import org.example.domain.Child;
import org.example.domain.ParentsCouple;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ChildService {
    public void saveChild(Child child) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(child);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateChild(Child child) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(child);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Child> getChildren() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Child", Child.class).list();
        }
    }

    public Child getById(int id) {
        return this.getChildren().stream().filter(x -> x.id == id).findFirst().get();
    }
}
