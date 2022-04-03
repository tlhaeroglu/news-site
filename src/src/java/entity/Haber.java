/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

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
    private int kategoriid;
    private int sehirid;
    private int kanalid;
    
    private String baslik, imgurl, icerik;
    private Date haberTarihi;

    public Haber() {
    }

    public Haber(int userid, int kategoriid, int sehirid, int kanalid, String baslik, String imgurl, String icerik) {
        this.userid = userid;
        this.kategoriid = kategoriid;
        this.sehirid = sehirid;
        this.kanalid = kanalid;
        this.baslik = baslik;
        this.imgurl = imgurl;
        this.icerik = icerik;
    }

    public Haber(int haberid, int userid, int kategoriid, int sehirid, int kanalid, String baslik, String imgurl, String icerik, Date haberTarihi) {
        this.haberid = haberid;
        this.userid = userid;
        this.kategoriid = kategoriid;
        this.sehirid = sehirid;
        this.kanalid = kanalid;
        this.baslik = baslik;
        this.imgurl = imgurl;
        this.icerik = icerik;
        this.haberTarihi = haberTarihi;
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

    public int getKategoriid() {
        return kategoriid;
    }

    public void setKategoriid(int kategoriid) {
        this.kategoriid = kategoriid;
    }

    public int getSehirid() {
        return sehirid;
    }

    public void setSehirid(int sehirid) {
        this.sehirid = sehirid;
    }

    public int getKanalid() {
        return kanalid;
    }

    public void setKanalid(int kanalid) {
        this.kanalid = kanalid;
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
    
    
}
