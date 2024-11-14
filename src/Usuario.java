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

    public Usuario(String RUN, String nombreCompleto, char genero) {
        this.RUN = RUN;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "RUN='" + RUN + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", genero=" + genero +
                '}';
    }

    public boolean validarRut(String rut) {
        // Eliminar puntos y guión
        rut = rut.replace(".", "").replace("-", "");
        // Validar largo del RUT
        if (rut.length() < 8 || rut.length() > 9) {
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
            return dv == dvCalculado;
        } catch (NumberFormatException e) {
            return false; // Si el número no es válido, retornamos false
        }
    }

    public boolean verificarExisteRun(ArrayList<Usuario> usuarios, String rut) {
        for (int i = 0; i < usuarios.size() ; i++){
            if(usuarios.get(i).getRUN()==rut){
                return true;
            }
        }
        return false;
    }

    public boolean validarGenero(char genero) {
        genero = Character.toUpperCase(genero);
        return genero == 'F' || genero == 'M';
    }
}
