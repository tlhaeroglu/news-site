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
    
    
    public Channel(int kanalid,String kanaladi){
        this.kanalid = kanalid;
        this.kanaladi = kanaladi;
    }

    public Channel(String kanaladi) {
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
    
    
    
}
