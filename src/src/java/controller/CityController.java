/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CityDAO;
import entity.City;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TALHA
 */
@Named(value = "cityController")
@SessionScoped
public class CityController implements Serializable {
    
    private City city;
    private CityDAO cityDAO;
    private List<City> cities;
    
    public CityController() {
        
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
    
   
    public List<City> getCities() {
        cityDAO = new CityDAO();
        return cityDAO.list();
    }
    
}
