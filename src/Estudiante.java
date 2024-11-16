/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
                "estudiante: " + super.toString() +" " +
                "carrera: " + carrera + " " +
                "} \n";
    }


    public static Usuario crearUsuario(String RUN, String nombreCompleto, char genero, String carrera) {

        if(!validarRut(RUN)){
            System.out.println("Rut invalido");
            return null;
        }
        if(!validarGenero(genero)){
            System.out.println("Genero Invalido");
            return null;
        }
        Estudiante usuario = new Estudiante(RUN,nombreCompleto,genero,carrera);

        return usuario;

    }
}
