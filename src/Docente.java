/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Docente extends Usuario {
    private String profesion;
    private String grado;

    public Docente(String RUN, String nombreCompleto, char genero, String profesion,String grado) {
        super(RUN, nombreCompleto, genero);
        this.profesion = profesion;
        this.grado = grado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "docente: " + super.toString() +" " +
                "grado: " + grado + " " +
                "profesion: " + profesion + " " +
                "} \n";
    }

    public static Usuario crearUsuario(String RUN, String nombreCompleto, char genero, String profesion, String grado) {
        if(!validarRut(RUN)){
            System.out.println("Rut invalido");
            return null;
        }
        if(!validarGenero(genero)){
            System.out.println("Genero Invalido");
            return null;
        }
        Docente usuario = new Docente(RUN,nombreCompleto,genero,profesion,grado);

        return usuario;
    }
}
