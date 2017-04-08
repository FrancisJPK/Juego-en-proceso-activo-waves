package main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

//el objetivo de esta clase es crear una ventana
public class Ventana extends Canvas{

	private static final long serialVersionUID = 1L;

	//en el constructor le pasamos un tamaño, nombre, y nuestra clase juego-------------------------------------------------------------------
	public Ventana(int ancho,int alto,String titulo,Juego juego){
		
		//creamos una ventana(JFrame) le damos el titulo y creamos una dimension que usaremos
		JFrame ventana = new JFrame(titulo);
		Dimension dimension = new Dimension(ancho,alto);
		
		//aca usamos la dimension
		ventana.setPreferredSize(dimension);
		ventana.setMinimumSize(dimension);
		ventana.setMaximumSize(dimension);
		
		//parametros generales para la ventana y añadimos el juego(clase principal) a la ventana
		
		ventana.setResizable(false);//no se podra redimensionar
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//que hacer cuando cerrar
		
		ventana.setLocationRelativeTo(null);//posicion al centro de la pantalla
		
		ventana.add(juego);//añadimos el juego
		
		ventana.setVisible(true);//hacer la ventana visible
		
		//llamamos al metodo que empieza el juego(metodo de la clase principal)
		juego.empezar();
	}//-------------------------------------------------------------------------------------------------------------------------------------------
	
}
