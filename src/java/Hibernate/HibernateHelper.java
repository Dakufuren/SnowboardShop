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

            String queryString = "Select l from Account l where l.email= :email";
            Query query = session.createQuery(queryString);
            query.setParameter("email", email);
            accountList = query.list(); 
            
            for (Account a : accountList) {
                System.out.println("For Each");
 
                if (a.getEmail().equals(email) && a.getPassword().equals(pass)) {
                    loginMatched = true;
                }
                else{
                    loginMatched = false;
                }
            }
           
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return loginMatched;
    }
    
    public void addAccount(String email, String name, int ssn, String password){
        Transaction tx = null;
        byte role = 1;
        try{
            tx = session.beginTransaction();
            Account a = new Account(email, name, ssn, password, role);
            session.save(a);
            tx.commit();
        
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
    } 
        
}
