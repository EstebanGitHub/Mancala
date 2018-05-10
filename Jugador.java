
package mancala;

import java.io.Serializable;

public class Jugador implements Serializable{

	int puntuacion;
        int identificador;
	
	public Jugador(int identificador) {
		this.puntuacion=0;
                this.identificador=identificador;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	
	public void setPuntuacion(int puntuacion) {
		this.puntuacion=puntuacion;
	}
	
	
}