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

public class Interfaz extends JFrame  {
	
	
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

	private Interfaz() {
		setLayout(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//Inicializamos las variables
		
		boton1 = new JButton("Accion");
		boton2 = new JButton("Accion");
		boton3 = new JButton("Accion");
		boton4 = new JButton("Accion");
		boton5 = new JButton("Accion");
		boton6 = new JButton("Accion");
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
		
		boton6.setBounds(180, 10, 80, 40);
		boton5.setBounds(290, 10, 80, 40);
		boton4.setBounds(400, 10, 80, 40);
		boton1.setBounds(180, 390, 80, 40);
		boton2.setBounds(290, 390, 80, 40);
		boton3.setBounds(400, 390, 80, 40);
		empezar.setBounds(700, 70, 130, 40);
		fichas6.setBounds(170, 70, 100, 100);
		fichas5.setBounds(280, 70, 100, 100);
		fichas4.setBounds(390, 70, 100, 100);
		fichas1.setBounds(170, 270, 100, 100);
		fichas2.setBounds(280, 270, 100, 100);
		fichas3.setBounds(390, 270, 100, 100);
		fichasJ2.setBounds(10,70,150,300);
		fichasJ1.setBounds(500,70,150,300);
		
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
		boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
		boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
		boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
		
		//Añadimos todos los componentes a la ventana
		add(fichasJ1);
		add(fichas1);
		add(fichas2);
		add(fichas3);
		add(fichas4);
		add(fichas5);
		add(fichas6);
		add(fichasJ2);
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		add(boton6);
		add(empezar);
		
		
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
		if(tableroIni.getTurno() == 1) {
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

		tableroIni.mostrarTablero();
		}
		finJuego();
		
    }
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if(tableroIni.getTurno() == 1) {
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

		tableroIni.mostrarTablero();
		}
		finJuego();
		
    }
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if(tableroIni.getTurno() == 1) {
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

		tableroIni.mostrarTablero();
		}
		finJuego();
		
    }
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		if(tableroIni.getTurno() == 2) {
		tableroIni.elegirHueco(tableroIni.getHuecosJ2()[0]);
		

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

		tableroIni.mostrarTablero();
		}
		finJuego();
		
    }
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		if(tableroIni.getTurno() == 2) {
		tableroIni.elegirHueco(tableroIni.getHuecosJ2()[1]);
		

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

		tableroIni.mostrarTablero();
		}
		finJuego();
		
    }
	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		if(tableroIni.getTurno() == 2) {
		tableroIni.elegirHueco(tableroIni.getHuecosJ2()[2]);
		

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

		tableroIni.mostrarTablero();
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
			
			System.out.println("EL JUEGO SE HA ACABADO");
			
		}
		
	}
	
	
	
	public static void main(String args []) {
		
		Interfaz interfaz = new Interfaz();
		interfaz.setBounds(0, 0, 1000, 600);
		interfaz.setVisible(true);
		interfaz.setLocationRelativeTo(null);
	}
	
}
