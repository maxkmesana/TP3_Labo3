package com.tp3.controller;

import com.tp3.model.entities.CategoryEntity;
import com.tp3.model.repositories.CategoryRepository;
import com.tp3.view.CategoryView;

import java.util.ArrayList;

public class CategoryController {
    private final CategoryView cView;
    private final CategoryRepository cRepository;

    public void controllerMenu(){
        while (true){
            Integer opcion = cView.viewMenu();
            switch (opcion){
                case 1:
                    addCategory();
                    break;
                case 2:
                    printCategoryList();
                    break;
                case 3:
                    searchPrintCategory();
                    break;
                case 4:
                    searchUpdateCategory();
                    break;
                case 5:
                    deleteCategory();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion ingresada es invalida. Vuelva a intentarlo.\n");
                    break;
            }
        }

    }

    public boolean emptyList(){
        return cRepository.getCategoryList().isEmpty();
    }

    public CategoryController(CategoryView cView, CategoryRepository cRepository) {
        this.cView = cView;
        this.cRepository = cRepository;
    }

    public void msgExito(Integer opcionMsg){
        cView.msgExito(opcionMsg);
    }

    public void msgError(Integer opcionMsg){
        switch (opcionMsg){
            case 1:
                cView.msgErrorId();
                break;
            case 2:
                cView.msgErrorList();
                break;
        }
    }

    public void addCategory(){
        CategoryEntity categoryEntity = cView.createCategory();
        cRepository.addCategory(categoryEntity);
        msgExito(1);
    }

    public CategoryEntity searchCategory(){
        Integer id = cView.getId();
        return cRepository.searchCategory(id);
    }

    public void searchUpdateCategory(){
        CategoryEntity categoryEntity = searchCategory();
        if(categoryEntity != null){
            String nombre = cView.updateCategory();
            cRepository.updateCategory(categoryEntity, nombre);
            msgExito(2);
        }else{
            msgError(1);
        }
    }

    public CategoryEntity updateCategory(CategoryEntity category){
        String nombre = cView.updateCategory();
        category.setNombre(nombre);
        return category;
    }

    public void deleteCategory(){
        CategoryEntity categoryEntity = searchCategory();
        if(categoryEntity != null){
            cRepository.deleteCategory(categoryEntity);
            msgExito(3);
        }else{
            msgError(1);
        }
    }

    public void searchPrintCategory(){
        CategoryEntity categoryEntity = searchCategory();
        if(categoryEntity != null){
            cView.printCategory(categoryEntity);
        }else{
            msgError(1);
        }
    }

    public void printCategory(CategoryEntity category){
        cView.printCategory(category);
    }

    public void printCategoryList(){
        ArrayList<CategoryEntity> categoryList = cRepository.getCategoryList();
        if(!categoryList.isEmpty()){
            cView.printCategoryList(categoryList);
        }else{
            msgError(2);
        }
    }
}
