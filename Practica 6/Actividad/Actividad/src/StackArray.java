// Clase que implementa una pila genérica usando un arreglo
public class StackArray<E> implements Stack<E> {

    private static final int CAPACIDAD = 100;  // Capacidad máxima de la pila
    private E[] data;  // Arreglo para almacenar los elementos
    private int top = -1;  // Índice del tope de la pila

    // Constructor
    @SuppressWarnings("unchecked")
    public StackArray() {
        data = (E[]) new Object[CAPACIDAD]; // Inicializa arreglo genérico
    }

    // Agrega un elemento a la pila
    @Override
    public void push(E item) {
        if (top == CAPACIDAD - 1) {
            throw new RuntimeException("La pila está llena.");
        }
        data[++top] = item;
    }

    // Elimina y retorna el elemento en el tope
    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La pila está vacía.");
        E temp = data[top];
        data[top--] = null;
        return temp;
    }

    // Retorna el elemento en el tope sin eliminarlo
    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La pila está vacía.");
        return data[top];
    }

    // Verifica si la pila está vacía
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    // Devuelve el número de elementos en la pila
    @Override
    public int size() {
        return top + 1;
    }

    // Retorna una representación en cadena de la pila
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(data[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

