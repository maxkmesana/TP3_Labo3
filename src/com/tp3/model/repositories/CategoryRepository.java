package com.tp3.model.repositories;

import com.tp3.model.entities.CategoryEntity;

import java.util.ArrayList;

public class CategoryRepository {
    private final ArrayList<CategoryEntity> categoryList;

    public CategoryRepository() {
        this.categoryList = new ArrayList<>();
    }

    public ArrayList<CategoryEntity> getCategoryList() {
        return categoryList;
    }

    public void addCategory(CategoryEntity category){
        categoryList.add(category);
    }

    public CategoryEntity searchCategory(Integer id){
        for (CategoryEntity category : categoryList){
            if(category.getId().equals(id)){
                return category;
            }
        }
        return null;
    }

    public void updateCategory(CategoryEntity category, String nombre){
        int index = categoryList.indexOf(category);
        category.setNombre(nombre);
        categoryList.set(index, category);
    }

    public void deleteCategory(CategoryEntity category){
        categoryList.remove(category);
    }
}
