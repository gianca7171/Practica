import graph.GraphLink;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        GraphLink<String> g = new GraphLink<>();

        // Insertar vértices
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");
        g.insertVertex("F");

        // Insertar aristas
        g.insertEdge("A", "B");
        g.insertEdge("A", "C");
        g.insertEdge("B", "D");
        g.insertEdge("C", "D");
        g.insertEdge("D", "E");
        g.insertEdge("E", "F");

        System.out.println("Grafo original:");
        System.out.println(g);

        // Recorrido DFS desde A
        System.out.println("DFS desde A:");
        g.dfs("A");

        // Buscar vértices y aristas
        System.out.println("\n¿Existe vértice E?: " + g.searchVertex("E"));
        System.out.println("¿Existe vértice X?: " + g.searchVertex("X"));
        System.out.println("¿Existe arista C-D?: " + g.searchEdge("C", "D"));
        System.out.println("¿Existe arista B-E?: " + g.searchEdge("B", "E"));

        // Eliminar una arista
        System.out.println("\nEliminando arista C-D...");
        g.removeEdge("C", "D");

        System.out.println("DFS desde A tras eliminar C-D:");
        g.dfs("A");

        // Eliminar un vértice
        System.out.println("\nEliminando vértice D...");
        g.removeVertex("D");

        // Estado final del grafo
        System.out.println("\nGrafo final:");
        System.out.println(g);

        // ========== EJERCICIO 1 ==========

        System.out.println("==== EJERCICIO 1 ====");

        System.out.println("BFS desde A:");
        g.bfs("A");

        System.out.println("Camino más corto de A a F:");
        ArrayList<String> camino = g.bfsPath("A", "F");

        if (camino != null) {
            System.out.println(camino);
        } else {
            System.out.println("No existe camino.");
        }

        System.out.println("Camino más corto de A a D:");
        ArrayList<String> camino2 = g.bfsPath("A", "D");

        if (camino2 != null) {
            System.out.println(camino2);
        } else {
            System.out.println("No existe camino.");
        }

        // ========== EJERCICIO 2 ==========

        System.out.println("==== EJERCICIO 2 ====");

        // Insertar aristas con pesos
        g.insertEdgeWeight("A", "F", 3);
        g.insertEdgeWeight("B", "E", 2);
        g.insertEdgeWeight("C", "F", 5);

        System.out.println("Grafo con aristas ponderadas:");
        System.out.println(g);

        // Probar shortPath (sin considerar peso)
        System.out.println("shortPath de A a F:");
        ArrayList<String> rutaSimple = g.shortPath("A", "F");
        System.out.println(rutaSimple);

        // Probar isConexo()
        System.out.println("¿Es conexo el grafo?: " + g.isConexo());

        // Probar Dijkstra (considerando pesos)
        System.out.println("Dijkstra de A a F:");
        java.util.Stack<String> rutaPesada = g.dijkstra("A", "F");

        if (rutaPesada != null) {
            while (!rutaPesada.isEmpty()) {
                System.out.print(rutaPesada.pop() + " ");
            }
            System.out.println();
        } else {
            System.out.println("No existe camino.");
        }
    }
}
