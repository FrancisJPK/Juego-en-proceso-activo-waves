package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemigoInteligente extends ObjetoDeJuego{

	private int ancho = 24;
	private int alto = 24;
	private Random r = new Random();
	private Handler manejador;
	private ObjetoDeJuego jugador;
	
	public EnemigoInteligente(int x,int y,ID id,Handler manejador){
		super(x,y,id);
		this.manejador = manejador;
		
		//recorremos los objetos que hay
		for (int i = 0; i < manejador.objetos.size(); i++) {
			//si el objeto que estamos analizando es un jugador igualamos nuestra variable local "jugador" al jugador
			//asi podemos manipular esa variable
			if (manejador.objetos.get(i).getId() == ID.Jugador) jugador = manejador.objetos.get(i);
		}
		
	}
	
	public Rectangle obtenerArea(){//-----------------------------------METODO OBTENERAREA (hitBox):
		return new Rectangle((int)x,(int)y,ancho,alto);
	}//--------------------------------- ---------------------------------------------------------
	
	int cont = 0;
	public void tick() {
		x += velX;
		y += velY;
		cont++;
		
		//matematicas para seguir al jugador-------------(real tuts)
		float difX = x -jugador.getX() - 8;
		float difY = y -jugador.getY() - 8;
		float distancia = (float) Math.sqrt((x - jugador.getX())*(x-jugador.getX()) + (y-jugador.getY())*(y-jugador.getY()));
		velX = (float) ((-1 / distancia)*difX);
		velY = (float) ((-1 / distancia)*difY);
		//-----------------------------------------------
		
		/*
		//matematicas para seguir al jugador-------------(yo)
		// ----x----
		if(x - jugador.getX() > 0){
			setVelX(-2);
		}else if(x - jugador.getX() < 0){
			setVelX(2);
		}else{
			setVelX(0);
		}
		// ----y----
		if(y - jugador.getY() > 0){
			setVelY(-2);
		}else if(y - jugador.getY() < 0){
			setVelY(2);
		}else{
			setVelY(0);
		}
		//-----------------------------------------------
		 * 
		 */
				
				
		//si el enemigo se sale de la pantalla invertimos la velocidad
		//en el lado respectivo
		
		if(x >= Juego.ANCHO -24 || x <= 0){
			velX *= -1;
		}
		if(y >= Juego.ALTO -48 || y <= 0){
			velY *= -1;
		}
		if(cont % 3 == 0)
		manejador.addObjeto(new Rastro((int)x+6,(int)y+6,ID.Rastro,manejador,alto/2,ancho/2,Color.yellow,0.007f));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval((int)x,(int)y, ancho, alto);
	}
	
}
