import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        // === EJERCICIO 1: Buscar un elemento en una lista genérica ===
        System.out.println("EJERCICIO 1: BUSCAR ELEMENTO EN LISTA.");

        List<String> nombres = new ArrayList<>();
        nombres.add("Giancarlo");
        nombres.add("Gloria");
        nombres.add("Cleo");

        System.out.println("\n¿Contiene 'Gloria'? " + FuncionesGenericas.buscarElemento(nombres, "Gloria"));
        System.out.println("¿Contiene 'Carlos'? " + FuncionesGenericas.buscarElemento(nombres, "Carlos"));

        // === EJERCICIO 2: Invertir una lista genérica ===
        System.out.println("\nEJERICICIO 2: INVERTIR LISTA GENERICA");

        System.out.println("\nLista original:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        System.out.println("\nLista invertida:");
        List<String> invertida = FuncionesGenericas.invertirLista(nombres);
        for (String nombre : invertida) {
            System.out.println(nombre);
        }

        // === EJERCICIO 3: Insertar un nodo al final ===
        System.out.println("\nEJERCICIO 3: INSERTAR AL FINAL DE UNA LISTA ENLAZADA");

        Node<String> cabeza = null;
        cabeza = FuncionesGenericas.insertarAlFinal(cabeza, "\nGiancarlo");
        cabeza = FuncionesGenericas.insertarAlFinal(cabeza, "Gloria");
        cabeza = FuncionesGenericas.insertarAlFinal(cabeza, "Cleo");

        // Recorremos e imprimimos los nodos
        Node<String> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }

        // === EJERCICIO 4: Contar los nodos ===
        System.out.println("\nEJERCICIO 4: CONTAR NODOS DE LA LISTA ENLAZADA");
        int total = FuncionesGenericas.contarNodos(cabeza);
        System.out.println("\nCantidad total de nodos: " + total);

        // === EJERCICIO 5: Comparar dos listas ===
        System.out.println("\nEJERCICIO 5: COMPARAR DOS LISTAS ENLAZADAS");

        Node<String> lista1 = null;
        lista1 = FuncionesGenericas.insertarAlFinal(lista1, "Giancarlo");
        lista1 = FuncionesGenericas.insertarAlFinal(lista1, "Gloria");
        lista1 = FuncionesGenericas.insertarAlFinal(lista1, "Cleo");

        Node<String> lista2 = null;
        lista2 = FuncionesGenericas.insertarAlFinal(lista2, "Giancarlo");
        lista2 = FuncionesGenericas.insertarAlFinal(lista2, "Gloria");
        lista2 = FuncionesGenericas.insertarAlFinal(lista2, "Cleo");

        boolean sonIguales = FuncionesGenericas.compararListas(lista1, lista2);
        System.out.println("\n¿Las listas son iguales? " + sonIguales);

        // === EJERCICIO 6: Concatenar listas ===
        System.out.println("\nEJERCICIO 6: CONCATENAR DOS LISTAS ENLAZADAS");

        Node<String> primera = null;
        primera = FuncionesGenericas.insertarAlFinal(primera, "\nGiancarlo");
        primera = FuncionesGenericas.insertarAlFinal(primera, "Gloria");

        Node<String> segunda = null;
        segunda = FuncionesGenericas.insertarAlFinal(segunda, "Cleo");
        segunda = FuncionesGenericas.insertarAlFinal(segunda, "Carlos");

        Node<String> resultado = FuncionesGenericas.concatenarListas(primera, segunda);

        // Imprimir la lista concatenada
        Node<String> actualConcat = resultado;
        while (actualConcat != null) {
            System.out.println(actualConcat.dato);
            actualConcat = actualConcat.siguiente;
        }
    }
}
