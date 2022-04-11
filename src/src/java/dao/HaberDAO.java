/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.City;
import entity.Haber;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class HaberDAO extends DBConnection {

    public String delete(Haber haber) {

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();

            for (City city : haber.getCities()) {
                String query = "delete from haber_sehir where haberid=" + haber.getHaberid();
                st.executeUpdate(query);
            }

            String sql = "delete from haber where haberid = " + haber.getHaberid();
            st.executeUpdate(sql);

        } catch (Exception e) {
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
    public String update(Haber haber) {

        try {
            Connection c = this.connect();
            String sql = "update haber set baslik = ?,  imgurl = ?, icerik=?, userid=?, kategoriid=?, kanalid=? where haberid = ?";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, haber.getBaslik());
            st.setString(2, haber.getImgurl());
            st.setString(3, haber.getIcerik());
            st.setInt(4, haber.getUserid());
            st.setInt(5, haber.getCategory().getKategoriid());
            st.setInt(6, haber.getChannel().getKanalid());
            st.setInt(7, haber.getHaberid());

            Statement s = c.createStatement();
            String query = "delete from haber_sehir where haberid=" + haber.getHaberid();
            s.executeUpdate(query);

            for (City city : haber.getCities()) {
                query = "insert into haber_sehir (haberid,sehirid) values (" + haber.getHaberid() + "," + city.getSehirid() + ")";
                s.executeUpdate(query);
            }

            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    //..Create 
    public String create(Haber haber) {

        try {
            Connection c = this.connect();

            String sql = "insert into haber (baslik,imgurl,icerik,userid,kategoriid,kanalid) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, haber.getBaslik());
            st.setString(2, haber.getImgurl());
            st.setString(3, haber.getIcerik());
            st.setInt(4, haber.getUserid());
            st.setInt(5, haber.getCategory().getKategoriid());
            st.setInt(6, haber.getChannel().getKanalid());
            st.executeUpdate();

            c = this.connect();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select max(haberid) from haber");
            rs.next();
            int haber_id = rs.getInt(1);
            System.out.println(haber_id);

            for (City ci : haber.getCities()) {
                Statement s2 = c.createStatement();
                s2.executeUpdate("insert into haber_sehir (haberid,sehirid) values (" + haber_id + "," + ci.getSehirid() + ") ");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(haber.getCities());
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
            CityDAO citydao = new CityDAO();

            while (rs.next()) {
                list.add(new Haber(
                        rs.getInt("haberid"),
                        rs.getInt("userid"),
                        categorydao.findByID(rs.getInt("kategoriid")),
                        citydao.findById(rs.getInt("haberid")),
                        channeldao.findById(rs.getInt("kanalid")),
                        rs.getString("baslik"),
                        rs.getString("imgurl"),
                        rs.getString("icerik"),
                        rs.getDate("haberTarihi"),
                        okuyucudao.findById(rs.getInt("haberid")),
                        yorumdao.findById(rs.getInt("haberid"))
                ));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public String getUsername(int id) {
        String username = "";
        try {
            Connection c = this.connect();

            String query = "SELECT nickname from users where userid=" + id;
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                username = rs.getString("nickname");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return username;
    }


}
