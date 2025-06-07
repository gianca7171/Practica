import graph.GraphAnalyzer;
import graph.GraphLink;

public class AppGraphAnalyzer {
    public static void main(String[] args) {
        // Crear un grafo no dirigido usando GraphLink
        GraphLink<String> grafo = new GraphLink<>();

        // Insertar vértices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");

        // Insertar aristas para formar un ciclo (A-B-C-D-A)
        grafo.insertEdge("A", "B");
        grafo.insertEdge("B", "C");
        grafo.insertEdge("C", "D");
        grafo.insertEdge("D", "A");

        // Mostrar el grafo
        System.out.println("==== GRAFO ====");
        System.out.println(grafo);

        // Calcular el grado de cada nodo
        System.out.println("\n==== GRADO DE CADA NODO ====");
        for (String v : new String[]{"A", "B", "C", "D"}) {
            System.out.println("Grado de " + v + ": " + GraphAnalyzer.grado(grafo, v));
        }

        // Verificar si es un camino
        System.out.println("\n¿Es CAMINO (Px)?: " + GraphAnalyzer.esCamino(grafo));

        // Verificar si es un ciclo
        System.out.println("¿Es CICLO (Cx)?: " + GraphAnalyzer.esCiclo(grafo));

        // Verificar si es una rueda (debería ser falso en este caso)
        System.out.println("¿Es RUEDA (Wx)?: " + GraphAnalyzer.esRueda(grafo));

        // Verificar si es completo (debería ser falso)
        System.out.println("¿Es COMPLETO (Kx)?: " + GraphAnalyzer.esCompleto(grafo));
    }
}
