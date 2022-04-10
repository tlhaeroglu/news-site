/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Okuyucu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class OkuyucuDAO extends DBConnection{
    //..Create 
    
    public String create(Okuyucu o){
        
        try{
            Connection c = this.connect();
            String sql = "insert into okuyucu (userid,haberid) values ("+o.getUserid()+","+o.getHaberid()+")";
            
            Statement st = c.createStatement();
           

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    public List<Okuyucu> findById(int id){
        List<Okuyucu> list = new ArrayList<>();
        
        try{
            Connection c = this.connect();
            String sql = "select * from okuyucu where haberid="+id;
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery(sql);
            
             while(rs.next()){
             list.add(new Okuyucu(
                     rs.getInt("userid"),
                     rs.getInt("haberid")
             ));
             
         }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return list;
    }
}
