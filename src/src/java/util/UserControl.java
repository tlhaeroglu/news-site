/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import entity.User;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import java.io.IOException;

/**
 *
 * @author TALHA
 */
public abstract class UserControl {
    
    public void control() throws IOException{
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("validUser") == null) {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect("/src/panel/login.xhtml");
        }
    }
    
    public void isAdmin() throws IOException{
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("validUser") == null) {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect("/src/panel/login.xhtml");
        } else{
            User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("validUser");
            if(!user.isIsAdmin()){
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                externalContext.redirect("/src/panel/login.xhtml");
            }
        }
    }
    
}
