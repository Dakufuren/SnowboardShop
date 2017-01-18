/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.SnowHelper;
import Hibernate.Snowboard;
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
    
    private List<Snowboard> snowList;
    private SnowHelper snow;
    /**
     * Creates a new instance of SnowboardBean
     */
    public SnowboardBean() {
        if(snowList != null){
            
        }
        else{
            snowList = new ArrayList<>();
            snow = new SnowHelper();
        
            snowList = snow.getSnowboards();
        }

    }

    /**
     * @return the snowList
     */
    public List<Snowboard> getSnowList() {
        return snowList;
    }
    
}
