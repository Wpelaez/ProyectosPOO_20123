
package Game;

import java.util.Scanner;


public class Seleccion{

    private int x;
    private int y;
    private int x_b;
    private int y_b;
    
    Scanner read = new Scanner(System.in);
    
    
    
    public void escojer(int dimx_, int dimy_){
                System.out.println("Ingrese las coordenadas de inicio");
                //System.out.println("dimx "+dimx_+" dimy"+dimy_);
                System.out.print("X:");
        
                do{
                    x = (read.nextInt())-1;
                    if((x>=(dimx_))||(x<0)){
                    System.out.println("Ingrese una coordenada entre 1 y "+(dimx_));
                    }
                }while((x>(dimx_-1))||(x<0));
                System.out.print("Y:");
                do{
                    y = (read.nextInt())-1;
                    if((y>=(dimy_))||(y<0)){
                        System.out.println("Ingrese una coordenada entre 1 y "+(dimy_));
                    }
                }while((y>(dimy_-1))||(y<0));
    }
    
    public void escojerb(int dimx_, int dimy_){
                System.out.println("Ingrese las coordenadas destino");
                //System.out.println("dimx "+dimx_+" dimy"+dimy_);
                System.out.print("X:");
        
                do{
                    x_b = (read.nextInt())-1;
                    if((x_b>=(dimx_))||(x_b<0)){
                    System.out.println("Ingrese una coordenada entre 1 y "+(dimx_));
                    }
                }while((x_b>(dimx_-1))||(x_b<0));
                System.out.print("Y:");
                do{
                    y_b = (read.nextInt())-1;
                    if((y_b>=(dimy_))||(y_b<0)){
                        System.out.println("Ingrese una coordenada entre 1 y "+(dimy_));
                    }
                }while((y_b>(dimy_-1))||(y_b<0));
    }
    
    public void fescojida(String a, boolean juegaficha_, boolean juegaarr_, boolean juegaabaj_, boolean juegaizq_, boolean juegader_){
        System.out.println("El dulce escojido es: "+a);
        if(juegaficha_==true){
            System.out.println("La ficha Puede Jugar");
        }else{
            System.out.println("La ficha NO Puede Jugar Ingrese las mismas coordenadas o otras, el movimiento no se contara");
        }
        if(juegaarr_==true){
            System.out.println("La ficha se puede mover para arriba");
        }
        if(juegaabaj_==true){
            System.out.println("La ficha se puede mover para abajo");
        }        
        if(juegaizq_==true){
            System.out.println("La ficha se puede mover para la izquierda");
        }
        if(juegader_==true){
            System.out.println("La ficha se puede mover para la derecha");
        }
        
    }
    
    //

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
     
    public int getX_b() {
        return x_b;
    }

    public int getY_b() {
        return y_b;
    }
    
    //


}
