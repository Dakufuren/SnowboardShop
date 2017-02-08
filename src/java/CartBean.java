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
import javax.faces.application.FacesMessage;
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
    private int totalSum;
    private boolean calcAlreadyRun = false;
    private boolean changeOnList = false;

    /**
     * Creates a new instance of CartBean
     */
    @PostConstruct
    public void init() {
        cartList = new ArrayList<>();
        ds = new DataStorage();
    }

    public CartBean() {

    }

    public void delFromCart(Snowboard s) {
        cartList.remove(s);
        changeOnList = true;
    }

    public void clearCart() {
        System.out.println("CLEARING CARTT!!!");
        cartList.clear();
        changeOnList = true;
    }

    public void addToCart() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        int tempID = Integer.parseInt(params.get("id"));

        snowList = ds.getSnowlist();
        cartList.add(snowList.get(tempID - 1));

        System.out.println(cartList.size());
        changeOnList = true;
    }

    public String loginMessage() {
        
        return "message";
    }
    
    public void checkOut() {
  
            
    }

    public int calcTotalSum() {
        if (changeOnList == true || calcAlreadyRun == false) {
            totalSum = 0;
            calcAlreadyRun = false;

            for (Snowboard s : cartList) {
                if (calcAlreadyRun == false) {
                    totalSum = totalSum + s.getPrice();
                }
            }
        }

        calcAlreadyRun = true;
        changeOnList = false;

        return totalSum;
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
