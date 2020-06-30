import Game.Acciones;
import Game.Fichas;
import Game.Juego;
import Game.Puntuacion;
import Game.Reglas;
import Game.Seleccion;
import Game.dibujar;


public class Main {
    public static void main(String[] args){
        
        int game=1;
        int puntos_main=0;
        int mov=0;
        boolean primeravez;
        boolean jugadas_a;
        boolean jugadas_b;
        boolean regla1;
        boolean regla2;
        boolean lvlpass=false;
        
        Juego nuevo = new Juego();
        dibujar pantalla = new dibujar();
        do{
            nuevo.bienvenida();
            nuevo.seleccionarnivel();
            if(nuevo.getNivel()!=4){
                do{//lvlpass
                    primeravez=true;
                    //System.out.println(nuevo.getDimx()+"=dimx "+nuevo.getDimy()+"=dimy");
                    Fichas tablero_b = new Fichas(nuevo.getDimx(), nuevo.getDimy());
                    Fichas tablero[][] = new Fichas[nuevo.getDimy()][nuevo.getDimx()];
                    for (int i=0;i<nuevo.getDimy();i++){
                        for(int i2=0; i2<nuevo.getDimx();i2++){
                            tablero[i][i2] = new Fichas(nuevo.getDimx(), nuevo.getDimy());
                            tablero[i][i2].fillE();
                        }
                    }
                    tablero_b.huecos(tablero, nuevo.getNivel());
                    tablero_b.llenar(tablero, primeravez);
                    //System.out.println(tablero[5][3].getDimx()+"=Dimension en X "+tablero[0][0].getDimy()+"=Dimension en y");
                    //System.out.println(tablero[7][6].getFicha());
                    nuevo.nivel(nuevo.getNivel());
                    Acciones jugador;
                    Seleccion control;
                    Reglas aprueba = new Reglas();
                    primeravez=false;//Este primera vez es para que la primera vez no DEJE que hayan 3 seguidas de una vez y lo hay genera un random nuevo
                    mov=0;
                    puntos_main=0;
                    do{
                        //Empezaria los ciclos o movimientos
                        tablero_b.jugadas(tablero);//Anliza que ESPACIO I I2 PUEDE SER MOVIDO TRUE SI SE PUEDE MOVER FALSE SI NO Y PARA DONDE DEBE SER MOVIDO
                        
                        jugador = new Acciones(tablero, nuevo.getDimx(), nuevo.getDimy());
                        
                        /*
                        do{//Forzar que ya no hayan mas jugadas                                            
                            jugador.forzarnojugadas();
                            tablero_b.llenar(tablero, true);
                            tablero_b.jugadas(tablero);
                            jugadas_b = jugador.jugadascheck();//Comprobar si hay mas jugadas
                            System.out.println("jugadas_b: "+jugadas_b);
                        }while(jugadas_b==true);//Terminar Forzar que no hayan mas jugadas
                        */
                        
                        pantalla.mostrar(tablero);//tablero_b.mostrar(tablero);
                        jugadas_b = jugador.jugadascheck();
                        System.out.println("Hay jugadas? "+jugadas_b);
                        System.out.println("Puntos: "+puntos_main);
                        //System.out.println("Movimientos: "+mov);
                        System.out.println("Movimientos Restantes: "+(nuevo.getMovimientos()-mov));
                        System.out.println("Vidas: "+nuevo.getVidas());

                        if(jugadas_b==true){
                            control = new Seleccion();
                            do{//Activar REGLAS
                                do{
                                    control.escojer(nuevo.getDimx(), nuevo.getDimy());          
                                    //if(tablero[control.getY()][control.getX()].isHueco()==true){
                                    //    System.out.println("No se pueden seleccionar huecos, Seleccione otra posciocion");
                                    //}
                                }while(tablero[control.getY()][control.getX()].isHueco()==true);

                                control.fescojida(tablero[control.getY()][control.getX()].getFicha(), tablero[control.getY()][control.getX()].isJuegaficha(), tablero[control.getY()][control.getX()].isJuegaarr()
                                , tablero[control.getY()][control.getX()].isJuegaabaj(), tablero[control.getY()][control.getX()].isJuegaizq(), tablero[control.getY()][control.getX()].isJuegader());

                                do{
                                    control.escojerb(nuevo.getDimx(), nuevo.getDimy());
                                    //if(tablero[control.getY_b()][control.getX_b()].isHueco()==true){
                                    //    System.out.println("No se pueden seleccionar huecos, Seleccione otra posciocion");
                                    //}
                                }while(tablero[control.getY_b()][control.getX_b()].isHueco()==true);

                                regla1 = aprueba.regla1(control.getX(), control.getY(), control.getX_b(), control.getY_b());
                                //System.out.println("Cumple regla 1?: "+regla1);
                                if(regla1==false){
                                    System.out.println("Por favor mueva la ficha SOLO un espacio para Arriba, Abajo, Izquiera o Derecha");
                                }
                                regla2 = aprueba.regla2(tablero[control.getY()][control.getX()].isJuegaarr(), tablero[control.getY()][control.getX()].isJuegaabaj()
                                        , tablero[control.getY()][control.getX()].isJuegaizq(), tablero[control.getY()][control.getX()].isJuegader(), 
                                        control.getX(), control.getY(), control.getX_b(), control.getY_b());
                                //System.out.println("Cumple regla 2?: "+regla2);
                                if((control.getX()==control.getX_b())&&(control.getY()==control.getY_b())){
                                        System.out.println("Se Selecciono, Las Mismas Coordenadas de Inicio y Final, No cuenta el movimiento");
                                }else{                
                                    if(regla2==false){
                                        System.out.println("Movimiento NO VALIDO");
                                    }
                                }

                            }while((regla1==false)||(regla2==false));//Termina activar reglas
                            //jugador = new Acciones(tablero, nuevo.getDimx(), nuevo.getDimy()); MOVER JUGADOR
                            //jugador.test();
                            //System.out.println("Pos 0 0 "+tablero[0][0].getFicha());
                            jugador.mover(control.getX(), control.getY(), control.getX_b(), control.getY_b());
                            tablero_b.llenar(tablero, primeravez);//Para volver recalcular los elementos si se pueden mover en las direcciones arriba abaj der izq y si hay jugadas de 3 seguidas
                            //ENTRA A UN CICLO PARA MIRAR DIFERENTES JUGADAS QUE RESULTEN DE LOS QUE VAN A CAR ARRIBA O DE LOS QUE YA ESTAN FORMADOS
                            do{//Lo repite si cuando se hizo una jugada al bajar las fichas estan mataron a otras al tiempo. 
                                jugadas_a = jugador.eliminarcheck();    
                                if(jugadas_a==true){
                                    pantalla.mostrar(tablero);//tablero_b.mostrar(tablero);
                                    System.out.println("Puntos: "+puntos_main);
                                    //System.out.println("Jugadas en standby?: "+jugadas_a);
                                    System.out.println("Vidas: "+nuevo.getVidas());
                                }
                                jugador.eliminarv2();
                                puntos_main += jugador.getPts();
                                jugador.setPts(0);//resetear puntos de jugador para que si hace el do 2 veces no sume otra vez lo de la otra jugada
                                if(jugadas_a==true){
                                    pantalla.mostrar(tablero);//tablero_b.mostrar(tablero);
                                    System.out.println("Puntos: "+puntos_main);
                                    //System.out.println("Jugadas en standby?: "+jugadas_a);
                                    System.out.println("Vidas: "+nuevo.getVidas());
                                }
                                //tablero_b.mostrar(tablero);//MUESTRA ANTES DE SUBIR LOS 'nada'
                                jugador.eliminarb();//SUBE LOS 'nada'
                                if(jugadas_a==true){
                                    pantalla.mostrar(tablero);//tablero_b.mostrar(tablero);
                                    System.out.println("Puntos: "+puntos_main);
                                    //System.out.println("Jugadas en standby?: "+jugadas_a);
                                    System.out.println("Vidas: "+nuevo.getVidas());
                                }        
                                tablero_b.llenar(tablero, primeravez);//LLENA los naday actualiza si hay posibles jugadas :D    
                                jugadas_a = jugador.eliminarcheck();

                            }while(jugadas_a==true);
                            mov++;
                            //Termina un movimiento 
                        }
                    }while((mov<nuevo.getMovimientos())&&(puntos_main<nuevo.getPass())&&(jugadas_b==true));//Ciclo de VIDAS o MOVIMIENTOS
                    //tablero_b.mostrar(tablero);
                    //aca sera la celebracion    
                    if(puntos_main>=nuevo.getPass()){
                        lvlpass = true;
                    }else{
                        nuevo.vidas(mov, jugadas_b);
                        lvlpass = false;
                    }
                }while((lvlpass==false)&&(nuevo.getVidas()>0));
                if(nuevo.getVidas()==0){
                    nuevo.gameover();
                }else{
                    nuevo.nivelcompletado(puntos_main, mov);
                }
                
            }
        }while(nuevo.getNivel()!=4);//Aca sale del Juego
        
    }
}
