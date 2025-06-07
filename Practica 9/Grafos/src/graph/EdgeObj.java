package graph;

public class EdgeObj<V, E> {
    protected E info;
    protected VertexObj<V, E> endVertex1;
    protected VertexObj<V, E> endVertex2;
    protected int position;

    public EdgeObj(VertexObj<V, E> vert1, VertexObj<V, E> vert2, E info, int position) {
        this.endVertex1 = vert1;
        this.endVertex2 = vert2;
        this.info = info;
        this.position = position;
    }

    public VertexObj<V, E> getEndVertex1() {
        return endVertex1;
    }

    public VertexObj<V, E> getEndVertex2() {
        return endVertex2;
    }

    public E getInfo() {
        return info;
    }

    public boolean equals(Object o) {
        if (o instanceof EdgeObj<?, ?>) {
            EdgeObj<?, ?> e = (EdgeObj<?, ?>) o;
            return (e.endVertex1.equals(this.endVertex1) && e.endVertex2.equals(this.endVertex2)) ||
                   (e.endVertex1.equals(this.endVertex2) && e.endVertex2.equals(this.endVertex1));
        }
        return false;
    }

    public String toString() {
        return "(" + endVertex1 + " - " + endVertex2 + ")";
    }
}
