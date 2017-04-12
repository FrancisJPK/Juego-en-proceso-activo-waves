package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemigoRapido extends ObjetoDeJuego{

	private int anchoE = 24;
	private int altoE = 24;
	private Random r = new Random();
	private Handler manejador;
	
	public EnemigoRapido(int x,int y,ID id,Handler manejador){
		super(x,y,id);
		
		setVelX(2);
		setVelY(9);
		
		this.manejador = manejador;
	}
	
	public Rectangle obtenerArea(){//-----------------------------------METODO OBTENERAREA (hitBox):
		return new Rectangle(x,y,anchoE,altoE);
	}//--------------------------------- ---------------------------------------------------------
	int cont = 0;
	public void tick() {
		x += velX;
		y += velY;
		cont++;
		
		//si el enemigo se sale de la pantalla invertimos la velocidad
		//en el lado respectivo
		
		if(x >= Juego.ANCHO -24 || x <= 0){
			velX *= -1;
		}
		if(y >= Juego.ALTO -48 || y <= 0){
			velY *= -1;
		}
		if(cont % 3 == 0)
		manejador.addObjeto(new Rastro(x+6,y+6,ID.Rastro,manejador,altoE/2,anchoE/2,Color.cyan,0.01f));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillOval(x, y, anchoE, altoE);
	}
	
}
