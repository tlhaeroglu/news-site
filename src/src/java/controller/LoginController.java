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
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;

/**
 *
 * @author ademtarhan
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    
    
    private User user;
    private UserDAO userDao;

    public User getUser() {
        if(user == null){
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDao() {
        if(userDao == null){
            userDao = new UserDAO();
        }
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }
    
    
    
    
    public LoginController() {
    }

    
     public boolean validateNickname(FacesContext context,UIComponent cmp,Object value) throws ValidatorException{
        String val = (String) value;
        
        if(val.isEmpty()){
            throw new ValidatorException(new FacesMessage("Kullanıcı Adı Alanı Boş Olamaz!"));
        }
        return true;
    }
      public boolean validatePassword(FacesContext context,UIComponent cmp,Object value) throws ValidatorException{
        String val = (String) value;
        
        if(val.isEmpty()){
            throw new ValidatorException(new FacesMessage("Şifre Alanı Boş Olamaz!"));
        }
        return true;
    }
    
    
    
    
    public void login(){
        if( user.getNickname().equals("test") && user.getSifre().equals("1234")){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser",user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Giriş Başarılı"));
        }else{
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı adı veya şifre hatalı"));
        }
        
    }

     
    
}
