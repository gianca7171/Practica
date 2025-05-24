package avltree;

public class TestAVL {

    public static void main(String[] args) {
        try {
            AVLTree<Integer> avlTree = new AVLTree<>();
            
            // Caso de prueba 1: RSR (Rotación simple a la derecha)
            avlTree.insert(30);
            avlTree.insert(20);
            avlTree.insert(10);  // Desbalance en 30 y se resuelve con RSR
            
            // Caso de prueba 2: RSR (Rotación simple a la derecha)
            avlTree.insert(5);
            avlTree.insert(2); // Desbalance en 10 y se resuelve con RSR
            
            
            // Caso de prueba 3: RDR (Rotación doble a la derecha)
            avlTree.insert(15);  // Desbalance en 20 y se resuelve con RDR
            
            // Caso de prueba 4: RDR (Rotación doble a la derecha)
            avlTree.insert(3);  // Desbalance en 5 y se resuelve con RDR
            
            
            // Caso de prueba 5: RSL (Rotación simple a la izquierda)
            avlTree.insert(40);
            avlTree.insert(50); // Desbalance en 30 y se resuelve con RSL
                        
            // Caso de prueba 6: RSL (Rotación simple a la izquierda)
            avlTree.insert(60); // Desbalance en 20 y se resuelve con RSL
            
            
            // Caso de prueba 7: RDL (Rotación doble a la izquierda)
            avlTree.insert(35); // Desbalance en 20 y se resuelve con RDL
            
            // Caso de prueba 8: RDL (Rotación doble a la izquierda)
            avlTree.insert(33); // Desbalance en 20 y se resuelve con RDL
            
            
            // Para visualizar el árbol en consola
            printTree(avlTree.root, "", true);
            System.out.println("--------------------------------");
            avlTree.recorridoPorAmplitud();
            
        } catch (ItemDuplicated ex) {
            System.out.println(ex.getMessage());
        }
    }

    // método para imprimir el árbol AVL en consola
    public static void printTree(AVLTree.Node node, String prefix, boolean isTail) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + (isTail ? "`-- " : "|-- ") + node);
        printTree(node.left, prefix + (isTail ? "    " : "|   "), false);
        printTree(node.right, prefix + (isTail ? "    " : "|   "), true);
    }
}