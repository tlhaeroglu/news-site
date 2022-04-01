/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.UserDAO;
import util.DBConnection;
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
    
     public HomeController() {
        
    }

    private User user;
    private UserDAO userDAO;
    private List<User> users;
    
   
    public User getUser() {
        if(user == null){
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public UserDAO getUserDAO() {
        if(userDAO == null){
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getUsers() {
        users = getUserDAO().list();
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    
    public void create(){
        userDAO.create(this.user);
        user = new User();
    }
    
    public void delete(User user){
        userDAO.delete(user);
    }
    
    public void update(){
        userDAO.update(this.user);
        user = new User();
    }
    
    public List<User> getDatabase(){
        userDAO = new UserDAO();
       return  userDAO.list();
    }
    
}
