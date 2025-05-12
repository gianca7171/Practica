// Implementación de una cola genérica usando arreglo circular
public class QueueArray<E> implements Queue<E> {

    private static final int CAPACIDAD = 10;
    private E[] data;
    private int front;    // índice del primer elemento
    private int rear;     // índice donde se insertará el siguiente
    private int size;

    // Constructor
    @SuppressWarnings("unchecked")
    public QueueArray() {
        data = (E[]) new Object[CAPACIDAD];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Inserta un elemento al final de la cola
    @Override
    public void enqueue(E item) {
        if (size == CAPACIDAD) {
            throw new RuntimeException("La cola está llena.");
        }
        data[rear] = item;
        rear = (rear + 1) % CAPACIDAD; // Avanza circularmente
        size++;
    }

    // Elimina y retorna el elemento del frente
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía.");
        E item = data[front];
        data[front] = null; // Limpia la posición
        front = (front + 1) % CAPACIDAD; // Avanza circularmente
        size--;
        return item;
    }

    // Retorna el elemento del frente sin eliminarlo
    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía.");
        return data[front];
    }

    // Retorna el elemento del final sin eliminarlo
    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía.");
        int lastIndex = (rear - 1 + CAPACIDAD) % CAPACIDAD;
        return data[lastIndex];
    }

    // Verifica si la cola está vacía
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Retorna la cantidad de elementos en la cola
    @Override
    public int size() {
        return size;
    }

    // Muestra el contenido de la cola como cadena
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % CAPACIDAD;
            sb.append(data[index]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
