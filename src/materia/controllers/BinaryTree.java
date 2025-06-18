package materia.controllers;

import materia.controllers.models.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void imprimirArbol() {
        System.out.print("Preorden: ");
        printPreOrder(root);
        System.out.println();

        System.out.print("Inorden: ");
        printInOrder(root);
        System.out.println();

        System.out.print("Postorden: ");
        printPostOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrder(node.getRight());
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }
    private boolean findValueRec(Node raiz, int valor) {
        if (raiz == null) {
            return false; 
        }
        if (raiz.getValor() == valor) {
            return true; 
        }
        return findValueRec(raiz.getLeft(), valor) || findValueRec(raiz.getRight(), valor);
    }

    public boolean findValue(int valor) {
        return findValueRec(raiz, valor);
    }
}