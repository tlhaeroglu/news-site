/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Channel;
import java.sql.Connection;
import util.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ademtarhan
 */
public class ChannelDAO extends DBConnection {
    
    //..Delete
    
    public String delete(Channel channel){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from kanal where kanalid = "+channel.getKanalid();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    //..Update
    
    public String update(Channel channel){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "update kanal set kanaladi = '"+channel.getKanaladi()+"' where kanalid = '"+channel.getKanalid()+"'";
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    //..Create 
    
    public String create(Channel channel){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "insert into kanal (kanaladi) values ('"+channel.getKanaladi()+"')";
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    public List<Channel> list() {
        List<Channel> list = new ArrayList<>();

        try {
            Connection c = this.connect();

            Statement st = c.createStatement();
            String query = "SELECT * from kanal order by kanalid";

            ResultSet rs = st.executeQuery(query);
            
             while(rs.next()){
             list.add(new Channel(
                     rs.getInt(1),
                     rs.getString(2)
             ));
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

}
