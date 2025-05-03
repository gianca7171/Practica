import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase principal con menú interactivo para gestionar tareas
public class App {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        List<Tarea> tareasCompletadas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú principal
            System.out.println("\n--- MENÚ DE TAREAS ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Ver si contiene una tarea");
            System.out.println("4. Obtener tarea más prioritaria");
            System.out.println("5. Invertir lista de tareas");
            System.out.println("6. Mostrar tareas pendientes");
            System.out.println("7. Mostrar tareas completadas");
            System.out.println("8. Contar tareas pendientes");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    // Agregar nueva tarea
                    System.out.print("Título de la tarea: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Prioridad (número): ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine();
                    gestor.agregarTarea(new Tarea(titulo, prioridad));
                    System.out.println("Tarea agregada.");
                    break;
                case 2:
                    // Eliminar tarea
                    System.out.print("Título de la tarea a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    System.out.print("Prioridad exacta: ");
                    int prioridadEliminar = scanner.nextInt();
                    scanner.nextLine();
                    Tarea tareaEliminar = new Tarea(tituloEliminar, prioridadEliminar);
                    if (gestor.eliminarTarea(tareaEliminar)) {
                        tareasCompletadas.add(tareaEliminar);
                        System.out.println("Tarea eliminada y marcada como completada.");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 3:
                    // Buscar tarea
                    System.out.print("Título de la tarea a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    System.out.print("Prioridad exacta: ");
                    int prioridadBuscar = scanner.nextInt();
                    scanner.nextLine();
                    boolean existe = gestor.contieneTarea(new Tarea(tituloBuscar, prioridadBuscar));
                    System.out.println(existe ? "Sí contiene esa tarea." : "No contiene esa tarea.");
                    break;
                case 4:
                    // Obtener tarea con mayor prioridad
                    Tarea masPrioritaria = (Tarea) gestor.obtenerTareaMasPrioritaria();
                    System.out.println(masPrioritaria != null ?
                            "Tarea más prioritaria: " + masPrioritaria :
                            "No hay tareas o no son del tipo correcto.");
                    break;
                case 5:
                    // Invertir la lista
                    gestor.invertirTareas();
                    System.out.println("Lista de tareas invertida.");
                    break;
                case 6:
                    // Mostrar pendientes
                    System.out.println("Tareas pendientes:");
                    gestor.imprimirTareas();
                    break;
                case 7:
                    // Mostrar completadas
                    System.out.println("Tareas completadas:");
                    for (Tarea t : tareasCompletadas) {
                        System.out.println(t);
                    }
                    break;
                case 8:
                    // Contar pendientes
                    System.out.println("Total de tareas pendientes: " + gestor.contarTareas());
                    break;
                case 0:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
