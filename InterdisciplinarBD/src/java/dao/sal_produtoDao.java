/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.sal_produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class sal_produtoDao {

    private Session session;

    public sal_produtoDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public void insert(sal_produto spro) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(spro);
        t.commit();
        session.close();
    }

    public void update(sal_produto spro) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(spro);
        t.commit();
        session.close();
    }

    public void delete(sal_produto spro) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(spro);
        t.commit();
        session.close();
    }

    public sal_produto findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        sal_produto spro = (sal_produto) session.get(sal_produto.class, id);
        session.close();
        return spro;
    }

    public List<sal_produto> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<sal_produto> ls = session.createQuery("from sal_produtos spro ").list();
        session.close();
        return ls;
    }
}
