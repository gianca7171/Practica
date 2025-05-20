package bstreeInterface;

public interface BinarySearchTree<E extends Comparable<E>> {
    void insert(E data);
    boolean search(E data);
    void delete(E data);
    String inOrder();
    String preOrder();
    String postOrder();
}
