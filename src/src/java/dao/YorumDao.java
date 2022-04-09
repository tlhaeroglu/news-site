/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Yorum;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author ademtarhan
 */
public class YorumDao  extends DBConnection{
    //..Delete
    
    public String delete(Yorum yorum){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from yorum where yorumid = "+yorum.getYorumID();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    //..Update
    
    public String update(Yorum yorum){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "update yorum set yorumicerik = '"+yorum.getIcerik()+"' where yorumid = '"+yorum.getYorumID()+"'";
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    //..Create 
    
    public String create(Yorum yorum){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "insert into yorum (yorumicerik) values ('"+yorum.getIcerik()+"')";
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    public List<Yorum> list() {
        List<Yorum> list = new ArrayList<>();

        try {
            Connection c = this.connect();

            Statement st = c.createStatement();
            String query = "SELECT * from yorum order by yorumid";

            ResultSet rs = st.executeQuery(query);
            
             while(rs.next()){
             list.add(new Yorum(
                     rs.getInt(1),
                     rs.getInt(2),
                     rs.getInt(3),
                     rs.getString(4),
                     rs.getDate(5)
             ));
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
}
