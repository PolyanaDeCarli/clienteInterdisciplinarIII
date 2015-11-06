/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.materia_prima;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class materia_primaDao {

    private Session session;

    public materia_primaDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(materia_prima mp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(mp);
        t.commit();
        session.close();
    }

    public void update(materia_prima mp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(mp);
        t.commit();
        session.close();
    }

    public void delete(materia_prima mp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(mp);
        t.commit();
        session.close();
    }

    public materia_prima findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        materia_prima mp = (materia_prima) session.get(materia_prima.class, id);
        session.close();
        return mp;
    }

    public List<materia_prima> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<materia_prima> ls = session.createQuery("from materia_prima").list();
        session.close();
        return ls;
    }

}
