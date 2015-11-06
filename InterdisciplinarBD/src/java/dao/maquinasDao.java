/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.maquinas;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class maquinasDao {

    private Session session;

    public maquinasDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(maquinas m) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(m);
        t.commit();
        session.close();
    }

    public void update(maquinas m) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(m);
        t.commit();
        session.close();
    }

    public void delete(maquinas m) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(m);
        t.commit();
        session.close();
    }

    public maquinas findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        maquinas m = (maquinas) session.get(maquinas.class, id);
        session.close();
        return m;
    }

    public List<maquinas> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<maquinas> ls = session.createQuery("from maquinas").list();
        session.close();
        return ls;
    }

}
