/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.cargos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class cargosDao {

    private Session session;

    public cargosDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(cargos c) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
        session.close();
    }

    public void update(cargos c) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(c);
        t.commit();
        session.close();
    }

    public void delete(cargos c) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(c);
        t.commit();
        session.close();
    }

    public cargos findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        cargos c = (cargos) session.get(cargos.class, id);
        session.close();
        return c;
    }

    public List<cargos> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<cargos> ls = session.createQuery("from cargos order by car_codigo").list();
        session.close();
        return ls;
    }
}
