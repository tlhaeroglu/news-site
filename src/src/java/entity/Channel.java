/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author ademtarhan
 */
public class Channel implements Serializable {
    
    private int kanalid;
    private String kanaladi;
    
    
    public Channel(){
        
    }
    
    public Channel(String kanaladi) {
        this.kanaladi = kanaladi;
    }
    
    
    public Channel(int kanalid,String kanaladi){
        this.kanalid = kanalid;
        this.kanaladi = kanaladi;
    }


    public int getKanalid() {
        return kanalid;
    }

    public void setKanalid(int kanalid) {
        this.kanalid = kanalid;
    }

    public String getKanaladi() {
        return kanaladi;
    }

    public void setKanaladi(String kanaladi) {
        this.kanaladi = kanaladi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.kanalid;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Channel other = (Channel) obj;
        return this.kanalid == other.kanalid;
    }
    
    
    
}
