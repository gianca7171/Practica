package hash;

public class TestHashO2 {
    public static void main(String[] args) {
        HashO tabla = new HashO(5);

        // Insertar los elementos dados
        tabla.insert(new Register(10, "Juan"));
        tabla.insert(new Register(15, "Ana"));
        tabla.insert(new Register(20, "Luis"));
        tabla.insert(new Register(25, "Rosa"));

        // Buscar la clave 20
        System.out.println("Buscando clave 20...");
        Register r1 = tabla.search(20);
        if (r1 != null) {
            System.out.println("Encontrado: " + r1);
        } else {
            System.out.println("No encontrado.");
        }

        // Buscar la clave 30 (no existe)
        System.out.println("\nBuscando clave 30...");
        Register r2 = tabla.search(30);
        if (r2 != null) {
            System.out.println("Encontrado: " + r2);
        } else {
            System.out.println("No se encontró ningún registro con la clave 30.");
        }
    }
}
