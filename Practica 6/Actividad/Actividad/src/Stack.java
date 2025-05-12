// Interfaz Stack con los métodos fundamentales de una pila
public interface Stack<E> {
    void push(E item);     // Agrega un elemento al tope
    E pop() throws ExceptionIsEmpty;  // Elimina y retorna el tope
    E top() throws ExceptionIsEmpty;  // Retorna el tope sin eliminar
    boolean isEmpty();     // Verifica si la pila está vacía
    int size();            // Retorna la cantidad de elementos
}
