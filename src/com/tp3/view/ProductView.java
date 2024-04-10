package com.tp3.view;

import com.tp3.model.entities.ProductEntity;


import java.util.Scanner;

public class ProductView {
    public Integer viewMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1- Crear un producto.
                2- Imprimir todos los productos.
                3- Buscar e imprimir un producto.
                4- Actualizar un producto (todos sus campos).
                5- Actualizar precio de producto.
                6- Actualizar nombre de producto.
                7- Eliminar un producto.
                0- SALIR.
                """);
        System.out.print("Ingrese una opcion: ");
        return scanner.nextInt();
    }

//    public void printProductList(ArrayList<ProductEntity> productList){
//        for(ProductEntity product : productList){
//            printProduct(product);
//        }
//    }

    public void printProduct(ProductEntity productEntity){
        System.out.println("ID de producto: "+ productEntity.getId());
        System.out.println("\t-Nombre de producto: "+ productEntity.getNombre());
        System.out.println("\t-Precio de producto: "+ productEntity.getPrecio() + "\n");
    }

    public ProductEntity createProduct(){
        Scanner scn = new Scanner(System.in);

        System.out.print("Ingrese el nombre para el producto: ");
        String str = scn.nextLine();

        System.out.print("Ingrese el precio para el producto: ");
        Double precio = scn.nextDouble();

        return new ProductEntity(str, precio);
    }

    public Integer getId(){
        Scanner scn = new Scanner(System.in);

        System.out.print("Ingrese el ID del producto a buscar: ");
        return scn.nextInt();
    }

    public String updateNombre(){
        Scanner scn = new Scanner(System.in);

        System.out.print("Ingrese un nuevo nombre para el producto: ");
        return scn.nextLine();
    }

    public Double updatePrecio(){
        Scanner scn = new Scanner(System.in);

        System.out.print("Ingrese un nuevo precio para el producto: ");
        return scn.nextDouble();
    }

    public void msgExito(Integer opcionMsg){
        switch (opcionMsg){
            case 1:
                System.out.println("El producto fue creado exitosamente.\n");
                break;
            case 2:
                System.out.println("El producto fue actualizado exitosamente.\n");
                break;
            case 3:
                System.out.println("El producto fue eliminado exitosamente.\n");
                break;
        }
    }

    public void msgErrorId(){
        System.out.println("ERROR: El ID buscado no pertenece a un producto existente.\n");
    }

    public  void msgErrorList(){
        System.out.println("ERROR: No existen productos en la base de datos.\n");
    }
}
