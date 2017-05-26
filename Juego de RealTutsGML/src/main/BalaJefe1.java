package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BalaJefe1 extends ObjetoDeJuego{

	private int ancho = 24;
	private int alto = 24;
	private Random r = new Random();
	private Handler manejador;
	
	public BalaJefe1(int x,int y,ID id,Handler manejador){
		super(x,y,id);
		
		setVelX(r.nextInt(6)-3);
		setVelY(r.nextInt(3)+3);
		
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
		/*
		if(x >= Juego.ANCHO -24 || x <= 0){
			velX *= -1;
		}
		if(y >= Juego.ALTO -48 || y <= 0){
			velY *= -1;
		}
		*/
		if((x >= Juego.ANCHO || x < 0)||(y >= Juego.ALTO|| y < 0)){
			manejador.removeObjeto(this);
			
		}
		if(cont % 6 == 0)
		manejador.addObjeto(new Rastro((int) x+6,(int) y+6,ID.Rastro,manejador,alto/2,ancho/2,Color.red,0.01f));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int) x,(int) y, ancho, alto);
	}
	
}
