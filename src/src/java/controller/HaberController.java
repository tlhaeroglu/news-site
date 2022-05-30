/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.HaberDAO;
import entity.Haber;
import entity.User;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import util.UserControl;

/**
 *
 * @author TALHA
 */
@Named(value = "haberController")
@SessionScoped
public class HaberController extends UserControl implements Serializable {
    
    final String absolutePath = "C:/Users/TALHA/Documents/NetBeansProjects/news-site/src/web/resources/images/";

    public HaberController(){
        
    }

    private List<Haber> haberler;
    private HaberDAO haberDAO;
    private Haber haber;
    private int page = 1;
    private int pageSize = 3;
    private int pageCount;
    private Part file;
    

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    

    public void next() {
        this.page++;
    }

    public void previous() {
        if (page != 1) {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getHaberDAO().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Haber> getHaberler() throws IOException {
        this.haberler = this.getHaberDAO().findAll(page, pageSize);
        return haberler;
    }

    public void setHaberler(List<Haber> haberler) {
        this.haberler = haberler;
    }

    public Haber getHaber() {
        if (haber == null) {
            haber = new Haber();
        }
        return haber;
    }

    public void setHaber(Haber haber) {
        this.haber = haber;
    }

    public void create() {
        /* UPLOAD */
        
        if(file != null && file.getSize() > 0){
            try{
                InputStream input = getFile().getInputStream();
                String temp = absolutePath+file.getSubmittedFileName();
                File f = new File(temp);
                Files.copy(input, f.toPath());
                this.haber.setImgurl(file.getSubmittedFileName());
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } else{
          this.haber.setImgurl("");  
        }
        /* UPLOAD */
        
        this.getHaberDAO().create(this.haber);
        haber = new Haber();
    }

    public void update() {
        this.getHaberDAO().update(haber);
        haber = new Haber();
    }

    public HaberDAO getHaberDAO() {
        if (haberDAO == null) {
            haberDAO = new HaberDAO();
        }
        return haberDAO;
    }

    public void setHaberDAO(HaberDAO haberDAO) {
        this.haberDAO = haberDAO;
    }

    public void delete(Haber haber) {
        this.getHaberDAO().delete(haber);
        haber = new Haber();
    }

    public List<Haber> list() {
        return this.getHaberDAO().list();
    }

    public String getUsername(int id) {
        return this.getHaberDAO().getUsername(id);
    }

}
