/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Haber;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.DBConnection;

public class HaberDAO extends DBConnection{
    public String delete(Haber haber){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from haber where haberid = "+haber.getHaberid();
 
            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    //..Update
    /*
    haberid serial primary key,
	baslik varchar(30),
	imgurl varchar(50) default null,
	icerik varchar(2000) not null,
	haberTarihi timestamp default CURRENT_TIMESTAMP,
	userid integer references users(userid),
	kategoriid integer references kategori(kategoriid),
	sehirid integer references sehir(sehirid),
	kanalid integer references kanal(kanalid)*/
    public String update(Haber haber){
        
        try{
            Connection c = this.connect();
            String sql = "update haber set baslik = ?,  imgurl = ?, icerik=?, userid=?, kategoriid=?, sehirid=?, kanalid=? where haberid = ?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, haber.getBaslik());
            st.setString(2, haber.getImgurl());
            st.setString(3, haber.getIcerik());
            st.setInt(4, haber.getUserid());
            st.setInt(5, haber.getCategory().getKategoriid());
            st.setInt(6, haber.getSehirid());
            st.setInt(7, haber.getChannel().getKanalid());
            st.setInt(8, haber.getHaberid());
            

            st.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    
    //..Create 
    
    public String create(Haber haber){
        
        try{
            Connection c = this.connect();
            
            String sql = "insert into haber (baslik,imgurl,icerik,userid,kategoriid,sehirid,kanalid) values (?,?,?,?,?,?,?) ";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, haber.getBaslik());
            st.setString(2, haber.getImgurl());
            st.setString(3, haber.getIcerik());
            st.setInt(4, haber.getUserid());
            st.setInt(5, haber.getCategory().getKategoriid());
            st.setInt(6, haber.getSehirid());
            st.setInt(7, haber.getChannel().getKanalid());
   
            st.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    public List<Haber> list() {
        List<Haber> list = new ArrayList<>();

        try {
            Connection c = this.connect();

            String query = "SELECT * from haber order by haberid";
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery(query);
            
            OkuyucuDAO okuyucudao = new OkuyucuDAO();
            CategoryDAO categorydao = new CategoryDAO();
            ChannelDAO channeldao = new ChannelDAO();
            YorumDao yorumdao = new YorumDao();
            
             while(rs.next()){
             list.add(new Haber(
                     rs.getInt("haberid"),
                     rs.getInt("userid"),
                     categorydao.findByID(rs.getInt("kategoriid")),
                     rs.getInt("sehirid"),
                     channeldao.findById(rs.getInt("kanalid")),
                     rs.getString("baslik"),
                     rs.getString("imgurl"),
                     rs.getString("icerik"),
                     rs.getDate("haberTarihi"),
                     okuyucudao.findById(rs.getInt("haberid")),
                     yorumdao.findById(rs.getInt("yorumid"))
             ));
             
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    
    public String getUsername(int id){
        String username = "";
        try {
            Connection c = this.connect();

            String query = "SELECT nickname from users where userid="+id;
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
             username = rs.getString("nickname");
             
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return username;
    }
    
    public String getYorumicerik(int id){
        String icerik = "";
        try {
            Connection c = this.connect();

            String query = "SELECT icerik from yorum where yorumid="+id;
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
             icerik = rs.getString("icerik");
             
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return icerik;
    }
    
}
