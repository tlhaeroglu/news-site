/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDAO;
import entity.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author ademtarhan
 */

@Named(value = "signinController")
@SessionScoped
public class SiginController implements Serializable {

    
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
    
    
     public void reqister() {
         this.getUserDao().create(user);
         user = new User();
     }
    
    
    
    public SiginController() {
    }
    
    
    
    public boolean validateName(FacesContext context,UIComponent cmp,Object value) throws ValidatorException{
        String val = (String) value;
        
        if(val.isEmpty()){
            throw new ValidatorException(new FacesMessage("İsim Alanı Boş Olamaz!"));
        }
        return true;
    }
    public boolean validateSurname(FacesContext context,UIComponent cmp,Object value) throws ValidatorException{
        String val = (String) value;
        if(val.isEmpty()){
            throw new ValidatorException(new FacesMessage("Soyad Alanı Boş Olamaz!"));
        }
        return true;
    }
    public boolean validateNickname(FacesContext context,UIComponent cmp,Object value) throws ValidatorException{
        String val = (String) value;
        if(val.isEmpty()){
            throw new ValidatorException(new FacesMessage("Kullanıcı Adı Alanı Boş Olamaz!"));
        }else if(val.length()<4){
            throw new ValidatorException(new FacesMessage("Kullanıcı Adı Alanının Uzunluğu 4 Karekterden Az Olamaz!"));
        }
        return true;
    }
    public boolean validatePassword(FacesContext context,UIComponent cmp,Object value) throws ValidatorException{
        String val = (String) value;
        if(val.isEmpty()){
            throw new ValidatorException(new FacesMessage("Şifre Alanı Boş Olamaz!"));
        }else if(val.length()<5){
            throw new ValidatorException(new FacesMessage("Şifre Alanının Uzunluğu 5 Karekterden Az Olamaz!"));
        }
        return true;
    }
    
    
    
}
