/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.cidades;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Larissa Cardoso
 */
public class cidadesDao {

    private Session session;

    public cidadesDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    public cidades findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        cidades c = (cidades) session.get(cidades.class, id);
        session.close();
        return c;
    }

    public List<cidades> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<cidades> ls = session.createQuery("from cidades").list();
        session.close();
        return ls;
    }

}
