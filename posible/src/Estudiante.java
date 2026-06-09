import java.io.Serializable;

public class Estudiante extends Persona implements Serializable {

    private String matricula;
    private double indice;

    public Estudiante(String nombre, int edad, String matricula, double indice) {
        super(nombre, edad);
        this.matricula = matricula;
        this.indice = indice;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula +
                "\nNombre: " + nombre +
                "\nEdad: " + edad +
                "\nIndice: " + indice +
                "\n-------------------------";
    }
}