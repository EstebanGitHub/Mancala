
package mancala;

public class HuecoJugador {

	int puntuacion;
        int identificador;
	
	public HuecoJugador(int identificador) {
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