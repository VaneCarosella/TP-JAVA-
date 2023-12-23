package data;

import entity.Libro;
import static data.Conexion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibroDAO {
    
    static Logger logger = LoggerFactory.getLogger(LibroDAO.class);
    
    private static final String SQL_SELECT = "SELECT * FROM libro";
    private static final String SQL_INSERT = "INSERT INTO libro(isbn, anio, titulo, autor, editorial, genero) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE libro SET isbn = ?, anio = ?, titulo = ?, autor ID = ?, editorial = ?, genero = ?";
    private static final String SQL_DELETE = "DELETE FROM libro WHERE isbn = ?";
    
    
        public List<Libro> selectLibros() throws SQLException{
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Libro libro = null;
        List<Libro> libros = new ArrayList();
        
        
        try {
            conn = getConexion();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT);
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            while(rs.next()) {
                int isbn = rs.getInt(1);
                int anio = rs.getInt(2);
                String titulo = rs.getString(3);
                String autor = rs.getString(4);
                String editorial = rs.getString(5);
                String genero = rs.getString(6);
                
                libro = new Libro(isbn, anio, titulo, autor, editorial, genero);
                libros.add(libro);
            }

            
            } catch(SQLException | NullPointerException | ClassNotFoundException |
                InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace(System.out);
            ex.getMessage();
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        } 
        return libros;
    }
    
        
    public int insertarLibro(Libro lib) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, lib.getIsbn());
            stmt.setInt(2, lib.getAnio());
            stmt.setString(3, lib.getTitulo());
            stmt.setString(4, lib.getAutor());
            stmt.setString(5, lib.getEditorial());
            stmt.setString(6, lib.getGenero());
            registros = stmt.executeUpdate();
            
        } catch(SQLException ex) {
            
            ex.printStackTrace(System.out);
            
        } finally {
            
            try {
                close(stmt);
                close(conn);
            } catch(SQLException ex) {
                ex.getMessage();
            }
        }
        return registros;
    }   
    
        public int actualizarLibro(Libro lib) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try{
            
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, lib.getIsbn());
            stmt.setInt(2, lib.getAnio());
            stmt.setString(3, lib.getTitulo());
            stmt.setString(4, lib.getAutor());
            stmt.setString(5, lib.getEditorial());
            stmt.setString(6, lib.getGenero());
            registros = stmt.executeUpdate();
            
        } catch(SQLException | NullPointerException ex) {
            
            ex.printStackTrace(System.out);
            
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch(SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int eliminarLibro(Integer i) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try{
            
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, i);
            registros = stmt.executeUpdate();
            
        } catch(SQLException | NullPointerException ex) {
            
            ex.printStackTrace(System.out);
            
        } finally {
            
            try {
                stmt.close();
                conn.close();
                
            } catch(SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }  
}
