
package mancala;


public class HuecoNeutro {
	
	int semillas;
	int identificador;
	
	
	
	public HuecoNeutro(int identificador) {
		this.semillas=4;
		this.identificador=identificador;
	}
	
	public int getSemillas() {
		return semillas;
	}
	public void setSemillas(int semillas) {
		this.semillas=semillas;
	}
        public int getId(){
            return identificador;
        }
	public static boolean estaHuecoVacio(HuecoNeutro hueco) {
            return hueco.getSemillas()==0;
	}
        
	
}
