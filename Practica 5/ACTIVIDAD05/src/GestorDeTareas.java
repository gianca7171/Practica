// Clase genérica que gestiona tareas usando una lista enlazada
public class GestorDeTareas<T> {
    private Node<T> head; // Nodo cabeza de la lista

    // Constructor: lista vacía al inicio
    public GestorDeTareas() {
        head = null;
    }

    // 1. Agregar tarea al final
    public void agregarTarea(T tarea) {
        Node<T> nuevo = new Node<>(tarea);
        if (head == null) {
            head = nuevo;
        } else {
            Node<T> actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    // 2. Eliminar una tarea si existe
    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;
        if (head.dato.equals(tarea)) {
            head = head.siguiente;
            return true;
        }
        Node<T> actual = head;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(tarea)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente == null) return false;
        actual.siguiente = actual.siguiente.siguiente;
        return true;
    }

    // 3. Verificar si contiene una tarea
    public boolean contieneTarea(T tarea) {
        Node<T> actual = head;
        while (actual != null) {
            if (actual.dato.equals(tarea)) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    // 4. Imprimir todas las tareas pendientes
    public void imprimirTareas() {
        Node<T> actual = head;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    // 5. Contar cantidad de tareas pendientes
    public int contarTareas() {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // 6. Obtener la tarea con mayor prioridad (solo si es Tarea)
    public T obtenerTareaMasPrioritaria() {
        if (head == null || !(head.dato instanceof Tarea)) return null;
        Node<T> actual = head;
        Tarea mayor = (Tarea) actual.dato;
        actual = actual.siguiente;
        while (actual != null) {
            Tarea actualTarea = (Tarea) actual.dato;
            if (actualTarea.getPrioridad() > mayor.getPrioridad()) {
                mayor = actualTarea;
            }
            actual = actual.siguiente;
        }
        return (T) mayor;
    }

    // 7. Invertir el orden de la lista de tareas
    public void invertirTareas() {
        Node<T> anterior = null;
        Node<T> actual = head;
        Node<T> siguiente;
        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }
}
