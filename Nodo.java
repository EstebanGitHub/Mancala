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
public class Nodo {
    
    public ArrayList hijos = new ArrayList();
    public Tablero tablero_nodo; //Aqui esta el tablero que contiene un nodo
    private int pre_orden=0;
    private int post_orden=0;
    
    public Nodo(Tablero tablero_nodo){//Constructor que inicializa el nodo con un tablero
        this.setTablero(tablero_nodo);
    }

    public Tablero getTablero(){
        
        return this.tablero_nodo;
        
    }
    
    
    public void setTablero(Tablero tablero){
        this.tablero_nodo= tablero;
    }
    
    public int getPostOrden(){
        return post_orden;
    }
    
    public void setPostOrden(int post_orden){
        this.post_orden=post_orden;
    }
    
    public int getPreOrden(){
        return pre_orden;
    }
    
    public void setPreOrden(int pre_orden){
        this.pre_orden=pre_orden;
    }
    
    
}
