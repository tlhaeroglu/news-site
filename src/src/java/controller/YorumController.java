/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.YorumDao;
import entity.Yorum;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import util.UserControl;

/**
 *
 * @author ademtarhan
 */
@Named(value = "yorumController")
@SessionScoped
public class YorumController extends UserControl implements Serializable {

    public YorumController() throws IOException {
        this.isAdmin();
    }

    private List<Yorum> yorumlar;
    private YorumDao yorumDao;
    private Yorum yorum;

    public List<Yorum> getYorumlar() {
        yorumDao = new YorumDao();
        return yorumDao.list();
    }

    public void setYorumlar(List<Yorum> yorumlar) {
        this.yorumlar = yorumlar;
    }

    public YorumDao getYorumDao() {
        if (this.yorumDao == null) {
            yorumDao = new YorumDao();
        }
        return yorumDao;
    }

    public void setYorumDao(YorumDao yorumDao) {
        this.yorumDao = yorumDao;
    }

    public Yorum getYorum() {
        if (this.yorum == null) {
            yorum = new Yorum();
        }
        return yorum;
    }

    public void setYorum(Yorum yorum) {
        this.yorum = yorum;
    }

    public void create() {
        getYorumDao().create(this.yorum);
        yorum = new Yorum();
    }

    public void delete(Yorum yorum) {
        yorumDao.delete(yorum);

    }

    public void update() {
        yorumDao.update(this.yorum);
        yorum = new Yorum();
    }

}
