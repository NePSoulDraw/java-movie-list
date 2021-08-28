package com.business;

import com.data.DataAccessImpl;
import com.data.IDataAccess;
import com.domain.Movie;
import com.exceptions.DataAccessEx;
import com.exceptions.DataReadEx;
import java.util.List;


public class MovieListImpl implements IMovieList {

    private final IDataAccess data;

    public MovieListImpl() {
        this.data = new DataAccessImpl();
    }

    @Override
    public void addMovie(String fileName) {
        Movie movie = new Movie(fileName);
        boolean append = false;
        try {
            append = data.exists(FILE_NAME);
            data.write(movie, FILE_NAME, append);
        } catch (DataAccessEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }

    }

    @Override
    public void listMovies() {
        try {
            List<Movie> movies = this.data.listMovies(FILE_NAME);
            for (Movie movie: movies){
                System.out.println("Película " + movie);
            }
        } catch (DataReadEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void searchMovie(String search) {
        String result = null;
        try {
            result = this.data.search(FILE_NAME, search);
        } catch (DataReadEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado = " + result);
    }

    @Override
    public void initMovieList() {
        try {
            if(this.data.exists(FILE_NAME)){
                data.delete(FILE_NAME);
                data.create(FILE_NAME);
            }else{
                data.create(FILE_NAME);
            }
        } catch (DataAccessEx ex) {
            System.out.println("Error al iniciar el catálogo de películas");
            ex.printStackTrace(System.out);
        }
    }

}
