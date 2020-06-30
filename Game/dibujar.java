/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;


public class dibujar {
    
   
    public void mostrar(Fichas a[][]){
            
            /*
            System.out.println("___________________");
            for(int i=0;i<a[0][0].getDimy();i++){
                for(int i2=0; i2<a[0][0].getDimx();i2++){
                    System.out.print(a[i][i2].isJuegaficha()+" ");
                }
                //System.out.println("Entre");
                System.out.println("");  
            }        
            */
            
            System.out.println("___________________");
            for(int i=-1;i<(a[0][0].getDimy());i++){
                if(i==-1){
                    System.out.print("   ");
                }else{
                    System.out.print((i+1)+" |");
                }
                for(int i2=0; i2<a[0][0].getDimx();i2++){
                        if(i==-1){
                            System.out.print((i2+1)+"  ");
                        }else{
                                System.out.print(a[i][i2].getFicha()+" ");
                            
                        }
                }
                //System.out.println("Entre");
                System.out.println("");  
            }
        }
    
}
