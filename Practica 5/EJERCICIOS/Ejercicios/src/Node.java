// Clase genérica que representa un nodo en una lista enlazada
public class Node<T> {
    public T dato;              // El valor que guarda el nodo
    public Node<T> siguiente;   // Referencia al siguiente nodo

    // Constructor que recibe el valor del nodo
    public Node(T dato) {
        this.dato = dato;
        this.siguiente = null; // Por defecto, no apunta a ningún otro nodo
    }
}
