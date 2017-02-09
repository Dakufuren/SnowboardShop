/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.HibernateHelper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sebastian
 */
@Named(value = "loginBean")
@Dependent
public class LoginBean {
    
    private String email;
    private String password;
    
    DataStorage ds = new DataStorage();

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
    
    public void validateLogin(String email, String password) throws IOException{
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
            
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect("index.xhtml");
            
        }
        else{
            System.out.println(isUserMatched);
            System.out.println("YOU ARE NOT LOGGED IN");
        }
    }
    
    public void logout() throws IOException {
        ds.setEmail("Login");
        ds.setPass("");
        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "");
        
    }
}
