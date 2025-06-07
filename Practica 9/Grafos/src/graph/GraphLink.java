package graph;

import listlinked.ListLinked;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Comparator;

public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data) {
        if (searchVertex(data)) return;
        Vertex<E> newVertex = new Vertex<>(data);
        listVertex.insertLast(newVertex);
    }

    public void insertEdge(E verOri, E verDes) {
        Vertex<E> vOri = getVertex(verOri);
        Vertex<E> vDes = getVertex(verDes);
        if (vOri == null || vDes == null) return;

        vOri.getListAdj().insertLast(new Edge<>(vDes));
        vDes.getListAdj().insertLast(new Edge<>(vOri));
    }

    public boolean searchVertex(E data) {
        for (int i = 0; i < listVertex.size(); i++) {
            if (listVertex.get(i).getData().equals(data)) return true;
        }
        return false;
    }

    public boolean searchEdge(E verOri, E verDes) {
        Vertex<E> vOri = getVertex(verOri);
        if (vOri == null) return false;

        for (int i = 0; i < vOri.getListAdj().size(); i++) {
            if (vOri.getListAdj().get(i).getRefDest().getData().equals(verDes)) return true;
        }
        return false;
    }

    public void removeVertex(E data) {
        Vertex<E> vRemove = getVertex(data);
        if (vRemove == null) return;

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex<E> v = listVertex.get(i);
            for (int j = 0; j < v.getListAdj().size(); j++) {
                if (v.getListAdj().get(j).getRefDest().equals(vRemove)) {
                    v.getListAdj().remove(j);
                    j--;
                }
            }
        }

        for (int i = 0; i < listVertex.size(); i++) {
            if (listVertex.get(i).equals(vRemove)) {
                listVertex.remove(i);
                break;
            }
        }
    }

    public void removeEdge(E verOri, E verDes) {
        Vertex<E> vOri = getVertex(verOri);
        Vertex<E> vDes = getVertex(verDes);
        if (vOri == null || vDes == null) return;

        for (int i = 0; i < vOri.getListAdj().size(); i++) {
            if (vOri.getListAdj().get(i).getRefDest().equals(vDes)) {
                vOri.getListAdj().remove(i);
                break;
            }
        }

        for (int i = 0; i < vDes.getListAdj().size(); i++) {
            if (vDes.getListAdj().get(i).getRefDest().equals(vOri)) {
                vDes.getListAdj().remove(i);
                break;
            }
        }
    }

    public void dfs(E start) {
        Vertex<E> vStart = getVertex(start);
        if (vStart == null) return;

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        dfsRecursive(vStart, visited);
        System.out.println();
    }

    private void dfsRecursive(Vertex<E> v, ListLinked<Vertex<E>> visited) {
        System.out.print(v.getData() + " ");
        visited.insertLast(v);

        for (int i = 0; i < v.getListAdj().size(); i++) {
            Vertex<E> neighbor = v.getListAdj().get(i).getRefDest();
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void bfs(E start) {
        Vertex<E> vStart = getVertex(start);
        if (vStart == null) return;

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        Queue<Vertex<E>> queue = new LinkedList<>();

        visited.insertLast(vStart);
        queue.add(vStart);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            System.out.print(current.getData() + " ");

            for (int i = 0; i < current.getListAdj().size(); i++) {
                Vertex<E> neighbor = current.getListAdj().get(i).getRefDest();
                if (!visited.contains(neighbor)) {
                    visited.insertLast(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public ArrayList<E> bfsPath(E start, E end) {
        Vertex<E> vStart = getVertex(start);
        Vertex<E> vEnd = getVertex(end);
        if (vStart == null || vEnd == null) return null;

        ArrayList<E> path = new ArrayList<>();
        Queue<Vertex<E>> queue = new LinkedList<>();
        ListLinked<Vertex<E>> visited = new ListLinked<>();
        HashMap<Vertex<E>, Vertex<E>> parentMap = new HashMap<>();

        queue.add(vStart);
        visited.insertLast(vStart);
        parentMap.put(vStart, null);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();

            if (current.equals(vEnd)) break;

            for (int i = 0; i < current.getListAdj().size(); i++) {
                Vertex<E> neighbor = current.getListAdj().get(i).getRefDest();
                if (!visited.contains(neighbor)) {
                    visited.insertLast(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        Vertex<E> step = vEnd;
        while (step != null) {
            path.add(0, step.getData());
            step = parentMap.get(step);
        }

        if (!path.isEmpty() && path.get(0).equals(start)) return path;
        return null;
    }

    public Vertex<E> getVertex(E data) {
        for (int i = 0; i < listVertex.size(); i++) {
            if (listVertex.get(i).getData().equals(data)) return listVertex.get(i);
        }
        return null;
    }    

    public String toString() {
        return this.listVertex.toString();
    }

    // ================= EJERCICIO 02 =================

    public void insertEdgeWeight(E v, E z, int w) {
        Vertex<E> v1 = getVertex(v);
        Vertex<E> v2 = getVertex(z);
        if (v1 == null || v2 == null) return;

        v1.getListAdj().insertLast(new Edge<>(v2, w));
        v2.getListAdj().insertLast(new Edge<>(v1, w));
    }

    public ArrayList<E> shortPath(E v, E z) {
        return bfsPath(v, z);
    }

    public boolean isConexo() {
        if (listVertex.size() == 0) return true;

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        Queue<Vertex<E>> queue = new LinkedList<>();
        Vertex<E> start = listVertex.get(0);

        visited.insertLast(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();

            for (int i = 0; i < current.getListAdj().size(); i++) {
                Vertex<E> neighbor = current.getListAdj().get(i).getRefDest();
                if (!visited.contains(neighbor)) {
                    visited.insertLast(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return visited.size() == listVertex.size();
    }

    public Stack<E> dijkstra(E start, E end) {
        Vertex<E> vStart = getVertex(start);
        Vertex<E> vEnd = getVertex(end);
        if (vStart == null || vEnd == null) return null;

        HashMap<Vertex<E>, Integer> dist = new HashMap<>();
        HashMap<Vertex<E>, Vertex<E>> prev = new HashMap<>();
        PriorityQueue<Vertex<E>> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex<E> v = listVertex.get(i);
            dist.put(v, Integer.MAX_VALUE);
            prev.put(v, null);
        }

        dist.put(vStart, 0);
        pq.add(vStart);

        while (!pq.isEmpty()) {
            Vertex<E> current = pq.poll();

            for (int i = 0; i < current.getListAdj().size(); i++) {
                Edge<E> edge = current.getListAdj().get(i);
                Vertex<E> neighbor = edge.getRefDest();
                int weight = edge.getWeight();
                int alt = dist.get(current) + (weight > -1 ? weight : 1);

                if (alt < dist.get(neighbor)) {
                    dist.put(neighbor, alt);
                    prev.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }

        Stack<E> path = new Stack<>();
        Vertex<E> step = vEnd;
        while (step != null) {
            path.push(step.getData());
            step = prev.get(step);
        }

        if (!path.isEmpty() && path.peek().equals(end)) return path;
        return null;
    }
}
