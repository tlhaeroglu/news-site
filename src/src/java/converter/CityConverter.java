/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CityDAO;
import entity.City;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("cityConverter")
public class CityConverter implements Converter{
    CityDAO dao;

    public CityDAO getDao() {
        if(dao == null){
            dao = new CityDAO();
        }
        return dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        City c = this.getDao().convByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        City c  = (City)t;
        return String.valueOf(c.getSehirid());
    }
    
}
