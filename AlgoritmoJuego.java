/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;



import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.SerializationUtils;
/**
 *
 * @author Esteban
 */
public class AlgoritmoJuego implements Serializable {

    /**Este algoritmo es lo que usara la CPU para elegir su proximo movimiento
     *Es un algoritmo minimax con poda alfa-beta.
     */
    
    
    //Comenzamos el algoritmo
    int cont=0;//Contador de iteraciones, nos servirá de manera auxiliar
    
    int nivel = 0;//Para saber en que nivel estamos
    public Arbol solucion = new Arbol();
    List <Tablero>escenarios_posibles =new LinkedList();
    public Tablero tablero_inicial = new Tablero();//Aquí está nuestra raíz
    public Nodo nodo_actual;
    public Arbol arbol_anterior=new Arbol();
    List<List<Tablero>> listas_de_niveles = new LinkedList(); //para evaluar los niveles
    boolean ultimo_paso;//Parche para terminar de recorrer el nivel
    
    
   
   
    
    
    
    
    
    
    
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
        aux=SerializationUtils.clone(tablero);
        tablero_inicial=aux;
    }
    
    public boolean finJuego(Tablero tablero){
        if(tablero.todosVaciosJ1(tablero.getHuecosJ1()) && tablero.getTurno()==1){
            return true;
        }
        else if(tablero.todosVaciosJ2(tablero.getHuecosJ2()) && tablero.getTurno()==2){
            return true;
        }
       
        else return false;
    }
    public int sumaSemillasJugador1(Tablero tablero){
            int resultado=0;
            for(int i=0; i<tablero.getHuecosJ1().length;i++){
                resultado=resultado+tablero.getHuecosJ1()[i].getSemillas();
            }
            
            return resultado;
        }
        
    public int sumaSemillasJugador2(Tablero tablero){
            int resultado=0;
            for(int i=0; i<tablero.getHuecosJ2().length;i++){
                resultado=resultado+tablero.getHuecosJ2()[i].getSemillas();
            }
            
            return resultado;
        }
    
    public Tablero fEvaluacion(List<Tablero> lista){//No funcional, no tiene en cuenta repeticiones de turnos ytodavía no hemos preparado las listas.
        //La idea es ver que tablero tiene mas semilla disponiles para el jugador que le toca,
        //a la CPU le interesa tener mas semillas y si es el tuerno del humano a la CPU le interesa que tenga menos
        int mejor_valor=0;
        int indice_mv=0;
        int turno =lista.get(0).getTurno();
        if(turno==1){
            for(int i=0;i<lista.size();i++){
                if(mejor_valor>=sumaSemillasJugador1(lista.get(i))){//Vamos comprobando cual es el mejor valor
                    mejor_valor=sumaSemillasJugador1(lista.get(i));
                    indice_mv=i;
                }else ;
                
            }
        }
        else if(turno==2){
            for(int i=0;i<lista.size();i++){
                if(mejor_valor<=sumaSemillasJugador2(lista.get(i))){//Vamos comprobando cual es el mejor valor
                    mejor_valor=sumaSemillasJugador2(lista.get(i));
                    indice_mv=i;
                }else ;
                
            }
        }
        return lista.get(indice_mv);//Devolvemos el mejor tablero basandonos en el indice
    }
    
    
    
   
    public void construirArbol(){
        
        if (solucion.raiz==null){//Para la iteracion 0
            if(arbol_anterior.raiz==null){
                solucion.insertarHijo(tablero_inicial, tablero_inicial);
            }
            
        }
        
        
       
        for(int i=0; i<3 ; i++){//Aquí da igau de quien tomemos la longuitud
                
                Tablero aux= SerializationUtils.clone(tablero_inicial) ;//Necesitamos copia profunda para poder tratar esto de forma recursiva
                
                
                if(aux.getTurno()==1){
                     if(HuecoNeutro.estaHuecoVacio(aux.huecos_neutros_jugador1[i])){
                         ;
                     }else{
                         aux.elegirHueco(aux.huecos_neutros_jugador1[i]);
                         solucion.insertarHijo(tablero_inicial,aux);
                         aux.setId(tablero_inicial.getId()+1);
                         escenarios_posibles.add(aux);
                         aux.mostrarTablero();
                        }    
                     
                     
                     
                     
                }
                else if(aux.getTurno()==2){
                    if(HuecoNeutro.estaHuecoVacio(aux.huecos_neutros_jugador2[i])){
                         ;
                     }else{  
                         aux.elegirHueco(aux.huecos_neutros_jugador2[i]);
                         solucion.insertarHijo(tablero_inicial,aux);
                         aux.setId(tablero_inicial.getId()+1);
                         escenarios_posibles.add(aux);
                         aux.mostrarTablero();
                         
                     
                    }
                }
               
                
                //solucion.insertarHijo(tablero_inicial,aux);
            
               
                
                
                
               
                
            
         
        }
        
        tablero_inicial=(Tablero)escenarios_posibles.get(0);//definimos nuevo tablero inicial
        
        escenarios_posibles.remove(0);
        if(escenarios_posibles.get(0).getId()!=tablero_inicial.getId()&&ultimo_paso==false){
            nivel++;
        }
        if(nivel<2){//Control de niveles
            
            construirArbol();
        }else if (nivel==2&&ultimo_paso==false){
            ultimo_paso=true;
            construirArbol();
            
        }else solucion.imprimirArbol(solucion);
        
        
        
        
        
        
        
        
      
        
            
    }
    
    
    
    public static void main(String args[]){//Para prubas, ya hace un arbol de un nivel sin errores, queda ver como hacemos que siga las reglas de manera recursiva
        AlgoritmoJuego prueba=new AlgoritmoJuego();
        prueba.construirArbol();
    }
       
        
        
        //Aquí ya deberíamos tener una lista de los primeros casos posibles
}
    
    

