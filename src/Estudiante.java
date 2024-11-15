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
}
