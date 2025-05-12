// Cola de prioridad con múltiples colas internas (por nivel de prioridad)
public class PriorityQueueLinked<E> {

    private static final int NIVELES = 5;  // Nivel 0 = mayor prioridad, 4 = menor
    private QueueLink<E>[] colas;

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked() {
        colas = new QueueLink[NIVELES];
        for (int i = 0; i < NIVELES; i++) {
            colas[i] = new QueueLink<>();
        }
    }

    // Inserta un dato en la cola correspondiente a su nivel de prioridad
    public void insert(E dato, int prioridad) {
        if (prioridad < 0 || prioridad >= NIVELES) {
            throw new IllegalArgumentException("Prioridad fuera de rango (0 a " + (NIVELES - 1) + ")");
        }
        colas[prioridad].enqueue(dato);
    }

    // Elimina y retorna el primer elemento con mayor prioridad disponible
    public E remove() throws ExceptionIsEmpty {
        for (int i = 0; i < NIVELES; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía.");
    }

    // Verifica si todas las colas están vacías
    public boolean isEmpty() {
        for (QueueLink<E> cola : colas) {
            if (!cola.isEmpty()) return false;
        }
        return true;
    }

    // Representación en texto de todas las colas por prioridad
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NIVELES; i++) {
            sb.append("Prioridad ").append(i).append(": ").append(colas[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
