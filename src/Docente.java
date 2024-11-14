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

    public Docente(String RUN, String nombreCompleto, char genero,  String profesion) {
        super(RUN, nombreCompleto, genero);
        this.profesion = profesion;
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
                "docente= " + super.toString() +'\'' +
                "profesion='" + profesion + '\'' +
                '}';
    }

    @Override
    public boolean validarRut(String rut) {
        if(super.validarRut(rut)){
            return true;
        }
        System.out.println("RUN de docente invalido!");
        return false;
    }

    @Override
    public boolean verificarExisteRun(ArrayList<Usuario> usuarios, String rut) {
        if(super.verificarExisteRun(usuarios, rut)){
            System.out.println("Docente "+getNombreCompleto()+" ya existe");
            return true;
        }
        return false;
    }

    @Override
    public boolean validarGenero(char genero) {
        if(!super.validarGenero(genero)){
            System.out.println("Genero debe ser 'M' o 'F'");
            return false;
        }
        return true;
    }

}
