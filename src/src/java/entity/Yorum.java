/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author ademtarhan
 */
public class Yorum {

    private int yorumid;
    private int haberid;
    private int userid;
    private String icerik;
    private Date yorumTarihi;

    public Yorum() {
    }

    public Yorum(int haberid, int userid, String icerik) {
        this.haberid = haberid;
        this.userid = userid;
        this.icerik = icerik;
    }
    

    public Yorum(int yorumid, int haberid, int userid, String icerik, Date yorumTarihi) {
        this.yorumid = yorumid;
        this.haberid = haberid;
        this.userid = userid;
        this.icerik = icerik;
        this.yorumTarihi = yorumTarihi;
    }
    
    

    public int getYorumid() {
        return yorumid;
    }

    public void setYorumid(int yorumid) {
        this.yorumid = yorumid;
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

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public Date getYorumTarihi() {
        return yorumTarihi;
    }

    public void setYorumTarihi(Date yorumTarihi) {
        this.yorumTarihi = yorumTarihi;
    }

   

}
