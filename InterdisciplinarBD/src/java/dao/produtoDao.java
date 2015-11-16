/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class produtoDao {

    private Session session;

    public produtoDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(produto pro) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(pro);
        t.commit();
        session.close();
    }

    public void update(produto pro) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(pro);
        t.commit();
        session.close();
    }

    public void delete(produto pro) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(pro);
        t.commit();
        session.close();
    }

    public produto findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        produto pro = (produto) session.get(produto.class, id);
        session.close();
        return pro;
    }

    public List<produto> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<produto> ls = session.createQuery("from produto p ").list();
      //  List<produto> ls = session.createQuery("from produto p ").list();
        session.close();
        return ls;
    }

}
