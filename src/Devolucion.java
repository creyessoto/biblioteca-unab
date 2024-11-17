/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Devolucion {

    private int ISBN;
    private String RUN;
    private int multa;
    private GregorianCalendar fecha;

    public Devolucion(int ISBN, String RUN, int multa, GregorianCalendar fecha) {
        this.ISBN = ISBN;
        this.RUN = RUN;
        this.multa = multa;
        this.fecha = fecha;
    }
    public Devolucion(){

    }
    public Devolucion( int isbn,String RUN, GregorianCalendar fecha) {
        this.ISBN = isbn;
        this.RUN = RUN;
        this.multa = 0;
        this.fecha = fecha;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getRUN() {
        return RUN;
    }

    public void setRUN(String RUN) {
        this.RUN = RUN;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Devolucion{" +
                "ISBN=" + ISBN +
                ", RUN='" + RUN + '\'' +
                ", multa=" + multa +
                ", fecha=" + fecha +
                '}';
    }

    public static Devolucion buscarDevolucion(String rut, int isbn, ArrayList<Devolucion> devoluciones){
        for (int i = 0; i < devoluciones.size(); i++) {
            Devolucion devolucion = devoluciones.get(i);
            if(devolucion.getRUN().equals(rut) && devolucion.getISBN() == isbn){
                return devolucion;
            }
        }
        return null;
    }
}
