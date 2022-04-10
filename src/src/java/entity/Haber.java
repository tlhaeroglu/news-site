/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.List;

/*

        haberid serial primary key,
	baslik varchar(30),
	imgurl varchar(50) default null,
	icerik varchar(2000) not null,
	haberTarihi timestamp default CURRENT_TIMESTAMP,
	userid integer references users(userid),
	kategoriid integer references kategori(kategoriid),
	sehirid integer references sehir(sehirid),
	kanalid integer references kanal(kanalid)

*/
public class Haber {

    
    private int haberid;
    private int userid;
    private Category category;
    private List<City> cities;
    private Channel channel;
    
    private String baslik, imgurl, icerik;
    private Date haberTarihi;
    private List<Okuyucu> okuyucular;
    private List<Yorum> yorumlar;

    public Haber() {
    }

    public Haber(int userid, Category category, List<City> cities, Channel channel, String baslik, String imgurl, String icerik) {
        this.userid = userid;
        this.category = category;
        this.cities = cities;
        this.channel = channel;
        this.baslik = baslik;
        this.imgurl = imgurl;
        this.icerik = icerik;
    }

    public Haber(int haberid, int userid, Category category, List<City> cities, Channel channel, String baslik, String imgurl, String icerik, Date haberTarihi, List<Okuyucu> okuyucular, List<Yorum> yorumlar) {
        this.haberid = haberid;
        this.userid = userid;
        this.category = category;
        this.cities = cities;
        this.channel = channel;
        this.baslik = baslik;
        this.imgurl = imgurl;
        this.icerik = icerik;
        this.haberTarihi = haberTarihi;
        this.okuyucular = okuyucular;
        this.yorumlar = yorumlar;
    }


    public int getHaberid() {
        return haberid;
    }

    public void setHaberid(int haberid) {
        this.haberid = haberid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }



    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

   


    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public Date getHaberTarihi() {
        return haberTarihi;
    }

    public void setHaberTarihi(Date haberTarihi) {
        this.haberTarihi = haberTarihi;
    }

    public List<Okuyucu> getOkuyucular() {
        return okuyucular;
    }

    public void setOkuyucular(List<Okuyucu> okuyucular) {
        this.okuyucular = okuyucular;
    }
    
    public int getOkuyucuSayisi(){
        return okuyucular.size();
    }

    public List<Yorum> getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(List<Yorum> yorumlar) {
        this.yorumlar = yorumlar;
    }
    
    
    
    
}
