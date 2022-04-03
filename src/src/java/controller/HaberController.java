/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.HaberDAO;
import entity.Haber;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author TALHA
 */
@Named(value = "haberController")
@SessionScoped
public class HaberController implements Serializable {

    private List<Haber> haberler;
    private HaberDAO haberDAO;
    private Haber haber; 
    
    public HaberController() {
    }

    public List<Haber> getHaberler() {
        return haberler;
    }

    public void setHaberler(List<Haber> haberler) {
        this.haberler = haberler;
    }

    public Haber getHaber() {
        if(haber == null){
            haber = new Haber();
        }
        return haber;
    }

    public void setHaber(Haber haber) {
        this.haber = haber;
    }
    
    public void create(){
        haberDAO.create(this.haber);
        haber = new Haber();
    }
    
    public void update(){
        haberDAO.update(haber);
        haber = new Haber();
    }
    
    public void delete(Haber haber){
        haberDAO.delete(haber);
    }
    
    public List<Haber> list(){
        haberDAO = new HaberDAO();
        return haberDAO.list();
    }
    
    
    
    
}
