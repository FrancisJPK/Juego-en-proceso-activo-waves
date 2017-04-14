package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class HUD {
	
	public static float VIDA = 100;
	public float verde = 255;
	
	private int puntos = 0;
	private int nivel = 1;
	public boolean seguirContando = true;
	
	public void tick(){//-------------------------------------------------------METODO TICK:
		//Notese como podemos usar el metodo barrera 
		//en la vida del jugador
		VIDA = Juego.barrera(VIDA, 0, 101);
		verde = VIDA  * 2;
		if(seguirContando)
			puntos++;
	}//------------------------------------------------------------------------------------
	
	public void render(Graphics g){//------------------------------------------METODO RENDER:
		//dibujamos la barra de vida
		g.setColor(new Color(100,(int)verde,0,200));
		g.fillRect(Juego.ANCHO/2 - 100, 0,(int) VIDA*2, 32);
		g.setColor(Color.WHITE);
		g.drawRect(Juego.ANCHO/2 - 100, 0, 200, 32);
		
		//Dibujamos el puntaje y el nivel
		g.drawString("Puntaje: "+puntos, 10, 10);
		g.drawString("Nivel: "+nivel, 200, 10);
		
		//dibujamos fpss
		g.drawString("FPS="+Juego.fpss, Juego.ANCHO - 70, 10);
	}//------------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------------------SETTERS GETTERS
	public void setPuntaje(int puntos){
		this.puntos = puntos;
	}
	
	public int getPuntaje(){
		return puntos;
	}
	
	public void setNivel(int nivel){
		this.nivel = nivel;
	}
	
	public float getNivel(){
		return nivel;
	}

}
