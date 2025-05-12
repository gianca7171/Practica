// Clase genérica para representar un nodo de lista enlazada
public class Node<E> {
    public E dato;
    public Node<E> siguiente;

    public Node(E dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
