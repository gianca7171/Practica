import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa<T> implements Iterable<T> {
    private ArrayList<T> lista = new ArrayList<>(); // Lista para almacenar los elementos
    private int tope; // Límite máximo de elementos en la bolsa

    // Constructor que define el límite de la bolsa
    public Bolsa(int tope) {
        this.tope = tope;
    }

    // Agrega un elemento a la bolsa si no ha alcanzado el límite
    public void add(T objeto) {
        if (lista.size() < tope) {
            lista.add(objeto);
        } else {
            throw new RuntimeException("No caben más objetos en la bolsa.");
        }
    }

    // Permite recorrer los elementos de la bolsa con un for-each
    public Iterator<T> iterator() {
        return lista.iterator();
    }
}
