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
}
