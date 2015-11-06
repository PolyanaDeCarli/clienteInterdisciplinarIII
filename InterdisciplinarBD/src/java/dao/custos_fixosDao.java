/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.custos_fixos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class custos_fixosDao {

    private Session session;

    public custos_fixosDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(custos_fixos cf) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(cf);
        t.commit();
        session.close();
    }

    public void update(custos_fixos cf) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(cf);
        t.commit();
        session.close();
    }

    public void delete(custos_fixos cf) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(cf);
        t.commit();
        session.close();
    }

    public custos_fixos findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        custos_fixos cf = (custos_fixos) session.get(custos_fixos.class, id);
        session.close();
        return cf;
    }

    public List<custos_fixos> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<custos_fixos> ls = session.createQuery("from custos_fixos").list();
        session.close();
        return ls;
    }
}
