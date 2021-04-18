package cr.ac.itcr.main;

import cr.ac.itcr.dataStructuresLinear.DoubleLinkedList;
import cr.ac.itcr.dataStructuresLinear.SimpleLinkedList;

public class Main {
    public static void main(String[] args) {
        /*
        JFrame pantalla = new JFrame(); // Se inicializa la variable de pantalla
        pantalla.setBounds(10, 10, 700,600); //tamaño de pantalla
        pantalla.setTitle("DUCK INVADERS"); //titulo de la pantalla
        pantalla.setResizable(false); // Bloqueo de ajuste de tamaño de pantalla
        pantalla.setVisible(true); // manda la ventana al frente y la hace un objeto modificable
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cuando se cierra la ventana se termina el programa
        */

        DoubleLinkedList lista1 = new DoubleLinkedList();

        lista1.addLast(2);

        lista1.addLast(4);
        lista1.addFirst(1);
        lista1.addAt(3,2);
        lista1.addLast(5);
        lista1.addLast(6);
        lista1.addLast(7);
        lista1.remove(4);
        lista1.clear();
        lista1.printList();


    }
}
