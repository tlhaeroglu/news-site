/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.City;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author ademtarhan
 */


public class CityDAO extends DBConnection {
    
    //..Delete
    
    public String delete(City city){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from sehir where sehirid = "+city.getSehirid();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    //..Update
    
    public String update(City city){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "update sehir set sehiradi = '"+city.getSehiradi()+"' where sehirid = '"+city.getSehirid()+"'";
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    //..Create 
    
    public String create(City city){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "insert into sehir (sehiradi) values ('"+city.getSehiradi()+"')";
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    public List<City> list() {
        List<City> list = new ArrayList<>();

        try {
            Connection c = this.connect();

            Statement st = c.createStatement();
            String query = "SELECT * from sehir order by sehirid";

            ResultSet rs = st.executeQuery(query);
            
             while(rs.next()){
             list.add(new City(
                     rs.getInt(1),
                     rs.getString(2)
             ));
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public List<City> findById(int id) {
        List<City> cities = new ArrayList<>();
        
        try {
            Connection c = this.connect();

            Statement st = c.createStatement();
            String query = "SELECT * from haber_sehir where haberid = "+id;

            ResultSet rs = st.executeQuery(query);
            
             while(rs.next()){
             cities.add( new City(
                     rs.getInt(1),
                     rs.getString(2)
             ));
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return cities;
    }
    
    public City convByID(int id){
        City city = new City();
        
        try {
            Connection c = this.connect();

            Statement st = c.createStatement();
            String query = "SELECT * from sehir where sehirid = "+id;

            ResultSet rs = st.executeQuery(query);
            
             while(rs.next()){
             city = new City(
                     rs.getInt(1),
                     rs.getString(2)
             );
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return city;
    }
    
    
    
}
