package cr.ac.itcr.main;

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

        SimpleLinkedList lista1 = new SimpleLinkedList();
        lista1.addLast(1);
        lista1.addFirst(2);
        lista1.addLast(3);
        lista1.addLast(4);
        lista1.addLast(5);
        lista1.addAt(6,4);

        System.out.println(lista1.getIndex(6));
    }
}
