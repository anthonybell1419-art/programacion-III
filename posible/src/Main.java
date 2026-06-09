import java.util.Scanner;

public class Main {

public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GestorEstudiantes gestor =
                new GestorEstudiantes();

        gestor.cargarArchivo();

        HiloRespaldo hilo =
                new HiloRespaldo(gestor);

        hilo.setDaemon(true);
        hilo.start();

        int opcion;

        do {

        System.out.println("\n===== MENU =====");
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Buscar estudiante");
        System.out.println("3. Eliminar estudiante");
        System.out.println("4. Mostrar estudiantes");
        System.out.println("5. Guardar archivo");
        System.out.println("6. Salir");

        System.out.print("Opcion: ");
        opcion = sc.nextInt();
        sc.nextLine();

        try {

                switch (opcion) {

                case 1:

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Matricula: ");
                        String matricula = sc.nextLine();

                        System.out.print("Indice: ");
                        double indice = sc.nextDouble();

                        Estudiante estudiante =
                                new Estudiante(
                                        nombre,
                                        edad,
                                        matricula,
                                        indice);

                        gestor.agregar(estudiante);

                        System.out.println(
                                "Estudiante agregado correctamente."
                        );

                        break;

                case 2:

                        System.out.print(
                                "Digite la matricula: ");

                        matricula = sc.nextLine();

                        System.out.println(
                                gestor.buscar(matricula)
                        );

                        break;

                case 3:

                        System.out.print(
                                "Digite la matricula: ");

                        matricula = sc.nextLine();

                        gestor.eliminar(matricula);

                        System.out.println(
                                "Estudiante eliminado."
                        );

                        break;

                case 4:

                        gestor.mostrar();

                        break;

                case 5:

                        gestor.guardarArchivo();

                        System.out.println(
                                "Archivo guardado."
                        );

                        break;

                case 6:

                        gestor.guardarArchivo();

                        System.out.println(
                                "Saliendo..."
                        );

                        break;

                default:

                        System.out.println(
                                "Opcion invalida."
                        );
                }

        } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
        }

        } while (opcion != 6);

        sc.close();
}
}