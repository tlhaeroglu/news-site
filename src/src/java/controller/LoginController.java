/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.UserDAO;
import entity.User;
import entity.UserManager;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author ademtarhan
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {
    public LoginController() {

    }

    private User user, myUser;
    private UserDAO userDao;

    public User getMyUser() {
        if (myUser == null) {
            myUser = new User();
        }
        return myUser;
    }

    public void setMyUser(User myUser) {
        this.myUser = myUser;
    }

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDao() {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }


    public boolean validateNickname(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {
        String val = (String) value;

        if (val.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Kullanıcı Adı Alanı Boş Olamaz!"));
        }
        return true;
    }

    public boolean validatePassword(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {
        String val = (String) value;

        if (val.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Şifre Alanı Boş Olamaz!"));
        }
        return true;
    }

    public void login() throws IOException {
        String username = getUser().getNickname();
        String password = getUser().getSifre();
        User u = (User) getUserDao().isValidUser(username, password);
        if (u.getUserid() != 0) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", u);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Giriş Başarılı"));
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect("/src/index.xhtml");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı adı veya şifre hatalı"));
            //return "/panel/login.xhmtl";
        }

    }
    
    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", new User());
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("/src/panel/login.xhtml");
    }

}
