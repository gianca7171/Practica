package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphListEdge<V, E> {
    ArrayList<VertexObj<V, E>> secVertex;
    ArrayList<EdgeObj<V, E>> secEdge;

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    public void insertVertex(V info) {
        if (!searchVertex(info)) {
            VertexObj<V, E> v = new VertexObj<>(info, secVertex.size());
            secVertex.add(v);
        }
    }

    public void insertEdge(V v, V z) {
        if (!searchEdge(v, z)) {
            VertexObj<V, E> v1 = getVertex(v);
            VertexObj<V, E> v2 = getVertex(z);
            if (v1 != null && v2 != null) {
                EdgeObj<V, E> e = new EdgeObj<>(v1, v2, null, secEdge.size());
                secEdge.add(e);
            }
        }
    }

    public boolean searchVertex(V info) {
        for (VertexObj<V, E> v : secVertex) {
            if (v.getInfo().equals(info)) return true;
        }
        return false;
    }

    public boolean searchEdge(V v, V z) {
        VertexObj<V, E> v1 = getVertex(v);
        VertexObj<V, E> v2 = getVertex(z);
        if (v1 == null || v2 == null) return false;

        for (EdgeObj<V, E> e : secEdge) {
            if ((e.getEndVertex1().equals(v1) && e.getEndVertex2().equals(v2)) ||
                (e.getEndVertex1().equals(v2) && e.getEndVertex2().equals(v1))) {
                return true;
            }
        }
        return false;
    }

    public void bfs(V info) {
        VertexObj<V, E> start = getVertex(info);
        if (start == null) return;

        ArrayList<VertexObj<V, E>> visited = new ArrayList<>();
        Queue<VertexObj<V, E>> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.poll();
            System.out.print(current.getInfo() + " ");

            for (EdgeObj<V, E> edge : secEdge) {
                VertexObj<V, E> neighbor = null;

                if (edge.getEndVertex1().equals(current)) {
                    neighbor = edge.getEndVertex2();
                } else if (edge.getEndVertex2().equals(current)) {
                    neighbor = edge.getEndVertex1();
                }

                if (neighbor != null && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    private VertexObj<V, E> getVertex(V info) {
        for (VertexObj<V, E> v : secVertex) {
            if (v.getInfo().equals(info)) return v;
        }
        return null;
    }

    public String toString() {
        return "Vértices: " + secVertex.toString() + "\nAristas: " + secEdge.toString();
    }
}
