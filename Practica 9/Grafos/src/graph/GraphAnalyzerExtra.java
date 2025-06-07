package graph;

import java.util.HashSet;

public class GraphAnalyzerExtra {

    // Verifica si dos grafos son isomorfos (misma cantidad de nodos, mismas conexiones)
    public static <E> boolean esIsomorfo(GraphLink<E> g1, GraphLink<E> g2) {
        // Si tienen diferente número de vértices, no son isomorfos
        if (g1.listVertex.size() != g2.listVertex.size()) return false;

        // Si tienen diferente número de aristas, no son isomorfos
        int aristas1 = contarAristas(g1);
        int aristas2 = contarAristas(g2);

        return aristas1 == aristas2;
    }

    // Método auxiliar para contar aristas (en grafo dirigido)
    private static <E> int contarAristas(GraphLink<E> grafo) {
        int total = 0;
        for (int i = 0; i < grafo.listVertex.size(); i++) {
            total += grafo.listVertex.get(i).getListAdj().size();
        }
        return total;
    }

    // Verifica si un grafo dirigido es conexo (algún camino une todos los vértices)
    public static <E> boolean esConexoDirigido(GraphLink<E> grafo) {
        if (grafo.listVertex.size() == 0) return true;

        // Iniciamos desde el primer vértice
        Vertex<E> inicio = grafo.listVertex.get(0);
        HashSet<Vertex<E>> visitados = new HashSet<>();

        // DFS para verificar conectividad
        dfs(inicio, visitados);

        // Si el tamaño del set de visitados es igual al total de vértices, es conexo
        return visitados.size() == grafo.listVertex.size();
    }

    // DFS para marcar nodos visitados
    private static <E> void dfs(Vertex<E> actual, HashSet<Vertex<E>> visitados) {
        visitados.add(actual);

        for (int i = 0; i < actual.getListAdj().size(); i++) {
            Vertex<E> vecino = actual.getListAdj().get(i).getRefDest();
            if (!visitados.contains(vecino)) {
                dfs(vecino, visitados);
            }
        }
    }

    // Verifica si un grafo es auto-complementario (su complemento es isomorfo al original)
    public static <E> boolean esAutoComplementario(GraphLink<E> grafo) {
        // Crear el grafo complemento
        GraphLink<E> complemento = new GraphLink<>();

        // Clonar los vértices
        for (int i = 0; i < grafo.listVertex.size(); i++) {
            complemento.insertVertex(grafo.listVertex.get(i).getData());
        }

        // Insertar todas las posibles aristas que NO existen en el grafo original
        for (int i = 0; i < grafo.listVertex.size(); i++) {
            E v1 = grafo.listVertex.get(i).getData();
            for (int j = 0; j < grafo.listVertex.size(); j++) {
                E v2 = grafo.listVertex.get(j).getData();
                if (!v1.equals(v2) && !grafo.searchEdge(v1, v2)) {
                    complemento.insertEdge(v1, v2);
                }
            }
        }

        // Comparar si el grafo complemento es isomorfo al original
        return esIsomorfo(grafo, complemento);
    }

    // Comprobación teórica (no implementada) de si un grafo es plano
    public static void esPlano() {
        System.out.println("La verificación de si un grafo es plano requiere representación gráfica o análisis de Kuratowski.");
        System.out.println("Este tipo de análisis no se puede automatizar solo con la estructura de datos.");
    }
}
