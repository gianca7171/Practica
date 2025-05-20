import bstreelinklistinterfgeneric.LinkedBST;

public class App {
    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();

        System.out.println("===== ACTIVIDAD 6: Inserción, búsqueda y eliminación =====");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Buscar 40: " + bst.search(40));
        System.out.println("Buscar 99: " + bst.search(99));

        bst.delete(30);
        System.out.println("Después de eliminar 30:");
        System.out.println(bst);

        System.out.println("\n===== ACTIVIDADES 7, 8 y 9: Recorridos =====");
        System.out.println("InOrder: " + bst.inOrder());
        System.out.println("PreOrder: " + bst.preOrder());
        System.out.println("PostOrder: " + bst.postOrder());

        System.out.println("\n===== ACTIVIDAD 10: Mínimo y máximo =====");
        try {
            System.out.println("Mínimo: " + bst.findMin());
            System.out.println("Máximo: " + bst.findMax());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n===== EJERCICIO 01: Funciones adicionales =====");
        System.out.println("Cantidad total de nodos: " + bst.countAllNodes());
        System.out.println("Cantidad de nodos no hoja: " + bst.countNodes());
        System.out.println("Altura del nodo 50: " + bst.height(50));
        System.out.println("Amplitud (nivel 2): " + bst.amplitude(2));

        System.out.println("\n===== EJERCICIO 02: Área, dibujo y comparación =====");
        System.out.println("Área del BST: " + bst.areaBST());

        System.out.println("Dibujo del árbol:");
        bst.drawBST();

        bst.destroyNodes();
        System.out.println("Árbol después de destruir: " + bst.inOrder());

        LinkedBST<Integer> otro = new LinkedBST<>();
        otro.insert(1);
        otro.insert(0);
        otro.insert(2);

        System.out.println("Área del segundo árbol: " + otro.areaBST());
        System.out.println("¿Tienen la misma área?: " + bst.sameArea(otro));

        System.out.println("\n===== EJERCICIO 03: Representación entre paréntesis =====");
        // Usamos el segundo árbol para que se vea más claro
        System.out.println("Árbol visual:");
        otro.drawBST();
        System.out.print("Formato parenthesize: ");
        otro.parenthesize();
    }
}
