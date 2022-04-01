/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entity.User;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TALHA
 */
@Named(value = "homeController")
@SessionScoped
public class HomeController implements Serializable {

    /**
     * Creates a new instance of HomeController
     */
    
    private String name;
    private List<User> names;
    public HomeController() {
        name = "adem";
    }

    public List<User> getNames() {
        return names;
    }

    public void setNames(List<User> names) {
        this.names = names;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<User> getDatabase(){
        List<User> list = new ArrayList<>();
        try{
         Class.forName("org.postgresql.Driver");
         Connection c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/news",
            "postgres", "12345");
         
         Statement st = c.createStatement();
         String query = "SELECT * from users";
         
         ResultSet rs = st.executeQuery(query);
         
         while(rs.next()){
             list.add(new User(
                     rs.getInt(1),
                     rs.getString(2),
                     rs.getString(3),
                     rs.getString(4),
                     rs.getString(5),
                     rs.getBoolean(6),
                     rs.getDate(7)
             ));
         }
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
        
        return list;
        
    }
    
}
