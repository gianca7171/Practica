package listlinked;

public class ListLinked<T> {
    private class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public ListLinked() {
        head = null;
        size = 0;
    }

    public void insertLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            head = head.next;
        } else {
            Node aux = head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.next;
            }
            aux.next = aux.next.next;
        }
        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.data;
    }

    public boolean contains(T data) {
        Node aux = head;
        while (aux != null) {
            if (aux.data.equals(data)) return true;
            aux = aux.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node aux = head;
        while (aux != null) {
            sb.append(aux.data.toString());
            aux = aux.next;
        }
        return sb.toString();
    }
}
