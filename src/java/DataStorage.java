
import Hibernate.Snowboard;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class DataStorage {
    
    
    private static List<Snowboard>snowlist; 

    /**
     * @return the snowlist
     */
    public static List<Snowboard> getSnowlist() {
        return snowlist;
    }

    /**
     * @param aSnowlist the snowlist to set
     */
    public static void updateSnowlist(List<Snowboard> aSnowlist) {
        snowlist = aSnowlist;
    }
    
    
}
