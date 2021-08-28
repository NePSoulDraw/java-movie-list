

package com.business;

public interface IMovieList {
    
    String FILE_NAME = "peliculas.txt";
    
    void addMovie(String fileName);
    
    void listMovies();
    
    void searchMovie(String search);
    
    void initMovieList();
    
}
