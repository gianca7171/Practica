// Interfaz genérica para una cola de prioridad
public interface PriorityQueue<E, N extends Comparable<N>> {
    void insert(E dato, N prioridad);       // Inserta un dato con su prioridad
    E removeMin();                           // Elimina y retorna el de menor prioridad
    E min();                                 // Retorna el de menor prioridad sin eliminarlo
    boolean isEmpty();                       // Verifica si está vacía
    int size();                              // Retorna el número de elementos
}
