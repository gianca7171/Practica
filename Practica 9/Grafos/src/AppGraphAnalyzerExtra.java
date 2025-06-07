import graph.GraphAnalyzerExtra;
import graph.GraphLink;

public class AppGraphAnalyzerExtra {
    public static void main(String[] args) {
        // Crear el primer grafo (G1)
        GraphLink<String> g1 = new GraphLink<>();
        g1.insertVertex("A");
        g1.insertVertex("B");
        g1.insertVertex("C");
        g1.insertEdge("A", "B");
        g1.insertEdge("B", "C");
        g1.insertEdge("C", "A");

        // Crear el segundo grafo (G2) isomorfo a G1
        GraphLink<String> g2 = new GraphLink<>();
        g2.insertVertex("X");
        g2.insertVertex("Y");
        g2.insertVertex("Z");
        g2.insertEdge("X", "Y");
        g2.insertEdge("Y", "Z");
        g2.insertEdge("Z", "X");

        System.out.println("==== GRAFOS PARA ISOMORFISMO ====");
        System.out.println("G1:\n" + g1);
        System.out.println("G2:\n" + g2);
        System.out.println("¿G1 es isomorfo a G2?: " + GraphAnalyzerExtra.esIsomorfo(g1, g2));

        System.out.println("\n==== CONECTIVIDAD ====");
        System.out.println("¿G1 es conexo?: " + GraphAnalyzerExtra.esConexoDirigido(g1));

        System.out.println("\n==== AUTO-COMPLEMENTARIO ====");
        System.out.println("¿G1 es auto-complementario?: " + GraphAnalyzerExtra.esAutoComplementario(g1));

        System.out.println("\n==== PLANARIDAD (teórico) ====");
        GraphAnalyzerExtra.esPlano();
    }
}
