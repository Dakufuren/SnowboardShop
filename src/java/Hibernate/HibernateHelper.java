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
public class HibernateHelper {

    Session session = null;

    public HibernateHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        //this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getSnowboards() {
        List<Snowboard> snowboardList = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();    
            Query q = session.createQuery("from Snowboard");
            snowboardList = (List<Snowboard>) q.list();
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return snowboardList;
    }
    
    public Boolean isUserMatched(String email, String pass) {
        Transaction tx = null;
        List<Account> accountList = null;
        Boolean loginMatched = false;

        try {
            tx = session.beginTransaction();    
            Query q = session.createQuery("SELECT * FROM `account` WHERE `name` =" + "'"+ email + "'" + " AND `password` = " + "'"+ pass + "'");
            accountList = (List<Account>) q.list();
           
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        String tempEmail = accountList.get(0).getEmail();
        String tempPass = accountList.get(0).getPassword();
        
        if(email == tempEmail && pass == tempPass){
            loginMatched = true;
        }
        
        return loginMatched;
    }
}
