/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

import javax.swing.JFrame;
import javax.swing.JTextPane;

/**
 *
 * @author Esteban
 */
public class Interfaz_2 extends JFrame {
    
    
    private JTextPane reglas;
    
    public Interfaz_2(){
        setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setSize(1200,720);
        reglas=new JTextPane();
        reglas.setBounds(30,30,1000,600);
        add(reglas);
        
        reglas.setText("El tablero está dispuesto por dos conjuntos de huecos de 2 colores distintos" + "\n" + "\n" +
                "--Cada color corresponde a un jugador, siendo el hueco grande su Hueco de Jugador y los pequeños los huecos con los que puede interactuar"
        + "\n" + "\n" + "--En cada turno, el jugador correspondiente selecciona uno de sus huecos pequeños, realizandose así una siembra"
        + "\n" + "\n" + "--En una siembra, el hueco que ha seleccionado se vacía, y sus semillas se reparten de una en una en sentido antihorario hacia los siguientes huecos, huecos de jugadores incluidos"
        + "\n" + "\n" + "--Si la ultima semilla que se reparte cae en tu hueco de jugador, siendo tu turno, obtienes un turno extra"
        + "\n" + "\n" + "--Si la ultima semilla cae en un hueco tuyo, anteriormente vacío, tanto esa semilla como las semillas del hueco en la misma posicion del jugador opuesto pasan a tu hueco de Jugador. A esto se le denomina captura"
        + "\n" + "\n" + "-- El juego acaba cuendo ni quedan semillas que repartir o cuando le toca a un jugador y este no puede realizar una siembra"
        + "\n" + "\n" + "--Si es el turno de un jugador y no puede realizar una siembra, el juego acaba. Las semillas sobrantes pasan directamente al hueco de Jugador correspondiente a esos huecos"
        + "\n" + "\n" +  "-- Gana el jugador que tenga más semillas en su hueco de jugador"
        + "\n" + "\n" + "\n" + "\n" + "--Esta version está pensada para jugar contra la maquina, el jugadorhumano controla la prte amarilla."
        + "\n" + "\n" + "--Puedes seguir los pasos de lamaquina con el boton <siguiente paso>, y reiniciar la partida con <recomenzar>"
        + "\n" + "\n" + "Puedes decidir quien comienza con los botones correspondientes"
        + "\n" + "\n" + "--Se mostrara <TIENES EXTRA> si el jugador humano tiene un turno extra, <TURNO EXTRA> si lo tiene la maquina. <SE ACABO> cuando finalice el Juego ");
        
        
        
        
        
    }
}
