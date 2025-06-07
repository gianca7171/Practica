package graph;

public class GraphAnalyzer {

    // Método que devuelve el grado (cantidad de conexiones) de un nodo v
    public static <E> int grado(GraphLink<E> grafo, E v) {
        Vertex<E> vertex = grafo.getVertex(v);
        if (vertex == null) return -1; // Si no existe, retorna -1
        return vertex.getListAdj().size(); // Cantidad de aristas conectadas
    }

    // Verifica si el grafo es un camino (Px): todos conectados, extremos con grado 1, intermedios con grado 2
    public static <E> boolean esCamino(GraphLink<E> grafo) {
        int grado1 = 0;
        int grado2 = 0;

        // Recorre todos los vértices del grafo
        for (int i = 0; i < grafo.listVertex.size(); i++) {
            int g = grafo.listVertex.get(i).getListAdj().size();

            if (g == 1) grado1++;     // Nodo de inicio o fin
            else if (g == 2) grado2++; // Nodo intermedio
            else return false;        // Si tiene otro grado, no es camino
        }

        // Un camino válido tiene exactamente 2 nodos con grado 1 y el resto con grado 2
        return grado1 == 2 && (grado1 + grado2 == grafo.listVertex.size());
    }

    // Verifica si el grafo es un ciclo (Cx): todos los nodos tienen grado 2
    public static <E> boolean esCiclo(GraphLink<E> grafo) {
        for (int i = 0; i < grafo.listVertex.size(); i++) {
            if (grafo.listVertex.get(i).getListAdj().size() != 2)
                return false; // Si algún vértice no tiene grado 2, no es ciclo
        }
        return true;
    }

    // Verifica si el grafo es una rueda (Wx): un nodo conectado con todos y el resto forma un ciclo
    public static <E> boolean esRueda(GraphLink<E> grafo) {
        int n = grafo.listVertex.size();
        if (n < 4) return false; // Se necesita al menos 4 vértices para formar una rueda

        int centro = -1;
        int contadorCentro = 0;

        // Buscar nodo central que esté conectado con todos los demás
        for (int i = 0; i < n; i++) {
            int grado = grafo.listVertex.get(i).getListAdj().size();
            if (grado == n - 1) {
                centro = i;
                contadorCentro++;
            }
        }

        if (contadorCentro != 1) return false; // Debe haber exactamente un centro

        // Verifica que los demás nodos formen un ciclo (grado 3: centro + dos vecinos en el ciclo)
        for (int i = 0; i < n; i++) {
            if (i == centro) continue;
            int g = grafo.listVertex.get(i).getListAdj().size();
            if (g != 3) return false;
        }

        return true;
    }

    // Verifica si el grafo es completo (Kx): todos conectados con todos (n*(n-1)/2 aristas)
    public static <E> boolean esCompleto(GraphLink<E> grafo) {
        int n = grafo.listVertex.size();
        int aristasEsperadas = n * (n - 1) / 2;
        int aristasActuales = 0;

        // Recorre todos los vértices y cuenta la cantidad total de conexiones
        for (int i = 0; i < n; i++) {
            aristasActuales += grafo.listVertex.get(i).getListAdj().size();
        }

        // Como el grafo es no dirigido, cada arista fue contada dos veces, por eso se divide entre 2
        aristasActuales /= 2;

        return aristasActuales == aristasEsperadas;
    }
}