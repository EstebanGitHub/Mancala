/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

import java.io.Serializable;

/**
 *
 * @author Esteban
 */
public class Indice implements Serializable{
    //Vamos a usar este indice para fijar la posicion en la que estamos e ir recooriendo
    
    private int index_preorden=-1;
    private int index_postorden=-1;
    private Tablero tablero_nodo;
    
    //El constructor del indice tiene los indicezs y el tablero correspondiente
    public Indice(int preOrden, int postOrden, Tablero tablero_nodo){
    this.setIndexPreOrden(preOrden);
    this.setIndexPostOrden(postOrden);
    this.setTableroNodo(tablero_nodo);
    }
    
    
    
    public int getIndexPostOrden(){
        return index_postorden;
    }
    
    public void setIndexPostOrden(int index_post){
        this.index_postorden=index_post;
    }
    
    public int getIndexPreOrden(){
        return index_preorden;
    }
    
    public void setIndexPreOrden(int index_pre){
        this.index_preorden=index_pre;
    }
    
    public Tablero getTableroNodo(){
        return tablero_nodo;
    }
    
    public void setTableroNodo(Tablero tablero_nodo){
        this.tablero_nodo=tablero_nodo;
    }
    
    
    
}
