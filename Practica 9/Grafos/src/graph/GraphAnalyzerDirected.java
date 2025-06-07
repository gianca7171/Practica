package graph;

public class GraphAnalyzerDirected {

    // Método que devuelve el grado de salida de un nodo (cuántas aristas salen)
    public static <E> int gradoSalida(GraphLink<E> grafo, E v) {
        Vertex<E> vertex = grafo.getVertex(v);
        if (vertex == null) return -1;
        return vertex.getListAdj().size(); // En lista de adyacencia: conexiones salientes
    }

    // Método que devuelve el grado de entrada de un nodo (cuántas aristas llegan)
    public static <E> int gradoEntrada(GraphLink<E> grafo, E v) {
        int contador = 0;

        // Recorremos todos los vértices y sus conexiones
        for (int i = 0; i < grafo.listVertex.size(); i++) {
            Vertex<E> actual = grafo.listVertex.get(i);
            for (int j = 0; j < actual.getListAdj().size(); j++) {
                if (actual.getListAdj().get(j).getRefDest().getData().equals(v)) {
                    contador++; // Si apunta hacia v, incrementamos entrada
                }
            }
        }

        return contador;
    }

    // Verifica si el grafo es un camino dirigido
    public static <E> boolean esCaminoDirigido(GraphLink<E> grafo) {
        int entrada1 = 0;
        int salida1 = 0;
        int intermedios = 0;

        // Evaluar cada nodo
        for (int i = 0; i < grafo.listVertex.size(); i++) {
            E dato = grafo.listVertex.get(i).getData();
            int entrada = gradoEntrada(grafo, dato);
            int salida = gradoSalida(grafo, dato);

            if (entrada == 0 && salida == 1) salida1++;          // Nodo de inicio
            else if (entrada == 1 && salida == 0) entrada1++;     // Nodo de fin
            else if (entrada == 1 && salida == 1) intermedios++;  // Intermedio
            else return false;
        }

        // Validación final: 1 inicio, 1 fin y los demás intermedios
        return entrada1 == 1 && salida1 == 1 &&
               (entrada1 + salida1 + intermedios == grafo.listVertex.size());
    }

    // Verifica si el grafo es un ciclo dirigido: cada nodo tiene entrada 1 y salida 1
    public static <E> boolean esCicloDirigido(GraphLink<E> grafo) {
        for (int i = 0; i < grafo.listVertex.size(); i++) {
            E dato = grafo.listVertex.get(i).getData();
            if (gradoEntrada(grafo, dato) != 1 || gradoSalida(grafo, dato) != 1) {
                return false;
            }
        }
        return true;
    }

    // Verifica si es una rueda dirigida (versión simple: un nodo central con muchas salidas)
    public static <E> boolean esRuedaDirigida(GraphLink<E> grafo) {
        int n = grafo.listVertex.size();
        if (n < 4) return false;

        int centro = 0;

        // Contamos cuántos nodos tienen salida a todos los demás
        for (int i = 0; i < n; i++) {
            if (gradoSalida(grafo, grafo.listVertex.get(i).getData()) == n - 1)
                centro++;
        }

        // Una rueda dirigida simple: solo un nodo con salida a todos los demás
        return centro == 1;
    }
}
