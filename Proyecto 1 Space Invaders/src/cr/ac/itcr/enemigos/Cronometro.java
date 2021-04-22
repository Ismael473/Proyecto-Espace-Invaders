package cr.ac.itcr.enemigos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Cronometro {
    private Timer t;
    private Integer min, sec, censec;
    private Integer ciclo;

    public Cronometro(Timer t) {
        this.t = t;
    }

    int delay = 1000;
    public ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            censec++;
            ciclo = 0;
            if(censec == 100){
                censec = 0;
                sec++;
            }
            if(sec == 60){
                sec = 0;
                min++;
            }
            if(min == 60){
                min = 0;
                ciclo++;

            }
        }
    };




}
