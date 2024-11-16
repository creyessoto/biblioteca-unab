/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Libro {
    private int ISBN;
    private String titulo;
    private String autor;
    private int cantBiblioteca;
    private int cantDisponible;
    private String imagen;

    public Libro(int ISBN, String titulo, String autor, int cantBiblioteca, int cantDisponible, String imagen) {

        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.cantBiblioteca = cantBiblioteca;
        this.cantDisponible = cantDisponible;
        this.imagen = imagen;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantBiblioteca() {
        return cantBiblioteca;
    }

    public void setCantBiblioteca(int cantBiblioteca) {
        this.cantBiblioteca = cantBiblioteca;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Libro{ \n" +
                "ISBN=" + ISBN +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", cantBiblioteca=" + cantBiblioteca +
                ", cantDisponible=" + cantDisponible +
                ", imagen='" + imagen + '\'' +
                "} \n";
    }
}
