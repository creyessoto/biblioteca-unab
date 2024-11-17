/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

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
    public Libro(int ISBN, String titulo, String autor, int cantDisponible, String imagen) {

        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.cantBiblioteca = 0;
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
                ", libros en prestamo=" + cantBiblioteca +
                ", cantidad disponible=" + cantDisponible +
                ", imagen='" + imagen + '\'' +
                "} \n";
    }

    public static boolean verificarExisteIsbn(ArrayList<Libro> libros, int isbn) {
        for (int i = 0; i < libros.size() ; i++){
            if(libros.get(i).getISBN()== isbn){
                return true;
            }
        }
        return false;
    }

    public static Libro agregarLibro(int isbn, String titulo, String autor, int cantidad, String imagen) {

        Libro libro = new Libro(isbn,titulo,autor,cantidad,imagen);

        return libro;
    }

    public static ArrayList<Libro> eliminarLibro(ArrayList<Libro> libros, int isbn){
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if(libro.getISBN() == isbn ){
                libros.remove(i);
                System.out.println("Libro Eliminado!");
            }
        }
        return libros;
    }
}
