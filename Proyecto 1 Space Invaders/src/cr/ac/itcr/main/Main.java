package cr.ac.itcr.main;

import cr.ac.itcr.dataStructuresLinear.*;

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

        SimpleLinkedList<Integer> listaSimple = new SimpleLinkedList<Integer>();
        listaSimple.addFirst(-2);
        listaSimple.addLast(0);
        listaSimple.addAt(-1,1);
        listaSimple.printList();

    }
}
