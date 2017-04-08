package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemigoBasico extends ObjetoDeJuego{

	private int anchoE = 24;
	private int altoE = 24;
	
	public EnemigoBasico(int x,int y,ID id){
		super(x,y,id);
		
		setVelX(2);
		setVelY(2);
	}
	
	public Rectangle obtenerArea(){//-----------------------------------METODO OBTENERAREA (hitBox):
		return new Rectangle(x,y,anchoE,altoE);
	}//--------------------------------- ---------------------------------------------------------
	
	public void tick() {
		x += velX;
		y += velY;
		
		//si el enemigo se sale de la pantalla invertimos la velocidad
		//en el lado respectivo
		if(x >= Juego.ANCHO -24 || x <= 0){
			velX *= -1;
		}
		if(y >= Juego.ALTO -48 || y <= 0){
			velY *= -1;
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, anchoE, altoE);
	}
	
}
