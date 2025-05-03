import java.util.ArrayList;
import java.util.List;

// Clase que contiene funciones genéricas para trabajar con listas
public class FuncionesGenericas {

    // EJERCICIO 1: Buscar un elemento en una lista genérica List<T>
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        for (T elemento : lista) {
            if (elemento.equals(valor)) {
                return true; // Se encontró el elemento
            }
        }
        return false; // No se encontró
    }

    // EJERCICIO 2: Invertir una lista genérica List<T>
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i)); // Añade desde el último hasta el primero
        }
        return invertida;
    }

    // EJERCICIO 3: Insertar un nodo al final de una lista enlazada
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor);
        if (head == null) return nuevo; // Si la lista está vacía, el nuevo nodo es la cabeza

        Node<T> actual = head;
        while (actual.siguiente != null) {
            actual = actual.siguiente; // Avanza al siguiente nodo
        }
        actual.siguiente = nuevo; // Conecta el nuevo nodo al final
        return head;
    }

    // EJERCICIO 4: Contar la cantidad de nodos de una lista enlazada
    public static <T> int contarNodos(Node<T> head) {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;             // Cuenta este nodo
            actual = actual.siguiente; // Avanza al siguiente
        }
        return contador;
    }

    // EJERCICIO 5: Comparar dos listas enlazadas
    public static <T> boolean compararListas(Node<T> l1, Node<T> l2) {
        while (l1 != null && l2 != null) {
            if (!l1.dato.equals(l2.dato)) return false; // Datos distintos
            l1 = l1.siguiente;
            l2 = l2.siguiente;
        }
        return l1 == null && l2 == null; // Ambas deben terminar al mismo tiempo
    }

    // EJERCICIO 6: Concatenar dos listas enlazadas
    public static <T> Node<T> concatenarListas(Node<T> l1, Node<T> l2) {
        if (l1 == null) return l2; // Si la primera lista está vacía, devolver la segunda

        Node<T> actual = l1;
        while (actual.siguiente != null) {
            actual = actual.siguiente; // Avanza hasta el último nodo
        }
        actual.siguiente = l2; // Conecta el final de l1 al inicio de l2
        return l1;
    }
}
