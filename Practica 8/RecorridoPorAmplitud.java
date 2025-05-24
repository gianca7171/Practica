public class RecorridoPorAmplitud {
    public static void main(String[] args) throws ItemDuplicated {
        AVLTree<Integer> avl = new AVLTree<>();
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 10, 25, 65};
        for (int val : valores) avl.insert(val);
        avl.recorridoPorAmplitud();
    }
}