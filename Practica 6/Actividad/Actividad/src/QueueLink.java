// Implementación de una cola genérica usando lista enlazada
public class QueueLink<E> implements Queue<E> {

    private Node<E> front;  // Primer nodo (frente)
    private Node<E> rear;   // Último nodo (final)
    private int size;

    public QueueLink() {
        front = rear = null;
        size = 0;
    }

    // Agrega un elemento al final de la cola
    @Override
    public void enqueue(E item) {
        Node<E> nuevo = new Node<>(item);
        if (isEmpty()) {
            front = rear = nuevo;
        } else {
            rear.siguiente = nuevo;
            rear = nuevo;
        }
        size++;
    }

    // Elimina y retorna el elemento del frente
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía.");
        E item = front.dato;
        front = front.siguiente;
        if (front == null) rear = null;
        size--;
        return item;
    }

    // Retorna el primer elemento sin eliminarlo
    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía.");
        return front.dato;
    }

    // Retorna el último elemento sin eliminarlo
    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía.");
        return rear.dato;
    }

    // Verifica si está vacía
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    // Devuelve la cantidad de elementos
    @Override
    public int size() {
        return size;
    }

    // Muestra la cola como una cadena
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> actual = front;
        sb.append("[");
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(", ");
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
