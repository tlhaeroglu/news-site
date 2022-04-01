/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
/*
        userid serial primary key not null,
	ad varchar(30) not null,
	soyad varchar(30),
	nickname varchar(30) unique not null,
	sifre varchar(30) not null,
	isAdmin boolean default false,
	kayitTarihi timestamp default CURRENT_TIME
*/

public class User implements Serializable{
    private int userid;
    private String ad, soyad, nickname, sifre;
    private boolean isAdmin;
    private Date kayitTarihi;
    
    public User(){
        
    }

    public User(String ad, String soyad, String nickname, String sifre) {
        this.ad = ad;
        this.soyad = soyad;
        this.nickname = nickname;
        this.sifre = sifre;
    }

    public User(int userid, String ad, String soyad, String nickname, String sifre, boolean isAdmin, Date kayitTarihi) {
        this.userid = userid;
        this.ad = ad;
        this.soyad = soyad;
        this.nickname = nickname;
        this.sifre = sifre;
        this.isAdmin = isAdmin;
        this.kayitTarihi = kayitTarihi;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", ad=" + ad + ", soyad=" + soyad + ", nickname=" + nickname + ", sifre=" + sifre + ", isAdmin=" + isAdmin + ", kayitTarihi=" + kayitTarihi + '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }
    
    
    
    
    
    
}
