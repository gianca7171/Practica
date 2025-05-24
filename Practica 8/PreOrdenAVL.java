public class PreOrdenAVL {
    public static void main(String[] args) throws ItemDuplicated {
        AVLTree<Integer> avl = new AVLTree<>();
        int[] valores = {40, 20, 60, 10, 30, 50, 70};
        for (int val : valores) avl.insert(val);
        avl.preOrden();
    }
}