/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.YorumDao;
import entity.Yorum;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author ademtarhan
 */
@FacesConverter("yorumConverter")
public class YorumConverter implements Converter {
    YorumDao dao;

    public YorumDao getDao() {
        if(dao == null){
            dao = new YorumDao();
        }
        return dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Yorum c = (Yorum) this.getDao().findById(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Yorum c  = (Yorum)t;
        return String.valueOf(c.getYorumid());
    }

}
