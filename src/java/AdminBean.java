/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.HibernateHelper;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Sebastian
 */
@Named(value = "adminBean")
@Dependent
public class AdminBean {
    
    private String email;
    HibernateHelper hh = new HibernateHelper();
    DataStorage ds = new DataStorage();

    /**
     * Creates a new instance of AdminBean
     */
    public AdminBean() {
    }
    
    public void checkAdmin(){
        
        
        email = ds.getEmail();
        Boolean checkIfAdmin=hh.isAdmin(email);
        
        if(checkIfAdmin == true){
            System.out.println("YOU ARE LOGGED IN AS ADMIN" +  "" +email + "" + checkIfAdmin);
        }
        else
            System.out.println("YOU ARE NOT LOGGED IN AS ADMIN" +  "" +email + "" + checkIfAdmin);
        
    }
    
}
