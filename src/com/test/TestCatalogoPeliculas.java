package com.test;

import com.business.IMovieList;
import com.business.MovieListImpl;
import java.util.Scanner;

public class TestCatalogoPeliculas {
    
    public static void main(String[] args) {
        
        int option = -1;
        Scanner scanner = new Scanner(System.in);
        IMovieList catalog = new MovieListImpl();
        
        while (option != 0) {
            
            System.out.println("Elige una opción: \n"
                    + "1. Eliminar todas las películas y regenerar fichero \n"
                    + "2. Agregar películas \n"
                    + "3. Listar películas \n"
                    + "4. Buscar película \n"
                    + "0. Salir");
            
            option = Integer.parseInt(scanner.nextLine());
            
            switch (option) {
                case 1:
                    catalog.initMovieList();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la película");
                    String movieName = scanner.nextLine();
                    catalog.addMovie(movieName);
                    break;
                case 3:
                    catalog.listMovies();
                    break;
                case 4:
                    System.out.println("Introduce una película a buscar");
                    String search = scanner.nextLine();
                    catalog.searchMovie(search);
                    break;
                case 0:
                    System.out.println("Fin de la aplicación");
                    break;
                default:
                    System.out.println("Opción no reconocida");
                    break;
                
            }
            
        }
        
    }
    
}
