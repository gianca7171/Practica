package bstreelinklistinterfgeneric;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import bstreeInterface.BinarySearchTree;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    private Node<E> root;

    public LinkedBST() {
        root = null;
    }

    @Override
    public void insert(E data) {
        try {
            root = insertRecursive(root, data);
        } catch (ItemDuplicated e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private Node<E> insertRecursive(Node<E> current, E data) throws ItemDuplicated {
        if (current == null) return new Node<>(data);
        int cmp = data.compareTo(current.data);
        if (cmp < 0) {
            current.left = insertRecursive(current.left, data);
        } else if (cmp > 0) {
            current.right = insertRecursive(current.right, data);
        } else {
            throw new ItemDuplicated("Elemento duplicado: " + data);
        }
        return current;
    }

    @Override
    public boolean search(E data) {
        try {
            return searchRecursive(root, data);
        } catch (ItemNoFound e) {
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }

    private boolean searchRecursive(Node<E> current, E data) throws ItemNoFound {
        if (current == null) throw new ItemNoFound("Elemento no encontrado: " + data);
        int cmp = data.compareTo(current.data);
        if (cmp == 0) return true;
        return (cmp < 0) ? searchRecursive(current.left, data) : searchRecursive(current.right, data);
    }

    @Override
    public void delete(E data) {
        try {
            if (root == null) throw new ExceptionIsEmpty("El árbol está vacío");
            root = deleteRecursive(root, data);
        } catch (ItemNoFound | ExceptionIsEmpty e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private Node<E> deleteRecursive(Node<E> current, E data) throws ItemNoFound {
        if (current == null) throw new ItemNoFound("Elemento no encontrado: " + data);
        int cmp = data.compareTo(current.data);
        if (cmp < 0) {
            current.left = deleteRecursive(current.left, data);
        } else if (cmp > 0) {
            current.right = deleteRecursive(current.right, data);
        } else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;
            current.data = findMinNode(current.right).data;
            current.right = deleteRecursive(current.right, current.data);
        }
        return current;
    }

    @Override
    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrderRecursive(root, sb);
        return sb.toString().trim();
    }

    private void inOrderRecursive(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrderRecursive(node.left, sb);
            sb.append(node.data).append(" ");
            inOrderRecursive(node.right, sb);
        }
    }

    @Override
    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        preOrderRecursive(root, sb);
        return sb.toString().trim();
    }

    private void preOrderRecursive(Node<E> node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data).append(" ");
            preOrderRecursive(node.left, sb);
            preOrderRecursive(node.right, sb);
        }
    }

    @Override
    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        postOrderRecursive(root, sb);
        return sb.toString().trim();
    }

    private void postOrderRecursive(Node<E> node, StringBuilder sb) {
        if (node != null) {
            postOrderRecursive(node.left, sb);
            postOrderRecursive(node.right, sb);
            sb.append(node.data).append(" ");
        }
    }

    @Override
    public String toString() {
        return "BST en orden: " + inOrder();
    }

    private Node<E> findMinNode(Node<E> node) throws ItemNoFound {
        if (node == null) throw new ItemNoFound("Árbol vacío");
        while (node.left != null) node = node.left;
        return node;
    }

    private Node<E> findMaxNode(Node<E> node) throws ItemNoFound {
        if (node == null) throw new ItemNoFound("Árbol vacío");
        while (node.right != null) node = node.right;
        return node;
    }

    public E findMin() throws ItemNoFound {
        return findMinNode(root).data;
    }

    public E findMax() throws ItemNoFound {
        return findMaxNode(root).data;
    }

    public void destroyNodes() {
        root = null;
    }

    public int countAllNodes() {
        return countAllRecursive(root);
    }

    private int countAllRecursive(Node<E> node) {
        if (node == null) return 0;
        return 1 + countAllRecursive(node.left) + countAllRecursive(node.right);
    }

    public int countNodes() {
        return countNonLeafNodes(root);
    }

    private int countNonLeafNodes(Node<E> node) {
        if (node == null || (node.left == null && node.right == null)) return 0;
        return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
    }

    public int height(E x) {
        Node<E> node = root;
        while (node != null) {
            int cmp = x.compareTo(node.data);
            if (cmp == 0) return heightIterative(node);
            node = cmp < 0 ? node.left : node.right;
        }
        return -1;
    }

    private int heightIterative(Node<E> node) {
        if (node == null) return -1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(node);
        int height = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for (int i = 0; i < size; i++) {
                Node<E> current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return height;
    }

    public int amplitude(int nivel) {
        if (nivel < 0 || root == null) return 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (currentLevel == nivel) return levelSize;
            for (int i = 0; i < levelSize; i++) {
                Node<E> current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            currentLevel++;
        }
        return 0;
    }

    public int areaBST() {
        int hojas = countLeavesIterative();
        int altura = heightIterative(root);
        return hojas * altura;
    }

    private int countLeavesIterative() {
        if (root == null) return 0;
        int count = 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> current = queue.poll();
            if (current.left == null && current.right == null) {
                count++;
            } else {
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return count;
    }

    public void drawBST() {
        drawRecursive(root, "", true);
    }

    private void drawRecursive(Node<E> node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data);
            drawRecursive(node.left, prefix + (isTail ? "    " : "│   "), false);
            drawRecursive(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    public boolean sameArea(LinkedBST<E> otro) {
        return this.areaBST() == otro.areaBST();
    }

    public void parenthesize() {
        parenthesizeRecursive(root);
        System.out.println(); // salto de línea final
    }
    
    private void parenthesizeRecursive(Node<E> node) {
        if (node == null) return;
    
        System.out.print(node.data);
        
        // Solo abrimos paréntesis si hay al menos un hijo
        if (node.left != null || node.right != null) {
            System.out.print("(");
            if (node.left != null)
                parenthesizeRecursive(node.left);
            else
                System.out.print(""); // vacío si no hay hijo izquierdo
    
            System.out.print(",");
    
            if (node.right != null)
                parenthesizeRecursive(node.right);
            else
                System.out.print(""); // vacío si no hay hijo derecho
    
            System.out.print(")");
        }
    }
    
}
