package cr.ac.itcr.enemigos;

import javax.swing.Timer;
import java.util.ArrayList;
import java.util.LinkedList;


public class Enemy {
     public Integer posx;
     public Integer posy;
     public Boolean basicLife;
     public Integer bossLife;

     ArrayList <Integer> tipo = new ArrayList<Integer>();
     //tipo.add(TypeA);
     //tipo.add(TypeB);
     //tipo.add(TypeC);
     //tipo.add(TypeD);
     //tipo.add(TypeE);

     public Integer getPosx() {

          return posx;
     }

     public void setPosx(Integer posx) {

          this.posx = posx;
     }

     public Integer getPosy() {

          return posy;
     }

     public void setPosy(Integer posy) {

          this.posy = posy;
     }

     public Boolean getBasicLife() {

          return basicLife;
     }

     public void setBasicLife(Boolean basicLife) {

          this.basicLife = basicLife;
     }

     public Integer getBossLife() {

          return bossLife;
     }

     public void setBossLife(Integer bossLife) {

          this.bossLife = bossLife;
     }


}
