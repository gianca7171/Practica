package hash;

public class TestHashO {
    public static void main(String[] args) {
        HashO tabla = new HashO(7); // Tamaño pequeño para forzar colisiones

        // Insertar registros
        tabla.insert(new Register(3, "Juan"));
        tabla.insert(new Register(10, "Ana"));    // Colisiona con 3 si size=7
        tabla.insert(new Register(17, "Luis"));   // Colisiona también
        tabla.insert(new Register(24, "Sofía"));
        tabla.insert(new Register(31, "Pedro"));  // Colisión en la misma posición que 3, 10, 17

        System.out.println("Contenido de la tabla después de inserciones:");
        tabla.printTable();

        // Buscar clave existente
        Register r = tabla.search(10);
        if (r != null)
            System.out.println("Clave 10 encontrada: " + r);
        else
            System.out.println("Clave 10 no encontrada.");

        // Buscar clave inexistente
        r = tabla.search(99);
        if (r != null)
            System.out.println("Clave 99 encontrada: " + r);
        else
            System.out.println("Clave 99 no encontrada.");

        // Eliminar una clave
        System.out.println("Eliminando clave 17...");
        tabla.delete(17);

        System.out.println("Tabla después de eliminar 17:");
        tabla.printTable();
    }
}
