package Game;


public class Acciones extends Fichas{
//public class Acciones{
    
    private Fichas resp;
    private Fichas a[][];
    private Fichas forzar;
    private int cont;
    private int i3;
    private int i4;
    private int i5;
    private int i6;
    private int fakerand;
    private boolean salir;
    private int pts=0;
    private boolean check;
    
    public Acciones(Fichas[][] a, int dimx_, int dimy_) {
        super(dimx_, dimy_);
        this.a = a;
    }
    
    Puntuacion puntos = new Puntuacion();
    
    public void test(){
        //a[0][0]=a[0][1];
        System.out.println(a[0][0].getFicha());
        System.out.println(a[0][0].getDimx());
        System.out.println(a[0][0].getDimy());
    }
    
    public void mover(int x_, int y_, int x_b, int y_b){
        //System.out.println(x_+" "+y_+" "+x_b+" "+y_b);
        if((a[y_][x_].isHueco()==false)&&(a[y_b][x_b].isHueco()==false)){
        resp = a[y_][x_];
        a[y_][x_] = a[y_b][x_b];
        a[y_b][x_b]= resp;        
        }
    }
    
    public void eliminar(){
        //System.out.println("dimx="+a[0][0].getDimx()+" dimy=="+a[0][0].getDimy());
        
        for(int i=0;i<a[0][0].getDimy();i++){
            for(int i2=0;i2<a[0][0].getDimx();i2++){
                //
                ///*
                
                // Empiezan Horizontales
                
                if((a[i][i2].isHorizontal()==true)&&(a[i][i2].isDer()==true)){//Aca entra si detecto jugada en horizontal en cada elemento de la matriz
                    if(((a[i][i2+2].isDer()==true)&&(a[i][i2+2].isVertical()==true))&&(a[i][i2].getRand()==a[i][i2+2].getRand())){//aca mira posible jugada en 'T' O 'L', si es una jugada normal de 3,4,5 etc
                        if((a[i][i2+3].getRand()==a[i][i2].getRand())&&(a[i][i2+4].getRand()==a[i][i2].getRand())){//aca mira si el analizado es de una vez la fila larga de la T
                            //es un movmiento en t, y se van 5 en horizontal pero las cuenta
                            i3=1;
                            //salir = false;
                            while(a[i][i2].getRand()==a[i][i2+i3].getRand()){//cuenta hacia la derecha
                                if((i2+i3)==(a[i][i2].getDimx())-1){
                                    //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                    i3++;
                                    break;
                                    //}
                                }else{
                                    i3++;
                                    //salir=false;
                                }
                            }
                            //declarar puntuacion de i3 seguidas
                            for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                a[i][i2+i4aux].fillE();
                            }
                            
                            //
                        }else{//aca me va a mirar si es una T en el otro sentido , en el juego es casi imposible que se de esta situacion, es decir que los dulces consecutivos son mas en la otra ilera que la analizada
                            if((a[i][i2+2].isArr()==true)&&(a[i][i2+2].isAbaj()==true)){//Aca mira si puede analizar en el elemento que comparte derecha izq si se puede analizar dimensionalmente es decir que no se salga de los limites tanto arriba como abajo
                                if((a[i+2][i2+2].getRand()==a[i][i2+2].getRand())&&(a[i-2][i2+2].getRand()==a[i][i2+2].getRand())){//Aca mira si el elemento analizado en la otra direccion cumple terner 3 seguidas tanto arriba como abajo
                                    i3=1;
                                    while(a[i][i2+2].getRand()==a[i+i3][i2+2].getRand()){//contar para abajo
                                        if((i+i3)==(a[i][i2+2].getDimy())-1){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i3++;
                                            break;
                                            //}
                                        }else{
                                            i3++;
                                            //salir=false;
                                        }
                                        
                                    }
                                    
                                    //i3 son los que van para abajo
                                    i4=1;
                                    while(a[i][i2+2].getRand()==a[i-i4][i2+2].getRand()){//contar para arriba
                                        if((i-i4)==0){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i4++;
                                            break;
                                            //}
                                        }else{
                                            i4++;
                                            //salir=false;
                                        }
                                        
                                    }   
                                    //i4 son los que can para arriba
                                    //declarar puntuacion de i3 + i4
                                    for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                        a[i+i4aux][i2+2].fillE();
                                    }
                                    
                                    for(int i4aux=0;i4aux<i4;i4aux++){//borrar el numero de seguidas
                                        a[i-i4aux][i2+2].fillE();
                                    }
                                }else{
                                    //aca entra si hay un movimiento donde el tercer dulce despues del detectado cumpla tener jugadas vertical y horizontal pero el vertical solo tiene la jugada para arriba o abajo no ambas
                                    //mata la fila de seguidas
                                    i3=1;
                                    //salir = false;
                                    while(a[i][i2].getRand()==a[i][i2+i3].getRand()){//contar horizontalmente pasando por alto este caso que es cuando hay una L
                                        if((i2+i3)==(a[i][i2].getDimx())-1){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i3++;
                                            break;
                                            //}
                                        }else{
                                            i3++;
                                            //salir=false;
                                        }
                                    }

                                    //declarar puntuacion para i3 seguidas
                                    for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                       a[i][i2+i4aux].fillE();
                                    }                                    
                                }
                            }else{//Aca entra si no puede ser analizado por arr o abaj y mataria directamente a la fila consecutiva de dulces analizada 
                                
                                //es un movmiento en t, y se van 5 en horizontal
                                i3=1;
                                //salir = false;
                                while(a[i][i2].getRand()==a[i][i2+i3].getRand()){//contar horizontalmente pasando por alto este caso que es cuando hay una L
                                    if((i2+i3)==(a[i][i2].getDimx())-1){
                                        //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                        i3++;
                                        break;
                                        //}
                                    }else{
                                        i3++;
                                        //salir=false;
                                    }
                                }
                                
                                //declarar puntuacion para i3 seguidas
                                for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                   a[i][i2+i4aux].fillE();
                                }
                            }
                        }
                    }else{//aca entra si son 'T' o 'L' muy cerca al borde
                        
                            if((((a[i][i2+2].isArr()==true)&&(a[i][i2+2].isAbaj()==true)))&&(a[i][i2+2].getRand()==a[i][i2].getRand())){
                                if((a[i-2][i2+2].getRand()==a[i][i2+2].getRand())&&(a[i+2][i2+2].getRand()==a[i][i2+2].getRand())){
                                    //
                                    
                                    i3=1;
                                    while(a[i][i2+2].getRand()==a[i+i3][i2+2].getRand()){//contar para abajo
                                        if((i+i3)==(a[i][i2+2].getDimy())-1){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i3++;
                                            break;
                                            //}
                                        }else{
                                            i3++;
                                            //salir=false;
                                        }
                                        
                                    }
                                    
                                    //i3 son los que van para abajo
                                    i4=1;
                                    while(a[i][i2+2].getRand()==a[i-i4][i2+2].getRand()){//contar para arriba
                                        if((i-i4)==0){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i4++;
                                            break;
                                            //}
                                        }else{
                                            i4++;
                                            //salir=false;
                                        }
                                        
                                    }   
                                    //i4 son los que can para arriba
                                    //declarar puntuacion de i3 + i4
                                    for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                        a[i+i4aux][i2+2].fillE();
                                    }
                                    
                                    for(int i4aux=0;i4aux<i4;i4aux++){//borrar el numero de seguidas
                                        a[i-i4aux][i2+2].fillE();
                                    }                                    
                                    
                                    //
                                }
                            }else{
                            
                                if(a[i][i2+2].getRand()==a[i][i2].getRand()){  //para evitar que se borren los dos que quedaron cn un movimiento en 'T'  
                                //para normales
                                //salir = false;
                                i3=1;
                                while(a[i][i2].getRand()==a[i][i2+i3].getRand()){//cuenta hacia la derecha
                                
                                if((i2+i3)==(a[i][i2].getDimx())-1){
                                    //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                    i3++;
                                    break;
                                    //}
                                }else{
                                    i3++;
                                    //salir=false;
                                }
                                }
                                
                            
                            //System.out.println("por aca voy");
                            //declarar puntuacion de i3 seguidas
                            for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                a[i][i2+i4aux].fillE();
                            }
                            }
                            
                        }
                    }
                }//No entra si el elemento analizado no cumple la jugada en horizontal
                
                //Terminan Horizontales
                //*/
                ///*
                // Empiezan Verticales
                
                if((a[i][i2].isVertical()==true)&&(a[i][i2].isAbaj()==true)){//Aca entra si detecto jugada en horizontal en cada elemento de la matriz
                ///*
                    if((a[i+2][i2].isAbaj()==true)&&(a[i+2][i2].isHorizontal()==true)&&(a[i][i2].getRand()==a[i+2][i2].getRand())){//aca mira posible jugada en 'T' O 'L', si es una jugada normal de 3,4,5 etc
                        if((a[i+3][i2].getRand()==a[i][i2].getRand())&&(a[i+4][i2].getRand()==a[i][i2].getRand())){//aca mira si el analizado es de una vez la fila larga de la T
                            //es un movmiento en t, y se van 5 en horizontal pero las cuenta
                            i3=1;
                            //salir = false;
                            while(a[i][i2].getRand()==a[i+i3][i2].getRand()){//cuenta hacia abajo
                                if((i+i3)==(a[i][i2].getDimy())-1){
                                    //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                    i3++;
                                    break;
                                    //}
                                }else{
                                    i3++;
                                    //salir=false;
                                }
                            }
                            //declarar puntuacion de i3 seguidas
                            for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                a[i+i4aux][i2].fillE();
                            }
                            
                            //
                        }else{//aca me va a mirar si es una T en el otro sentido , en el juego es casi imposible que se de esta situacion, es decir que los dulces consecutivos son mas en la otra ilera que la analizada
                            if((a[i+2][i2].isIzq()==true)&&(a[i+2][i2].isDer()==true)){//Aca mira si puede analizar en el elemento que comparte las dos positivos vertical horizontal se pueda analizar dimensionalmente es decir que no se salga de los limites tanto izquierda como derecha
                                if((a[i+2][i2+2].getRand()==a[i+2][i2].getRand())&&(a[i+2][i2-2].getRand()==a[i+2][i2].getRand())){//Aca mira si el elemento analizado en la otra direccion cumple terner 3 seguidas tanto izquierda como derecha
                                    i3=1;
                                    while(a[i+2][i2].getRand()==a[i+2][i2-i3].getRand()){//contar para la izquierda
                                        if((i2-i3)==0){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i3++;
                                            break;
                                            //}
                                        }else{
                                            i3++;
                                            //salir=false;
                                        }
                                        
                                    }
                                    
                                    //i3 son los que van para la izquierda
                                    i4=1;
                                    while(a[i+2][i2].getRand()==a[i+2][i2+i4].getRand()){//contar para la derecha
                                        if((i2+i4)==(a[i][i2].getDimx())-1){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i4++;
                                            break;
                                            //}
                                        }else{
                                            i4++;
                                            //salir=false;
                                        }
                                        
                                    }   
                                    //i4 son los que can para la derecha
                                    //declarar puntuacion de i3 + i4
                                        for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                                a[i+2][i2-i4aux].fillE();
                                        }

                                        for(int i4aux=0;i4aux<i4;i4aux++){//borrar el numero de seguidas
                                                a[i+2][i2+i4aux].fillE();
                                        } 
                                }else{
                                    //aca entra si hay un movimiento donde el tercer dulce despues del detectado cumpla tener jugadas vertical y horizontal pero el vertical solo tiene la jugada para arriba o abajo no ambas
                                    //mata la fila de seguidas
                                    i3=1;
                                    //salir = false;
                                    while(a[i][i2].getRand()==a[i+i3][i2].getRand()){//cuenta hacia abajo despresiando que hay una L ******Esta pendiente
                                        if((i+i3)==(a[i][i2].getDimy())-1){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i3++;
                                            break;
                                            //}
                                        }else{
                                            i3++;
                                            //salir=false;
                                        }
                                    }
                                    //declarar puntuacion de i3 seguidas
                                    for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                        a[i+i4aux][i2].fillE();
                                    }                                   
                                }
                            }else{//Aca entra si no puede ser analizado por izq o der y mataria directamente a la columna consecutiva de dulces analizada 
                                
                                    i3=1;
                                    //salir = false;
                                    while(a[i][i2].getRand()==a[i+i3][i2].getRand()){//cuenta hacia abajo despresiando que hay una L ******Esta pendiente
                                        if((i+i3)==(a[i][i2].getDimy())-1){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i3++;
                                            break;
                                            //}
                                        }else{
                                            i3++;
                                            //salir=false;
                                        }
                                    }
                                    //declarar puntuacion de i3 seguidas
                                    for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                        a[i+i4aux][i2].fillE();
                                    }                                   
                                }
                            }
                        
                    }else{//aca entra si son jugadas en t o l muy cerca al borde
                                    i3=1;
                                    if(((a[i+2][i2].isIzq()==true)&&(a[i+2][i2].isDer()==true))&&(a[i][i2].getRand()==a[i+2][i2].getRand())){
                                    if((a[i+2][i2-2].getRand()==a[i+2][i2].getRand())&&(a[i+2][i2+2].getRand()==a[i+2][i2].getRand())){
                                        //
                                            i3=1;
                                            while(a[i+2][i2].getRand()==a[i+2][i2-i3].getRand()){//contar para la izquierda
                                                if((i2-i3)==0){
                                                    //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                                    i3++;
                                                    break;
                                                    //}
                                                }else{
                                                    i3++;
                                                    //salir=false;
                                                }

                                            }

                                            //i3 son los que van para la izquierda
                                            i4=1;
                                            while(a[i+2][i2].getRand()==a[i+2][i2+i4].getRand()){//contar para la derecha
                                                if((i2+i4)==(a[i][i2].getDimx())-1){
                                                    //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                                    i4++;
                                                    break;
                                                    //}
                                                }else{
                                                    i4++;
                                                    //salir=false;
                                                }

                                            }   
                                            //i4 son los que can para la derecha
                                            //declarar puntuacion de i3 + i4
                                            for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                                a[i+2][i2-i4aux].fillE();
                                            }

                                            for(int i4aux=0;i4aux<i4;i4aux++){//borrar el numero de seguidas
                                                a[i+2][i2+i4aux].fillE();
                                            }                                        
                                        //
                                    }
                                    }else{
                                        
                                        if(a[i+2][i2].getRand()==a[i][i2].getRand()){//evitar que se borren las dos restantes luego de un movimiento en T
                                    //entra si son normales.
                                    //salir = false;
                                    while(a[i][i2].getRand()==a[i+i3][i2].getRand()){//cuenta hacia abajo despresiando que hay una L ******Esta pendiente
                                        if((i+i3)==(a[i][i2].getDimy())-1){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i3++;
                                            break;
                                            //}
                                        }else{
                                            i3++;
                                            //salir=false;
                                        }
                                    }
                                    //declarar puntuacion de i3 seguidas
                                    for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas
                                        a[i+i4aux][i2].fillE();
                                    }
                                    
                                    }
                                    
                                    }
                                                    
                        }
                
                    }//Termina verticales
                    //*/
                }
                
            }
        }
    public void eliminarv2(){
        //contar horizontales verticales, y sacar el mayor no importa si es jugada L o T
        for(int i=0;i<a[0][0].getDimy();i++){
            for(int i2=0;i2<a[0][0].getDimx();i2++){
        
        ///*        
                
        //Empiezan Horizontales
        
        if((a[i][i2].isHorizontal()==true)&&(a[i][i2].isDer()==true)){
                //Contar
                            i3=1;
                                //salir = false;
                            while(a[i][i2].getRand()==a[i][i2+i3].getRand()){//cuenta hacia la derecha
                                if((i2+i3)==(a[i][i2].getDimx())-1){
                                    //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                    i3++;
                                    break;
                                    //}
                                }else{
                                    i3++;
                                    //salir=false;
                                }
                            }
                //termina contar
                //Empieza evaluar movimiento en T o L para sacar quien tiene mas dulces
                
                if((a[i][i2+2].isVertical()==true)&&((a[i][i2+2].isArr()==true)||(a[i][i2+2].isAbaj()==true))){
                    //Contar hacia arriba
                    if(a[i][i2+2].isArr()==true){
                                    i4=1;
                                    while(a[i][i2+2].getRand()==a[i-i4][i2+2].getRand()){//contar para arriba
                                        if((i-i4)==0){
                                            //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                            i4++;
                                            break;
                                            //}
                                        }else{
                                            i4++;
                                            //salir=false;
                                        }
                                        
                                    }                    
                    }else{
                        if((i==1)&&(a[i][i2+2].getRand()==a[0][i2+2].getRand())){
                            i4=2;
                        }
                    }//Termina arriba
                    //Contar hacia abajo
                    if(a[i][i2+2].isAbaj()==true){
                            i5=1;
                            while(a[i][i2+2].getRand()==a[i+i5][i2+2].getRand()){//cuenta hacia abajo
                                if((i+i5)==(a[i][i2].getDimy())-1){
                                    //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                    i5++;
                                    break;
                                    //}
                                }else{
                                    i5++;
                                    //salir=false;
                                }
                            }                   
                    }else{
                        if(((i==(a[i][i2].getDimy()-2)))&&(a[i][i2+2].getRand()==a[a[i][i2].getDimy()-1][i2+2].getRand())){
                            i5=2;
                        }
                        
                        
                    }//Termina Abajo   
                    
                    //analizar cual es mayor
                    
                    if(i3>=((i4+i5)-1)){
                        //Mate las horizontales
                        if(i3>=3){//Esto lo hace si hay algun tipo ESPECIAL que salto todos los if y indica que solo son 2 seguidas y no tres
                            for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas derecha
                                a[i][i2+i4aux].fillE();
                            }
                        }    
                        pts += puntos.calculopuntos(i3);//mande el puntaje con i3
                    }else{
                        //Mate las verticales de i2+2
                        if(((i4+i5)-1)>=3){//Esto lo hace si hay algun tipo ESPECIAL que salto todos los if y indica que solo son 2 seguidas y no tres
                            for(int i4aux=0;i4aux<i4;i4aux++){//borrar el numero de seguidas arriba
                                a[i-i4aux][i2+2].fillE();
                            }
                                    
                            for(int i4aux=0;i4aux<i5;i4aux++){//borrar el numero de seguidas abajo
                                a[i+i4aux][i2+2].fillE();
                            }                         
                        
                        }
                        pts += puntos.calculopuntos((i4+i5));//mande el puntaje con i4+i5
                    }
                    
                    //Termina analizar cual es mayor
                    
                    
                }else{
                    //van normales
                    //Matar Horizontales
                    if(i3>=3){//Esto lo hace si hay algun tipo ESPECIAL que salto todos los if y indica que solo son 2 seguidas y no tres
                        for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas derecha
                            a[i][i2+i4aux].fillE();
                        }
                    }
                    pts += puntos.calculopuntos(i3);//mandar el puntaje con i3
                }
                
                //Termina evaluar movimiento en T o L para sacar quien tiene mas dulces
                
            }
        
        //Terminan Horizontales
        
        //*/
        ///*
        //Empiezan Verticales
        
        if((a[i][i2].isVertical()==true)&&(a[i][i2].isAbaj())){
            //contar verticales hacia abajo
                            i3=1;
                            while(a[i][i2].getRand()==a[i+i3][i2].getRand()){//cuenta hacia abajo
                                if((i+i3)==(a[i][i2].getDimy())-1){
                                    //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                                    i3++;
                                    break;
                                    //}
                                }else{
                                    i3++;
                                    //salir=false;
                                }
                            }            
            //termina contar
            //empiza evaluar posible movimineto en T o L para contar el que mas tenga
            if((a[i+2][i2].isHorizontal()==true)&&((a[i+2][i2].isIzq()==true)||(a[i+2][i2].isDer()==true))){
                if(a[i+2][i2].isIzq()==true){//contar izquierda
                i4=1;
                while(a[i+2][i2].getRand()==a[i+2][i2-i4].getRand()){//contar para la izquierda
                    if((i2-i4)==0){
                        //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                        i4++;
                        break;
                        //}
                    }else{
                        i4++;
                        //salir=false;
                    }
                }                    
                
                    
                }else{
                    if((i2==1)&&(a[i+2][i2].getRand()==a[i+2][0].getRand())){
                       i4=2; 
                    }
                }//termina contar izquierda
                
                if(a[i+2][i2].isDer()==true){//contar derecha
                i5=1;
                while(a[i+2][i2].getRand()==a[i+2][i2+i5].getRand()){//contar para la derecha
                    if((i2+i5)==(a[i][i2].getDimx())-1){
                        //if(a[i][(a[i][i2].getDimx())].getRand()==a[i][i2].getRand()){
                        i5++;
                        break;
                         //}
                    }else{
                        i5++;
                    //salir=false;
                    }
                }                    
                    
                }else{
                    if((i2==(a[i][i2].getDimx()-2))&&(a[i+2][i2].getRand()==a[i+2][a[i][i2].getDimx()-1].getRand())){
                        i5=2;
                    }
                    
                    
                }//termina contar derecha
                
                if(i3>=((i4+i5)-1)){
                    //matar verticales
                    if(i3>=3){
                        for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas abajo
                            a[i+i4aux][i2].fillE();
                        }
                    }
                    pts += puntos.calculopuntos(i3);//mandar puntuaje de i3
                }else{
                    //matar las horizontales de i+2
                    if(((i4+i5)-1)>=3){
                    for(int i4aux=0;i4aux<i4;i4aux++){//borrar el numero de seguidas IZQUIERDA
                        a[i+2][i2-i4aux].fillE();
                    }

                    for(int i4aux=0;i4aux<i5;i4aux++){//borrar el numero de seguidas DERECHA
                        a[i+2][i2+i4aux].fillE();
                    }                         
                    pts += puntos.calculopuntos((i4+i5));//mandar el puntaje i4+i5
                    }
                }
                
            }else{
                //NORMALES
                //matar verticales
                if(i3>=3){
                    for(int i4aux=0;i4aux<i3;i4aux++){//borrar el numero de seguidas abajo
                        a[i+i4aux][i2].fillE();
                    }
                pts += puntos.calculopuntos(i3);//mandar puntuaje de i3                
                }
                
            }
            
            
        }
        
        //Terminan Verticales
        //*/
                //System.out.println("Puntos de la jugada: "+pts);  
                //System.out.println("En la posicion i:"+(i+1)+" i2:"+(i2+1)+"Puntos de la Jugada pequeña fueron: "+pts);
            }//segundo for
        }//primer for
        System.out.println("Puntos de la Jugada: "+pts);
    }
    
    public void eliminarb(){//Acomodar la matriz que caigan las filas o columnas al eliminar cosas//
        for(int i=(a[0][0].getDimy()-1);i>0;i--){//0 no lo analiza porque se totea todo, ya que alli es donde van a terminar los 'nada'
            for(int i2=0;i2<a[0][0].getDimx();i2++){
                if((a[i][i2].getRand()==-1)&&(a[i][i2].isHueco()==false)){
                    //System.out.println("ENTRE i:"+i+" i2:"+i2);
                    i4=1;
                    while((a[i-i4][i2].getRand()==-1)&&(i-i4>0)){//Cuenta si arriba ya hay 'nada' para saltearselos y cambiarlo por uno queya no sea nada
                        i4++;
                    }
                   //for(int i3=i;(i3-i4)>=0;i3--){//cuenta los que se salteo para cambiar i4 posiciones arriba
                   int i3=i;
                   while((i3-i4)>=0){
                       //System.out.println("Analize i: "+i+" i2:"+i2);
                       if(a[i3-i4][i2].isHueco()==false){
                       resp=a[i3][i2];
                       a[i3][i2]=a[i3-i4][i2];//i4==1
                       a[i3-i4][i2] = resp;
                       //
                       }
                       i3=i3-i4;
                       i4=1;
                       if(i3>0){
                        while((a[i3-i4][i2].getRand()==-1)&&(i3-i4>0)){//Cuenta si arriba ya hay 'nada' para saltearselos y cambiarlo por uno queya no sea nada
                            i4++;
                        }
                       }                       
                       //
                      
                   }
                }
            }
        }
    }
      
    public boolean eliminarcheck(){//Mira si todos son falso es decir si ya no 3 fichas seguidas para eliminar// TRUE hay mas jugadas en stamdby FALSE ya no hay mas 3 seguidas
        for(int i=0;i<a[0][0].getDimy();i++){
            for(int i2=0;i2<a[0][0].getDimx();i2++){
                if((a[i][i2].isHorizontal()==true)||(a[i][i2].isVertical()==true)){
                    check = true;
                    i2=a[0][0].getDimx();//SACAR DEL CICLO
                    i=a[0][0].getDimy();//SACAR DEL CICLO
                }else{
                    check = false;
                }
            }
        }
        return check;
    }
    
    public boolean jugadascheck(){//Mira si todos son falso es decir si ya no 3 fichas seguidas para eliminar// TRUE hay mas jugadas en stamdby FALSE ya no hay mas 3 seguidas
        for(int i=0;i<a[0][0].getDimy();i++){
            for(int i2=0;i2<a[0][0].getDimx();i2++){
                if(a[i][i2].isJuegaficha()==true){
                    check = true;
                    i2=a[0][0].getDimx();//SACAR DEL CICLO
                    i=a[0][0].getDimy();//SACAR DEL CICLO
                }else{
                    check = false;
                }
            }
        }
        return check;
    }

    public void forzarnojugadas(){
        for(int i=0;i<a[0][0].getDimy();i++){
            for(int i2=0;i2<a[0][0].getDimx();i2++){
                if(a[i][i2].isJuegaficha()==true){
                   do{
                       a[i][i2].fillE();
                   }while(a[i][i2].isJuegaficha()==true);                 
                }
            }
        }        
    }
    
    
    
    
    // getters 
    public int getPts() {
        return pts;
    }
    
    // termina getters
    
    //setters
        public void setPts(int pts) {
        this.pts = pts;
    }
    // termina setters



    
    
    }
