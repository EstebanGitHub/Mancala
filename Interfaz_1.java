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
import mancala.AlgoritmoJuego;
import mancala.AlgoritmoJuego;
import mancala.AlgoritmoJuego;
import mancala.AlgoritmoJuego;
import mancala.HuecoNeutro;
import mancala.HuecoNeutro;
import mancala.HuecoNeutro;
import mancala.HuecoNeutro;
import mancala.JPanelConFondo;
import mancala.JPanelConFondo;
import mancala.JPanelConFondo;
import mancala.JPanelConFondo;
import mancala.Tablero;
import mancala.Tablero;
import mancala.Tablero;
import mancala.Tablero;

public class Interfaz_1 extends JFrame  {
	
	
	private JButton boton1, boton2, boton3, boton4, boton5, boton6;
	private JButton empezar;
	private JTextPane fichas1, fichas2, fichas3, fichas4, fichas5, fichas6;
	private JTextPane fichasJ1, fichasJ2;
	private HuecoNeutro huecoFichas1, huecoFichas2, huecoFichas3, 
	huecoFichas4, huecoFichas5, huecoFichas6, huecoFichasJ1, huecoFichasJ2;
	private Tablero tableroIni;
	int numFichasIni = 2;
	JPanelConFondo fondoFinJuego;
	Color caoba = new Color(95,32,0);
        boolean fin=false;
        private JTextPane turno,textoTurno, explicaciones;
        
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
		empezar.setBounds(700, 70, 130, 40);
		fichas6.setBounds(170, 70, 100, 100);
		fichas5.setBounds(280, 70, 100, 100);
		fichas4.setBounds(390, 70, 100, 100);
		fichas1.setBounds(170, 270, 100, 100);
		fichas2.setBounds(280, 270, 100, 100);
		fichas3.setBounds(390, 270, 100, 100);
		fichasJ2.setBounds(10,70,150,300);
		fichasJ1.setBounds(500,70,150,300);
                
                //POSICIONES DE NUESTRAS NUEVAS VARIABLES Y TAMA�O(Esteban)
		turno.setBounds(250, 400, 100, 40);
		explicaciones.setBounds(450, 400, 100, 100);
		textoTurno.setBounds(30, 400, 230, 40);
		
		//Colores y bordes
		
		fichas1.setBackground(Color.LIGHT_GRAY);
		fichas2.setBackground(Color.LIGHT_GRAY);
		fichas3.setBackground(Color.LIGHT_GRAY);
		fichas4.setBackground(Color.LIGHT_GRAY);
		fichas5.setBackground(Color.LIGHT_GRAY);
		fichas6.setBackground(Color.LIGHT_GRAY);
		fichasJ1.setBackground(Color.LIGHT_GRAY);
		fichasJ2.setBackground(Color.LIGHT_GRAY);
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
		append(Color.BLACK, "Turno a mostrar", turno);
		append(Color.BLACK, "Lo que quieras poner de explicacion", explicaciones);
		
		
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
                jButton3ActionPerformed(evt);
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
		add(empezar);
		
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
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if(tableroIni.getTurno() == 1 && fin==false) {
		tableroIni.elegirHueco(tableroIni.getHuecosJ1()[0]);
		
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
                
              
                
		tableroIni.mostrarTablero();
		}
                finJuego();
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
                
                
                }

		finJuego();
		
    }
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if(tableroIni.getTurno() == 1 && fin==false) {
		tableroIni.elegirHueco(tableroIni.getHuecosJ1()[1]);
		

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
                
               
                

		tableroIni.mostrarTablero();
		}
		finJuego();
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
                
                
                tableroIni.mostrarTablero();   
                }

		
    }
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if(tableroIni.getTurno() == 1&& fin==false) {
		tableroIni.elegirHueco(tableroIni.getHuecosJ1()[2]);
		

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
                
                
                

		tableroIni.mostrarTablero();
		}
                if(tableroIni.getTurno()==2&& fin==false){
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
                
                
                }

                
		finJuego();
                
		
    }
        
        
	private void cargarImagenes() {
        Image imagenInterna = new ImageIcon(
           getClass().getResource("src/Imagenes/Fin_del_Juego_Spidey.png")).getImage();
		fondoFinJuego.setImagen(imagenInterna);

    }    
	
	private void finJuego() {
		if(tableroIni.todosVaciosJ1(tableroIni.getHuecosJ1())
				|| tableroIni.todosVaciosJ2(tableroIni.huecos_neutros_jugador2)) {
			fin=true;
			System.out.println("EL JUEGO SE HA ACABADO");
			
		}
		
	}
	
	
	
	public static void main(String args []) {
		
		Interfaz_1 interfaz = new Interfaz_1();
		interfaz.setBounds(0, 0, 1000, 600);
		interfaz.setVisible(true);
		interfaz.setLocationRelativeTo(null);
	}
	
}