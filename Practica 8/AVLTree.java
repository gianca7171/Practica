package avltree;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

    private boolean height; // indicador de cambio de altura

    class NodeAVL extends Node {
        protected int bf;

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        public String toString() {
            return this.data + " (BF: " + bf + ")"; // imprime dato y factor de equilibrio
        }
    }

    public AVLTree() {
        super();
    }

    public void insert(E x) throws ItemDuplicated {
        this.height = false; // se inicializa en false antes de la insercion
        this.root = insert(x, (NodeAVL) this.root);
    }

    protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
        NodeAVL fat = node;
        if (node == null) {  // caso base
            this.height = true;  // cambio de altura
            fat = new NodeAVL(x);
        } else {
            int resC = node.data.compareTo(x);  // compara el dato del nodo actual con el elemento que se quiere insertar
            if (resC == 0) {  // ya existe en el arbol
                throw new ItemDuplicated(x + " ya se encuentra en el arbol...");
            }
            if (resC < 0) {  // se inserta en el subarbol derecho
                fat.right = insert(x, (NodeAVL) node.right);
                if (this.height) {
                    switch (fat.bf) {
                        case -1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = 1;
                            this.height = true;
                            break;
                        case 1: //bf = 2
                            fat = balanceToLeft(fat);
                            this.height = false;
                            break;
                    }
                }
            } else {  // se inserta en el subarbol izquierdo
                fat.left = insert(x, (NodeAVL) node.left);
                if (this.height) {
                    switch (fat.bf) {
                        case 1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = -1;
                            this.height = true;
                            break;
                        case -1: //bf = -2
                            fat = balanceToRight(fat);
                            this.height = false;
                            break;
                    }
                }
            }
        }
        return fat;
    }
    
    private NodeAVL balanceToLeft(NodeAVL node) {  // RSL o RDL
        NodeAVL hijo = (NodeAVL) node.right;
        switch (hijo.bf) {
            case 1:  // rotacion simple a la izquierda
                node.bf = 0;    
                hijo.bf = 0;
                node = rotateSL(node);
                break;
            case -1: // rotacion doble izquierda
                NodeAVL nieto = (NodeAVL) hijo.left;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = -1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.right = rotateSR(hijo);
                node = rotateSL(node);
                break;
        }
        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) { //RSR o RDR
        NodeAVL hijo = (NodeAVL) node.left;
        switch (hijo.bf) { 
            case -1: // rotacion simple
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1: // rotacion doble
                NodeAVL nieto = (NodeAVL) hijo.right;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = 0;
                        hijo.bf = -1;
                        break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
                break;
        }
        return node;
    }
    
    // rotacion simple a la izquierda
    private NodeAVL rotateSL(NodeAVL node) {  
        NodeAVL p = (NodeAVL) node.right; 
        node.right = p.left;
        p.left = node;
        return p;
    }
    
    // rotacion simple a la derecha
    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right; // subarbol derecho de p pasa a ser subarbol izquierdo del padre de p
        p.right = node;  // padre de p pasa a ser subarbol derecho de p
        return p; 
    }
    

    public void remove(E x) throws ItemNoFound {
        this.height = false; // se inicializa en false antes de la eliminación
        this.root = remove(x, (NodeAVL) this.root);
    }

    protected NodeAVL remove(E x, NodeAVL node) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound(x + " no se encuentra en el árbol...");
        }

        NodeAVL fat = node;
        int resC = node.data.compareTo(x);

        if (resC < 0) { // buscar en el subarbol derecho
            fat.right = remove(x, (NodeAVL) node.right);
            if (this.height) {
                fat = balanceToRight(fat);
                if (fat.bf == -1) {
                    this.height = false;
                }
            }
        } else if (resC > 0) { // buscar en el subarbol izquierdo
            fat.left = remove(x, (NodeAVL) node.left);
            if (this.height) {
                fat = balanceToLeft(fat);
                if (fat.bf == 1) {
                    this.height = false;
                }
            }
        } else { // nodo encontrado
            if (node.left == null || node.right == null) { // tiene 0 o 1 hijo
                fat = (NodeAVL) (node.left != null ? node.left : node.right);
                this.height = true;
            } else { // tiene 2 hijos
                NodeAVL succ = findMin((NodeAVL) node.right);
                node.data = succ.data;
                node.right = remove(node.data, (NodeAVL) node.right);
                if (this.height) {
                    fat = balanceToRight(fat);
                    if (fat.bf == -1) {
                        this.height = false;
                    }
                }
            }
        }

        return fat;
    }
    
    // método encuentra el nodo con el valor mínimo en un subárbol (el nodo más a la izquierda)
    private NodeAVL findMin(NodeAVL node) {
        while (node.left != null) {
            node = (NodeAVL) node.left;
        }
        return node;
    }
    
    
    public void recorridoPorAmplitud() {
        int height = getHeight((NodeAVL) this.root);
        for (int level = 0; level <= height; level++) {
            imprimirNivel((NodeAVL) this.root, level);
        }
    }

    // Método para obtener la altura del árbol
    private int getHeight(NodeAVL node) {
        if (node == null) {
            return -1;
        } else {
            int leftHeight = getHeight((NodeAVL) node.left);
            int rightHeight = getHeight((NodeAVL) node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // Método para imprimir los nodos de un nivel específico
    private void imprimirNivel(NodeAVL node, int level) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            System.out.print(node.data + " ");
        } else {
            imprimirNivel((NodeAVL) node.left, level - 1);
            imprimirNivel((NodeAVL) node.right, level - 1);
        }
    }
}
