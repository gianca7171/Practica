// Cola de prioridad implementada con lista enlazada ordenada por prioridad
public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    // Clase interna que guarda dato y prioridad
    private static class EntryNode<E, N extends Comparable<N>> {
        E dato;
        N prioridad;
        EntryNode<E, N> siguiente;

        public EntryNode(E dato, N prioridad) {
            this.dato = dato;
            this.prioridad = prioridad;
            this.siguiente = null;
        }
    }

    private EntryNode<E, N> head;  // Nodo con menor prioridad (el primero)
    private int size;

    public PriorityQueueLinkSort() {
        head = null;
        size = 0;
    }

    // Inserta un nuevo dato en orden según prioridad
    @Override
    public void insert(E dato, N prioridad) {
        EntryNode<E, N> nuevo = new EntryNode<>(dato, prioridad);

        if (head == null || prioridad.compareTo(head.prioridad) < 0) {
            nuevo.siguiente = head;
            head = nuevo;
        } else {
            EntryNode<E, N> actual = head;
            while (actual.siguiente != null && prioridad.compareTo(actual.siguiente.prioridad) >= 0) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }

        size++;
    }

    // Elimina y retorna el elemento de menor prioridad (el head)
    @Override
    public E removeMin() {
        if (isEmpty()) throw new RuntimeException("La cola de prioridad está vacía.");
        E dato = head.dato;
        head = head.siguiente;
        size--;
        return dato;
    }

    // Retorna el dato con menor prioridad sin eliminarlo
    @Override
    public E min() {
        if (isEmpty()) throw new RuntimeException("La cola de prioridad está vacía.");
        return head.dato;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    // Muestra la cola con prioridades en orden
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        EntryNode<E, N> actual = head;
        sb.append("[");
        while (actual != null) {
            sb.append("(").append(actual.dato).append(", prioridad=").append(actual.prioridad).append(")");
            if (actual.siguiente != null) sb.append(" -> ");
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
