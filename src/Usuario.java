/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public abstract class Usuario {
    private String RUN;
    private String nombreCompleto;
    private char genero;
    private int prestamo;


    public Usuario(String RUN, String nombreCompleto, char genero) {
        this.RUN = RUN;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
        this.prestamo = 0;
    }

    public String getRUN() {
        return RUN;
    }

    public void setRUN(String RUN) {
        if(validarRut(RUN)){
            this.RUN = RUN;
        }
        System.out.println("RUN invalido!");
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    public int getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(int prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public String toString() {
        return "RUN: " + RUN + " " +
                ", nombreCompleto: " + nombreCompleto + " " +
                ", genero: " + genero +" "+
                '}';
    }

    public static boolean validarRut(String rut) {
        // Eliminar puntos y guión
        rut = rut.replace(".", "").replace("-", "");
        // Validar largo del RUT
        if (rut.length() < 8 || rut.length() > 9) {
            System.out.println("RUN invalido!");
            return false;
        }
        // Separar el número y el dígito verificador
        String rutNumero = rut.substring(0, rut.length() - 1);
        char dv = rut.charAt(rut.length() - 1);
        try {
            int rutInt = Integer.parseInt(rutNumero);
            // Calcular el dígito verificador
            int m = 0, s = 1;
            for (; rutInt != 0; rutInt /= 10) {
                s = (s + rutInt % 10 * (9 - m++ % 6)) % 11;
            }
            char dvCalculado = (s != 0) ? (char) (s + 47) : 'K';

            // Verificar si el dígito verificador es correcto
            if (dv == dvCalculado) {
                return true;
            }
            System.out.println("RUN invalido!");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("RUN invalido!");
            return false; // Si el número no es válido, retornamos false
        }
    }

    public static String formatearRun(String rut) {
        rut = rut.replace(".", "").replace("-", "");
        String rutNumero = rut.substring(0, rut.length() - 1);
        char dv = rut.charAt(rut.length() - 1);
        return rutNumero+"-"+dv;
    }


    public static boolean verificarExisteRun(ArrayList<Usuario> usuarios, String rut) {
        for (int i = 0; i < usuarios.size() ; i++){
            if(usuarios.get(i).getRUN().equals(rut)){
                System.out.println("Run ya existe");
                return true;
            }
        }
        return false;
    }

    public static boolean validarGenero(char genero) {
        try {
            genero = Character.toUpperCase(genero);
            if (genero == 'F' || genero == 'M') {
                return true;
            }
            System.out.println("Genero debe ser 'M' o 'F'");
            return false;
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Genero debe ser 'M' o 'F'");
        }
        return false;
    }

    public static ArrayList<Usuario> eliminarUsuario(ArrayList<Usuario> usuarios, String RUN){
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if(usuario.getRUN().equals(RUN)){
                usuarios.remove(i);
                System.out.println("Usuario Eliminado!");
            }
        }
        return usuarios;
    }

}
