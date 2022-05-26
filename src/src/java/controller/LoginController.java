/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entity.UserManager;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

/**
 *
 * @author ademtarhan
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    
    private UserManager user;
    
    public LoginController() {
    }

    public UserManager getUser() {
        if(user == null){
            user = new UserManager();
        }
        return user;
    }

    public void setUser(UserManager user) {
        this.user = user;
    }
    
    
    
    public void login(){
        if( user.getUsername().equals("test") && user.getPassword().equals("1234")){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser",user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Giriş Başarılı"));
        }else{
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı adı veya şifre hatalı"));
        }
        
    }
     
    
}
