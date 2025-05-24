package avltree;

public class TestBSTvsAVL {

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    // Caso de prueba 1: Inserción en orden ascendente
    public static void testCase1() {
        try {
            System.out.println("Caso de prueba 1: Insercion en orden ascendente");
            
            BSTree<Integer> bst = new BSTree<>();
            AVLTree<Integer> avl = new AVLTree<>();
            
            int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            
            for (int element : elements) {
                try {
                    bst.insert(element);
                    avl.insert(element);
                } catch (ItemDuplicated e) {
                    System.out.println(e.getMessage());
                }
            }
            
            System.out.println("BST: " + bst);
            System.out.println("AVL: " + avl);
            
            System.out.println("BST Altura: " + bst.height(1));
            System.out.println("AVL Altura: " + avl.height(1));
        } catch (ItemNoFound ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Caso de prueba 2: Inserción que provoca rotaciones
    public static void testCase2() {
        try {
            System.out.println("Caso de prueba 2: Insercion que provoca rotaciones");
            
            BSTree<Integer> bst = new BSTree<>();
            AVLTree<Integer> avl = new AVLTree<>();
            
            int[] elements = {30, 20, 40, 10, 25, 35, 50, 22, 27};
            
            for (int element : elements) {
                try {
                    bst.insert(element);
                    avl.insert(element);
                } catch (ItemDuplicated e) {
                    System.out.println(e.getMessage());
                }
            }
            
            System.out.println("BST: " + bst);
            System.out.println("AVL: " + avl);
            
            System.out.println("BST Altura: " + bst.height(30));
            System.out.println("AVL Altura: " + avl.height(30));
        } catch (ItemNoFound ex) {
            System.out.println(ex.getMessage());
        }
    }
}