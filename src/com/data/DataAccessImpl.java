package com.data;

import com.domain.Movie;
import com.exceptions.*;
import java.io.*;
import java.util.*;


public class DataAccessImpl implements IDataAccess {

    @Override
    public boolean exists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    @Override
    public List<Movie> listMovies(String fileName) throws DataReadEx {
        File file = new File(fileName);
        List<Movie> movies = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = null;
            line = input.readLine();

            while (line != null) {
                Movie movie = new Movie(line);
                movies.add(movie);
                line = input.readLine();
            }

            input.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new DataReadEx("Excepción al listar películas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DataReadEx("Excepción al listar películas" + ex.getMessage());
        }

        return movies;
    }

    @Override
    public void write(Movie movie, String fileName, boolean append) throws DataWriterEx {
        File file = new File(fileName);
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName, append));
            out.println(movie.toString());
            out.close();

            System.out.println("Se ha escrito información al archivo: " + movie);

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DataWriterEx("Excepción al escribir películas: " + ex.getMessage());
        }

    }

    @Override
    public String search(String name, String search) throws DataReadEx {
        File file = new File(name);
        String result = null;
        try {
            BufferedReader entry = new BufferedReader(new FileReader(file));
            String line = null;
            line = entry.readLine();
            int index = 1;
            while (line != null) {
                if (search != null && search.equalsIgnoreCase(line)) {
                    result = "Película " + line + " encontrada en el indice " + index;
                    break;
                }
                line = entry.readLine();
                index++;
            }

            entry.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new DataReadEx("Excepción al buscar película:" + ex.getMessage());
        } catch (IOException ex) {
            throw new DataReadEx("Excepción al buscar película:" + ex.getMessage());
        }

        return result;
    }

    @Override
    public void create(String fileName) throws DataAccessEx {
        File file = new File(fileName);
        try {
            PrintWriter out = new PrintWriter(new FileWriter(file));
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DataAccessEx("Excepción al crear archivo: " + ex.getMessage());
        }

    }

    @Override
    public void delete(String fileName) throws DataAccessEx {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        System.out.println("Se ha eliminado el archivo");

    }

}
