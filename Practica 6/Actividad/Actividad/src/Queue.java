// Interfaz genérica para una cola
public interface Queue<E> {
    void enqueue(E item);
    E dequeue() throws ExceptionIsEmpty;
    E front() throws ExceptionIsEmpty;
    E back() throws ExceptionIsEmpty;
    boolean isEmpty();
    int size();
}
