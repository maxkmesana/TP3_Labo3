package com.tp3.controller;

import com.tp3.model.entities.CategoryEntity;
import com.tp3.model.entities.ProductEntity;
import com.tp3.model.repositories.ProductRepository;
import com.tp3.view.ProductView;

import java.util.ArrayList;

public class ProductController {


    private final ProductView pView;
    private final ProductRepository pRepository;

    private final CategoryController cController;


    public ProductController(ProductView pView, ProductRepository pRepository, CategoryController cController) {
        this.pView = pView;
        this.pRepository = pRepository;
        this.cController = cController;
    }

    public void controllerMenu(){
        while(true){
            Integer opcion = pView.viewMenu();
            switch (opcion){
                case 1:
                    addProduct();
                    break;
                case 2:
                    printProductList();
                    break;
                case 3:
                    searchPrintProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    updatePrecio();
                    break;
                case 6:
                    updateNombre();
                    break;
                case 7:
                    deleteProduct();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion ingresada es invalida. Vuelva a intentarlo. \n");
                    break;
            }
        }
    }

    public ProductEntity searchProduct(){
        Integer id = pView.getId();
        return pRepository.searchProduct(id);
    }

    public void addProduct(){
        ProductEntity productEntity = pView.createProduct();

        cController.printCategoryList();

        if(cController.emptyList()) {
            cController.msgError(2);
            return;
        }

        CategoryEntity category = cController.searchCategory();
        if(category != null){
            productEntity.setCategory(category);
            pRepository.addProduct(productEntity);
            pView.msgExito(1);
        }else {
            cController.msgError(1);
        }
    }

    public void printProductList(){
        ArrayList<ProductEntity> productEntities = pRepository.getProductList();
        if(!productEntities.isEmpty()){
            for(ProductEntity product : productEntities){
                pView.printProduct(product);
                cController.printCategory(product.getCategory());
            }
        }else{
            pView.msgErrorList();
        }
    }

    public void searchPrintProduct(){
        ProductEntity productEntity = searchProduct();
        if(productEntity != null){
            pView.printProduct(productEntity);
        }else{
            pView.msgErrorId();
        }
    }

    public void updateNombre(){
        ProductEntity productEntity = searchProduct();
        if(productEntity != null){
            String nombre = pView.updateNombre();
            pRepository.updateNombre(productEntity, nombre);
            System.out.println("Nombre del producto actualizado.");
        }else{
            pView.msgErrorId();
        }
    }

    public void updatePrecio(){
        ProductEntity productEntity = searchProduct();
        if(productEntity != null){
            Double precio = pView.updatePrecio();
            pRepository.updatePrecio(productEntity, precio);
            System.out.println("Nombre del producto actualizado.");
        }else{
            pView.msgErrorId();
        }
    }

    public void updateProduct(){
        ProductEntity productEntity = searchProduct();
        if(productEntity != null){
            Double precio = pView.updatePrecio();
            String nombre = pView.updateNombre();
            CategoryEntity category = cController.updateCategory(productEntity.getCategory());

            pRepository.updateProduct(productEntity, precio, nombre, category);
            pView.msgExito(2);
        }else{
            pView.msgErrorId();
        }
    }

    public void deleteProduct(){
        ProductEntity productEntity = searchProduct();
        if(productEntity != null){
            pRepository.deleteProduct(productEntity);
            pView.msgExito(3);
        }else{
            pView.msgErrorId();
        }
    }
}
