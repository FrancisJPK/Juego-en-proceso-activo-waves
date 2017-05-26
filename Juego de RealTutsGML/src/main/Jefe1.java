package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Jefe1 extends ObjetoDeJuego{

	private int ancho = 96;
	private int alto = 96;
	private Random r = new Random();
	private Handler manejador;
	private int reloj = 100;
	private int reloj2 = 100;
	
	public Jefe1(int x,int y,ID id,Handler manejador){
		super(x,y,id);
		
		setVelX(0);
		setVelY(3);
		
		this.manejador = manejador;
	}
	
	public Rectangle obtenerArea(){//-----------------------------------METODO OBTENERAREA (hitBox):
		return new Rectangle((int) x,(int) y,ancho,alto);
	}//--------------------------------- ---------------------------------------------------------
	
	int cont = 0;
	public void tick() {
		x += velX;
		y += velY;
		cont++;
		//si el enemigo se sale de la pantalla invertimos la velocidad
		//en el lado respectivo
		
		if(x >= Juego.ANCHO -56 || x <= 0){
			velX *= -1;
		}
		/*
		if(y >= Juego.ALTO -68 || y <= 0){
			velY *= -1;
		}
		*/
		
		if(reloj <= 0) setVelY(0);
		else reloj--;
		
		if(reloj <= 0) reloj2--;
		if(reloj2 <= 0){
			if(velX == 0) velX = 6;
			int rand = r.nextInt(6);
			if(rand == 0){
				manejador.addObjeto(new BalaJefe1((int)x, (int)y, ID.Bala, manejador));
			}
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x,(int) y, ancho, alto);
	}
	
}
