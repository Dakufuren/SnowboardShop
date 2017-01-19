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
@Named(value = "loginBean")
@Dependent
public class LoginBean {
    
    private String email;
    private String password;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void validateLogin(String email, String password){
        System.out.println(email);
        System.out.println(password);
        
        HibernateHelper hh = new HibernateHelper();
        Boolean isUserMatched = hh.isUserMatched(email, password);
        
        if(isUserMatched == true){
            System.out.println(isUserMatched);
            System.out.println("YOU ARE LOGGED IN");
            
            DataStorage ds = new DataStorage();
            ds.setPass(password);
            ds.setEmail(email);
            setPassword(password);
            setEmail(email);
        }
        else{
            System.out.println(isUserMatched);
            System.out.println("YOU ARE NOT LOGGED IN");
        }
    }
}
