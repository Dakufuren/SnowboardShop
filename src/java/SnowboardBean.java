/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.HibernateHelper;
import Hibernate.Snowboard;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Albin
 */
@Named(value = "snowboardBean")
@Dependent
public class SnowboardBean {

    /**
     * @return the productId
     */
    
    private String loggedIn = "Login";
    
    private List<Snowboard> snowList;
    DataStorage ds = new DataStorage();
    private HibernateHelper snow;
    /**
     * Creates a new instance of SnowboardBean
     */
    public SnowboardBean() {

    }
    
    @PostConstruct
    public void init() {
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
    
// NOT USED ANYMORE    
//    public void forwardId(){
//        FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
//		String tempID = params.get("id");
//                
//                id = Integer.parseInt(tempID) - 1;
//
//                String tempStr =  Integer.toString(id) + "  !!!ID NUMBER";
//        System.out.println("ForwardID");
//        System.out.println(getId());
//
//        try {
//            
//        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
//        response.sendRedirect("infopage.xhtml");
//            //fc.getExternalContext().dispatch("infopage.xhtml");
//        } catch (IOException ex) {
//            Logger.getLogger(SnowboardBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public String outcome(){
//        System.out.println("Clicked!!!");
//        return "clicked";
//    }

    /**
     * @return the loggedIn
     */
    public String getLoggedIn() {
        return loggedIn;
    }
}
