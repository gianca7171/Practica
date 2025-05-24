public class EliminarAVL {
    public static void main(String[] args) throws ItemDuplicated, ItemNoFound {
        AVLTree<Integer> avl = new AVLTree<>();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int val : valores) avl.insert(val);
        avl.remove(70);
        avl.remove(30);
        avl.recorridoPorAmplitud();
    }
}