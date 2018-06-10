package mancala;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Interfaz_1 extends JFrame  {
	
	
	private JButton boton1, boton2, boton3, boton4, boton5, boton6;
	private JButton empezar;
        private JButton comienzaJ1;
        private JButton comienzaJ2;
        private JButton boton_paso;
        private JButton nuevo_comienzo;
        private JButton reglas;
	private JTextPane fichas1, fichas2, fichas3, fichas4, fichas5, fichas6;
	private JTextPane fichasJ1, fichasJ2;
	private HuecoNeutro huecoFichas1, huecoFichas2, huecoFichas3, 
	huecoFichas4, huecoFichas5, huecoFichas6, huecoFichasJ1, huecoFichasJ2;
	private Tablero tableroIni;
	int numFichasIni = 2;
	JPanelConFondo fondoFinJuego;
	Color MORADO_SUAVE = new Color(192,130,192);
        Color AZUL_APAGADO= new Color(192,192,130);
        boolean fin=false;
        private JTextPane turno,textoTurno, explicaciones;
        private boolean turno_pulsado=false;
        
        
	private Interfaz_1() {
		setLayout(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//Inicializamos las variables
		
		boton1 = new JButton("");
		boton2 = new JButton("");
		boton3 = new JButton("");
		boton4 = new JButton("");
		boton5 = new JButton("");
		boton6 = new JButton("");
		empezar = new JButton("Empezar");
		fichasJ1 = new JTextPane();
		fichas1 = new JTextPane();
		fichas2 = new JTextPane();
		fichas3 = new JTextPane();
		fichas4 = new JTextPane();
		fichas5 = new JTextPane();
		fichas6 = new JTextPane();
		fichasJ2 = new JTextPane();
                comienzaJ1 = new JButton("Empieza el jugador");
                comienzaJ2 = new JButton("Empieza la CPU");
                boton_paso= new JButton("Siguiente paso");
                nuevo_comienzo=new JButton ("Recomenzar");
                reglas= new JButton("Reglas");
                
                  
		huecoFichas1 = new HuecoNeutro(1);
		huecoFichas2 = new HuecoNeutro(2);
		huecoFichas3 = new HuecoNeutro(3);
		huecoFichas4 = new HuecoNeutro(4);
		huecoFichas5 = new HuecoNeutro(5);
		huecoFichas6 = new HuecoNeutro(6);
		huecoFichasJ1 = new HuecoNeutro(0);
		huecoFichasJ1.setSemillas(0);
		huecoFichasJ2 = new HuecoNeutro(-1);
		huecoFichasJ2.setSemillas(0);
		tableroIni = new Tablero();
                
		
                
                //INICIALIZAR (Esteban)
		turno = new JTextPane();
		turno.setEditable(false);
		turno.setOpaque(false);
		explicaciones = new JTextPane();
		explicaciones.setEditable(false);
		explicaciones.setOpaque(false);
		textoTurno = new JTextPane();
		textoTurno.setEditable(false);
		textoTurno.setOpaque(false);
		append(Color.BLACK, "ES EL TURNO DEL:", textoTurno);
		
		
		//Para cambiar la letra de nuestro JTextPane para que se vea
       append(Color.BLACK, "" + huecoFichas1.getSemillas(), fichas1);
       append(Color.BLACK, "" + huecoFichas2.getSemillas(), fichas2);
       append(Color.BLACK, "" + huecoFichas3.getSemillas(), fichas3);
       append(Color.BLACK, "" + huecoFichas4.getSemillas(), fichas4);
       append(Color.BLACK, "" + huecoFichas5.getSemillas(), fichas5);
       append(Color.BLACK, "" + huecoFichas6.getSemillas(), fichas6);
       append(Color.BLACK, "0", fichasJ1);
       append(Color.BLACK, "0", fichasJ2);
		
		
		
		//Ponemos la posicion y dimensiones en nuestra ventana
		
		boton6.setBounds(170, 10, 100, 100);
		boton5.setBounds(280, 10, 100, 100);
		boton4.setBounds(390, 10, 100, 100);
		boton1.setBounds(170, 270, 100, 100);
		boton2.setBounds(280, 270, 100, 100);
		boton3.setBounds(390, 270, 100, 100);
		
		fichas6.setBounds(170, 70, 100, 100);
		fichas5.setBounds(280, 70, 100, 100);
		fichas4.setBounds(390, 70, 100, 100);
		fichas1.setBounds(170, 270, 100, 100);
		fichas2.setBounds(280, 270, 100, 100);
		fichas3.setBounds(390, 270, 100, 100);
		fichasJ2.setBounds(10,70,150,300);
		fichasJ1.setBounds(500,70,150,300);
                comienzaJ1.setBounds(700, 70, 230, 40);
                comienzaJ2.setBounds(700, 170, 230, 40);
                boton_paso.setBounds(700, 270, 230, 40);
                nuevo_comienzo.setBounds(700, 370, 230, 40);
                reglas.setBounds(700, 470, 230, 40);
                
                //POSICIONES DE NUESTRAS NUEVAS VARIABLES Y TAMA�O(Esteban)
		turno.setBounds(250, 400, 100, 40);
		explicaciones.setBounds(450, 400, 100, 100);
		textoTurno.setBounds(30, 400, 230, 40);
		
		//Colores y bordes
		
		fichas1.setBackground(AZUL_APAGADO);
		fichas2.setBackground(AZUL_APAGADO);
		fichas3.setBackground(AZUL_APAGADO);
		fichas4.setBackground(MORADO_SUAVE);
		fichas5.setBackground(MORADO_SUAVE);
		fichas6.setBackground(MORADO_SUAVE);
		fichasJ1.setBackground(AZUL_APAGADO);
		fichasJ2.setBackground(MORADO_SUAVE);
		fichas1.setSelectedTextColor(Color.LIGHT_GRAY);
		fichas1.setOpaque(true);
		fichas2.setOpaque(true);
		fichas3.setOpaque(true);
		fichas4.setOpaque(true);
		fichas5.setOpaque(true);
		fichas6.setOpaque(true);
		fichasJ1.setOpaque(true);
		fichasJ2.setOpaque(true);
		fichas1.setEditable(false);
		fichas2.setEditable(false);
		fichas3.setEditable(false);
		fichas4.setEditable(false);
		fichas5.setEditable(false);
		fichas6.setEditable(false);
		fichasJ1.setEditable(false);
		fichasJ2.setEditable(false);
		
                //Poner donde se consiga turno extra o se cambie de turno, es decir en los botones 
		//y la maquina (Esteban)
		append(Color.BLACK, "ELIGE", turno);
		append(Color.BLACK, "NADA", explicaciones);
		
		
		//Hacemos los botones invisibles
		
		boton1.setOpaque(false);
		boton1.setContentAreaFilled(false);
		boton1.setBorderPainted(false);
		boton2.setOpaque(false);
		boton2.setContentAreaFilled(false);
		boton2.setBorderPainted(false);
		boton3.setOpaque(false);
		boton3.setContentAreaFilled(false);
		boton3.setBorderPainted(false);
		boton4.setOpaque(false);
		boton4.setContentAreaFilled(false);
		boton4.setBorderPainted(false);
		boton5.setOpaque(false);
		boton5.setContentAreaFilled(false);
		boton5.setBorderPainted(false);
		boton6.setOpaque(false);
		boton6.setContentAreaFilled(false);
		boton6.setBorderPainted(false);
		
		
		//Hacemos los listeners de los botones
		
		boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
		boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton3ActionPerformed(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Interfaz_1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
                comienzaJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comienzaJ1ActionPerformed(evt);
            }
        });
                 comienzaJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comienzaJ2ActionPerformed(evt);
            }
        });
                 boton_paso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPasoActionPerformed(evt);
            }
        });
                 nuevo_comienzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoComienzoActionPerformed(evt);
            }
        });
                 reglas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reglasActionPerformed(evt);
            }
        });
	
		
		//A�adimos todos los componentes a la ventana
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		add(boton6);
		add(fichasJ1);
		add(fichas1);
		add(fichas2);
		add(fichas3);
		add(fichas4);
		add(fichas5);
		add(fichas6);
		add(fichasJ2);
		
                add(comienzaJ1);
                add(comienzaJ2);
                add(boton_paso);
                add(nuevo_comienzo);
                add(reglas);
		
		//A�adir a ventana (Esteban)
		add(turno);
		add(textoTurno);
		add(explicaciones);
	}
	
	//Metodo para meter un style chulo en el JTextPane
	public void append(Color color, String texto, JTextPane pane) {
        StyledDocument doc = pane.getStyledDocument();
        Style syle = doc.addStyle("txt", null);
		pane.setFont(new Font("Serif", Font.PLAIN, 24));
        StyleConstants.setForeground(syle, color);
        try {
             doc.insertString(doc.getLength(), texto, syle);
             
         } catch (BadLocationException ex) {
             ex.printStackTrace();
         }
    }
	
	// Acciones que se realizan al pulsar los botones
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
		if(tableroIni.getTurno() == 1 && fin==false) {
		tableroIni.elegirHueco(tableroIni.getHuecosJ1()[0]);
                
                if(tableroIni.getSucesionTurnos().get(tableroIni.getSucesionTurnos().size()-1)
                        ==tableroIni.getSucesionTurnos().get(tableroIni.getSucesionTurnos().size()-2)){
                    explicaciones.setText("");
                    append(Color.BLACK, "TIENES EXTRA" , explicaciones);
                }else{
                    explicaciones.setText("");
                    append(Color.BLACK, "" , explicaciones);
                }
		
		fichas1.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[0].getSemillas(), fichas1);
		
		fichas2.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[1].getSemillas(), fichas2);
		
		fichas3.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[2].getSemillas(), fichas3);
		
		fichas4.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[0].getSemillas(), fichas4);

		fichas5.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[1].getSemillas(), fichas5);
		
		fichas6.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[2].getSemillas(), fichas6);
		
		fichasJ1.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador1().getPuntuacion(), fichasJ1);

		fichasJ2.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador2().getPuntuacion(), fichasJ2);
                
                turno.setText("");
                append(Color.BLACK, "" + tableroIni.getTurno(), turno);
                
              
                finJuego();
		tableroIni.mostrarTablero();
		}
                finJuego();
            

		
		
    }
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt){
		if(tableroIni.getTurno() == 1 && fin==false) {
		tableroIni.elegirHueco(tableroIni.getHuecosJ1()[1]);
		if(tableroIni.getSucesionTurnos().get(tableroIni.getSucesionTurnos().size()-1)
                        ==tableroIni.getSucesionTurnos().get(tableroIni.getSucesionTurnos().size()-2)){
                    explicaciones.setText("");
                    append(Color.BLACK, "TIENES EXTRA" , explicaciones);
                }else{
                    explicaciones.setText("");
                    append(Color.BLACK, "" , explicaciones);
                }

		fichas1.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[0].getSemillas(), fichas1);
		
		fichas2.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[1].getSemillas(), fichas2);
		
		fichas3.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[2].getSemillas(), fichas3);
		
		fichas4.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[0].getSemillas(), fichas4);

		fichas5.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[1].getSemillas(), fichas5);
		
		fichas6.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[2].getSemillas(), fichas6);
		
		fichasJ1.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador1().getPuntuacion(), fichasJ1);

		fichasJ2.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador2().getPuntuacion(), fichasJ2);
                
                turno.setText("");
                append(Color.BLACK, "" + tableroIni.getTurno(), turno);
                
               
                
                finJuego();
		tableroIni.mostrarTablero();
		}
		finJuego();
           
                
                
		
    }
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException{
		if(tableroIni.getTurno() == 1&& fin==false) {
		tableroIni.elegirHueco(tableroIni.getHuecosJ1()[2]);
		
                if(tableroIni.getSucesionTurnos().get(tableroIni.getSucesionTurnos().size()-1)
                        ==tableroIni.getSucesionTurnos().get(tableroIni.getSucesionTurnos().size()-2)){
                    explicaciones.setText("");
                    append(Color.BLACK, "TIENES EXTRA" , explicaciones);
                }else{
                    explicaciones.setText("");
                    append(Color.BLACK, "" , explicaciones);
                }
		fichas1.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[0].getSemillas(), fichas1);
		
		fichas2.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[1].getSemillas(), fichas2);
		
		fichas3.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[2].getSemillas(), fichas3);
		
		fichas4.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[0].getSemillas(), fichas4);

		fichas5.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[1].getSemillas(), fichas5);
		
		fichas6.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[2].getSemillas(), fichas6);
		
		fichasJ1.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador1().getPuntuacion(), fichasJ1);

		fichasJ2.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador2().getPuntuacion(), fichasJ2);
                
                turno.setText("");
                append(Color.BLACK, "" + tableroIni.getTurno(), turno);
                
                
                
                finJuego();
		tableroIni.mostrarTablero();
		}
                finJuego();
                
                
		
    }
        private void comienzaJ1ActionPerformed(java.awt.event.ActionEvent evt){
            if(turno_pulsado==false){
                tableroIni.getSucesionTurnos().add(1);
                turno_pulsado=true;
                turno.setText("");
                append(Color.BLACK, "" + tableroIni.getTurno(), turno);
            }
        }
        private void comienzaJ2ActionPerformed(java.awt.event.ActionEvent evt){
            if(turno_pulsado==false){
                tableroIni.getSucesionTurnos().add(2);
                turno_pulsado=true;
                turno.setText("");
                append(Color.BLACK, "" + tableroIni.getTurno(), turno);
            }
        }
        
        private void botonPasoActionPerformed(java.awt.event.ActionEvent evt){
            if(tableroIni.getTurno()==2 && fin==false){
                    AlgoritmoJuego prueba=new AlgoritmoJuego();//Constructor del algoritmo
                    prueba.setNuevoTableroInicial(tableroIni);
                    prueba.construirArbol();//Con un tablero inicial establecido en pruebs, te crea el arbol de tres niveles o menos sino llega
                    prueba.fEvaluacion(prueba.getListaNiveles());//Asigna un valor de evaluacion a cada elemento de la lista de niveles TENEIS QUE PONEROS CON ESTO
                    prueba.tablero_inicial=prueba.podaAlfaBeta();
                    tableroIni=prueba.tablero_inicial;
                    
                    fichas1.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[0].getSemillas(), fichas1);
		
		fichas2.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[1].getSemillas(), fichas2);
		
		fichas3.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[2].getSemillas(), fichas3);
		
		fichas4.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[0].getSemillas(), fichas4);

		fichas5.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[1].getSemillas(), fichas5);
		
		fichas6.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[2].getSemillas(), fichas6);
		
		fichasJ1.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador1().getPuntuacion(), fichasJ1);

		fichasJ2.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador2().getPuntuacion(), fichasJ2);
                
                turno.setText("");
                append(Color.BLACK, "" + tableroIni.getTurno(), turno);
                
               if (!(tableroIni.equals(tableroIni.getSuNodo().getPadre().getTablero()))&&
                        (tableroIni.getTurno()==tableroIni.getSuNodo().getPadre().getTablero().getTurno())){
                    explicaciones.setText("");
                    append(Color.BLACK, "TURNO EXTRA", explicaciones);
                }else{
                    explicaciones.setText("");
                    append(Color.BLACK, "", explicaciones);
                }
                
                finJuego();
                tableroIni.mostrarTablero();   
                }
                finJuego();
        }
        
        
        private void nuevoComienzoActionPerformed(java.awt.event.ActionEvent evt){
           
               
                tableroIni=new Tablero();
                fin=false;
                    
                fichas1.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[0].getSemillas(), fichas1);
		
		fichas2.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[1].getSemillas(), fichas2);
		
		fichas3.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[2].getSemillas(), fichas3);
		
		fichas4.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[0].getSemillas(), fichas4);

		fichas5.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[1].getSemillas(), fichas5);
		
		fichas6.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[2].getSemillas(), fichas6);
		
		fichasJ1.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador1().getPuntuacion(), fichasJ1);

		fichasJ2.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador2().getPuntuacion(), fichasJ2);
                
                turno.setText("");
                append(Color.BLACK, "ELIGE", turno);
                
                explicaciones.setText("");
		append(Color.BLACK, "NADA", explicaciones);
             
        }
        
        private void reglasActionPerformed(java.awt.event.ActionEvent evt){
            Interfaz_2 reglas= new Interfaz_2();
            
            reglas.setVisible(true);
        }
        
        
        
        
        
  
	private boolean reanudable(){
            boolean reanudar=false;
            if(tableroIni.getTurno()==1){
                for(int i=0; i<tableroIni.getHuecosJ1().length;i++){
                    if(tableroIni.getHuecosJ1()[i].getSemillas()>3-i){
                        reanudar=true;
                    }
                }
            }else if(tableroIni.getTurno()==2){
                for(int i=0; i<tableroIni.getHuecosJ2().length;i++){
                    if(tableroIni.getHuecosJ2()[i].getSemillas()>3-i){
                        reanudar=true;
                    }
                }
            }
            return reanudar;
        }
	private void finJuego() {
		if((tableroIni.todosVaciosJ1(tableroIni.getHuecosJ1())
				|| tableroIni.todosVaciosJ2(tableroIni.getHuecosJ2()))&&!(reanudable())){
			fin=true;
			System.out.println("EL JUEGO SE HA ACABADO");
                       if(tableroIni.getTurno()==1){//Esto significa que no tiene nada con lo que jugar, todo esta en 2
                            int añadir=0;
                            for(int i=0; i<tableroIni.getHuecosJ2().length;i++){
                                añadir=añadir+tableroIni.getHuecosJ2()[i].getSemillas();
                                tableroIni.getHuecosJ2()[i].setSemillas(0);
                            
                            
                            }
                            tableroIni.getJugador2().setPuntuacion(tableroIni.getJugador2().getPuntuacion()+añadir);
                       }
                            else if(tableroIni.getTurno()==2){
                            int añadir=0;
                            for(int i=0; i<tableroIni.getHuecosJ1().length;i++){
                                añadir=añadir+tableroIni.getHuecosJ1()[i].getSemillas();
                                tableroIni.getHuecosJ1()[i].setSemillas(0);
                            }
                            tableroIni.getJugador1().setPuntuacion(tableroIni.getJugador1().getPuntuacion()+añadir);
                            }
                fichas1.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[0].getSemillas(), fichas1);
		
		fichas2.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[1].getSemillas(), fichas2);
		
		fichas3.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ1()[2].getSemillas(), fichas3);
		
		fichas4.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[0].getSemillas(), fichas4);

		fichas5.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[1].getSemillas(), fichas5);
		
		fichas6.setText("");
		append(Color.BLACK, "" + tableroIni.getHuecosJ2()[2].getSemillas(), fichas6);
		
		fichasJ1.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador1().getPuntuacion(), fichasJ1);

		fichasJ2.setText("");
		append(Color.BLACK, "" + tableroIni.getJugador2().getPuntuacion(), fichasJ2);
                
                turno.setText("");
                append(Color.BLACK, "" + tableroIni.getTurno(), turno);
                
                explicaciones.setText("");
                append(Color.BLACK, "SE ACABO", explicaciones);
                        
                                                                
			
		
                }
		
	}
	
	
	
	public static void main(String args []) {
		
		Interfaz_1 interfaz = new Interfaz_1();
		interfaz.setBounds(0, 0, 1000, 600);
		interfaz.setVisible(true);
		interfaz.setLocationRelativeTo(null);
	}
	
}
