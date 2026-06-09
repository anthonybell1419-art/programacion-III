import java.io.*;
import java.util.ArrayList;

public class GestorEstudiantes {

    private ArrayList<Estudiante> lista;

    public GestorEstudiantes() {
        lista = new ArrayList<>();
    }

    public void agregar(Estudiante e) {
        lista.add(e);
    }

    public Estudiante buscar(String matricula)
            throws EstudianteNoEncontradoException {

        for (Estudiante e : lista) {
            if (e.getMatricula().equals(matricula)) {
                return e;
            }
        }

        throw new EstudianteNoEncontradoException("Estudiante no encontrado."
        );
    }

    public void eliminar(String matricula)
            throws EstudianteNoEncontradoException {

        Estudiante e = buscar(matricula);
        lista.remove(e);
    }

    public void mostrar() {

        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante e : lista) {
            System.out.println(e);
        }
    }

    public void guardarArchivo() {

        try {

            ObjectOutputStream salida =
                    new ObjectOutputStream(
                            new FileOutputStream("estudiantes.dat"));

            salida.writeObject(lista);

            salida.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarArchivo() {

        try {

            ObjectInputStream entrada =
                    new ObjectInputStream(
                            new FileInputStream("estudiantes.dat"));

            lista = (ArrayList<Estudiante>) entrada.readObject();

            entrada.close();

            System.out.println("Archivo cargado correctamente.");

        } catch (Exception e) {
            System.out.println("No existe archivo previo.");
        }
    }
}