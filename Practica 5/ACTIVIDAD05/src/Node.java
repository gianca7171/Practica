// Clase genérica Node usada para crear listas enlazadas
public class Node<T> {
    T dato;             // Dato que almacena el nodo
    Node<T> siguiente;  // Referencia al siguiente nodo

    // Constructor que recibe el dato
    public Node(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
