package Game;


public class Reglas {
    
    private boolean cumplex;
    private boolean cumpley;
    private boolean cumple;
    
    public boolean regla1(int x_, int y_, int x_b, int y_b){
        //Esta me mira que no me haya movido mas de una pos Y TAMPOCO EN DIAGONAL
        if(Math.abs((x_-x_b))<=1){
            if(y_==y_b){
                cumplex = true;
            }else{
                if(x_-x_b==0){
                    cumplex=true;
                }else{
                    cumplex = false;
                }
                
            }
            
        }else{
            cumplex=false;
        }
        if(Math.abs((y_-y_b))<=1){
            if(x_==x_b){
                cumpley = true;
            }else{
                if(y_-y_b==0){
                    cumpley=true;
                }else{
                    cumpley = false;
                }
                
            }
            
        }else{
            cumpley=false;
        }
        if((cumpley==true)&&(cumplex==true)){
            cumple= true;
        }else{
            cumple= false;
        }
        
        return cumple;
    }
    
    
    
    public boolean regla2(boolean juegaarr_, boolean juegaabaj_, boolean juegaizq_, boolean juegader_, int x_, int y_, int x_b, int y_b){
        //Me mira si la jugada es valida
        cumple = false;
        if((y_b==y_-1)&&(juegaarr_==true)){//arriba
           cumple = true; 
        }
        if((y_b==y_+1)&&(juegaabaj_==true)){//abajo
           cumple = true; 
        }        
        if((x_b==x_+1)&&(juegader_==true)){//derecha
           cumple = true; 
        }
        if((x_b==x_-1)&&(juegaizq_==true)){//izquierda
           cumple = true; 
        }
        
    return cumple;   
    }
}
