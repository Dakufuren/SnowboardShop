/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albin
 */
public class SnowboardObject {
 
    private int id;
    private String brandName;
    private String productName;
    private int price;
    private String pictureLink;
    
    public SnowboardObject(int id, String brandName, String productName, int price, String pictureLink){
       this.id = id;
       this.brandName = brandName;
       this.productName = productName;
       this.price = price;
       this.pictureLink = pictureLink;
        
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the pictureLink
     */
    public String getPictureLink() {
        return pictureLink;
    }
}
