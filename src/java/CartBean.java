/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.Snowboard;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Albin
 */
@ManagedBean(name = "cartBean")
@SessionScoped
public class CartBean {
    
    private List<Snowboard> cartList;
    private List<Snowboard> snowList;
    private DataStorage ds;
    private String selectedItem;

    /**
     * Creates a new instance of CartBean
     */
    
    @PostConstruct
    public void init(){
         cartList = new ArrayList<>();
         ds = new DataStorage();
    }

    public CartBean() {
        
    }
    
    public void delFromCart(){
        for (Snowboard s : cartList) {
            if(s.getProductName().equals(selectedItem)){
                cartList.remove(s);
                System.out.println("Removed!!!!");
            }
        }
    }
    
    public void addToCart(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	int tempID = Integer.parseInt(params.get("id"));
        
        snowList = ds.getSnowlist();

        cartList.add(snowList.get(tempID - 1));

        System.out.println(getCartList().size());
        System.out.println(cartList.size());
    }

    public void checkOut(){

    }

    /**
     * @return the selectedItem
     */
    public String getSelectedItem() {
        return selectedItem;
    }

    /**
     * @param selectedItem the selectedItem to set
     */
    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    /**
     * @return the cartList
     */
    public List<Snowboard> getCartList() {
        return cartList;
    }

    /**
     * @param cartList the cartList to set
     */
}
