import graph.GraphListEdge;
import graph.GraphPresenterEdge;

public class AppGraphPresenterEdge {
    public static void main(String[] args) {
        // Crear el grafo no dirigido usando GraphListEdge
        GraphListEdge<String, String> grafo = new GraphListEdge<>();

        // Insertar vértices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");

        // Insertar aristas
        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "C");
        grafo.insertEdge("C", "D");

        // Mostrar representación formal (vértices y aristas)
        GraphPresenterEdge.mostrarFormal(grafo);

        // Mostrar lista de adyacencias por cada vértice
        GraphPresenterEdge.mostrarAdyacencias(grafo);

        // Mostrar matriz de adyacencia en 0s y 1s
        GraphPresenterEdge.mostrarMatrizAdyacencia(grafo);
    }
}
