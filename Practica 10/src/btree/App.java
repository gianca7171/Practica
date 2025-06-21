package btree;

public class App {
    public static void main(String[] args) {
        BTree<RegistroEstudiante> arbolEstudiantes = new BTree<>(4);

        arbolEstudiantes.insert(new RegistroEstudiante(103, "Ana"));
        arbolEstudiantes.insert(new RegistroEstudiante(110, "Luis"));
        arbolEstudiantes.insert(new RegistroEstudiante(101, "Carlos"));
        arbolEstudiantes.insert(new RegistroEstudiante(120, "Lucía"));
        arbolEstudiantes.insert(new RegistroEstudiante(115, "David"));
        arbolEstudiantes.insert(new RegistroEstudiante(125, "Jorge"));
        arbolEstudiantes.insert(new RegistroEstudiante(140, "Camila"));
        arbolEstudiantes.insert(new RegistroEstudiante(108, "Rosa"));
        arbolEstudiantes.insert(new RegistroEstudiante(132, "Ernesto"));
        arbolEstudiantes.insert(new RegistroEstudiante(128, "Denis"));
        arbolEstudiantes.insert(new RegistroEstudiante(145, "Enrique"));
        arbolEstudiantes.insert(new RegistroEstudiante(122, "Karina"));
        arbolEstudiantes.insert(new RegistroEstudiante(108, "Juan")); // Repetido

        System.out.println("Nombre del código 115: " + arbolEstudiantes.buscarNombre(115)); // David
        System.out.println("Nombre del código 132: " + arbolEstudiantes.buscarNombre(132)); // Ernesto
        System.out.println("Nombre del código 999: " + arbolEstudiantes.buscarNombre(999)); // No encontrado

        // Eliminar al estudiante con código 101
        arbolEstudiantes.remove(new RegistroEstudiante(101, "")); // No implementado aún

        // Insertar nuevo estudiante
        arbolEstudiantes.insert(new RegistroEstudiante(106, "Sara"));

        // Buscar nuevo
        System.out.println("Nombre del código 106: " + arbolEstudiantes.buscarNombre(106)); // Sara
    }
}
