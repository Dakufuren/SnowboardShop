
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
    private static String email;
    private static String pass;

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
    
    // More methods to hold information in the future

    /**
     * @return the user
     */
    public static String getEmail() {
        return email;
    }

    /**
     * @param aUser the user to set
     */
    public static void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * @return the pass
     */
    public static String getPass() {
        return pass;
    }

    /**
     * @param aPass the pass to set
     */
    public static void setPass(String aPass) {
        pass = aPass;
    }
}
