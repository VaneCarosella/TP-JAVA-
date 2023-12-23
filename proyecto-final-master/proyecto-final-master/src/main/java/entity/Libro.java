package entity;

public class Libro {
    
    private int isbn;
    private int anio;
    private String titulo;
    private String autor;
    private String editorial;
    private String genero;

    public Libro() {
    }

    public Libro(int isbn, int anio, String titulo, String autor, String editorial, String genero) {
        this.isbn = isbn;
        this.anio = anio;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getAnio() {
        return anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", anio=" + anio + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", genero=" + genero + '}';
    }
}
