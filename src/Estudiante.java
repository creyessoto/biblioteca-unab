/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Estudiante extends Usuario {
    private String carrera;


    public Estudiante(String RUN, String nombreCompleto, char genero, String carrera) {
        super(RUN, nombreCompleto, genero);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "estudiante= " + super.toString() +'\'' +
                "carrera='" + carrera + '\'' +
                '}';
    }

    @Override
    public boolean validarRut(String rut) {
        if(super.validarRut(rut)){
            return true;
        }
        System.out.println("RUN de estudiante invalido!");
        return false;
    }

    @Override
    public boolean verificarExisteRun(ArrayList<Usuario> usuarios, String rut) {
        if(super.verificarExisteRun(usuarios, rut)){
            System.out.println("Estudiante "+getNombreCompleto()+" ya existe");
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
