package com.tp3.view;

import com.tp3.model.entities.CategoryEntity;


import java.util.ArrayList;
import java.util.Scanner;

public class CategoryView {

    public Integer viewMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1- Crear una categoria.
                2- Imprimir todas las categorias existentes.
                3- Imprimir una categoria.
                4- Actualizar una categoria.
                5- Eliminar una categoria.
                0- SALIR.
                """);
        System.out.print("Ingrese una opcion: ");
        return scanner.nextInt();
    }

    public CategoryEntity createCategory(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un nombre para la categoria: ");
        String nombre = scanner.nextLine();

        return new CategoryEntity(nombre);
    }

    public void printCategory(CategoryEntity category){
        System.out.println("ID de categoria: "+ category.getId());
        System.out.println("\t-Nombre de categoria: "+ category.getNombre() + "\n");
    }

    public void printCategoryList(ArrayList<CategoryEntity> categoryList){
        for (CategoryEntity category : categoryList){
            printCategory(category);
        }
    }

    public String updateCategory(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nuevo nombre para la categoria: ");

        return scanner.nextLine();
    }

    public Integer getId(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID de la categoria a buscar: ");

        return scanner.nextInt();
    }

    public void msgExito(Integer opcionMsg){
        switch (opcionMsg){
            case 1:
                System.out.println("La categoria fue creada exitosamente.\n");
                break;
            case 2:
                System.out.println("La categoria fue actualizada exitosamente.\n");
                break;
            case 3:
                System.out.println("La categoria fue elimindada exitosamente.\n");
                break;
        }
    }

    public void msgErrorId(){
        System.out.println("ERROR: EL ID buscado no pertenece a una categoria existente.\n");
    }

    public void msgErrorList(){
        System.out.println("ERROR: No existen categorias en la base de datos.\n");
    }
}