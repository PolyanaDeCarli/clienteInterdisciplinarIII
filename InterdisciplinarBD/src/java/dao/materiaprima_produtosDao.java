/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.materiaprima_produtos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class materiaprima_produtosDao {

    private Session session;

    public materiaprima_produtosDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(materiaprima_produtos mp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(mp);
        t.commit();
        session.close();
    }

    public void update(materiaprima_produtos mp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(mp);
        t.commit();
        session.close();
    }

    public void delete(materiaprima_produtos mp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(mp);
        t.commit();
        session.close();
    }

    public materiaprima_produtos findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        materiaprima_produtos mp = (materiaprima_produtos) session.get(materiaprima_produtos.class, id);
        session.close();
        return mp;
    }

    public List<materiaprima_produtos> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<materiaprima_produtos> ls = session.createQuery("from materiaprima_produtos mp ").list();
        session.close();
        return ls;
    }

}
