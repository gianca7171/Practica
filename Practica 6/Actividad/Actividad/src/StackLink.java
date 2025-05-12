// Implementación de una pila genérica usando lista enlazada
public class StackLink<E> implements Stack<E> {

    private Node<E> top;  // Nodo que representa el tope de la pila
    private int size;

    public StackLink() {
        top = null;
        size = 0;
    }

    // Agrega un elemento al tope de la pila
    @Override
    public void push(E item) {
        Node<E> nuevo = new Node<>(item);
        nuevo.siguiente = top; // El nuevo nodo apunta al anterior tope
        top = nuevo;           // Ahora el nuevo nodo es el tope
        size++;
    }

    // Elimina y retorna el elemento del tope
    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La pila está vacía.");
        E item = top.dato;
        top = top.siguiente;  // El nuevo tope es el siguiente nodo
        size--;
        return item;
    }

    // Retorna el elemento del tope sin eliminarlo
    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La pila está vacía.");
        return top.dato;
    }

    // Verifica si la pila está vacía
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    // Devuelve el número de elementos en la pila
    @Override
    public int size() {
        return size;
    }

    // Devuelve una representación en texto de la pila
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> actual = top;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(", ");
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
