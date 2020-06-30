
package Game;

public class Fichas{
    
    private int dimx;
    private int dimy;
    private int rand;
    private String ficha;
    private boolean hueco;
    private boolean rep=true;
    private boolean izq;
    private boolean der;
    private boolean arr;
    private boolean abaj;
    private int izq_b;
    private int der_b;
    private int arr_b;
    private int abaj_b;
    private boolean juegaficha;
    private boolean juegaarr;
    private boolean juegaabaj;
    private boolean juegader;
    private boolean juegaizq;
    private boolean izq_simple;
    private boolean der_simple;
    private boolean arr_simple;
    private boolean abaj_simple;
    private boolean horizontal;
    private boolean vertical;
    private boolean entre1;
    private boolean entre2;
    private int auxi;
    
    //Juego dum = new Juego();
    
    public Fichas(){
        
    }

    public Fichas(int dimx_,int dimy_){
        dimx=dimx_;
        dimy=dimy_;
    }
    
    public void mostrarb(){
        //dum.seleccionarnivel();
        //System.out.println(getTest()+"En la clase fichas TESTTT");
        System.out.println("dimx:"+dimx+" dimy:"+dimy+" En la clase fichas");
    }
    
    public void fillE(){
        ficha="nada";
        rand = -1;//CAMBIE POR -1
        hueco = false;
        izq = true;
        der = true;
        arr = true;
        abaj = true;
        izq_b = 1;
        der_b = 1;
        arr_b = 1;
        abaj_b = 1;
        horizontal = false;
        vertical = false;
        juegaficha = false;
        juegaarr=false;
        juegaabaj=false;
        juegaizq=false;
        juegader=false;
    }
    
