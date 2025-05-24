public class TestBSTvsAVL {
    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    public static void testCase1() {
        System.out.println("Caso 1: Inserción en orden ascendente");
        BSTree<Integer> bst = new BSTree<>();
        AVLTree<Integer> avl = new AVLTree<>();
        int[] elementos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int x : elementos) {
            try {
                bst.insert(x);
                avl.insert(x);
            } catch (ItemDuplicated ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("BST altura: " + bst.height(30));
        System.out.println("AVL altura: " + avl.height(30));
        System.out.println();
    }

    public static void testCase2() {
        System.out.println("Caso 2: Inserciones que provocan rotaciones");
        BSTree<Integer> bst = new BSTree<>();
        AVLTree<Integer> avl = new AVLTree<>();
        int[] elementos = {30, 20, 40, 10, 25, 35, 50, 22, 27};

        for (int x : elementos) {
            try {
                bst.insert(x);
                avl.insert(x);
            } catch (ItemDuplicated ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("BST altura: " + bst.height(30));
        System.out.println("AVL altura: " + avl.height(30));
    }
}