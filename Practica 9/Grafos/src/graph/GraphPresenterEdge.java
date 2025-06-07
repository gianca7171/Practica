package graph;

import java.util.ArrayList;

public class GraphPresenterEdge {

    // Muestra la representación formal: lista de vértices y lista de aristas
    public static <V, E> void mostrarFormal(GraphListEdge<V, E> grafo) {
        System.out.println("=== Representación Formal con GraphListEdge ===");

        // Mostrar los vértices
        System.out.print("Vértices: ");
        for (int i = 0; i < grafo.secVertex.size(); i++) {
            System.out.print(grafo.secVertex.get(i).getInfo());
            if (i < grafo.secVertex.size() - 1) System.out.print(", ");
        }
        System.out.println();

        // Mostrar las aristas como pares (v1 - v2)
        System.out.print("Aristas: ");
        for (EdgeObj<V, E> edge : grafo.secEdge) {
            V v1 = edge.getEndVertex1().getInfo();
            V v2 = edge.getEndVertex2().getInfo();

            // Para evitar repeticiones, mostramos solo si v1 < v2 alfabéticamente
            if (v1.toString().compareTo(v2.toString()) < 0) {
                System.out.print("(" + v1 + " - " + v2 + ") ");
            }
        }
        System.out.println("\n");
    }

    // Muestra la lista de adyacencias para cada vértice
    public static <V, E> void mostrarAdyacencias(GraphListEdge<V, E> grafo) {
        System.out.println("=== Lista de Adyacencias con GraphListEdge ===");

        // Por cada vértice, buscamos sus vecinos
        for (VertexObj<V, E> v : grafo.secVertex) {
            System.out.print(v.getInfo() + " → ");

            ArrayList<V> vecinos = new ArrayList<>();

            for (EdgeObj<V, E> edge : grafo.secEdge) {
                if (edge.getEndVertex1().equals(v)) {
                    vecinos.add(edge.getEndVertex2().getInfo());
                } else if (edge.getEndVertex2().equals(v)) {
                    vecinos.add(edge.getEndVertex1().getInfo());
                }
            }

            for (int i = 0; i < vecinos.size(); i++) {
                System.out.print(vecinos.get(i));
                if (i < vecinos.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }

        System.out.println();
    }

    // Muestra la matriz de adyacencia (0 y 1)
    public static <V, E> void mostrarMatrizAdyacencia(GraphListEdge<V, E> grafo) {
        System.out.println("=== Matriz de Adyacencia con GraphListEdge ===");

        int n = grafo.secVertex.size();

        // Mostrar cabecera de columnas
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.print(grafo.secVertex.get(i).getInfo() + " ");
        }
        System.out.println();

        // Construir la matriz
        for (int i = 0; i < n; i++) {
            VertexObj<V, E> fila = grafo.secVertex.get(i);
            System.out.print(fila.getInfo() + " | ");

            for (int j = 0; j < n; j++) {
                VertexObj<V, E> columna = grafo.secVertex.get(j);
                int conectado = 0;

                for (EdgeObj<V, E> edge : grafo.secEdge) {
                    if ((edge.getEndVertex1().equals(fila) && edge.getEndVertex2().equals(columna)) ||
                        (edge.getEndVertex1().equals(columna) && edge.getEndVertex2().equals(fila))) {
                        conectado = 1;
                        break;
                    }
                }

                System.out.print(conectado + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}
