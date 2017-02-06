/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Albin
 */
@Named(value = "productBean")
@Dependent
public class ProductBean {

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the ImageLink
     */
    public String getImageLink() {
        return ImageLink;
    }

    /**
     * @param ImageLink the ImageLink to set
     */
    public void setImageLink(String ImageLink) {
        this.ImageLink = ImageLink;
    }

    /**
     * @return the Price
     */
    public String getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(String Price) {
        this.Price = Price;
    }

    /**
     * @return the Desc
     */
    public String getDesc() {
        return Desc;
    }

    /**
     * @param Desc the Desc to set
     */
    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    /**
     * @return the BrandName
     */
    public String getBrandName() {
        return BrandName;
    }

    /**
     * @param BrandName the BrandName to set
     */
    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    /**
     * @return the ProductName
     */
    public String getProductName() {
        return ProductName;
    }

    /**
     * @param ProductName the ProductName to set
     */
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }
    private String ID;
    private String ImageLink;
    private String Price;
    private String Desc;
    private String BrandName;
    private String ProductName;

    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }
    
}
