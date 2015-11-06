/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.pessoas;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class pessoasDao {

    private Session session;

    public pessoasDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(pessoas p) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(p);
        t.commit();
        session.close();
    }

    public void update(pessoas p) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(p);
        t.commit();
        session.close();
    }

    public void delete(pessoas p) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(p);
        t.commit();
        session.close();
    }

    public pessoas findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        pessoas p = (pessoas) session.get(pessoas.class, id);
        session.close();
        return p;
    }

    public List<pessoas> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<pessoas> ls = session.createQuery("from pessoas").list();
        session.close();
        return ls;
    }

}
