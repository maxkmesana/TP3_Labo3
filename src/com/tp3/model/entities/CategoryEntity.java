package com.tp3.model.entities;

public class CategoryEntity {
    private static Integer contador = 0;
    private final Integer id;
    private String nombre;

    public CategoryEntity(String nombre) {
        this.id = ++contador;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
