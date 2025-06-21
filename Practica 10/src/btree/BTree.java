package btree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;

        mediana = push(this.root, cl);

        if (up) {
            pnew = new BNode<>(this.orden);
            pnew.count = 1;
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, this.root);
            pnew.childs.set(1, nDes);

            if (this.root != null) this.root.parent = pnew;
            if (nDes != null) nDes.parent = pnew;

            this.root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        int[] pos = new int[1];
        E mediana;

        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean fl = current.searchNode(cl, pos);
            if (fl) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }

            mediana = push(current.childs.get(pos[0]), cl);

            if (up) {
                if (current.nodeFull(this.orden - 1)) {
                    mediana = dividedNode(current, mediana, pos[0]);
                } else {
                    putNode(current, mediana, nDes, pos[0]);
                    up = false;
                }
            }

            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        for (int i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;

        if (rd != null) rd.parent = current;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int i, posMdna;

        posMdna = this.orden / 2;
        E median = current.keys.get(posMdna);

        nDes = new BNode<>(this.orden);
        nDes.parent = current.parent;

        for (i = posMdna + 1; i < this.orden - 1; i++) {
            nDes.keys.set(i - (posMdna + 1), current.keys.get(i));
            nDes.childs.set(i - (posMdna + 1) + 1, current.childs.get(i + 1));
            if (nDes.childs.get(i - (posMdna + 1) + 1) != null) {
                nDes.childs.get(i - (posMdna + 1) + 1).parent = nDes;
            }
        }

        nDes.count = (this.orden - 1) - (posMdna + 1);

        for (i = posMdna + 1; i < this.orden - 1; i++) {
            current.keys.set(i, null);
            current.childs.set(i + 1, null);
        }

        current.count = posMdna;
        current.keys.set(posMdna, null);
        current.childs.set(posMdna + 1, null);

        if (k <= posMdna) {
            putNode(current, cl, rd, k);
        } else {
            putNode(nDes, cl, rd, k - (posMdna + 1));
        }

        return median;
    }

    public boolean search(E cl) {
        return searchRecursive(this.root, cl);
    }

    private boolean searchRecursive(BNode<E> node, E cl) {
        if (node == null) return false;

        int pos = 0;
        while (pos < node.count && cl.compareTo(node.keys.get(pos)) > 0) {
            pos++;
        }

        if (pos < node.count && cl.compareTo(node.keys.get(pos)) == 0) {
            System.out.println(cl + " se encuentra en el nodo " + node.idNode + " en la posición " + pos);
            return true;
        }

        return searchRecursive(node.childs.get(pos), cl);
    }

    public void remove(E cl) {
        System.out.println("(No implementado aún) Eliminando: " + cl);
    }

    public static BTree<Integer> building_Btree(String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        int orden = Integer.parseInt(br.readLine().trim());
        BTree<Integer> btree = new BTree<>(orden);

        Map<Integer, BNode<Integer>> nodos = new HashMap<>();
        Map<Integer, Integer> niveles = new HashMap<>();
        List<String[]> lineas = new ArrayList<>();

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            lineas.add(partes);
            int id = Integer.parseInt(partes[1]);
            niveles.put(id, Integer.parseInt(partes[0]));

            BNode<Integer> nodo = new BNode<>(orden);
            nodo.idNode = id;
            for (int i = 2; i < partes.length; i++) {
                nodo.keys.set(i - 2, Integer.parseInt(partes[i]));
                nodo.count++;
            }
            nodos.put(id, nodo);
        }
        br.close();

        lineas.sort(Comparator.comparingInt(a -> Integer.parseInt(a[0])));

        for (String[] partes : lineas) {
            int idPadre = Integer.parseInt(partes[1]);
            BNode<Integer> padre = nodos.get(idPadre);

            if (niveles.get(idPadre) == 0) {
                if (btree.root == null) {
                    btree.root = padre;
                }
                continue;
            }

            for (int i = 0; i < partes.length; i++) {
                if (partes[i].equals(String.valueOf(idPadre))) {
                    int nivelHijo = Integer.parseInt(partes[0]) - 1;
                    for (int j = 0; j < lineas.size(); j++) {
                        String[] lineaHija = lineas.get(j);
                        if (Integer.parseInt(lineaHija[0]) == nivelHijo) {
                            int idHijo = Integer.parseInt(lineaHija[1]);
                            BNode<Integer> hijo = nodos.get(idHijo);
                            if (hijo.parent == null) {
                                hijo.parent = padre;
                                for (int k = 0; k < padre.childs.size(); k++) {
                                    if (padre.childs.get(k) == null) {
                                        padre.childs.set(k, hijo);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }

        return btree;
    }

    public String buscarNombre(int codigo) {
        return buscarNombreRecursivo(this.root, codigo);
    }

    private String buscarNombreRecursivo(BNode<E> nodo, int codigo) {
        if (nodo == null) return "No encontrado";

        for (int i = 0; i < nodo.count; i++) {
            RegistroEstudiante est = (RegistroEstudiante) nodo.keys.get(i);
            if (est.getCodigo() == codigo) {
                return est.getNombre();
            } else if (codigo < est.getCodigo()) {
                return buscarNombreRecursivo(nodo.childs.get(i), codigo);
            }
        }
        return buscarNombreRecursivo(nodo.childs.get(nodo.count), codigo);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("BTree is empty...\n");
        } else {
            sb.append(String.format("%-10s%-30s%-12s%-20s\n", "Id.Nodo", "Claves Nodo", "Id.Padre", "Id.Hijos"));
            sb.append(String.format("%-10s%-30s%-12s%-20s\n", "-------", "------------------------------", "--------", "--------------"));
            sb.append(writeTree(this.root));
        }
        return sb.toString();
    }

    private String writeTree(BNode<E> current) {
        StringBuilder sb = new StringBuilder();
        if (current != null) {
            ArrayList<E> clavesActuales = new ArrayList<>();
            for (int i = 0; i < current.count; i++) {
                clavesActuales.add(current.keys.get(i));
            }

            sb.append(String.format("%-10d", current.idNode));
            sb.append(String.format("%-30s", clavesActuales));

            if (current.parent != null) {
                sb.append(String.format("%-12s", "[" + current.parent.idNode + "]"));
            } else {
                sb.append(String.format("%-12s", "--"));
            }

            ArrayList<Integer> hijos = new ArrayList<>();
            for (int i = 0; i <= current.count; i++) {
                BNode<E> hijo = current.childs.get(i);
                if (hijo != null) hijos.add(hijo.idNode);
            }

            sb.append(hijos.isEmpty() ? "--" : hijos.toString());
            sb.append("\n");

            for (int i = 0; i <= current.count; i++) {
                if (current.childs.get(i) != null) {
                    sb.append(writeTree(current.childs.get(i)));
                }
            }
        }
        return sb.toString();
    }
}
