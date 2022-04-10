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
public class City implements Serializable {
    private int sehirid;
    private String sehiradi;
    
    public City(){
        
    }

    public City(String sehiradi) {
        this.sehiradi = sehiradi;
    }
    
    
    
    public City(int sehirid,String sehiradi){
        this.sehirid = sehirid;
        this.sehiradi = sehiradi;
    }

    public int getSehirid() {
        return sehirid;
    }

    public void setSehirid(int sehirid) {
        this.sehirid = sehirid;
    }

    public String getSehiradi() {
        return sehiradi;
    }

    public void setSehiradi(String sehiradi) {
        this.sehiradi = sehiradi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.sehirid;
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
        final City other = (City) obj;
        return this.sehirid == other.sehirid;
    }
    
    
    
}
