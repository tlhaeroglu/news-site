/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Category {
    private int kategoriid;
    private String kategoriadi;


    public Category() {
    }
    
    public Category(String kategoriadi) {
        this.kategoriadi = kategoriadi;
    }

    public Category(int kategoriid, String kategoriadi) {
        this.kategoriid = kategoriid;
        this.kategoriadi = kategoriadi;
    }

    public int getKategoriid() {
        return kategoriid;
    }

    public void setKategoriid(int kategoriid) {
        this.kategoriid = kategoriid;
    }

    public String getKategoriadi() {
        return kategoriadi;
    }

    public void setKategoriadi(String kategoriadi) {
        this.kategoriadi = kategoriadi;
    }
    
    
}
