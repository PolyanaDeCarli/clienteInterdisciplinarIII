/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.custos_variaveis;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.Transaction;

/**
 *
 * @author Larissa Cardoso
 */
public class custos_variaveisDao {

    private Session session;

    public custos_variaveisDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(custos_variaveis cv) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(cv);
        t.commit();
        session.close();
    }

    public void update(custos_variaveis cv) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(cv);
        t.commit();
        session.close();
    }

    public void delete(custos_variaveis cv) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(cv);
        t.commit();
        session.close();
    }

    public custos_variaveis findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        custos_variaveis cv = (custos_variaveis) session.get(custos_variaveis.class, id);
        session.close();
        return cv;
    }

    public List<custos_variaveis> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<custos_variaveis> ls = session.createQuery("from custos_variaveis").list();
        session.close();
        return ls;
    }

}
