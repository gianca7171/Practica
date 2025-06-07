import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import java.util.List;

public class AppJGraphT {
    public static void main(String[] args) {
        // Crear grafo no dirigido simple
        Graph<String, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);

        // Insertar vértices
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addVertex("C");
        grafo.addVertex("D");
        grafo.addVertex("E");

        // Insertar aristas
        grafo.addEdge("A", "B");
        grafo.addEdge("A", "C");
        grafo.addEdge("B", "D");
        grafo.addEdge("C", "D");
        grafo.addEdge("D", "E");

        // Mostrar el grafo
        System.out.println("Grafo con JGraphT:");
        System.out.println("Vértices: " + grafo.vertexSet());
        System.out.println("Aristas: " + grafo.edgeSet());

        // Camino más corto entre A y E
        DijkstraShortestPath<String, DefaultEdge> dijkstra = new DijkstraShortestPath<>(grafo);
        List<String> path = dijkstra.getPath("A", "E").getVertexList();

        System.out.println("Camino más corto de A a E: " + path);
    }
}
