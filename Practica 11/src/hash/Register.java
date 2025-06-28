package hash;

/**
 * Clase que representa un registro con una clave y un nombre.
 */
public class Register {
    private int key;       // Clave usada como índice en la tabla hash
    private String name;   // Nombre del registro

    // Constructor
    public Register(int key, String name) {
        this.key = key;
        this.name = name;
    }

    // Getter para la clave
    public int getKey() {
        return key;
    }

    // Getter para el nombre
    public String getName() {
        return name;
    }

    // Representación textual del objeto
    @Override
    public String toString() {
        return "(" + key + ", " + name + ")";
    }
}
