/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.maquinas_produtos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class maquinas_produtosDao {

    private Session session;

    public maquinas_produtosDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(maquinas_produtos mqp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(mqp);
        t.commit();
        session.close();
    }

    public void update(maquinas_produtos mqp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(mqp);
        t.commit();
        session.close();
    }

    public void delete(maquinas_produtos mqp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(mqp);
        t.commit();
        session.close();
    }

    public maquinas_produtos findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        maquinas_produtos mqp = (maquinas_produtos) session.get(maquinas_produtos.class, id);
        session.close();
        return mqp;
    }

    public List<maquinas_produtos> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<maquinas_produtos> ls = session.createQuery("from maquinas_produtos mqp ").list();
        session.close();
        return ls;
    }

}
