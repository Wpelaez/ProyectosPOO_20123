
package Game;

import java.util.Scanner;


public class Juego {
    Scanner read = new Scanner(System.in);
    private int nivel=0;
    private int dimx;
    private int dimy;
    private int test;
    private boolean bool;
    private int pass;
    private int vidas=5;
    private int movimientos;
    
   public void bienvenida(){
       System.out.println("Bienvenido a candy crush, acontinuacion selecciona el nivel:");
       System.out.println("1. Jelly");
       System.out.println("2. Ingredient");
       System.out.println("3. Timed");
       System.out.println("4. Salir");
   }
   
   public void nivel(int a){
       switch (a){
           case 1:{
               System.out.println("Nivel 1 : Jelly");
               System.out.println("Puntos para pasar: "+pass);
               System.out.println("Movimientos permitidos: "+movimientos);
               break;
           }
           case 2:{
               System.out.println("Nivel 2 : Ingredient");
               
               break;
           }
           case 3:{
               System.out.println("Nivel 3 : Timed");
               
               break;
           }
       }
   }
   
   public void seleccionarnivel(){
       do{
       nivel = read.nextInt();
       if((nivel<=4)&&(nivel>=1)){
           switch(nivel){
               case 1:{
                   dimx = 9;
                   dimy = 9;
                   pass = 1000; // Puntos para pasar
                   movimientos = 50;
                   //test = 20;
                   break;
               }
               case 2:{
                   System.out.println("Aun no disponible");
                   break;
               }
               case 3:{
                   System.out.println("Aun no disponible");
                   break;
               }
               case 4:{
                   System.out.println("SALIR");
               }
           }
       }else{
           System.out.println("Ingrese un numero valido");
       }
       }while((nivel!=1)&&(nivel!=4));
       //System.out.println(dimx+" "+dimy+"En la clase juego");
   }
   
   public void vidas(int a, boolean b){
       if((a>=movimientos)||(b==false)){
           vidas -=1;
           System.out.println("Se perdio una Vida");
       }
       if(b==false){
           System.out.println("Te has quedado sin Jugadas");
       }
       if(a>=movimientos){
           System.out.println("Te has quedado sin movimientos");
       }
   }
   
   public void nivelcompletado(int a, int b){
       System.out.println("Felicidades Nivel:"+nivel+" completado");
       System.out.println("Puntos: "+a);
       System.out.println("Movimientos: "+b);
       System.out.println("Por el momento no hay mas niveles construidos sera llevado devuelta al menu.");
   }
   
   public void gameover(){
       if(vidas==0){
           System.out.println("GAME OVER");
           System.out.println("Te quedaste sin Vidas");
           System.out.println("Por el momento no hay mas niveles construidos sera llevado devuelta al menu.");
       }
   }
   
   
   /*
   public void mostrara (){
       System.out.println(dimx+" "+dimy+"EN LA CLASE JUEGO DESPUES DEL SWTICH");
   }
    */
   
   //getters
   public int getDimx (){
       return dimx;
   }
   public int getDimy (){
       return dimy;
   }
   
   public int getTest() {
        return test;
    }
   public int getNivel(){
       return nivel;
   }
   public int getPass() {
        return pass;
    }
   public int getVidas() {
        return vidas;
    }
   public int getMovimientos() {
        return movimientos;
    }
   
   
   
   //termina getters







 
}
