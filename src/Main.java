import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        int tipo;
        String datos;
        String nombre;
        String profesion;
        String carrera;
        String grado;
        String run;

        //Catalogo de libros
        Libro lib1 = new Libro(11111,"Don Quijote de la Mancha","Miguel de Cervantes",10,4,"https://www.planetadelibros.com/libro-don-quijote-de-la-mancha/197057");
        Libro lib2 = new Libro(22222,"Orgullo y prejuicio","Jane Austen",5,5,"https://www.planetadelibros.com/libro-orgullo-y-prejuicio/61382");
        Libro lib3 = new Libro(33333,"Frankenstein","Mary Shelley",5,0,"https://www.planetadelibros.com/libro-frankenstein/190884");
        Libro lib4 = new Libro(44444,"Las mil y una noches","Anonimo",3,1,"https://www.planetadelibros.com/libro-las-mil-y-una-noches/255855");

        Estudiante est1 = new Estudiante("18528468-9","Juan Perez",'M',"Ingenieria informatica");
        Estudiante est2 = new Estudiante("113539297-9","Juan Perez",'F',"Ingenieria informatica");
        Docente doce1 = new Docente("17767354-4","Juan Perez",'F',"Medico Cirujano","Dr");
        Docente doce2 = new Docente("16638643-8","Juan Perez",'M',"Traumatologo","Dr");

        Prestamo prestamoEst2 = new Prestamo(est2,lib1,new GregorianCalendar(2024,11,14),null);




        //Usuario user1 = new Estudiante("18528468-9","Juan Perez",'M',"Ingenieria informatica");
        //ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(est1);
        usuarios.add(est2);
        usuarios.add(doce1);
        usuarios.add(doce2);
        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(lib1);
        libros.add(lib2);
        libros.add(lib3);
        libros.add(lib4);

        //estudiantes.add(est1);

        //System.out.println(Usuario.validarRut("11111111-1"));
        System.out.println(Estudiante.validarRut("11111111-1"));
        Estudiante.verificarExisteRun(usuarios,"18528468-9");
        Docente.validarGenero('X');
        System.out.println(Prestamo.ingresarPrestamo(11111,"18528468-9",libros,usuarios));
        System.out.println(libros);

        System.out.println("Borrar usuario 2");
        //Usuario.eliminarUsuario(usuarios,"113539297-9");
        System.out.println(usuarios);

        /*
        Usuarios
        crearUsuario()
        editarUsuario()
        eliminarusuario()
        listarUsuarios()

        Libro
        AgregarLibro()
        eliminarLibro()
        listarLibro()

        crearPrestamo()
        devolverLibro()

        Prestamo y Devolucion
        crearPrestamo()
        devolverLibro()
         */

        while (!salir) {
            System.out.println("===========================");
            System.out.println("SISTEMA DE BIBLIOTECA UNAB");
            System.out.println("===========================");
            System.out.println("");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Editar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Agregar Libro");
            System.out.println("5. Eliminar Libro 3");
            System.out.println("6. Generar Prestamo");
            System.out.println("7. Devolver Libro");
            System.out.println("8. Listar Usuarios");
            System.out.println("9. Listar Libros");

            System.out.println("10. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Crear Usuario");
                        System.out.println("");
                        System.out.println("Ingrese RUN: (ejemplo: 12345678-9");
                        datos = sn.next();
                        if (!Usuario.validarRut(datos)) {
                            break;
                        }
                        run = Usuario.formatearRun(datos);
                        if (Usuario.verificarExisteRun(usuarios, run)) {
                            break;
                        }
                        System.out.println("Ingrese genero: (ejemplo: M o F)");
                        char g = sn.next().charAt(0);
                        if (!Usuario.validarGenero(g)) {
                            break;
                        }
                        sn.nextLine();
                        System.out.println("Ingrese nombre completo:");
                        nombre= sn.nextLine();
                        System.out.println("ingrese tipo de Usuario a crear: 1.Estudiante 2.Docente");
                        tipo = sn.nextInt();
                        switch (tipo) {
                            case 1:
                                sn.nextLine();
                                System.out.println("Ingrese carrera la cual pertenece");
                                carrera= sn.nextLine();
                                Usuario estudiante = Estudiante.crearUsuario(run,nombre,g,carrera);
                                if(estudiante != null){
                                    System.out.println("Usuario agregado!");
                                    usuarios.add(estudiante);
                                }
                                break;
                            case 2:
                                sn.nextLine();
                                System.out.println("Ingrese su profesion");
                                profesion= sn.nextLine();
                                System.out.println("Ingrese su grado academico");
                                grado= sn.nextLine();
                                Usuario docente = Docente.crearUsuario(run,nombre,g,profesion,grado);
                                if(docente != null) {
                                    System.out.println("Usuario agregado!");
                                    usuarios.add(docente);
                                }
                                break;
                            default:
                                System.out.println("Solo números entre 1 y 2");
                        }

                        break;
                    case 2:
                        System.out.println("Editar Usuario ");
                        break;
                    case 3:
                        System.out.println("Eliminar Usuario");
                        System.out.println("");
                        System.out.println("Ingrese RUN: (ejemplo: 12345678-9");
                        datos = sn.next();
                        if (!Usuario.validarRut(datos)) {
                            break;
                        }
                        run = Usuario.formatearRun(datos);
                        if (Usuario.verificarExisteRun(usuarios, run)) {
                            usuarios = Usuario.eliminarUsuario(usuarios, run);
                            System.out.println("Usuario Eliminado");
                            }else {
                            System.out.println("No existen usuarios con ese RUN");
                        }
                        break;
                    case 4:
                        System.out.println("Agregar Libro");
                        break;
                    case 5:
                        System.out.println("Eliminar Libro");
                        break;
                    case 6:
                        System.out.println("Generar Prestamo");
                        break;
                    case 7:
                        System.out.println("Devolver Libro");
                        break;
                    case 8:
                        System.out.println("Listar Usuarios");
                        System.out.println(usuarios.toString());
                        break;
                    case 9:
                        System.out.println("Listar Libros");
                        System.out.println(libros.toString());
                        break;
                    case 10:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 10");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }




    }
}

