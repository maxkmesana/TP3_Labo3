package com.tp3.model.entities;

public class ProductEntity {
    private static int contador = 0;
    private final Integer id;

    private CategoryEntity category;
    private String nombre;
    private Double precio;


    public ProductEntity(String nombre, Double precio) {
        this.id = ++contador;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
   }
}
