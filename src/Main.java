import java.util.ArrayList;
import java.util.GregorianCalendar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //Catalogo de libros
        Libro lib1 = new Libro(11111,"Don Quijote de la Mancha","Miguel de Cervantes",10,10,"https://www.planetadelibros.com/libro-don-quijote-de-la-mancha/197057");
        Libro lib2 = new Libro(22222,"Orgullo y prejuicio","Jane Austen",5,5,"https://www.planetadelibros.com/libro-orgullo-y-prejuicio/61382");
        Libro lib3 = new Libro(33333,"Frankenstein","Mary Shelley",5,5,"https://www.planetadelibros.com/libro-frankenstein/190884");
        Libro lib4 = new Libro(44444,"Las mil y una noches","Anonimo",3,3,"https://www.planetadelibros.com/libro-las-mil-y-una-noches/255855");

        Estudiante est1 = new Estudiante("18528468-9","Juan Perez",'M',"Ingenieria informatica");
        Estudiante est2 = new Estudiante("113539297-9","Juan Perez",'F',"Ingenieria informatica");
        Estudiante est3 = new Estudiante("17767354-4","Juan Perez",'F',"Ingenieria informatica");
        Estudiante est4 = new Estudiante("16638643-8","Juan Perez",'M',"Ingenieria informatica");

        Prestamo prestamoEst2 = new Prestamo(est2,lib1,new GregorianCalendar(2024,11,14),null);




        //Usuario user1 = new Estudiante("18528468-9","Juan Perez",'M',null,"Ingenieria informatica");
        //ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(est1);
        usuarios.add(est2);
        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(lib1);
        libros.add(lib2);
        libros.add(lib3);
        libros.add(lib4);

        //estudiantes.add(est1);

        //System.out.println(Usuario.validarRut("11111111-1"));
        est1.validarRut("12334");
        est1.verificarExisteRun(usuarios,"18528468-9");
        est1.validarGenero('m');

    }
}

