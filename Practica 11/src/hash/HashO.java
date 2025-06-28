package hash;

import java.util.LinkedList;

/**
 * Clase que implementa una tabla hash con encadenamiento (listas enlazadas).
 */
public class HashO {
    private LinkedList<Register>[] table;  // Tabla de listas enlazadas
    private int size;                      // Tamaño de la tabla

    /**
     * Constructor que inicializa la tabla con listas vacías.
     */
    @SuppressWarnings("unchecked")
    public HashO(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    /**
     * Función hash para determinar el índice.
     */
    private int hash(int key) {
        return key % size;
    }

    /**
     * Inserta un registro en la tabla.
     * Si ya existe un registro con la misma clave, lo reemplaza.
     */
    public void insert(Register reg) {
        int index = hash(reg.getKey());

        // Buscar si ya existe uno con la misma clave
        for (Register r : table[index]) {
            if (r.getKey() == reg.getKey()) {
                System.out.println("Clave duplicada, reemplazando...");
                table[index].remove(r);
                break;
            }
        }

        table[index].add(reg);
    }

    /**
     * Busca un registro por clave.
     */
    public Register search(int key) {
        int index = hash(key);
        for (Register r : table[index]) {
            if (r.getKey() == key) {
                return r;
            }
        }
        return null;
    }

    /**
     * Elimina un registro por clave.
     */
    public void delete(int key) {
        int index = hash(key);
        for (Register r : table[index]) {
            if (r.getKey() == key) {
                table[index].remove(r);
                System.out.println("Eliminado correctamente.");
                return;
            }
        }
        System.out.println("Clave no encontrada para eliminar: " + key);
    }

    /**
     * Muestra el contenido de cada lista de la tabla.
     */
    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("---");
            } else {
                for (Register r : table[i]) {
                    System.out.print(r + " ");
                }
                System.out.println();
            }
        }
    }
}
