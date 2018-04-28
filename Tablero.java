
package mancala;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Esteban
 */
public  class Tablero{
	
	
	int semillas_totales;
	public HuecoNeutro[] huecos_neutros_jugador1=new HuecoNeutro[3];
	public HuecoNeutro[] huecos_neutros_jugador2=new HuecoNeutro[3];
	public Jugador jugador1;
	public Jugador jugador2;
	public List<Integer> sucesion_turnos;
	Iterator<Integer> iterador_turnos;
	public boolean repetir_turno;

	public Tablero(){//Constructor para definir el escenario inicial
            //Construimos el escenario de los huecos neutros de ambos jugadores
            for (int i=0 ; i<3; i++) {
                    huecos_neutros_jugador1[i] = new HuecoNeutro(i+1);
            }
            for (int i=0 ; i<3; i++) {
                    huecos_neutros_jugador2[i] = new HuecoNeutro((i+3)+1);
            }
            //Definimos el resto de variables necesarias
            semillas_totales=12;
            jugador1= new Jugador(1);
            jugador2= new Jugador(2);
            sucesion_turnos = new LinkedList<>();
            iterador_turnos = sucesion_turnos.iterator();
            repetir_turno=false;
        }
        public Tablero(Jugador jugador1, Jugador jugador2,
                HuecoNeutro[] huecos_neutros_jugador1, HuecoNeutro[] huecos_neutros_jugador2,
                int turno){//Constructor para definir la situacion actual
          
        }
        
	public void cambioTurno(boolean extra) {
		if (sucesion_turnos.isEmpty()) {
			//Tenemos que ver como iniciamos el primer turno
		}else if(sucesion_turnos.get(sucesion_turnos.size()-1)==1 && extra==false) {
			sucesion_turnos.add(2);
		}else if(sucesion_turnos.get(sucesion_turnos.size()-1)==1 && extra==true) {//Repeticion de turno
			sucesion_turnos.add(1);
		}else if (sucesion_turnos.get(sucesion_turnos.size()-1)==2  && extra==false) {
			sucesion_turnos.add(1);
		}else if(sucesion_turnos.get(sucesion_turnos.size()-1)==2 && extra==true) {//repeticion de turno
			sucesion_turnos.add(2);
		}
	}
        
        
        public boolean comparaHuecos(HuecoNeutro hueco1, HuecoNeutro hueco2){
            return hueco1.getId()==hueco2.getId();
        }
	
	public boolean todosVaciosJ1(HuecoNeutro[] huecos_jugador) {
		int contador=0;
		for (int i=0 ; i<3; i++) {
			if(HuecoNeutro.estaHuecoVacio(huecos_neutros_jugador1[i])) {
				contador++;
			}
		}
            return contador == 3;
	}
	
	public boolean todosVaciosJ2(HuecoNeutro[] huecos_jugador) {
		int contador=0;
		for (int i=0 ; i<3; i++) {
			if(HuecoNeutro.estaHuecoVacio(huecos_neutros_jugador2[i])) {
				contador++;
			}
		}
            return contador == 3;
	}
	
	public int definirPosicionJ1(HuecoNeutro hueco) {
            int resultado = 0;
		for (int i=0; i<huecos_neutros_jugador1.length;i++){
                    if(comparaHuecos(huecos_neutros_jugador1[i],hueco)) {
                        resultado = i;
                }else ;
            
            }
		
            return resultado;
	}
        
        public int definirPosicionJ2(HuecoNeutro hueco){
            int resultado = 0;
		for (int i=0; i<huecos_neutros_jugador1.length;i++){
                    if(comparaHuecos(huecos_neutros_jugador2[i],hueco)) {
                        resultado = i;
                }else ;
            
            }
		
            return resultado;
        }
        
        public void capturaJ1(HuecoNeutro hueco){//Aquí captura el jugador 1
           int posicion = definirPosicionJ1(hueco);
           jugador1.setPuntuacion(jugador1.getPuntuacion()+huecos_neutros_jugador2[posicion].getSemillas()
           + 1);
           huecos_neutros_jugador1[posicion].setSemillas(0);
           huecos_neutros_jugador2[posicion].setSemillas(0);
        }
        
