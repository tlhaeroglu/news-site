/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CategoryDAO;
import entity.Category;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author TALHA
 */
@FacesConverter("categoryConverter")
public class CategoryConverter implements Converter{
    CategoryDAO dao;

    public CategoryDAO getDao() {
        if(dao == null){
            dao = new CategoryDAO();
        }
        return dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Category c = this.getDao().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Category c  = (Category)t;
        return String.valueOf(c.getKategoriid());
    }
   
}