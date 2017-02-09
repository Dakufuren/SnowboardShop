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
@Named(value = "signupBean")
@Dependent
public class SignupBean {
    
    private String name;
    private String email;
    private String ssn;
    private String password;
    HibernateHelper hh = new HibernateHelper();

    /**
     * Creates a new instance of SignupBean
     */
    public SignupBean() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the ssn
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
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
    
    public void addAccount(String email, String name, int ssn, String password){
        
        try {
            hh.addAccount(email, name, ssn, password);
            
            
            MailBean mb = new MailBean();
            mb.sendSignupEmail(email);
        } catch (Exception e) {
            System.out.println("");
        }
}
    
    
    
    
    
    
}
