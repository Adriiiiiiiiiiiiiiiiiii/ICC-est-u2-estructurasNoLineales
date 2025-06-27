package materia.controllers;

import materia.controllers.models.Node;

public class AVLTree {
    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            System.out.println("nodo insertado -> " + value + " con balance 0");
            return newNode;
        }

        if (value < node.getValue()) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRec(node.getRight(), value));
        } else {
            return node; // Valor duplicado
        }

        System.out.println("nodo actual -> " + node.getValue());

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        System.out.println("    altura -> " + node.getHeight());

        int balance = getBalance(node);
        System.out.println("    balance -> " + balance);

        // Casos de rotación
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Cambio");
            System.out.println("Rotacion simple derecha");
            return rotateRight(node);
        }

        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Cambio");
            System.out.println("Rotacion simple izquierda");
            return rotateLeft(node);
        }

        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Cambio");
            System.out.println("Rotacion doble izquierda-derecha");
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }

        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("Cambio");
            System.out.println("Rotacion doble derecha-izquierda");
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }

        return node;
    }

    private int height(Node node) {
        return node == null ? 0 : node.getHeight();
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.getLeft()) - height(node.getRight());
    }

    private Node rotateRight(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        System.out.println("Rotacion a la izquierda en nodo " + x.getValue() + ", con balance = " + getBalance(x));

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));

        System.out.println("Nueva raiz despues de la rotacion " + y.getValue());

        return y;
    }

    public void printInOrder() {
        System.out.println("InOrder del árbol AVL:");
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(Node node) {
        if (node != null) {
            printInOrderRec(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrderRec(node.getRight());
        }
    }

    public Node getRoot() {
        return root;
    }
}
