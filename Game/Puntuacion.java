
package Game;

public class Puntuacion {
   private int pts_b;
        
    public int calculopuntos(int a){
        if(a>2){//Me oculta problemas que hayan con la puntiacion
        pts_b = (int) (Math.pow(2, (a-3))*50);
        }else{
            pts_b=0;
        }
        return pts_b;    
    }
    
    
}
