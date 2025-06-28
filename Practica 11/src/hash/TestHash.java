package hash;

public class TestHash {
    public static void main(String[] args) {
        HashC tabla = new HashC(13);

        // Insertar valores con claves repetidas y colisiones
        tabla.insert(new Register(34, "Juan"));
        tabla.insert(new Register(3, "Ana"));
        tabla.insert(new Register(7, "Luis"));
        tabla.insert(new Register(30, "Carla"));
        tabla.insert(new Register(11, "Mario"));
        tabla.insert(new Register(8, "Jose"));
        tabla.insert(new Register(7, "Lucia"));  // clave repetida
        tabla.insert(new Register(23, "Laura"));
        tabla.insert(new Register(41, "Marta"));
        tabla.insert(new Register(16, "Pedro"));
        tabla.insert(new Register(34, "Noelia")); // clave repetida

        System.out.println("--- Tabla antes de eliminar ---");
        tabla.printTable();

        // Eliminar clave 30
        System.out.println("\nEliminando clave 30:");
        tabla.delete(30);

        System.out.println("\n--- Tabla después de eliminar ---");
        tabla.printTable();

        // Buscar clave 23
        Register r = tabla.search(23);
        System.out.println("\nResultado de búsqueda de clave 23:");
        if (r != null) {
            System.out.println("Encontrado: " + r.getName());
        } else {
            System.out.println("No encontrado");
        }
    }
}
