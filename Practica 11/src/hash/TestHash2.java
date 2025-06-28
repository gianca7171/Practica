package hash;

public class TestHash2 {
    public static void main(String[] args) {
        HashC tabla = new HashC(6);

        // Insertar los valores con colisiones
        Register[] registros = {
            new Register(12, "Valor1"),
            new Register(18, "Valor2"),
            new Register(24, "Valor3"),
            new Register(30, "Valor4")
        };

        for (Register r : registros) {
            System.out.println("Insertando: " + r.getKey());
            tabla.insert(r);
            tabla.printTable();
            System.out.println();
        }
    }
}
