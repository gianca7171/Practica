package btree;

import java.util.ArrayList;

public class BNode<E> {
    public static int nextId = 1;

    public int idNode;
    public int count;
    public ArrayList<E> keys;
    public ArrayList<BNode<E>> childs;
    public BNode<E> parent;

    public BNode(int orden) {
        this.idNode = nextId++;
        this.count = 0;
        this.keys = new ArrayList<>(orden - 1);
        this.childs = new ArrayList<>(orden);
        this.parent = null;

        for (int i = 0; i < orden - 1; i++) {
            this.keys.add(null);
        }
        for (int i = 0; i < orden; i++) {
            this.childs.add(null);
        }
    }

    public boolean nodeFull(int max) {
        return this.count == max;
    }

    public boolean nodeEmpty() {
        return this.count == 0;
    }

    public boolean searchNode(E key, int[] pos) {
        pos[0] = 0;
        while (pos[0] < count && compare(keys.get(pos[0]), key) < 0) {
            pos[0]++;
        }
        return (pos[0] < count && compare(keys.get(pos[0]), key) == 0);
    }

    @SuppressWarnings("unchecked")
    private int compare(E a, E b) {
        return ((Comparable<E>) a).compareTo(b);
    }
}
