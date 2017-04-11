package main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Rastro extends ObjetoDeJuego{
	
	//hay mejores maneras de hacer el rastro de los enemigos sin embargo nosotros vamos
	//a crear un "enemigos sin colisión" detras del principal, porque al ser un juego simplon
	//no nos va a consumir recursos
	
	private float alpha = 1;
	private Handler manejador;
	private int alto,ancho;
	private float vida;
	private Color color;

	public Rastro(int x, int y, ID id,Handler manejador,int alto,int ancho,Color color,float vida) {
		super(x, y, id);
		this.manejador = manejador;
		this.alto = alto;
		this.ancho = ancho;
		this.color = color;
		this.vida = vida;
	}


	public void tick() {//--------------------------------------------------------------METODO TICK:
		if(alpha > vida){
			alpha -= vida - 0.001f;
		}else manejador.removeObjeto(this);
	}//---------------------------------------------------------------------------------------------

	
	public void render(Graphics g) {//--------------------------------------------------METODO RENDER:
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(desopacar(alpha));
		
		g.setColor(color);
		g.fillOval(x, y, ancho, alto);
		
		g2d.setComposite(desopacar(1));
		
	}//---------------------------------------------------------------------------------------------

	
	private AlphaComposite desopacar(float alpha){//------------------------------------METODO DESOPACAR:
		
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
		
	}//--------------------------------------------------------------------------------------------
	
	public Rectangle obtenerArea() {//--------------------------------------------------METODO BOTENER AREA:
		//no colosiona con nada asi que el area es nula
		return null;
	}//------------------------------------------------------------------------------------------------

}
