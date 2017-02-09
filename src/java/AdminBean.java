/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.HibernateHelper;
import Hibernate.Snowboard;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.hibernate.Transaction;

/**
 *
 * @author Sebastian
 */
@Named(value = "adminBean")
@Dependent
public class AdminBean {

    
     private String brandName;
     private String productName;
     private String description;
     private String pictureLink;
     private Integer boardLength;
     private Integer price; 
    
    private String email;
    HibernateHelper hh = new HibernateHelper();
    DataStorage ds = new DataStorage();
    
    
    private static boolean test;
    private static boolean boardAdded;

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
            test = true;
        }
        else
            System.out.println("YOU ARE NOT LOGGED IN AS ADMIN" +  "" +email + "" + checkIfAdmin);
        
    }
    
    public boolean checkIfBoardAdded(){
        boardAdded = hh.isBoardAdded();
        
        return boardAdded;
    }
    
    public long getAmountOfBoards(){
        long amount = hh.nrOfBoards();
        
        return amount;
    }
    
    public long getAmountOfAccounts(){
        long amount = hh.nrOfAccounts();
        
        return amount;
    }
    
    public void addSnowboard(String brandName, String productName, String description, String pictureLink, Integer boardLength, Integer price){
        System.out.println("TRYING TO ADD BOARD TO STOREEEEEEE");
        hh.addSnowboard(brandName, productName, description, pictureLink, boardLength, price);
        
       } 
    

    /**
     * @return the test
     */
    public boolean isTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(boolean test) {
        this.test = test;
    }
    
    /**
     * @return the brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName the brandName to set
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the pictureLink
     */
    public String getPictureLink() {
        return pictureLink;
    }

    /**
     * @param pictureLink the pictureLink to set
     */
    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    /**
     * @return the boardLength
     */
    public Integer getBoardLength() {
        return boardLength;
    }

    /**
     * @param boardLength the boardLength to set
     */
    public void setBoardLength(Integer boardLength) {
        this.boardLength = boardLength;
    }

    /**
     * @return the price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    
    
}