    public void huecos(Fichas a[][],int b){
        switch(b){
            case 1:{
                //a[0][0].hueco=true;
                //a[0][0].ficha="..";
                //a[1][0].hueco=true;
                //a[1][0].ficha="..";
                //a[0][8].hueco=true;
                //a[0][8].ficha="..";
                //a[1][8].hueco=true;
                //a[1][8].ficha="..";
                //a[8][0].hueco=true;
                //a[8][0].ficha="..";
                //a[7][0].hueco=true;
                //a[7][0].ficha="..";
                //a[8][8].hueco=true;
                //a[8][8].ficha="..";
                //a[7][8].hueco=true;
                //a[7][8].ficha="..";
                //no hay huecos matriz cuadrada
                break;
            }
            case 2:{
                //aun no
                break;
            }
            case 3:{
                //aun no
                break;
            }
        }
    }
    
    
    public void llenar(Fichas a[][], boolean b){
        //Llena la matriz de random sin mirar si repiten cada dos pos
        for (int i=0;i<dimy;i++){
            for(int i2=0;i2<dimx;i2++){
                //System.out.println("Entre");
                if((a[i][i2].rand==-1)&&(a[i][i2].hueco==false)){
                        a[i][i2].rand = (int)(Math.random()*4);
                }
            }
        }
        //
        
        //Evalua cada elemento con un dos posiciones ya sea izq, der, arr, abj para que no se den 3 repetidos seguidos sin emepezar a jugar
        //Evalua si se puede comprobar arrb o abaj etc dependiendo la pos
        
        for(int i=0;i<dimy;i++){
            for(int i2=0;i2<dimx;i2++){
                //a[i][i2].abaj = true;
                
                if(i<2){
                    a[i][i2].arr = false;
                    a[i][i2].arr_b = -1;                    
                }else{
                    a[i][i2].arr = true;
                    a[i][i2].arr_b = 1;
                }
                if(i2<2){
                    a[i][i2].izq = false;
                    a[i][i2].izq_b = -1;
                }else{
                    a[i][i2].izq = true;
                    a[i][i2].izq_b = 1;
                }
                if(i>(dimy-3)){//6
                    a[i][i2].abaj = false;
                    a[i][i2].abaj_b = -1;
                }else{
                    a[i][i2].abaj = true;
                    a[i][i2].abaj_b = 1;
                }
                if(i2>(dimx-3)){//6
                    a[i][i2].der = false;
                    a[i][i2].der_b = -1;
                }else{
                    a[i][i2].der = true;
                    a[i][i2].der_b = 1;
                }      
        //termina de asignar las posiciones especiales
        //empieza la comprobacion
                if(a[i][i2].hueco==false){
                    rep = true;
                    entre1 = false;
                    auxi = 0;
                    a[i][i2].horizontal=false;
                    a[i][i2].vertical=false;
                    //System.out.println("Analize la posicion "+(i+1)+" "+(i2+1)+" arr:"+a[i][i2].arr+" abaj:"+a[i][i2].abaj+" izq:"+a[i][i2].izq+" der:"+a[i][i2].der);
                    
                    while(rep==true){
                        
                        if((a[i-(1*a[i][i2].arr_b)][i2].rand==a[i][i2].rand)&&(a[i-(2*a[i][i2].arr_b)][i2].rand==a[i][i2].rand)&&(a[i][i2].arr != false)&&(a[i][i2].vertical==false)){
                            if((a[i-1][i2].hueco!=true)&&((a[i-2][i2].hueco!=true))){    
                                if(b==true){
                                    //System.out.print("Cambie en la posicion ARRB "+(i+1)+" "+(i2+1)+" un "+a[i][i2].rand+" por un ");
                                    a[i][i2].rand=(int)(Math.random()*4);
                                    //System.out.println(a[i][i2].rand+"");
                                    //
                                }else{
                                        //System.out.println("Entre ARRB ");
                                        a[i][i2].vertical = true;
                                        //entre1 = true;
                                        //rep=false;
                                }
                            }
                        }else{
                            
                            if((a[i+(1*a[i][i2].abaj_b)][i2].rand==a[i][i2].rand)&&(a[i+(2*a[i][i2].abaj_b)][i2].rand==a[i][i2].rand)&&(a[i][i2].abaj != false)&&(a[i][i2].vertical==false)){
                                if((a[i+1][i2].hueco!=true)&&((a[i+2][i2].hueco!=true))){
                                    if(b==true){
                                        //System.out.print("Cambie en la posicion ABAJ "+(i+1)+" "+(i2+1)+" un "+a[i][i2].rand+" por un ");
                                        a[i][i2].rand=(int)(Math.random()*4);
                                        //System.out.println(a[i][i2].rand+"");
                                    }else{
                                        //System.out.println("Entre Abaj");
                                        a[i][i2].vertical = true;
                                        //entre1 = true;
                                        //rep=false;
                                    }
                                }
                            }else{
                                if((a[i][i2+(1*a[i][i2].der_b)].rand==a[i][i2].rand)&&(a[i][i2+(2*a[i][i2].der_b)].rand==a[i][i2].rand)&&(a[i][i2].der != false)&&(a[i][i2].horizontal==false)){
                                    if((a[i][i2+1].hueco!=true)&&((a[i][i2+2].hueco!=true))){
                                        if(b==true){
                                            //System.out.print("Cambie en la posicion DER "+(i+1)+" "+(i2+1)+" un "+a[i][i2].rand+" por un ");
                                            a[i][i2].rand=(int)(Math.random()*4);
                                            //System.out.println(a[i][i2].rand+"");
                                        }else{
                                            //System.out.println("Entre DER ");
                                            a[i][i2].horizontal=true;
                                            //entre1=true;
                                            //rep=false;
                                        }
                                    }
                                }else{
                                    if((a[i][i2-(1*a[i][i2].izq_b)].rand==a[i][i2].rand)&&(a[i][i2-(2*a[i][i2].izq_b)].rand==a[i][i2].rand)&&(a[i][i2].izq != false)&&(a[i][i2].horizontal==false)){
                                        if((a[i][i2-1].hueco!=true)&&((a[i][i2-2].hueco!=true))){
                                            if(b==true){
                                                //System.out.print("Cambie en la posicion IZQ "+(i+1)+" "+(i2+1)+" un "+a[i][i2].rand+" por un ");
                                                a[i][i2].rand=(int)(Math.random()*4);
                                                //System.out.println(a[i][i2].rand+"");
                                            }else{
                                                //System.out.println("Entre Izq ");
                                                a[i][i2].horizontal=true;
                                                //entre1=true;
                                                //rep=false;
                                            }
                                        }
                                    }else{
                                        rep = false;
                                        //System.out.println("SALI en la posicion "+(i+1)+(i2+1)+" con un valor de "+a[i][i2].rand);
                                        //System.out.println("Entre FIN CICLO con la posicion "+i+" "+i2);
                                        //a[i][i2].vertical=false;
                                        //a[i][i2].horizontal=false;
                                        /*
                                        if(entre1!=true){
                                            a[i][i2].vertical=false;
                                            a[i][i2].horizontal=false;
                                            while(auxi<1){
                                                rep = true;
                                                auxi=auxi+1;
                                            }
                                        }
                                        */
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //termina la comprobacion 
        /*
        vertical y horizontal determinan si hay 3 seguidas y asignan un valor de true al elemnto del la matriz
        cada if evalua si hay en el momento 3 seguidas ya sea arriba, abajo, izq, derecha.
        si el elemento entra a algun if, con el boolean entre se recuerda esa accion para que pueda salir del ciclo
        si un elemento no entra al algun if puede ser por:
            a)en el momento ni arr,abaj,izq,der hay tres seguidas de su mismo color
            b)trae de alguna jugada anterior el boolean horizontal o vertical ya en true, razon por la cual se le asignan valores de 
              false en horizontal y vertical recordando si entro a algun ciclo
        */
        //Termina evaluar repetido
       //empieza a asignar ficha(dulce)
       
       for(int i=0; i<dimy;i++){
           for(int i2=0; i2<dimx;i2++){
               //((a)&&(()||(().eq())))
               //if((a[i][i2].hueco==false)&&((b==true)||((a[i][i2].ficha).equals("nada")))){
               if(a[i][i2].hueco==false){
               switch (a[i][i2].rand){
                   case 0:{
                       a[i][i2].ficha="Ro";//Jelly bean ROJO
                       break;
                   }
                   case 1:{
                       a[i][i2].ficha="Na";// Pastilla Naranja
                       break;
                   }
                   case 2:{
                       a[i][i2].ficha="Am";// Gota de limón. Amarillo
                       break;
                   }
                   case 3:{
                       a[i][i2].ficha="Ve";// Cuadrados de chiclets Verde
                       break;
                   }
                   case 4:{
                       a[i][i2].ficha="Az";// "Cabeza" de piruleta. Azul
                       break;
                   }
               }
               }
           }
       }
       //
       
    }

    /*
    public void mostrar(Fichas a[][]){
        //System.out.println(dimy);
        
        for(int i=0;i<dimy;i++){
            for(int i2=0; i2<dimx;i2++){
                System.out.print(a[i][i2].vertical+" ");
            }
            //System.out.println("Entre");
            System.out.println("");  
        }
        
        
        System.out.println("___________________");
        for(int i=0;i<dimy;i++){
            for(int i2=0; i2<dimx;i2++){
                System.out.print(a[i][i2].rand+" ");
            }
            //System.out.println("Entre");
            System.out.println("");  
        }
        
        System.out.println("___________________");
        for(int i=0;i<dimy;i++){
            for(int i2=0; i2<dimx;i2++){
                System.out.print(a[i][i2].ficha+" ");
            }
            //System.out.println("Entre");
            System.out.println("");  
        }
    }
    
    */


    public void jugadas(Fichas a[][]){//Detectar que elemento se podra mover, detectar jugadas, HAY 16 POSIBLES JUGADAS FORMAS DE FORMAR 3 O MAS SEGUIDAS
        for(int i=0;i<a[0][0].dimy;i++){
            for(int i2=0;i2<a[0][0].dimx;i2++){
                //mirar si se puede analizar una posicion arriba
                if(i<1){
                    a[i][i2].arr_simple=false;
                }else{
                    a[i][i2].arr_simple=true;
                }
                if(i2<1){
                    a[i][i2].izq_simple=false;
                }else{
                    a[i][i2].izq_simple=true;
                }
                if(i>(a[i][i2].dimy)-2){
                    a[i][i2].abaj_simple=false;
                }else{
                    a[i][i2].abaj_simple=true;
                }
                if(i2>(a[i][i2].dimx)-2){
                    a[i][i2].der_simple=false;
                }else{
                    a[i][i2].der_simple=true;
                }
                //
            }
        }

        for(int i=0;i<a[0][0].dimy;i++){
            for(int i2=0;i2<a[0][0].dimx;i2++){
                a[i][i2].juegaficha=false;
                a[i][i2].juegaarr=false;
                a[i][i2].juegaabaj=false;
                a[i][i2].juegaizq=false;
                a[i][i2].juegader=false;
                if(a[i][i2].hueco==false){
                    //Empieza normales
                        //arriba
                            if(a[i][i2].arr==true){
                                if((a[i-2][i2].arr_simple==true)&&(a[i-2][i2].rand==a[i][i2].rand)){
                                    if(a[i-3][i2].rand==a[i][i2].rand){
                                        a[i][i2].juegaficha=true;
                                        a[i][i2].juegaarr=true;
                                        //entre2 = true;
                                    }
                                }
                            }
                            //System.out.println("Posicion i:"+(i+1)+" i2:"+(i2+1)+" arriba es: "+a[i][i2].juegaficha);
                        //termina arriba
                        //abajo
                            if(a[i][i2].abaj==true){
                                if((a[i+2][i2].abaj_simple==true)&&(a[i+2][i2].rand==a[i][i2].rand)){
                                    if(a[i+3][i2].rand==a[i][i2].rand){
                                        a[i][i2].juegaficha=true;
                                        a[i][i2].juegaabaj=true;
                                        //entre2 = true;
                                    }
                                }
                            }
                            //System.out.println("Posicion i:"+(i+1)+" i2:"+(i2+1)+" abajo es: "+a[i][i2].juegaficha);
                        //termina abajo
                        //izquierda
                            if(a[i][i2].izq==true){
                                if((a[i][i2-2].izq_simple==true)&&(a[i][i2-2].rand==a[i][i2].rand)){
                                    if(a[i][i2-3].rand==a[i][i2].rand){
                                        a[i][i2].juegaficha=true;
                                        a[i][i2].juegaizq=true;
                                        //entre2 = true;
                                    }
                                }
                            }
                            //System.out.println("Posicion i:"+(i+1)+" i2:"+(i2+1)+" izquierda es: "+a[i][i2].juegaficha);
                        //termina izquierda
                        //derecha
                            if(a[i][i2].der==true){
                                if((a[i][i2+2].der_simple==true)&&(a[i][i2+2].rand==a[i][i2].rand)){
                                    if(a[i][i2+3].rand==a[i][i2].rand){
                                        a[i][i2].juegaficha=true;
                                        a[i][i2].juegader=true;
                                        //entre2 = true;
                                    }
                                }
                            }
                            //System.out.println("Posicion i:"+(i+1)+" i2:"+(i2+1)+" derecha es: "+a[i][i2].juegaficha);
                        //termina derecha
                    //Termina normales
                    //Empiezan Diagonales, Cada una TIENE DOS CASOS POSIBLES !!!
                        //Empieza diagonal arriba derecha
                            if((a[i][i2].arr_simple==true)&&(a[i][i2].der_simple==true)){
                               if(a[i-1][i2+1].rand==a[i][i2].rand){
                                   //Empieza caso derecha
                                   if(a[i-1][i2+1].der_simple==true){
                                       if(a[i-1][i2+2].rand==a[i][i2].rand){
                                           a[i][i2].juegaficha=true;
                                           a[i][i2].juegaarr=true;
                                           //entre2 = true;
                                       }
                                   }
                                   //Termina Caso derecha
                                   //empieza caso arriba
                                   if(a[i-1][i2+1].arr_simple==true){
                                       if(a[i-2][i2+1].rand==a[i][i2].rand){
                                           a[i][i2].juegaficha=true;
                                           a[i][i2].juegader=true;
                                           //entre2 = true;
                                       }                                       
                                   }
                                   //termina caso arriba
                               } 
                            }
                            //System.out.println("Posicion i:"+(i+1)+" i2:"+(i2+1)+" arriba derecha es: "+a[i][i2].juegaficha);
                        //Termina diagonal arriba derecha
                        //Empieza diagonal arriba izquierda
                            if((a[i][i2].arr_simple==true)&&(a[i][i2].izq_simple==true)){
                               if(a[i-1][i2-1].rand==a[i][i2].rand){
                                   //Empieza caso izquierda
                                   if(a[i-1][i2-1].izq_simple==true){
                                       if(a[i-1][i2-2].rand==a[i][i2].rand){
                                           a[i][i2].juegaficha=true;
                                           a[i][i2].juegaarr=true;
                                           //entre2 = true;
                                       }
                                   }
                                   //Termina Caso izquierda
                                   //empieza caso arriba
                                   if(a[i-1][i2-1].arr_simple==true){
                                       if(a[i-2][i2-1].rand==a[i][i2].rand){
                                           a[i][i2].juegaficha=true;
                                           a[i][i2].juegaizq=true;
                                           //entre2 = true;
                                       }                                       
                                   }
                                   //termina caso arriba
                               } 
                            }
                            //System.out.println("Posicion i:"+(i+1)+" i2:"+(i2+1)+" arriba izquierda es: "+a[i][i2].juegaficha);
                        //Termina diagonal arriba izquierda
                        //Empieza diagonal abajo derecha
                            if((a[i][i2].abaj_simple==true)&&(a[i][i2].der_simple==true)){
                               if(a[i+1][i2+1].rand==a[i][i2].rand){
                                   //Empieza caso derecha
                                   if(a[i+1][i2+1].der_simple==true){
                                       if(a[i+1][i2+2].rand==a[i][i2].rand){
                                           a[i][i2].juegaficha=true;
                                           a[i][i2].juegaabaj=true;
                                           //entre2 = true;
                                       }
                                   }
                                   //Termina Caso derecha
                                   //empieza caso abajo
                                   if(a[i+1][i2+1].abaj_simple==true){
                                       if(a[i+2][i2+1].rand==a[i][i2].rand){
                                           a[i][i2].juegaficha=true;
                                           a[i][i2].juegader=true;
                                           //entre2 = true;
                                       }                                       
                                   }
                                   //termina caso abajo
                               } 
                            }
                            //System.out.println("Posicion i:"+(i+1)+" i2:"+(i2+1)+" abajo derecha es: "+a[i][i2].juegaficha);
                        //Termina diagonal abajo derecha
                        //Empieza diagonal abajo izquierda
                            if((a[i][i2].abaj_simple==true)&&(a[i][i2].izq_simple==true)){
                               if(a[i+1][i2-1].rand==a[i][i2].rand){
                                   //Empieza caso izquierda
                                   if(a[i+1][i2-1].izq_simple==true){
                                       if(a[i+1][i2-2].rand==a[i][i2].rand){
                                           a[i][i2].juegaficha=true;
                                           a[i][i2].juegaabaj=true;
                                           //entre2 = true;
                                       }
                                   }
                                   //Termina Caso izquierda
                                   //empieza caso abajo
                                   if(a[i+1][i2-1].abaj_simple==true){
                                       if(a[i+2][i2-1].rand==a[i][i2].rand){
                                           a[i][i2].juegaficha=true;
                                           a[i][i2].juegaizq=true;
                                           //entre2 = true;
                                       }                                       
                                   }
                                   //termina caso abajo
                               } 
                            }
                            //System.out.println("Posicion i:"+(i+1)+" i2:"+(i2+1)+" arriba izquierda es: "+a[i][i2].juegaficha);
                        //Termina diagonal abajo izquierda
                    //Terminan diagonales
                    //Empíezan centros xyx
                    //                 yxy
                    //                 xyx
                    //Empieza arriba
                    if((a[i][i2].arr_simple==true)&&(a[i][i2].izq_simple==true)&&(a[i][i2].der_simple==true)){
                        if((a[i-1][i2-1].rand==a[i][i2].rand)&&(a[i-1][i2+1].rand==a[i][i2].rand)){
                            a[i][i2].juegaficha=true;
                            a[i][i2].juegaarr=true;
                        }                        
                    }
                    //Termina arriba
                    //Empieza abajo
                    if((a[i][i2].abaj_simple==true)&&(a[i][i2].izq_simple==true)&&(a[i][i2].der_simple==true)){
                        if((a[i+1][i2-1].rand==a[i][i2].rand)&&(a[i+1][i2+1].rand==a[i][i2].rand)){
                            a[i][i2].juegaficha=true;
                            a[i][i2].juegaabaj=true;
                        }                        
                    }                    
                    //Termina abajo
                    //Empieza izquierda
                    if((a[i][i2].izq_simple==true)&&(a[i][i2].arr_simple==true)&&(a[i][i2].abaj_simple==true)){
                        if((a[i-1][i2-1].rand==a[i][i2].rand)&&(a[i+1][i2-1].rand==a[i][i2].rand)){
                            a[i][i2].juegaficha=true;
                            a[i][i2].juegaizq=true;
                        }                        
                    }                    
                    //Termina izquierda
                    //Empieza derecha
                    if((a[i][i2].der_simple==true)&&(a[i][i2].arr_simple==true)&&(a[i][i2].abaj_simple==true)){
                        if((a[i-1][i2+1].rand==a[i][i2].rand)&&(a[i+1][i2+1].rand==a[i][i2].rand)){
                            a[i][i2].juegaficha=true;
                            a[i][i2].juegader=true;
                        }                        
                    }
                    //Termina derecha
                    
                    //Terminan centros
                    
                    
                }
            }
        }    
        
        
    }
    
//
    
    public int getDimx() {
        return dimx;
    }

    public int getDimy() {
        return dimy;
    }
    
    public String getFicha(){
        return ficha;
    }

    public boolean isHueco() {
        return hueco;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public boolean isVertical() {
        return vertical;
    }

    public boolean isIzq() {
        return izq;
    }

    public boolean isDer() {
        return der;
    }

    public boolean isArr() {
        return arr;
    }

    public boolean isAbaj() {
        return abaj;
    }

    public int getRand() {
        return rand;
    }

    public boolean isJuegaficha() {
        return juegaficha;
    }

    public boolean isJuegaarr() {
        return juegaarr;
    }

    public boolean isJuegaabaj() {
        return juegaabaj;
    }

    public boolean isJuegader() {
        return juegader;
    }

    public boolean isJuegaizq() {
        return juegaizq;
    }
  
    
//

    public void setDimx(int dimx) {
        this.dimx = dimx;
    }

    public void setDimy(int dimy) {
        this.dimy = dimy;
    }
//

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }
    
    
    
}
