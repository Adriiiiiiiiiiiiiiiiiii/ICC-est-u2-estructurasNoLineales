package materia.controllers;

import materia.controllers.models.Node;

public class BinaryTree {
    private Node root;
    private int size = 0;
    private int alturaDelArbol = 0;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node current, int value) {
        if (current == null) {
            size++;
            return new Node(value);
        }

        if (value < current.getValue()) {
            current.setLeft(insertRec(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRec(current.getRight(), value));
        }

        return current;
    }

    public int getHeight(Node node) {
        if (node == null)
            return 0;
        int left = getHeight(node.getLeft());
        int right = getHeight(node.getRight());
        return 1 + Math.max(left, right);
    }

    public void calcularAltura() {
        this.alturaDelArbol = getHeight(root);
    }

    public void imprimirAltura() {
        System.out.println("Altura del árbol: " + alturaDelArbol);
    }

    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    public void imprimirFactoresEquilibrio() {
        System.out.println("Factores de equilibrio (InOrder):");
        printInOrderBalance(root);
        System.out.println();
    }

    private void printInOrderBalance(Node node) {
        if (node != null) {
            printInOrderBalance(node.getLeft());
            System.out.print(node.getValue() + "(bf=" + getBalanceFactor(node) + "), ");
            printInOrderBalance(node.getRight());
        }
    }

    public void printPreOrder() {
        System.out.println("PreOrder:");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            preOrderRec(node.getLeft());
            preOrderRec(node.getRight());
        }
    }

    public void printInOrder() {
        System.out.println("InOrder:");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.getLeft());
            System.out.print(node.getValue() + ", ");
            inOrderRec(node.getRight());
        }
    }

    public void printPostOrder() {
        System.out.println("PostOrder:");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.getLeft());
            postOrderRec(node.getRight());
            System.out.print(node.getValue() + ", ");
        }
    }

    public void printWithHeights() {
        System.out.println("Alturas por nodo (InOrder):");
        printInOrderHeights(root);
        System.out.println();
    }

    private void printInOrderHeights(Node node) {
        if (node != null) {
            printInOrderHeights(node.getLeft());
            System.out.print(node.getValue() + "(h=" + getHeight(node) + "), ");
            printInOrderHeights(node.getRight());
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean estaEquilibrado() {
        return estaEquilibradoRec(root);
    }

    private boolean estaEquilibradoRec(Node node) {
        if (node == null)
            return true;

        int balance = getBalanceFactor(node);
        if (Math.abs(balance) > 1)
            return false;

        return estaEquilibradoRec(node.getLeft()) && estaEquilibradoRec(node.getRight());
    }

    public void imprimirNodosDesequilibrados() {
        System.out.print("Nodos desequilibrados: ");
        imprimirNodosDesequilibradosRec(root);
        System.out.println();
    }

    private void imprimirNodosDesequilibradosRec(Node node) {
        if (node != null) {
            imprimirNodosDesequilibradosRec(node.getLeft());

            int bf = getBalanceFactor(node);
            if (Math.abs(bf) > 1) {
                System.out.print(node.getValue() + "(fE = " + bf + ") ");
            }

            imprimirNodosDesequilibradosRec(node.getRight());
        }
    }

    public boolean findValue(int value) {
        return findValueRec(root, value);
    }

    private boolean findValueRec(Node node, int value) {
        if (node == null)
            return false;
        if (node.getValue() == value)
            return true;
        return value < node.getValue()
                ? findValueRec(node.getLeft(), value)
                : findValueRec(node.getRight(), value);
    }

    public int getSize() {
        return size;
    }

    public void printSize() {
        System.out.println("Peso del árbol (cantidad de nodos): " + size);
    }
}
