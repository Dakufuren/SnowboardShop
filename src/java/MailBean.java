/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.HibernateHelper;
import Hibernate.Snowboard;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Albin
 */
@Named(value = "mailBean")
@SessionScoped
public class MailBean implements Serializable {

    private String receiver = "";
    private String sender = "dakufuren@gmail.com";
    private DataStorage ds;

    /**
     * Creates a new instance of MailBean
     */
    public MailBean() {
    }

    @PostConstruct
    public void init() {

    }

    public void sendSuccessEmail() {
        List<Snowboard> cartList = ds.getCart();
        
        
        String tempItems = "";
        for (Snowboard s : cartList) {
            if(tempItems.equals("")){
                tempItems = "Product Name: " + s.getProductName() + "\n" +
                        "Brand Name: " + s.getBrandName() + "\n" +
                        "Length: " + s.getBoardLength()+ "\n" +
                        "Price: " + s.getPrice() + "\n\n";
            }else{
                tempItems = tempItems + "Product Name: " + s.getProductName() + "\n" +
                        "Brand Name: " + s.getBrandName() + "\n" +
                        "Length: " + s.getBoardLength()+ "\n" +
                        "Price: " + s.getPrice() + "\n\n";
            }
        }
        
        
        String subject = "Success Email, Snowshop";
        String msg = "Success! You have bought this: \n\n" + tempItems;
        String toEmail;
        toEmail = ds.getEmail();
        doConnect(msg, subject, toEmail);
    }

    public void sendSignupEmail(String tempMail) {
        String signupEmail = tempMail;

        String subject = "Success on Signup, Snowshop";
        String msg = "Success! You have succesfully signed up: " + signupEmail;

        doConnect(msg, subject, tempMail);
    }

    private void doConnect(String emailMsg, String emailSubject, String toEmail) {
        ds = new DataStorage();
        receiver = toEmail;

        final String username = "snowshophkr@gmail.com";
        final String password = "759486456";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver));
            message.setSubject(emailSubject);
            message.setText(emailMsg);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
