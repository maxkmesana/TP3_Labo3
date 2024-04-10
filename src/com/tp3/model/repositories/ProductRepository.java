package com.tp3.model.repositories;

import com.tp3.model.entities.CategoryEntity;
import com.tp3.model.entities.ProductEntity;

import java.util.ArrayList;

public class ProductRepository {
    private final ArrayList<ProductEntity> productList;

    public ProductRepository() {
        this.productList = new ArrayList<>();
    }

    public ArrayList<ProductEntity> getProductList() {
        return productList;
    }

    public void addProduct(ProductEntity productEntity){
        this.productList.add(productEntity);
    }

    public ProductEntity searchProduct(Integer id){
        for (ProductEntity product : productList){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    public void deleteProduct(ProductEntity product){
        this.productList.remove(product);
    }

    public void updatePrecio(ProductEntity product, Double precio){
        int index = this.productList.indexOf(product);
        product.setPrecio(precio);
        this.productList.set(index, product);
    }

    public void updateNombre(ProductEntity product, String nombre){
        int index = this.productList.indexOf(product);
        product.setNombre(nombre);
        this.productList.set(index, product);
    }

    public void updateProduct(ProductEntity product, Double precio, String nombre, CategoryEntity category){
        int index = this.productList.indexOf(product);
        product.setPrecio(precio);
        product.setNombre(nombre);
        product.setCategory(category);
        this.productList.set(index, product);
    }
}
