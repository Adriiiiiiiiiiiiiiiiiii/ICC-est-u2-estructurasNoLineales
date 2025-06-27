import materia.controllers.BinaryTree;
import materia.controllers.AVLTree;

public class App {
    public static void main(String[] args) {
        System.out.println("\nNombre: Adriano Rodas\n");

        BinaryTree ab = new BinaryTree();
        int[] values = { 50, 17, 76, 9, 23, 54, 14, 19 };

        for (int v : values) {
            ab.insert(v);
        }

        ab.printSize();
        System.out.println("Altura es = " + ab.getHeight(ab.getRoot()));

        ab.printInOrder();
        ab.printWithHeights();
        ab.imprimirFactoresEquilibrio();

        System.out.println("Árbol está equilibrado = " + (ab.estaEquilibrado() ? "TRUE" : "FALSE"));
        System.out.println("Existe el nodo 15 = " + (ab.findValue(15) ? "TRUE" : "FALSE"));

        System.out.println("Agregamos valor = 15");
        ab.insert(15);

        System.out.println("Árbol está equilibrado = " + (ab.estaEquilibrado() ? "TRUE" : "FALSE"));
        ab.imprimirFactoresEquilibrio();
        ab.imprimirNodosDesequilibrados();

        System.out.println("\n===== AVL TREE =====");
        AVLTree avl = new AVLTree();
        for (int v : values) {
            avl.insert(v);
        }
        avl.insert(15);

        System.out.print("InOrder del AVL: ");
        avl.printInOrder();
    }
}