        public void capturaJ2(HuecoNeutro hueco){//Aquí captura el jugador 2
           int posicion = definirPosicionJ2(hueco);
           jugador2.setPuntuacion(jugador2.getPuntuacion()+huecos_neutros_jugador1[posicion].getSemillas()
           + 1);
           huecos_neutros_jugador1[posicion].setSemillas(0);
           huecos_neutros_jugador2[posicion].setSemillas(0);
        }
        
        
	public void elegirHueco(HuecoNeutro hueco) {
		if(HuecoNeutro.estaHuecoVacio(hueco)) {
			//Negamos acceso, ya veremos como
		}else { //Si hemos elegido un hueco valido, empezamos el reparto
			int valor_actual = hueco.getSemillas();
			
                        boolean cambio=false;//Para empezar a sumar a la otra fila de huecos
                        boolean extra=false;//Para los turnos extra
			if(sucesion_turnos.get(sucesion_turnos.size()-1)==1) {//Caso jugador 1
                            int posicion_actual = definirPosicionJ1(hueco);
				if(todosVaciosJ1(huecos_neutros_jugador1)){
                                    cambioTurno(false);
                                }
                                else{
                                    for (int i= valor_actual; i>0 ;i--){
                                        if(posicion_actual==2){
                                            jugador2.setPuntuacion(jugador2.getPuntuacion()+1);
                                            posicion_actual=0;
                                            cambio = cambio==false;
                                            extra = i==0;
                                            
                                        }
                                        else if(cambio){
                                            //Estamos manipilando el otro lado, aquí no podemos capturar
                                             huecos_neutros_jugador2[posicion_actual+1].setSemillas(huecos_neutros_jugador2[posicion_actual+1].getSemillas()+1);
                                             posicion_actual++;
                                        }
                                        else if(i==0 && HuecoNeutro.estaHuecoVacio(huecos_neutros_jugador1[posicion_actual+1])){
                                            capturaJ1(huecos_neutros_jugador1[posicion_actual+1]);
                                            posicion_actual++;
                                        }
                                        else{
                                            
                                            huecos_neutros_jugador1[posicion_actual+1].setSemillas(huecos_neutros_jugador1[posicion_actual+1].getSemillas()+1);
                                            posicion_actual++;
                                            
                                        }
                                        
                                        
                                    }
                                    hueco.setSemillas(0);//Vaciamos el hueco
                                    cambioTurno(extra);
                                }
			}
                        if(sucesion_turnos.get(sucesion_turnos.size()-1)==2) {
                            int posicion_actual = definirPosicionJ2(hueco);
				if(todosVaciosJ2(huecos_neutros_jugador2)){
                                    cambioTurno(false);
                                }
                                else{
                                    
                                    for (int i= valor_actual; i>0 ;i--){
                                        if(posicion_actual==2){
                                            jugador1.setPuntuacion(jugador1.getPuntuacion()+1);
                                            posicion_actual=0;
                                            cambio = cambio==false;//Será true o false en funcion al numero de cambios
                                            extra = i==0;
                                            
                                        }
                                        else if(cambio){
                                             //Estamos manipilando el otro lado, aquí no podemos capturar
                                            
                                            huecos_neutros_jugador1[posicion_actual+1].setSemillas(huecos_neutros_jugador1[posicion_actual+1].getSemillas()+1);
                                            posicion_actual++;
                                             
                                        }
                                        else if(i==0 && HuecoNeutro.estaHuecoVacio(huecos_neutros_jugador2[posicion_actual+1])){
                                            capturaJ2(huecos_neutros_jugador2[posicion_actual+1]);
                                            posicion_actual++;
                                        }
                                        else{
                                            
                                            huecos_neutros_jugador2[posicion_actual+1].setSemillas(huecos_neutros_jugador2[posicion_actual+1].getSemillas()+1);
                                            posicion_actual++;
                                            
                                        }
                                        
                                        
                                    }
                                    hueco.setSemillas(0);//Vaciamos el hueco
                                    cambioTurno(extra);
                                }
			}
                        
			
		}
	}

	
	
	

}
