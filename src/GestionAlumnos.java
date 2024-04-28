import java.util.ArrayList;
import java.util.Scanner;

public class GestionAlumnos {
    public static void main(String[] args) {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar alumno");
            System.out.println("2. Mostrar lista de alumnos");
            System.out.println("3. Calcular media de notas");
            System.out.println("4. Mostrar alumno con la nota más alta");
            System.out.println("5. Buscar alumno por nombre");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: (Ingrese un numero del 1 al 6)");
            //try {
                int opcion = scanner.nextInt();
            //}catch (){
            //}

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del alumno: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese la edad del alumno: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese la nota del alumno: ");
                    double nota = scanner.nextDouble();
                    listaAlumnos.add(new Alumno(nombre, edad, nota));
                    System.out.println("Alumno agregado correctamente.");
                    break;
                case 2:
                    System.out.println("Lista de alumnos:");
                    for (Alumno alumno : listaAlumnos) {
                        System.out.println("Nombre: " + alumno.getNombre() + ", Edad: " + alumno.getEdad() + ", Nota: " + alumno.getNota());
                    }
                    break;
                case 3:
                    double sumaNotas = 0;
                    for (Alumno alumno : listaAlumnos) {
                        sumaNotas += alumno.getNota();
                    }
                    double mediaNotas = sumaNotas / listaAlumnos.size();
                    System.out.println("La media de notas de todos los alumnos es: " + mediaNotas);
                    break;
                case 4:
                    double notaMasAlta = 0;
                    Alumno alumnoNotaMasAlta = null;
                    for (Alumno alumno : listaAlumnos) {
                        if (alumno.getNota() > notaMasAlta) {
                            notaMasAlta = alumno.getNota();
                            alumnoNotaMasAlta = alumno;
                        }
                    }
                    if (alumnoNotaMasAlta == null){
                        System.out.println("No hay ningun alumno registrado, o las notas ingresadas estan en numeros negativos.");
                        break;
                    }
                    System.out.println("El alumno con la nota más alta es: " + alumnoNotaMasAlta.getNombre() + ", Nota: " + alumnoNotaMasAlta.getNota());
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del alumno a buscar: ");
                    String nombreBusqueda = scanner.next();
                    boolean encontrado = false;
                    for (Alumno alumno : listaAlumnos) {
                        if (alumno.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                            System.out.println("Alumno encontrado:");
                            System.out.println("Nombre: " + alumno.getNombre() + ", Edad: " + alumno.getEdad() + ", Nota: " + alumno.getNota());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Alumno no encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
