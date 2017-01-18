/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Albin
 */
public class SnowHelper {

    Session session = null;

    public SnowHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getSnowboards() {
        List<Snowboard> snowboardList = null;
        
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Snowboard");
            snowboardList = (List<Snowboard>) q.list();
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return snowboardList;
    }
}
