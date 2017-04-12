package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Jugador extends ObjetoDeJuego{
	
	private int anchoJ = 32;
	private int altoJ = 32;
	private Handler manejador;
	
	public Jugador(int x, int y, ID id, Handler manejador) {
		super(x, y, id);
		this.manejador = manejador;
	}

	public Rectangle obtenerArea(){//-----------------------------------METODO OBTENERAREA (hitBox):
		return new Rectangle(x,y,anchoJ,altoJ);
	}//--------------------------------- ---------------------------------------------------------
	
	
	//en este metodo tenemos que poner todo lo que se tenga que actualizar por ticks del juego(60 ticks/s)
	public void tick() {
		x+=velX;
		y+=velY;
		
		//ESTE ES MI METODO PARA NO DEJAR QUE SE SALGA EL JUGADOR DE LA PANTALLA
		//sin embargo decidi usar el metodo del turorial
		/*
		if(x < 0) x-=velX;
		else if(x>Juego.ANCHO-38) x-=velX;
		if(y < 0) y-=velY;
		else if(y>Juego.ALTO-60) y-=velY;
		*/
		
		x = Juego.barrera(x, 0, Juego.ANCHO-38);
		y = Juego.barrera(y, 0, Juego.ALTO-60);
		
		colision();
		
		manejador.addObjeto(new Rastro(x,y,ID.Rastro,manejador,anchoJ,altoJ,Color.blue,0.05f));
	}
	
	public void colision(){//--------------------------------------------------------METODO COLISION:
		//recorremos todos los objetos de juego
		for (int i = 0; i < manejador.objetos.size(); i++) {
			ObjetoDeJuego temp = manejador.objetos.get(i);
			//si el objeto temporal actual es de tipo enemigo
			if(temp.getId() == ID.EnemigoBasico || temp.getId() == ID.EnemigoRapido){
				//si las cajas de colisión de los dos se están chocando
				if(obtenerArea().intersects(temp.obtenerArea())){
					//restar 2 de vida
					HUD.VIDA--;
				}
			}
			
		}
	}//---------------------------------------------------------------------------------------------
	
	//renderizacion
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, anchoJ, altoJ);
	}
}