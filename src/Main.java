/*

@Author Maximo Alessandro Camesana
@Author Yatel Nehuen Espasandin

:D
*/


import com.tp3.controller.ProductController;
import com.tp3.model.repositories.CategoryRepository;
import com.tp3.model.repositories.ProductRepository;
import com.tp3.view.CategoryView;
import com.tp3.view.ProductView;
import com.tp3.controller.CategoryController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CategoryView categoryView = new CategoryView();
        CategoryRepository categoryRepository = new CategoryRepository();
        CategoryController categoryController = new CategoryController(categoryView, categoryRepository);


        ProductView productView = new ProductView();
        ProductRepository productRepository = new ProductRepository();
        ProductController productController = new ProductController(productView, productRepository, categoryController);



        while (true){
            System.out.println("""
                    1- Menu de categorias.
                    2- Menu de productos.
                    0- SALIR.
                    """);
            System.out.print("Ingrese una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    categoryController.controllerMenu();
                    break;
                case 2:
                    productController.controllerMenu();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opcion ingresada invalida. Intente nuevamente.\n");
                    break;
            }
        }
    }
}