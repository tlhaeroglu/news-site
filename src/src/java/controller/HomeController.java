/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.ChannelDAO;
import dao.CityDAO;
import dao.HaberDAO;
import dao.UserDAO;
import util.DBConnection;
import entity.User;
import entity.Channel;
import entity.City;
import entity.Haber;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.UserControl;

/**
 *
 * @author TALHA
 */
@Named(value = "homeController")
@SessionScoped
public class HomeController extends UserControl implements Serializable {

    public HomeController() throws IOException {
        this.control();
    }

    private List<Haber> haberler;
    private HaberDAO haberDAO;
    private Haber haber;

    public Haber getHaber() {
        if(this.haber == null){
            this.haber = new Haber();
        }
        return haber;
    }

    public void setHaber(Haber haber) {
        this.haber = haber;
    }
    

    public List<Haber> list() {
        return this.getHaberDAO().list();
    }

    public HaberDAO getHaberDAO() {
        if (haberDAO == null) {
            haberDAO = new HaberDAO();
        }
        return haberDAO;
    }

    public void setHaberDAO(HaberDAO haberDAO) {
        this.haberDAO = haberDAO;
    }
    
    public String getUsername(int id) {
        return this.getHaberDAO().getUsername(id);
    }

}
