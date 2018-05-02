/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Arbol {
    public Nodo raiz;
    Nodo nodoActual;
    private int contPostOrden=0;
    private int contPreOrden=0;
    private ArrayList indexNodos= new ArrayList();


//Constructor, para inicializar el arbol

    public Arbol(){
    raiz=null;
    }

    public void insertarHijo(Tablero padre, Tablero hijo){//Con escenario inicial, desde la raiz
        Nodo aux=new Nodo(hijo);//Le creamos para prepararlo para colocarlo
        
        if (raiz==null){//No tenemos arbol, constructores iniciales
            
            raiz=aux;
            this.preorden();
            this.postorden();
            System.out.println("Raiz iniciada");
            
            
        }
        else{
            this.insertarHijo(raiz,padre,hijo);
            this.preorden();
            this.postorden();
        }
        
        
        
    }
    
    public void insertarHijo(Nodo nodo_actual,Tablero padre, Tablero hijo){//Paracualquier otro escenario
        
        if (nodo_actual.getTablero().equals(padre)){
            nodo_actual.hijos.add(new Nodo(hijo));
            System.out.println("Nodo insertado");
        }else{
            
            for (int i=0; i<nodo_actual.hijos.size(); i++){
                this.insertarHijo((Nodo)nodo_actual.hijos.get(i), padre, hijo);
            }
            
            
        }
        
        
    }
    
    
    
    public void preorden(){//Constructor preorden inicial
        contPreOrden=0;
        this.preorden(raiz);
    }
    
    public void preorden(Nodo nodo_actual){//Teniendo ya un arbol definido
        Nodo aux= null;
        
        contPreOrden++;
        nodo_actual.setPreOrden(contPreOrden);
        this.agregarEnIndice(nodo_actual, true, false); //esti es preorden
        //Nos queda ver como mostrar como ha quedado
        for(int i=0; i<nodo_actual.hijos.size();i++){
            aux=(Nodo)nodo_actual.hijos.get(i);
            this.preorden(aux);
        }
        
    }
    
    public void postorden(){
        contPostOrden=0;
        this.postorden(raiz);
    }
    
    public void postorden(Nodo nodo_actual){
        Nodo aux=null;
        
        for(int i=0; i<nodo_actual.hijos.size();i++){//Recorre los nodos y los pone a postorden
            aux=(Nodo) nodo_actual.hijos.get(i);
            this.postorden(aux);
        }
        
        contPostOrden++;
        nodo_actual.setPostOrden(contPostOrden);
        this.agregarEnIndice(nodo_actual, false, true); //esti es postorden
        //Nos queda ver como mostrar como ha quedado
        
        
    }
        
    public void agregarEnIndice(Nodo nodo_actual, boolean esPreorden,
            boolean esPostorden){
        
        Indice indice_temporal;
        boolean existe=false;
        
        for(int i=0; i<indexNodos.size();i++){//Realizamos busqueda
            indice_temporal = (Indice) indexNodos.get(i);
            
            if(indice_temporal.getTableroNodo().equals(nodo_actual.getTablero())){
                existe = true;
                
                if(esPreorden) indice_temporal.setIndexPreOrden(nodo_actual.getPreOrden());
                
                if(esPostorden) indice_temporal.setIndexPostOrden(nodo_actual.getPostOrden());
                
                
            }
        }
        
        if(!existe){
            
            indexNodos.add(new Indice(nodo_actual.getPreOrden(),nodo_actual.getPostOrden()
                    ,nodo_actual.getTablero())); //Añadimos nuevo indice
             
        }
      
    }
    //Metodos pendientes, para mostrar los resultados
    public void imprimirIndices(){
        
    }
    
    public void imprimirArbol(){
        
    }
    
    

    
        
    
        

}
