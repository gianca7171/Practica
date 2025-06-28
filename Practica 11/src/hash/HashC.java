package hash;

/**
 * Implementación de una tabla hash usando hash cerrado (sondeo lineal).
 */
public class HashC {

    /**
     * Clase interna para representar una celda de la tabla hash.
     */
    private static class Element {
        Register register;       // Registro guardado
        boolean isAvailable;     // Indica si la celda está disponible

        public Element() {
            this.register = null;
            this.isAvailable = true;
        }
    }

    private Element[] table;  // Arreglo de elementos (la tabla hash)
    private int size;         // Tamaño de la tabla

    /**
     * Constructor de la clase HashC.
     */
    public HashC(int size) {
        this.size = size;
        this.table = new Element[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    /**
     * Función hash para calcular el índice a partir de la clave.
     */
    private int hash(int key) {
        return key % size;
    }

    /**
     * Inserta un nuevo registro con sondeo lineal.
     */
    public void insert(Register reg) {
        int key = reg.getKey();
        int index = hash(key);
        int start = index;

        do {
            if (table[index].isAvailable) {
                table[index].register = reg;
                table[index].isAvailable = false;
                return;
            }
            index = (index + 1) % size;
        } while (index != start);

        System.out.println("Error: la tabla está llena");
    }

    /**
     * Busca un registro por clave usando sondeo lineal.
     */
    public Register search(int key) {
        int index = hash(key);
        int start = index;

        do {
            if (!table[index].isAvailable && table[index].register.getKey() == key) {
                return table[index].register;
            }
            index = (index + 1) % size;
        } while (index != start);

        return null;
    }

    /**
     * Elimina un registro de forma lógica usando sondeo lineal.
     */
    public void delete(int key) {
        int index = hash(key);
        int start = index;

        do {
            if (!table[index].isAvailable && table[index].register.getKey() == key) {
                table[index].isAvailable = true;
                return;
            }
            index = (index + 1) % size;
        } while (index != start);

        System.out.println("Clave no encontrada para eliminar: " + key);
    }

    /**
     * Imprime el contenido actual de la tabla.
     */
    public void printTable() {
        for (int i = 0; i < size; i++) {
            if (!table[i].isAvailable) {
                System.out.println(i + ": " + table[i].register);
            } else {
                System.out.println(i + ": ---");
            }
        }
    }
}
