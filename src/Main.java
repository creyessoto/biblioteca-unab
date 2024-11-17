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

        Estudiante est1 = new Estudiante("18528468-9","Camilo Reyes",'M',"Ingenieria informatica");
        Estudiante est2 = new Estudiante("113539297-9","Juanita Perez",'F',"Ingenieria informatica");
        Docente doce1 = new Docente("17767354-4","Maria Paz",'F',"Medico Cirujano","Dr");
        Docente doce2 = new Docente("16638643-8","Armando Casas",'M',"Traumatologo","Dr");
        est2.setPrestamo(11111);
        doce2.setPrestamo(33333);

        Devolucion devolucion1 = new Devolucion(11111,"113539297-9",new GregorianCalendar(2024,10,15));
        Devolucion devolucion2 = new Devolucion(33333,"17767354-4",new GregorianCalendar(2024,9,20));


        Prestamo prestamo1 = new Prestamo(est2,lib1,new GregorianCalendar(2024,11,1),devolucion1);
        Prestamo prestamo2 = new Prestamo(doce1,lib3,new GregorianCalendar(2024,9,14),devolucion2);




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

        ArrayList<Prestamo> prestamos = new ArrayList<>();
        prestamos.add(prestamo1);
        prestamos.add(prestamo2);

        ArrayList<Devolucion> devoluciones = new ArrayList<>();
        devoluciones.add(devolucion1);
        devoluciones.add(devolucion2);


        //System.out.println(libros);

        //System.out.println(usuarios);

        while (!salir) {
            System.out.println("===========================");
            System.out.println("SISTEMA DE BIBLIOTECA UNAB");
            System.out.println("===========================");
            System.out.println("");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Editar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Agregar Libro");
            System.out.println("5. Eliminar Libro");
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
                        System.out.println("Ingrese RUN: (ejemplo: 12345678-9)");
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
                        System.out.println("Ingrese RUN de usuario: (ejemplo: 12345678-9)");
                        datos = sn.next();
                        if (!Usuario.validarRut(datos)) {
                            break;
                        }
                        run = Usuario.formatearRun(datos);
                        if (!Usuario.verificarExisteRun(usuarios, run)) {
                            break;
                        }
                        System.out.println("Ingrese nuevo Nombre: ");
                        sn.nextLine();
                        String nombreNuevo = sn.nextLine();
                        Usuario.editarUsuario(run,nombreNuevo,usuarios);
                        System.out.println("Usuario actualizado");
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
                            }else {
                            System.out.println("No existen usuarios con ese RUN");
                        }
                        break;
                    case 4:
                        System.out.println("Agregar Libro");
                        System.out.println("Ingrese ISBN: (ejemplo: 123456");
                        int isbn = sn.nextInt();
                        if(!Libro.verificarExisteIsbn(libros,isbn)){
                            sn.nextLine();
                            System.out.println("Ingrese Titulo del libro");
                            String titulo = sn.nextLine();
                            System.out.println("Ingrese autor del libro");
                            String autor = sn.nextLine();
                            System.out.println("Ingrese la cantidad de libros disponibles");
                            int cantidad = sn.nextInt();
                            sn.nextLine();
                            System.out.println("Ingrese URL de la imagen");
                            String imagen = sn.nextLine();
                            Libro libro = Libro.agregarLibro(isbn,titulo,autor,cantidad,imagen);
                            libros.add(libro);
                            System.out.println("Libro agregado!");
                        }else{
                            System.out.println("Libro ya existe");
                        }
                        break;
                    case 5:
                        System.out.println("Eliminar Libro");
                        System.out.println("");
                        System.out.println("Ingrese ISBN: (ejemplo: 123456");
                        int ISBN = sn.nextInt();
                        if (Libro.verificarExisteIsbn(libros,ISBN)) {
                            libros = Libro.eliminarLibro(libros,ISBN);
                        }else{
                            System.out.println("Libro no existe");
                        }
                        break;
                    case 6:
                        System.out.println("Generar Prestamo");
                        System.out.println("Ingrese ISBN de libro a solicitar: (ejemplo: 123456)");
                        int codLibro = sn.nextInt();
                        if(Libro.verificarExisteIsbn(libros,codLibro)) {
                            sn.nextLine();
                            System.out.println("Ingrese Rut del solicitante");
                            datos = sn.nextLine();
                            run = Usuario.formatearRun(datos);
                            if (Usuario.verificarExisteRun(usuarios, run)) {
                                System.out.println("Ingrese la cantidad de dias que necesita reservar el libro");
                                System.out.println("Para Docentes maximo 20 dias, Estudiantes 10 dias maximo");
                                int dias = sn.nextInt();
                                if(!Prestamo.validarDias(run,usuarios,dias)){
                                    break;
                                }
                                Prestamo prestamo = Prestamo.ingresarPrestamo(codLibro, run, libros, usuarios,dias,devoluciones);
                                if (prestamo != null) {
                                    prestamos.add(prestamo);
                                    System.out.println("Prestamo creado!");
                                    Prestamo.imprimirPrestamo(prestamo,devoluciones);
                                }
                            }
                        }else {
                            System.out.println("No existe libro");
                        }

                        break;
                    case 7:
                        System.out.println("Devolver Libro");
                        System.out.println("Ingrese ISBN de libro a devolver: (ejemplo: 123456)");
                        int codLibroDev = sn.nextInt();
                        if(Libro.verificarExisteIsbn(libros,codLibroDev)) {
                            sn.nextLine();
                            System.out.println("Ingrese Rut del solicitante");
                            datos = sn.nextLine();
                            run = Usuario.formatearRun(datos);
                            if (Usuario.verificarExisteRun(usuarios, run)) {
                                if(Prestamo.buscarPrestamo(codLibroDev,run,prestamos)==null){
                                    System.out.println("No existen Prestamos asociados");
                                    break;
                                }else {
                                    Prestamo.ingresarDevolucion(codLibroDev, run, prestamos, devoluciones);
                                }
                            }
                        }
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

