/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.ChannelDAO;
import dao.CityDAO;
import dao.UserDAO;
import util.DBConnection;
import entity.User;
import entity.Channel;
import entity.City;
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
    private List<Channel> channels;
    private ChannelDAO channelDAO;
    private Channel channel; 
    private City city;
    private CityDAO cityDAO;
    private List<City> cities;
    
    public Channel getChannel(){
        if(channel == null){
            channel = new Channel();
        }
        return this.channel;
    }
    
    public void setChannel(Channel channel){
        this.channel = channel;
    }
    
    public City getCity(){
        if(city == null){
            city = new City();
        }
        return this.city;
    }
    
    public void setCity(City city){
        this.city = city;
    }
    
   
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
    
    public void createChannel(){
        channelDAO.create(this.channel);
        channel = new Channel();
    }
    
    public void deleteChannel(Channel channel){
        channelDAO.delete(channel);
        
    }
    
    public void createCity(){
        cityDAO.create(this.city);
        city = new City();
    }
    
    public void deleteCity(City city){
        cityDAO.delete(city);
        
    }
    
    public void updateCity(){
        cityDAO.update(this.city);
        city = new City();
    }
    
    
    
    public void delete(User user){
        userDAO.delete(user);
    }
    
    public void update(){
        userDAO.update(this.user);
        user = new User();
    }
    
    public void updateChannel(){
        channelDAO.update(this.channel);
        channel = new Channel();
    }
    
    public List<User> getDatabase(){
       userDAO = new UserDAO();
       return  userDAO.list();
    }
    
    public List<Channel> getChannels() {
        channelDAO = new ChannelDAO();
        return channelDAO.list();
    }
    
    public List<City> getCities() {
        cityDAO = new CityDAO();
        return cityDAO.list();
    }
    
}
