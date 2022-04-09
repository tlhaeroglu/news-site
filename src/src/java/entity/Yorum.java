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

    private int yorumID;
    private int haberId;
    private int userID;
    private String icerik;
    private Date yorumTarihi;

    public Yorum() {
    }

    public Yorum(String icerik) {
        this.icerik = icerik;
    }

    public Yorum(int yorumID, int haberId, int userID, String icerik, Date yorumTarihi) {
        this.yorumID = yorumID;
        this.haberId = haberId;
        this.userID = userID;
        this.icerik = icerik;
        this.yorumTarihi = yorumTarihi;
    }

    public int getYorumID() {
        return yorumID;
    }

    public void setYorumID(int yorumID) {
        this.yorumID = yorumID;
    }

    public int getHaberId() {
        return haberId;
    }

    public void setHaberId(int haberId) {
        this.haberId = haberId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
