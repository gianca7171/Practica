import graph.GraphListEdge;

public class AppGraphListEdge {
    public static void main(String[] args) {
        GraphListEdge<String, String> g = new GraphListEdge<>();

        // Insertar vértices
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");

        // Insertar aristas
        g.insertEdge("A", "B");
        g.insertEdge("A", "C");
        g.insertEdge("B", "D");
        g.insertEdge("C", "D");
        g.insertEdge("D", "E");

        // Mostrar grafo
        System.out.println("==== GRAFO ====");
        System.out.println(g);

        // Buscar vértices
        System.out.println("\n¿Existe el vértice A?: " + g.searchVertex("A"));
        System.out.println("¿Existe el vértice Z?: " + g.searchVertex("Z"));

        // Buscar aristas
        System.out.println("\n¿Existe la arista A-C?: " + g.searchEdge("A", "C"));
        System.out.println("¿Existe la arista B-E?: " + g.searchEdge("B", "E"));

        // Recorrido BFS
        System.out.println("\n==== BFS desde A ====");
        g.bfs("A");
    }
}
