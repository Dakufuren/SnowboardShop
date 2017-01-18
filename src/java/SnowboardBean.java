/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
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
    
    private ArrayList<SnowboardObject> objectList;
    
    private int id;
    private String brandName;
    private String productName;
    private int price;
    private String pictureLink;
    
    /**
     * Creates a new instance of SnowboardBean
     */
    public SnowboardBean() {
        objectList = new ArrayList<>();
        
        objectList.add(new SnowboardObject(0, "Burton", "BurtonDelux", 2000, "https://www.junkyard.se/media/catalog/product/930x/6/8/687468.jpg"));
        objectList.add(new SnowboardObject(1, "Desco", "DescoDelux", 3000, "https://www.junkyard.se/media/catalog/product/930x/6/8/687468.jpg"));
        objectList.add(new SnowboardObject(2, "Mysko", "MyskoDelux", 4000, "https://www.junkyard.se/media/catalog/product/930x/6/8/687468.jpg"));
        
        //TODO: Create SnowboardObjects from Hibernate then add to the ObjectList
    }

    /**
     * @return the objectList
     */
    public ArrayList<SnowboardObject> getObjectList() {
        return objectList;
    }
    
    
    
}
