package hash;

public class TestHashC {
    public static void main(String[] args) {
        // Crear una tabla hash de tamaño 7
        HashC tabla = new HashC(7);

        // Insertar los valores: 3, 10, 17, 24 (no hay colisiones porque h(x) = x % 7 da posiciones distintas)
        tabla.insert(new Register(3, "Tres"));
        tabla.insert(new Register(10, "Diez"));
        tabla.insert(new Register(17, "Diecisiete"));
        tabla.insert(new Register(24, "Veinticuatro"));

        // Mostrar la tabla hash final
        System.out.println("Tabla Hash Final:");
        tabla.printTable();
    }
}
