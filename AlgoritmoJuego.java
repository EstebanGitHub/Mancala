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
    boolean primer_paso=true;//Parche para ver cuando tomamos los valores adecuados antes de que sean borrados
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
    
    public List<Integer> copiaProfundaListaEv(List<Integer> lista){//Parece que
        //SerializationUtils no clona listas por las buenas
        List<Integer> solucion=new LinkedList();
        for(int i=0;i<lista.size();i++){
            int aux=SerializationUtils.clone(lista.get(i));
            solucion.add(aux);
        }
        return solucion;
    }
    
     public List<Tablero> copiaProfundaListaTablero(List<Tablero> lista){//Parece que
        //SerializationUtils no clona listas por las buenas
        List<Tablero> solucion=new LinkedList();
        for(int i=0;i<lista.size();i++){
            Tablero aux=SerializationUtils.clone(lista.get(i));
            solucion.add(aux);
        }
        return solucion;
    }
    
    
    public List<List<Tablero>> getListaNiveles(){
        return listas_de_niveles;
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
    
    public List<List<Integer>> fEvaluacion(List<List<Tablero>> lista){//Funcional, criterio muy pobre todavía
        //La idea es ver que tablero tiene mas semilla disponiles para el jugador que le toca,
        //a la CPU le interesa tener mas semillas y si es el tuerno del humano a la CPU le interesa que tenga menos
       
        
        int valor_actual=0;
        
        List<List<Integer>> solucion = new LinkedList();
        List lista_nivel = new LinkedList();
        List<Integer> lista_nivel_aux = new LinkedList();
        
        for(int i=lista.size()-1;i>=0;i--){
            if (i==lista.size()-1){
                for(int k=0;k<lista.get(i).size();k++){
                    if (lista.get(i).get(k).getTurno()==1){
                        valor_actual=sumaSemillasJugador1(lista.get(i).get(k));
                        lista.get(i).get(k).setValorPoda(12-valor_actual);
                        lista_nivel.add(12-valor_actual);
                    }
                    else if(lista.get(i).get(k).getTurno()==2){
                        valor_actual=sumaSemillasJugador2(lista.get(i).get(k));
                        lista.get(i).get(k).setValorPoda(valor_actual);
                        lista_nivel.add(valor_actual);
                    }
                    
                    
                    
                }
                lista_nivel_aux=copiaProfundaListaEv(lista_nivel);
                solucion.add(lista_nivel_aux);
                lista_nivel.clear();
            }else{
                for(int k=0;k<lista.get(i).size();k++){
                    if (lista.get(i).get(k).getTurno()==1){
                        valor_actual=sumaSemillasJugador1(lista.get(i).get(k));
                        lista_nivel.add(12-valor_actual);
                    }
                    else if(lista.get(i).get(k).getTurno()==2){
                        
                        valor_actual=sumaSemillasJugador2(lista.get(i).get(k));
                        lista_nivel.add(valor_actual);
                    }
                    
                    ;
                    
                }
                lista_nivel_aux=copiaProfundaListaEv(lista_nivel);
                solucion.add(0, lista_nivel_aux);
                lista_nivel.clear();
                
            }
        }
        System.out.println(solucion);
        
        return solucion;
        
        
    }
    
    public List<Tablero> getTablerosPorId(int id,List <Tablero> lista){
        List<Tablero> solucion= new LinkedList();
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getId()==id && solucion.indexOf(lista.get(i))==-1){
                solucion.add(lista.get(i));
            }
        }
        return solucion;
    }
    
    public List<List<Integer>> getValoresListaNiveles(List<List<Tablero>> listas_de_niveles){
        List<List<Integer>> solucion=new LinkedList();
       
        for(int i=0;i<listas_de_niveles.size();i++){
            List<Integer> temp=new LinkedList();
            for(int j=0; j<listas_de_niveles.get(i).size();j++){
                temp.add(listas_de_niveles.get(i).get(j).getValorPoda());
            }
            solucion.add(temp);
        }
        return solucion;
        
    }
    
    
   
    
    
   
    public void construirArbol(){
        
        if (solucion.raiz==null){//Para la iteracion 0
            
            solucion.insertarHijo(tablero_inicial, tablero_inicial);
          
            
        }
        
        
       
        for(int i=0; i<3 ; i++){//Aquí da igau de quien tomemos la longuitud,recorre,os huecos
                
                Tablero aux= SerializationUtils.clone(tablero_inicial) ;//Necesitamos copia profunda para poder tratar esto de forma recursiva
                aux.setPasito(0);//Para evitar acumulacion por recursividad
                
                if(aux.getTurno()==1){
                     if(HuecoNeutro.estaHuecoVacio(aux.huecos_neutros_jugador1[i])){
                         ;
                     }else{
                         aux.elegirHueco(aux.huecos_neutros_jugador1[i]);
                         solucion.insertarHijo(tablero_inicial,aux);
                         aux.setId(tablero_inicial.getId()+1);
                         escenarios_posibles.add(aux);
                         tablero_inicial.setPasito(tablero_inicial.getPasito()+1);
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
                         tablero_inicial.setPasito(tablero_inicial.getPasito()+1);
                         aux.mostrarTablero();
                         
                         
                     
                    }
                }
               
                
                //solucion.insertarHijo(tablero_inicial,aux);
            
   
        }
        if(escenarios_posibles.isEmpty()){
            construirArbol();
        }
        
        else if(nivel<=2&& primer_paso==true){
                   
                   listas_de_niveles.add(getTablerosPorId(nivel+1,escenarios_posibles));
                   System.out.println(listas_de_niveles);
                   primer_paso=false;
        }
        tablero_inicial=(Tablero)escenarios_posibles.get(0);//definimos nuevo tablero inicial
        
        escenarios_posibles.remove(0);
        
        if(escenarios_posibles.isEmpty()||escenarios_posibles.get(0).getId()!=tablero_inicial.getId()&&ultimo_paso==false){
            
            
            nivel++;
            primer_paso=true;
        }
        if(nivel<2){//Control de niveles
            
            construirArbol();
        }else if (nivel==2&&ultimo_paso==false){
            ultimo_paso=true;
            construirArbol();
            
            
        }else solucion.imprimirArbol(solucion);
       
            
    }
    public int mayorValor(List<Integer> valores){
        int resultado=0;
        for(int i=0;i<valores.size();i++){
            if (valores.get(i)>resultado){
                resultado=valores.get(i);
            }
        }
        return resultado;
    }
    public int menorValor(List<Integer> valores){
        int resultado=0;
        for(int i=0;i<valores.size();i++){
            if (valores.get(i)<resultado){
                resultado=valores.get(i);
            }
        }
        return resultado;
    }
    
    public List<Integer> getValoresLista(List<Nodo> tableros){
        List<Integer> solucion = new LinkedList();
        for(int i=0; i<tableros.size();i++){
            solucion.add(tableros.get(i).getTablero().getValorPoda());
        }
        
        return solucion;
    }
    
    public Tablero podaAlfaBeta(){
        Tablero solucion;
        List<Tablero>camino=new LinkedList();
        
        //Vamos recorreindo los hijos, con el mismo padre, y con ello vamos al siguiente nivel
        for(int i=listas_de_niveles.size()-1; i>0 ;i--){//Recorremos cada nivel
            List<Tablero> lista_de_niveles_padres=listas_de_niveles.get(i-1);//Sus padres
           
            for(int j=0;j<lista_de_niveles_padres.size();j++){//Recorremos los padres de cada nivel
               int mejor_valor;
               Tablero padre =lista_de_niveles_padres.get(j);
               List<Nodo> hijos = padre.getSuNodo().hijos;
               List<Integer> valores_hijos = getValoresLista(hijos);
               int nuevo_valor = mayorValor(valores_hijos);
              
               
               padre.setValorPoda(nuevo_valor);
               
            }
            
            //Aqui acabamos un nivel
            
        }
        List<List<Integer>>cosa=getValoresListaNiveles(listas_de_niveles);
        System.out.println(cosa);
        int el_elegido_val= mayorValor(cosa.get(0));
        Tablero el_elegido_tab=listas_de_niveles.get(0).get(cosa.get(0).indexOf(el_elegido_val));
        camino.add(el_elegido_tab);
        for(int i=0; i<listas_de_niveles.size()-1 ;i++){
            List<Nodo> hijos = el_elegido_tab.getSuNodo().hijos;
            if (hijos.isEmpty()){
                ;
            }else{
                List<Integer> valores_hijos = getValoresLista(hijos);
                Tablero nuevo_elegido=hijos.get(valores_hijos.indexOf(el_elegido_val)).getTablero();
                camino.add(nuevo_elegido);
                el_elegido_tab=nuevo_elegido;
            }
            
                    
            
        }
        System.out.println(camino.get(camino.size()-1));
        System.out.println(camino.get(camino.size()-1).getValorPoda());
        camino.get(camino.size()-1).mostrarTablero();
        solucion=camino.get(camino.size()-1);
        solucion.setPasito(0);
        solucion.setId(0);
        nivel=0;
        
        return solucion;
    }
    
   
    
    
    
    
    
    
    public static void main(String args[]){//Para pruebas
        
        AlgoritmoJuego prueba=new AlgoritmoJuego();
        prueba.construirArbol();
        prueba.fEvaluacion(prueba.getListaNiveles());
        prueba.tablero_inicial=prueba.podaAlfaBeta();
        AlgoritmoJuego prueba2=new AlgoritmoJuego();
        prueba2.setNuevoTableroInicial(SerializationUtils.clone(prueba.tablero_inicial));
        prueba2.construirArbol();
        prueba2.fEvaluacion(prueba2.getListaNiveles());
        prueba2.tablero_inicial=prueba2.podaAlfaBeta();
        AlgoritmoJuego prueba3=new AlgoritmoJuego();
        prueba3.setNuevoTableroInicial(SerializationUtils.clone(prueba2.tablero_inicial));
        prueba3.construirArbol();
        prueba3.fEvaluacion(prueba3.getListaNiveles());
        System.out.println(prueba3.listas_de_niveles);
        prueba3.tablero_inicial=prueba3.podaAlfaBeta();
        AlgoritmoJuego prueba4=new AlgoritmoJuego();
        prueba4.setNuevoTableroInicial(SerializationUtils.clone(prueba3.tablero_inicial));
        prueba4.construirArbol();
        prueba4.fEvaluacion(prueba4.getListaNiveles());
        System.out.println(prueba4.listas_de_niveles);
        prueba4.tablero_inicial=prueba4.podaAlfaBeta();
      
      
        
    }
       
        
        
        //Aquí ya deberíamos tener una lista de los primeros casos posibles
}
    
    

