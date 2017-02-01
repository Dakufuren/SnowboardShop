/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.HibernateHelper;
import Hibernate.Snowboard;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Albin
 */
@Named(value = "snowboardBean")
@Dependent
public class SnowboardBean {
    
    private String loggedIn = "Login";
    
    private List<Snowboard> snowList;
    DataStorage ds = new DataStorage();
    private HibernateHelper snow;
    /**
     * Creates a new instance of SnowboardBean
     */
    public SnowboardBean() {
        
        snowList = ds.getSnowlist();
        if(ds.getEmail() != null){
            loggedIn = ds.getEmail();
        }
        
        if(snowList == null){
            snowList = new ArrayList<>();
            snow = new HibernateHelper();
        
            snowList = snow.getSnowboards();
            
            ds.updateSnowlist(snowList);
            System.out.println(snowList + "  <- snowList Initialize to DataStorage");
        }
        else{
            System.out.println(snowList + "  <- snowList Get from DataStorage");
        }

    }

    /**
     * @return the snowList
     */
    public List<Snowboard> getSnowList() {
        return snowList;
    }

    /**
     * @return the loggedIn
     */
    public String getLoggedIn() {
        return loggedIn;
    }
}
