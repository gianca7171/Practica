import graph.GraphLink;
import graph.GraphPresenter;

public class AppGraphPresenter {
    public static void main(String[] args) {
        // Crear el grafo usando GraphLink (no dirigido)
        GraphLink<String> grafo = new GraphLink<>();

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

        // Mostrar representación formal
        GraphPresenter.mostrarFormal(grafo);

        // Mostrar lista de adyacencias
        GraphPresenter.mostrarAdyacencias(grafo);

        // Mostrar matriz de adyacencia
        GraphPresenter.mostrarMatrizAdyacencia(grafo);
    }
}
