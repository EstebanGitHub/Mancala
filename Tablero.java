
package mancala;

import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;
import org.apache.commons.lang3.SerializationUtils;


/**
 *
 * @author Esteban
 */
public  class Tablero implements Serializable{
	
	
	int semillas_totales;
	public HuecoNeutro[] huecos_neutros_jugador1=new HuecoNeutro[3];
	public HuecoNeutro[] huecos_neutros_jugador2=new HuecoNeutro[3];
	public Jugador jugador1;
	public Jugador jugador2;
	public List<Integer> sucesion_turnos=new LinkedList<>();
        int identificador=0;
        int pasito=0;
        int valor_poda=0;
        public Nodo su_nodo;
        public boolean finalizado=false;
        int post=0;
        boolean de_captura=false;
     
        
        
	
        

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
            sucesion_turnos.add(1);
            identificador=0;
            pasito=0;
           
        }
        
        public Tablero(HuecoNeutro[] huecos_neutros_jugador1,HuecoNeutro[] huecos_neutros_jugador2,
                Jugador jugador1,Jugador jugador2,List<Integer> sucesion_turnos,
                int id){//Constructor para los tableros que se van sucediendo
            semillas_totales=12;
            this.setHuecosJ1(huecos_neutros_jugador1);
            this.setHuecosJ2(huecos_neutros_jugador2);
            this.setJugador1(jugador1);
            this.setJugador2(jugador2);
            this.setSucesionTurnos(sucesion_turnos);
            this.setId(id);
           
            
            
            
        }
        public boolean hayCaptura(){
            return de_captura;
        }
        public boolean getFinalizado(){
            return this.finalizado;
        }
         public void setFinalizado(boolean finalizado){
            this.finalizado = finalizado;
        }
        
        public int getPasito(){
            return pasito;
        }
        
        public void setPasito(int pasito){
            this.pasito=pasito;
        }
        
        
        public int getValorPoda(){
            return valor_poda;
        }
        
        public void setValorPoda(int valor_poda){
            this.valor_poda=valor_poda;
        }
        
        public Nodo getSuNodo(){
            return su_nodo;
        }
        
        public void setSuNodo(Nodo su_nodo){
            this.su_nodo=su_nodo;
        }
       
       
       
       
       
        
        public void mostrarTablero(){
            System.out.println("Jugador 1");
            System.out.println("Puntuacion del jugador 1: " + jugador1.getPuntuacion());
            System.out.println("Huecos que usa el jugador 1: ");
            for (int i=0 ; i<3; i++) {
                   System.out.println("Hueco "+ huecos_neutros_jugador1[i].getId() + ":" 
                           + huecos_neutros_jugador1[i].getSemillas());
            }
            System.out.println("Jugador 2:");
            System.out.println("Puntuacion del jugador 2: " + jugador2.getPuntuacion());
            System.out.println("Huecos que usa el jugador 2: ");
            for (int i=0 ; i<3; i++) {
                   System.out.println("Hueco "+ huecos_neutros_jugador2[i].getId() + ":" 
                           + huecos_neutros_jugador2[i].getSemillas());
            }
            System.out.println("El turno corresponde a: "+ this.sucesion_turnos.get(sucesion_turnos.size()-1));
            System.out.println("Valor Poda:" + this.valor_poda);
            
        }
        
        
        
      
        
        
	public void cambioTurno(boolean extra) {
		if(sucesion_turnos.get(sucesion_turnos.size()-1)==1 && extra==false) {
			sucesion_turnos.add(2);
		}else if(sucesion_turnos.get(sucesion_turnos.size()-1)==1 && extra==true) {//Repeticion de turno
			sucesion_turnos.add(1);
		}else if (sucesion_turnos.get(sucesion_turnos.size()-1)==2  && extra==false) {
			sucesion_turnos.add(1);
		}else if(sucesion_turnos.get(sucesion_turnos.size()-1)==2 && extra==true) {//repeticion de turno
			sucesion_turnos.add(2);
		}
	}
        public int getId(){
            return identificador;
        }
        public void setId(int id){
            this.identificador=id;
        }
        
        public HuecoNeutro[] getHuecosJ1(){//Para la CPU
            return huecos_neutros_jugador1;
        }
        public void setHuecosJ1(HuecoNeutro[] huecosJ1){
            this.huecos_neutros_jugador1 = huecosJ1;
        }
        public HuecoNeutro[] getHuecosJ2(){//Para la CPU
            return huecos_neutros_jugador2;
        }
        public void setHuecosJ2(HuecoNeutro[] huecosJ2){//Para la CPU
            this.huecos_neutros_jugador2 = huecosJ2;
        }
        public Jugador getJugador1(){
             return jugador1;
        }
        public Jugador getJugador2(){//Para la CPU
             return jugador2;
        }
        public void setJugador1(Jugador jugador1){
             this.jugador1=jugador1;
        }
        public void setJugador2(Jugador jugador2){//Para la CPU
             this.jugador2=jugador2;
        }
        public List getSucesionTurnos(){
            return sucesion_turnos;
        }
        public void setSucesionTurnos(List turnos){
            this.sucesion_turnos=turnos;
        }
        public int getTurno(){
            return sucesion_turnos.get(sucesion_turnos.size()-1);
        }
        
        
        
        
         
         
        public boolean comparaHuecos(HuecoNeutro hueco1, HuecoNeutro hueco2){
            return hueco1.getId() == hueco2.getId();
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
		for (int i=0; i<huecos_neutros_jugador2.length;i++){
                    if(comparaHuecos(huecos_neutros_jugador2[i],hueco)) {
                        resultado = i;
                }else ;
            
            }
		
            return resultado;
        }
        
        public void capturaJ1(HuecoNeutro hueco){//Aquí captura el jugador 1
           int posicion = definirPosicionJ1(hueco);
           jugador1.setPuntuacion(jugador1.getPuntuacion()+huecos_neutros_jugador2[2-posicion].getSemillas()
           + 1);
           huecos_neutros_jugador1[posicion].setSemillas(0);
           huecos_neutros_jugador2[2-posicion].setSemillas(0);
           de_captura=true;
        }
        
        public void capturaJ2(HuecoNeutro hueco){//Aquí captura el jugador 2
           int posicion = definirPosicionJ2(hueco);
           jugador2.setPuntuacion(jugador2.getPuntuacion()+huecos_neutros_jugador1[2-posicion].getSemillas()
           + 1);
           huecos_neutros_jugador1[2-posicion].setSemillas(0);
           huecos_neutros_jugador2[posicion].setSemillas(0);
           de_captura=true;
        }
        
        
        
        
	public void elegirHueco(HuecoNeutro hueco) {
            if (sucesion_turnos.isEmpty()) {
			//Tenemos que ver como iniciamos el primer turno, de momento...
                        sucesion_turnos.add(1);
		}
            if(HuecoNeutro.estaHuecoVacio(hueco)) {
			;
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
                                            jugador1.setPuntuacion(jugador1.getPuntuacion()+1);
                                            posicion_actual=-1;
                                            
                                            cambio = cambio==false;
                                            extra = i==1;//ultima iteracion del bucle
                                            
                                        }
                                        else if(cambio){
                                            //Estamos manipilando el otro lado, aquí no podemos capturar
                                             huecos_neutros_jugador2[posicion_actual+1].setSemillas(huecos_neutros_jugador2[posicion_actual+1].getSemillas()+1);//Aquí emepezamos desde fuera
                                             posicion_actual++;
                                        }
                                        else if(i==1 && HuecoNeutro.estaHuecoVacio(huecos_neutros_jugador1[posicion_actual+1])&&!HuecoNeutro.estaHuecoVacio(huecos_neutros_jugador2[1-posicion_actual])){
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
                        else if(sucesion_turnos.get(sucesion_turnos.size()-1)==2) {
                            int posicion_actual = definirPosicionJ2(hueco);
				if(todosVaciosJ2(huecos_neutros_jugador2)){
                                    cambioTurno(false);
                                }
                                else{
                                    
                                    for (int i= valor_actual; i>0 ;i--){
                                        if(posicion_actual==2){
                                            jugador2.setPuntuacion(jugador2.getPuntuacion()+1);
                                            posicion_actual=-1;
                                            cambio = cambio==false;//Será true o false en funcion al numero de cambios
                                            extra = i==1;//Ultima iteracion del bucle
                                            
                                        }
                                        else if(cambio){
                                             //Estamos manipilando el otro lado, aquí no podemos capturar
                                            
                                            huecos_neutros_jugador1[posicion_actual+1].setSemillas(huecos_neutros_jugador1[posicion_actual+1].getSemillas()+1);
                                            posicion_actual++;
                                             
                                        }
                                        else if(i==1 && HuecoNeutro.estaHuecoVacio(huecos_neutros_jugador2[posicion_actual+1])&&!HuecoNeutro.estaHuecoVacio(huecos_neutros_jugador1[1-posicion_actual])){
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
