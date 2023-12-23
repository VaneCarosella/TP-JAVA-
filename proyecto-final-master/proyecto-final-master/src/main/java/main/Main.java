package main;

import data.LibroDAO;
import entity.Libro;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        
        List<Libro> librosLista = new ArrayList();
        LibroDAO dao = new LibroDAO();
        
        Libro libroUno = new Libro(3,1993,"Harry Potter 3", "J.K Rowling", "Salamandra","Fantasía");
        
        //librosLista = dao.selectLibros();
        //librosLista.forEach(System.out::println);
        
        dao.insertarLibro(libroUno);
       // librosLista = dao.selectLibros();
        //librosLista.forEach(System.out::println);
        
    }
    
}
