/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.salarios;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class salariosDao {

    private Session session;

    public salariosDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(salarios s) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(s);
        t.commit();
        session.close();
    }

    public void update(salarios s) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(s);
        t.commit();
        session.close();
    }

    public void delete(salarios s) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(s);
        t.commit();
        session.close();
    }

    public salarios findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        salarios s = (salarios) session.get(salarios.class, id);
        session.close();
        return s;
    }

    public List<salarios> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<salarios> ls = session.createQuery("from salarios").list();
        session.close();
        return ls;
    }

}
