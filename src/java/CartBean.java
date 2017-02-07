/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.Snowboard;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author Albin
 */
@Named(value = "cartBean")
@Dependent
public class CartBean {
    
    private List<Snowboard> cartList;
    private List<Snowboard> snowList;
    private DataStorage ds;

    /**
     * Creates a new instance of CartBean
     */
    public CartBean() {
        cartList = new ArrayList<>();
        ds = new DataStorage();
    }
    
    public void addToCart(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	int tempID = Integer.parseInt(params.get("id"));
        
        snowList = ds.getSnowlist();
        
        getCartList().add(snowList.get(tempID - 1));
        
        System.out.println("SNOWBOARD ID OF OBJECT: " +getCartList().get(0).getId());
    }

    /**
     * @return the cartList
     */
    public List<Snowboard> getCartList() {
        return cartList;
    }
}
