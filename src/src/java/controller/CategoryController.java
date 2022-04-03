/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import entity.Category;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "categoryController")
@SessionScoped
public class CategoryController implements Serializable{

    private List<Category> categories;
    private CategoryDAO categoryDAO;
    private Category category; 
    
    public CategoryController() {
    }
    
    

    public List<Category> getCategories() {
        
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

   
    public Category getCategory() {
        if(this.category == null){
            category = new Category();
        }
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
  
    
    public void createCategory(){
        categoryDAO.create(this.category);
        category = new Category();
    }
    
    public void deleteCategory(Category category){
        categoryDAO.delete(category);
    }
    
    public void updateCategory(){
        categoryDAO.update(this.category);
        category = new Category();
    }
    
    public List<Category> getCategorys() {
        categoryDAO = new CategoryDAO();
        return categoryDAO.list();
    }
    
}
