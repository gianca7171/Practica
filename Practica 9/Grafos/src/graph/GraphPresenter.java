package graph;

public class GraphPresenter {

    // Muestra la representación formal del grafo:
    // Lista los vértices y luego las aristas como pares (v1 - v2)
    public static <E> void mostrarFormal(GraphLink<E> grafo) {
        System.out.println("=== Representación Formal ===");

        // Mostrar vértices
        System.out.print("Vértices: ");
        for (int i = 0; i < grafo.listVertex.size(); i++) {
            System.out.print(grafo.listVertex.get(i).getData());
            if (i < grafo.listVertex.size() - 1) System.out.print(", ");
        }
        System.out.println();

        // Mostrar aristas sin repetir (como es no dirigido)
        System.out.print("Aristas: ");
        for (int i = 0; i < grafo.listVertex.size(); i++) {
            Vertex<E> v = grafo.listVertex.get(i);
            for (int j = 0; j < v.getListAdj().size(); j++) {
                E destino = v.getListAdj().get(j).getRefDest().getData();

                // Mostrar solo una vez cada arista
                if (v.getData().toString().compareTo(destino.toString()) < 0) {
                    System.out.print("(" + v.getData() + " - " + destino + ") ");
                }
            }
        }

        System.out.println("\n");
    }

    // Muestra la lista de adyacencias de cada vértice
    public static <E> void mostrarAdyacencias(GraphLink<E> grafo) {
        System.out.println("=== Lista de Adyacencias ===");

        for (int i = 0; i < grafo.listVertex.size(); i++) {
            Vertex<E> v = grafo.listVertex.get(i);
            System.out.print(v.getData() + " → ");

            for (int j = 0; j < v.getListAdj().size(); j++) {
                System.out.print(v.getListAdj().get(j).getRefDest().getData());
                if (j < v.getListAdj().size() - 1) System.out.print(", ");
            }
            System.out.println();
        }

        System.out.println();
    }

    // Muestra la matriz de adyacencia con 0 (no conectado) y 1 (conectado)
    public static <E> void mostrarMatrizAdyacencia(GraphLink<E> grafo) {
        System.out.println("=== Matriz de Adyacencia ===");

        int n = grafo.listVertex.size();

        // Mostrar cabecera de columnas
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.print(grafo.listVertex.get(i).getData() + " ");
        }
        System.out.println();

        // Generar matriz
        for (int i = 0; i < n; i++) {
            Vertex<E> v1 = grafo.listVertex.get(i);
            System.out.print(v1.getData() + " | ");

            for (int j = 0; j < n; j++) {
                Vertex<E> v2 = grafo.listVertex.get(j);

                boolean conectado = false;

                for (int k = 0; k < v1.getListAdj().size(); k++) {
                    if (v1.getListAdj().get(k).getRefDest().equals(v2)) {
                        conectado = true;
                        break;
                    }
                }

                System.out.print((conectado ? "1" : "0") + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}
