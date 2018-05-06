/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Esteban
 */
public class AlgoritmoJuego {

    /**Este algoritmo es lo que usara la CPU para elegir su proximo movimiento
     *Es un algoritmo minimax con poda alfa-beta.
     */
    
    
    //Comenzamos el algoritmo
    
    int alfa;
    int beta;
    public Arbol solucion = new Arbol();
    List escenarios_posibles =new LinkedList();
    public Tablero tablero_inicial = new Tablero();//Aquí está nuestra raíz
    
   
   
    
    
    
    
    
    
    
    /*Vamos a darle una vuelta al algoritmo:
    *La idea es que cada nodo genera los escenarios posibles al realizar los movimientos posibles
    *Esto nos va a dar un maximo de 3 hijos como maximo en cada nodo, por ejemplo:
    *Si comenzamos desde la raíz, debemos insertar 3 hijos para 3 casos posibles, partiendo las 3 veces desde el escenario inicial  (3 para el simplificado)
    *Luego, deberemos comprobar cada uno de estos 3 hijos, sus escenarios posibles (3 para el simplificado)
    *A todo esto, hay que sumarle la heuristica
    *Suponemos que la CPU es el jugador 2
    */
   
    
    public void setNuevoTableroInicial(Tablero tablero){
        Tablero aux;
        aux=tablero;
    }
    
   
    public void construirArbol(){
       
        
        solucion.insertarHijo(tablero_inicial, tablero_inicial);//creamos raíz
        for(int i=0; i<3 ; i++){//Aquí da igau de quien tomemos la longuitud
            
                Tablero aux = new Tablero(); //Necesitamos copia profunda para poder tratar esto de forma recursiva
                
                
                if(aux.getTurno()==1){
                     if(HuecoNeutro.estaHuecoVacio(aux.huecos_neutros_jugador1[i])){
                         ;
                     }else{
                         aux.elegirHueco(aux.huecos_neutros_jugador1[i]);
                     }
                     
                     
                     
                }
                else if(aux.getTurno()==2){
                      if(HuecoNeutro.estaHuecoVacio(aux.huecos_neutros_jugador2[i])){
                         ;
                     }else{
                         aux.elegirHueco(aux.huecos_neutros_jugador2[i]);
                     }
                     
                }
                solucion.insertarHijo(tablero_inicial,aux);
                aux.mostrarTablero();
                
                
                escenarios_posibles.add(aux);
                
            
            
        //Una vez acaba de recorrer, ¿que?, tenemos que bajar el nivel,recorriendo de izquierda a derecha
        /*for(int z=0;z<escenarios_posibles.size();z++){
            Tablero aux2= clonarTablero((Tablero)escenarios_posibles.get(i));
            for(int y=0;y<aux2.huecos_neutros_jugador2.length;y++){
                if(HuecoNeutro.estaHuecoVacio(aux2.huecos_neutros_jugador2[i])){
                    ;
                }else{
                    aux2= clonarTablero((Tablero)escenarios_posibles.get(i));
                    aux2.elegirHueco(aux2.huecos_neutros_jugador2[i]);
                
                    escenarios_posibles.add(i, aux2);
                    escenarios_posibles.remove(i+1);//Añadimos el nuevo escenario y borramos su anterior
                    solucion.insertarHijo(tablero_inicial,aux2);
                    
                        
                    }
                }
                if(z==aux2.huecos_neutros_jugador2.length && z!=0){
                    setNuevoTableroInicial((Tablero) escenarios_posibles.get(0)); 
                    z=0;
                    
                }
               
                    
            }
         */  
        }
        
        setNuevoTableroInicial((Tablero) escenarios_posibles.get(0));
        
        solucion.imprimirArbol(solucion);
            
    }
    
    public static void main(String args[]){//Para prubas, ya hace un arbol de un nivel sin errores, queda ver como hacemos que siga las reglas de manera recursiva
        AlgoritmoJuego prueba=new AlgoritmoJuego();
        prueba.construirArbol();
    }
       
        
        
        //Aquí ya deberíamos tener una lista de los primeros casos posibles
}
    
    

