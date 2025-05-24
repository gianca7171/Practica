public class TestAVLRotaciones {
    public static void main(String[] args) throws ItemDuplicated {
        AVLTree<Integer> avl = new AVLTree<>();

        avl.insert(30);
        avl.insert(20);
        avl.insert(10);  // RSR

        avl.insert(5);
        avl.insert(2);   // RSR

        avl.insert(15);  // RDR
        avl.insert(3);   // RDR

        avl.insert(40);
        avl.insert(50);  // RSL
        avl.insert(60);  // RSL

        avl.insert(35);  // RDL
        avl.insert(33);  // RDL

        avl.drawAVL();
    }
}