/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author TALHA
 */
public class UserDAO extends DBConnection  {
    
    
    public String delete ( User user ){
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from users where userid="+user.getUserid();
           

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    public String update( User user ){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "update users set ad='"+user.getAd()+
                    "', soyad='"+user.getSoyad()+"', nickname='"+user.getNickname()+"',sifre='"+user.getSifre()+"' where userid="+user.getUserid();
            System.out.println(sql);
           

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return "index";
    }
    
    public String create(User user){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "insert into users (ad,soyad,nickname,sifre) values ('"+user.getAd()+
                    "', '"+user.getSoyad()+"','"+user.getNickname()+"','"+user.getSifre()+"')";
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
   public List<User> list(){
       List<User> list = new ArrayList<>();
        
        try{
         Connection c = this.connect();
         
         Statement st = c.createStatement();
         String query = "SELECT * from users order by userid";
         
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
