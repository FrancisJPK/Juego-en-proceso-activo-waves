package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class HUD {
	
	Random r = new Random();
	public static int VIDA = 100;
	
	public void tick(){
		//Notese como podemos usar el metodo barrera 
		//en la vida del jugador
		VIDA = Juego.barrera(VIDA, 0, 101);
		
	}
	
	public void render(Graphics g){
		Color c = new Color(150, 255, 180, 100);
		g.setColor(c);
		g.fillRect(Juego.ANCHO/2 - 100, 0, VIDA*2, 32);
		g.setColor(Color.WHITE);
		g.drawRect(Juego.ANCHO/2 - 100, 0, 200, 32);
	}

}
