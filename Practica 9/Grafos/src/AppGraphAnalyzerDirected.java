import graph.GraphAnalyzerDirected;
import graph.GraphLink;

public class AppGraphAnalyzerDirected {
    public static void main(String[] args) {
        // Crear un grafo dirigido (simulamos dirección agregando solo una arista por relación)
        GraphLink<String> grafo = new GraphLink<>();

        // Insertar vértices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");

        // Insertar aristas dirigidas manualmente (solo una dirección)
        grafo.insertEdge("A", "B"); // A → B
        grafo.insertEdge("B", "C"); // B → C
        grafo.insertEdge("C", "D"); // C → D

        // Mostrar el grafo
        System.out.println("==== GRAFO DIRIGIDO SIMULADO ====");
        System.out.println(grafo);

        // Calcular grados de entrada y salida
        System.out.println("==== GRADO DE ENTRADA Y SALIDA ====");
        for (String v : new String[]{"A", "B", "C", "D"}) {
            int entrada = GraphAnalyzerDirected.gradoEntrada(grafo, v);
            int salida = GraphAnalyzerDirected.gradoSalida(grafo, v);
            System.out.println(v + " → entrada: " + entrada + ", salida: " + salida);
        }

        // Verificar si es un camino dirigido
        System.out.println("\n¿Es CAMINO dirigido (Px)?: " + GraphAnalyzerDirected.esCaminoDirigido(grafo));

        // Verificar si es ciclo dirigido
        System.out.println("¿Es CICLO dirigido (Cx)?: " + GraphAnalyzerDirected.esCicloDirigido(grafo));

        // Verificar si es rueda dirigida
        System.out.println("¿Es RUEDA dirigida (Wx)?: " + GraphAnalyzerDirected.esRuedaDirigida(grafo));
    }
}
