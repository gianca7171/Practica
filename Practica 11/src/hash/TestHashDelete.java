package hash;

public class TestHashDelete {
    public static void main(String[] args) {
        HashC tabla = new HashC(7);

        // Insertamos con nombres de ejemplo
        tabla.insert(new Register(5, "A"));
        tabla.insert(new Register(12, "B"));
        tabla.insert(new Register(19, "C"));

        System.out.println("--- Tabla luego de insertar ---");
        tabla.printTable();

        System.out.println("\nEliminando la clave 12...");
        tabla.delete(12);

        System.out.println("\n--- Tabla después de eliminar 12 (eliminación lógica) ---");
        tabla.printTable();

        System.out.println("\nBuscando la clave 19...");
        Register r = tabla.search(19);
        if (r != null) {
            System.out.println("Encontrado: " + r);
        } else {
            System.out.println("No encontrado.");
        }

        System.out.println("\n¿Diferencia entre eliminación lógica y física?");
        System.out.println("La eliminación lógica solo marca la celda como disponible, permitiendo que las búsquedas con sondeo continúen correctamente. "
                + "La eliminación física elimina el dato directamente, lo que podría interrumpir la búsqueda en tablas con colisiones resueltas por sondeo.");
    }
}
