/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Tom
 */
public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private GregorianCalendar fecha;
    private Devolucion devolucion;


    public Prestamo(Usuario usuario, Libro libro, GregorianCalendar fecha, Devolucion devolucion) {
        this.usuario = usuario;
        this.libro = libro;
        this.fecha = fecha;
        this.devolucion = devolucion;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * @return the fecha
     */
    public GregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the devolucion
     */
    public Devolucion getDevolucion() {
        return devolucion;
    }

    /**
     * @param devolucion the devolucion to set
     */
    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }
    
    public String obtenerTipoDeUsuario() {
        if (getUsuario() instanceof Docente) {
            return "Docente";
        }
        return "Estudiante";
    }
    
    // SOLICITO LOS PARÁMETROS DE ENTRADA DE LA DEVOLUCIÓN
    public void asignarDevolucion(Devolucion devolucion) {

        // TENGO QUE HABILITAR AL USUARIO
        getUsuario().setPrestamo(0);
        // TENGO QUE AUMENTAR EL STOCK DISPONBILE Y DISMINUIR EL STOCK ASIGNADO
        getLibro().setCantDisponible(getLibro().getCantDisponible()+1);
        getLibro().setCantBiblioteca(getLibro().getCantBiblioteca()-1);
        // TENGO QUE COBRAR MULTA SI ES QUE CORRESPONDE
        GregorianCalendar fechaActual = new GregorianCalendar(TimeZone.getDefault(), Locale.getDefault());
        if(fechaActual.after(devolucion.getFecha())){
            long diferenciaMilis =  fechaActual.getTimeInMillis() - devolucion.getFecha().getTimeInMillis() ;
            // Convertir la diferencia en días
            long dias = TimeUnit.MILLISECONDS.toDays(diferenciaMilis);
            int multa = (int) (1000*dias);
            devolucion.setMulta(multa);
        }

    }
    
    public static Prestamo ingresarPrestamo(int ISBN, String RUN, ArrayList<Libro> libros, ArrayList<Usuario> usuarios,int dias,ArrayList<Devolucion> devoluciones) {

        // ASIGNO UNA VARIABLE CON VALOR A LO QUE RETORNE EL MÉTODO BUSCARLIBRO
        Libro libro = buscarLibro(ISBN, libros);
        
        // SI EL LIBRO ES NULO, ES PORQUE NO LO HE ENCONTRADO
        if (libro == null) {
            throw new IllegalArgumentException("El libro a buscar no existe.");
        }
        
        // ASIGNO UNA VARIABLE CON VALOR A LO QUE RETORNE EL MÉTODO BUSCARUSUARIO
        Usuario usuario = buscarUsuario(RUN, usuarios);
        
        // SI EL USUARIO ES NULO, ES PORQUE NO LO HE ENCONTRADO
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario a buscar no existe.");
        }
        
        // EN ESTE PUNTO, YA SABEMOS QUE EL USUARIO Y EL LIBRO YA EXISTEN
        // AHORA DEBEMOS REALIZAR LAS VALIDACIONES
        
        // AQUÍ VALIDAMOS QUE EL LIBRO TENGA COMO MÍNIMO UN EJEMPLAR //
        if (libro.getCantDisponible()<1){
            System.out.println("No quedan unidades disponibles para solicitar");
            return null;
        }
        // AQUÍ VALIDAMOS QUE EL USUARIO DEBA ESTAR HABILTIADO PARA EL PRÉSTAMO //
        if(usuario.getPrestamo()>0){
            System.out.println("Este usuario no esta habilitado para reservar");
            return null;
        }
        
        // UNAS VEZ GENERADA TODAS LAS VALIDACIONES
        
        // GENERAMOS UNA INSTANCIA DE PRÉSTAMO
        Prestamo prestamo = new Prestamo(usuario, libro, new GregorianCalendar(TimeZone.getDefault(), Locale.getDefault()),null);
        // ---------------- LO QUE SE DEBE HACER A CONTINUACIÓN SE PUEDE REALIZAR DENTRO DE ÉSTE MÉTODO Ó ----------------
        // ----------------------------- DENTRO DE LA INSTANCIACIÓN DEL OBJETO -------------------------------------------
        // REDUCIMOS LA CANTIDAD DISPONIBLE DEL LIBRO Y AUMENTAMOS LA CANTIDAD EN USO
        libro.setCantDisponible(libro.getCantDisponible()-1);
        libro.setCantBiblioteca(libro.getCantBiblioteca()+1);
        // DEJAMOS AL USUARIO NO DISPONIBLE PARA EL NUEVO PRÉSTAMO
        usuario.setPrestamo(libro.getISBN());
        GregorianCalendar fechaDevolucion = new GregorianCalendar(TimeZone.getDefault(), Locale.getDefault());
        fechaDevolucion.add(Calendar.DAY_OF_MONTH,dias);
        Devolucion devolucion = new Devolucion(libro.getISBN(),RUN,fechaDevolucion);
        devoluciones.add(devolucion);
        
        // RETORNAMOS EL PRÉSTAMO VALIDADO
        return prestamo;
    }

    public static void imprimirPrestamo(Prestamo prestamo, ArrayList<Devolucion> devoluciones){
        Devolucion devolucion = Devolucion.buscarDevolucion(prestamo.getUsuario().getRUN(),prestamo.getLibro().getISBN(),devoluciones);
        System.out.println("============================");
        System.out.println("TICKET DE PRESTAMO");
        System.out.println("============================");
        System.out.println("");
        System.out.println("Fecha Prestamo: "+Prestamo.obtenerFecha(prestamo.getFecha()));
        System.out.println("Fecha de Devolucion: "+Prestamo.obtenerFecha(devolucion.getFecha()));
        System.out.println("============================");
        System.out.println("Libro: "+prestamo.getLibro());
        System.out.println("Prestamo a nombre de: "+prestamo.getUsuario());

    }

    public static void ingresarDevolucion(int ISBN, String RUN, ArrayList<Prestamo> prestamos,ArrayList<Devolucion> devoluciones) {
        // EN BASE A LA GUÍA, DEBEMOS VALIDAR QUE EXISTA EL LIBRO Y EL USUARIO
        
        // LUEGO DEBEMOS VALIDAR QUE EL USUARIO A BUSCAR Y EL ISBN EXISTAN
        // ASIGNO UNA VARIABLE CON VALOR A LO QUE RETORNE EL MÉTODO BUSCAR PRESTAMO
        Prestamo prestamo = buscarPrestamo(ISBN, RUN, prestamos);
        // SI EL PRÉTAMO ES NULO, ES PORQUE NO LO HE ENCONTRADO
        if (prestamo == null) {
            throw new IllegalArgumentException("El prestamo a buscar no existe.");
        }
        Devolucion devolucion = Devolucion.buscarDevolucion(RUN,ISBN,devoluciones);
        if (devolucion == null) {
            throw new IllegalArgumentException("El prestamo a buscar no existe.");
        }
        
        // UNA VEZ GENERADAS TODAS LAS VALIDACIONES, EJECUTAMOS EL MÉTODO ASIGNAR DEVOLUCIÓN
        prestamo.asignarDevolucion(devolucion);

        System.out.println("Libro entregado!");
        System.out.println("multa a pagar: $"+devolucion.getMulta());
        prestamos.remove(prestamo);
        devoluciones.remove(devolucion);
    }
    
    public static Libro buscarLibro(int ISBN, ArrayList<Libro> libros) {
        // BUSCO EL LIBRO EN EL ARREGLO DE LIBROS
        for (int i = 0; i < libros.size(); i++) {
            // VOY OBTENIENDO CADA LIBRO EN EL ARREGLO DE LIBROS
            Libro libro = libros.get(i);
            
            // PREGUNTO SI EL ISBN DEL LIBRO ES IGUAL AL LIBRO QUE BUSCO
            if (libro.getISBN() == ISBN) {
                // SI LO ENCUENTRO, LO RETORNO
                return libro;
            }
        }
        
        // SI NO LO ENCUENTRO, RETORNO UN NULL
        return null;
    }
    
    public static Usuario buscarUsuario(String RUN, ArrayList<Usuario> usuarios) {
        // BUSCO EL LIBRO EN EL ARREGLO DE USUARIOS
        for (int i = 0; i < usuarios.size(); i++) {
            // VOY OBTENIENDO CADA USUARIO EN EL ARREGLO DE USUARIOS
            Usuario usuario = usuarios.get(i);
            
            // PREGUNTO SI EL RUT DEL USUARIO ES IGUAL AL RUN QUE BUSCO
            if (usuario.getRUN().equals(RUN)) {
                // SI LO ENCUENTRO, LO RETORNO
                return usuario;
            }
        }
        
        // SI NO LO ENCUENTRO, RETORNO UN NULL
        return null;
    }
    
    public static Prestamo buscarPrestamo(int ISBN, String RUN, ArrayList<Prestamo> prestamos) {
        // BUSCO EL PRESTAMO EN EL ARREGLO DE PRESTAMOS
        for (int i = 0; i < prestamos.size(); i++) {
            // VOY OBTENIENDO CADA PRESTAMO EN EL ARREGLO DE PRESTAMO
            Prestamo prestamo = prestamos.get(i);
            
            // PREGUNTO SI EL RUT DEL USUARIO ES IGUAL AL RUN QUE BUSCO Y EL ISBN DEL LIBRO ES IGUAL AL ISBN A BUSCAR
            // FALTA VALIDAR QUE EL PRÉSTAMO ESTÉ ACTUALMENTE ACTIVO Y NO ENCUENTRE UN PRÉSTAMO YA DEVUELVO
            if (prestamo.getUsuario().getRUN().equals(RUN)  && prestamo.getLibro().getISBN() == ISBN) {
                // SI LO ENCUENTRO, LO RETORNO
                return prestamo;
            }
        }
        
        // SI NO LO ENCUENTRO, RETORNO UN NULL
        return null;
    }

    public static boolean validarDias(String RUN, ArrayList<Usuario>usuarios, int dias){
        Usuario usuario = buscarUsuario( RUN,  usuarios);
        if(usuario instanceof Docente){
            if(dias<=20 && dias > 0){
                return true;
            }else{
                System.out.println("Ingrese un plazo valido");
            }
        }
        if(dias<=10 && dias >0){
            return true;
        }else{
            System.out.println("Ingrese un plazo valido");
        }
        return false;
    }
    
    @Override
    public String toString() {
        // GENERAMOS UN ESTADO BASE
        String estadoBase = "Prestamo: \n" + 
                "ISBN: " + getLibro().getISBN() + "\n" +
                "RUN: " + getUsuario().getRUN() + "\n" +
                "Fecha Prestamo: " + obtenerFecha(getFecha()) + "\n" +
                "Arrendado por: " + obtenerTipoDeUsuario() + "\n" + 
                "Estado: ";
        
        // LO MODIFICAMOS EN BASE A LA DEVOLUCIÓN
        if (getDevolucion() == null) {
            estadoBase += "En préstamo.";
        } else {
            estadoBase += "Devuelto.";
        }
        
        return estadoBase;
    }

    public static String obtenerFecha(GregorianCalendar fecha){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        return format.format(fecha.getTime());
    }
}
