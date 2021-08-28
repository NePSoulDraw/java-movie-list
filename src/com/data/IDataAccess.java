
package com.data;

import com.domain.Movie;
import com.exceptions.DataAccessEx;
import com.exceptions.DataReadEx;
import com.exceptions.DataWriterEx;
import java.util.List;

public interface IDataAccess {
    
    boolean exists(String fileName) throws DataAccessEx;
    
    List<Movie> listMovies(String fileName) throws DataReadEx;
    
    void write(Movie movie, String fileName, boolean append) throws DataWriterEx;
    
    String search(String name, String search) throws DataReadEx;
    
    void create(String fileName) throws DataAccessEx;
    
    void delete(String fileName) throws DataAccessEx;
    
}
