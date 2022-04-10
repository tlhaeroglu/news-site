/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.ChannelDAO;
import entity.Channel;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author ademtarhan
 */

@FacesConverter("channelConverter")


public class ChannelConverter implements Converter{
    ChannelDAO dao;

    public ChannelDAO getDao() {
        if(dao == null){
            dao = new ChannelDAO();
        }
        return dao;
    }

    

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Channel c = this.getDao().findById(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Channel c  = (Channel)t;
        return String.valueOf(c.getKanalid());
    }

    

    
}
