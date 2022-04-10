/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author TALHA
 */
public class CategoryDAO extends DBConnection{
    public String delete(Category category){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from kategori where kategoriid = "+category.getKategoriid();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    //..Update
    
    public String update(Category category){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "update kategori set kategoriadi = '"+category.getKategoriadi()+"' where kategoriid = '"+category.getKategoriid()+"'";
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    //..Create 
    
    public String create(Category category){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "insert into kategori (kategoriadi) values ('"+category.getKategoriadi()+"')";
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    public List<Category> list() {
        List<Category> list = new ArrayList<>();

        try {
            Connection c = this.connect();

            Statement st = c.createStatement();
            String query = "SELECT * from kategori order by kategoriid";

            ResultSet rs = st.executeQuery(query);
            
             while(rs.next()){
             list.add(new Category(
                     rs.getInt(1),
                     rs.getString(2)
             ));
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public Category findByID(int id){
        Category category = new Category();
        
        try {
            Connection c = this.connect();

            Statement st = c.createStatement();
            String query = "SELECT * from kategori where kategoriid = "+id;

            ResultSet rs = st.executeQuery(query);
            
             while(rs.next()){
             category = new Category(
                     rs.getInt(1),
                     rs.getString(2)
             );
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return category;
    }
}
