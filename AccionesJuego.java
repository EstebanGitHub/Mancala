
package mancala;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class AccionesJuego{
	
	
	int semillas_totales;
	public HuecoNeutro[] huecos_neutros_jugador1=new HuecoNeutro[6];
	public HuecoNeutro[] huecos_neutros_jugador2=new HuecoNeutro[6];
	public HuecoJugador jugador1;
	public HuecoJugador jugador2;
	public List<Integer> sucesion_turnos;
	Iterator<Integer> iterador_turnos;
	public boolean repetir_turno;

	public AccionesJuego(){//Constructor para definir el escenario inicial
            //Construimos el escenario de los huecos neutros de ambos jugadores
            for (int i=0 ; i<6; i++) {
                    huecos_neutros_jugador1[i] = new HuecoNeutro(i+1);
            }
            for (int i=0 ; i<6; i++) {
                    huecos_neutros_jugador2[i] = new HuecoNeutro(i+1);
            }
            //Definimos el resto de variables necesarias
            semillas_totales=48;
            jugador1= new HuecoJugador(1);
            jugador2= new HuecoJugador(2);
            sucesion_turnos = new LinkedList<>();
            iterador_turnos = sucesion_turnos.iterator();
            repetir_turno=false;
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
		for (int i=0 ; i<6; i++) {
			if(HuecoNeutro.estaHuecoVacio(huecos_neutros_jugador1[i])) {
				contador++;
			}
		}
            return contador == 6;
	}
	
	public boolean todosVaciosJ2(HuecoNeutro[] huecos_jugador) {
		int contador=0;
		for (int i=0 ; i==6; i++) {
			if(HuecoNeutro.estaHuecoVacio(huecos_neutros_jugador2[i])) {
				contador++;
			}
		}
            return contador == 6;
	}
	
	public int definirPosicion(HuecoNeutro hueco) {
            int resultado = 0;
		for (int i=0; i<huecos_neutros_jugador1.length;i++){
                    if(comparaHuecos(huecos_neutros_jugador1[i],hueco)) {
                        resultado = i;
                }else ;
            
            }
		
            return resultado;
	}
        
        public void roboAlHueco(){
            
        }
        
        
	public void elegirHueco(HuecoNeutro hueco) {
		if(HuecoNeutro.estaHuecoVacio(hueco)) {
			//Negamos acceso, ya veremos como
		}else { //Si hemos elegido un hueco valido, empezamos el reparto
			int valor_actual = hueco.getSemillas();
			int posicion_actual = definirPosicion(hueco);
                        boolean cambio=false;//Para empezar a sumar a la otra fila de huecos
                        boolean extra=false;//Para los turnos extra
			if(sucesion_turnos.get(sucesion_turnos.size()-1)==1) {//Caso jugador 1
                            
				if(todosVaciosJ1(huecos_neutros_jugador1)){
                                    cambioTurno(false);
                                }
                                else{
                                    for (int i= valor_actual; i>0 ;i--){
                                        if(posicion_actual==5){
                                            jugador2.setPuntuacion(jugador2.getPuntuacion()+1);
                                            posicion_actual=0;
                                            cambio = cambio==false;
                                            extra = i==0;
                                            
                                        }
                                        else if(cambio){
                                             huecos_neutros_jugador1[posicion_actual+1].setSemillas(huecos_neutros_jugador2[posicion_actual+1].getSemillas()+1);
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
				if(todosVaciosJ2(huecos_neutros_jugador2)){
                                    cambioTurno(false);
                                }
                                else{
                                    
                                    for (int i= valor_actual; i>0 ;i--){
                                        if(posicion_actual==5){
                                            jugador1.setPuntuacion(jugador1.getPuntuacion()+1);
                                            posicion_actual=0;
                                            cambio = cambio==false;//Será true o false en funcion al numero de cambios
                                            extra = i==0;
                                            
                                        }
                                        else if(cambio){
                                             huecos_neutros_jugador1[posicion_actual+1].setSemillas(huecos_neutros_jugador1[posicion_actual+1].getSemillas()+1);
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
