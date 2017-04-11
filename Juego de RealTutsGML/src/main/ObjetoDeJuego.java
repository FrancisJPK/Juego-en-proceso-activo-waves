package main;

import java.awt.Graphics;
import java.awt.Rectangle;

//esta clase es a lo que nos vamos a referir como objeto de juego, este concepto abarca todo lo que 
//son , como su nombre lo dice, los objetos que vemos en el juego como por ejemplo:
//enemigos, el jugador, una luz, un triggerer de sonido, etc.
public abstract class ObjetoDeJuego {
	
	protected int x,y;//nuestros objetos van a tener unas coordenadas en el juego
	protected ID id;
	protected int velX,velY;//velocidad del objeto

	//----------------------------------------------------------------------------------------CONSTRUCTOR
	public ObjetoDeJuego(int x,int y,ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}//--------------------------------------------------------------------------------------------------
	
	//---------------------------------------------------METODOS QUE NUESTROS OBJETOS DE JUEGO NESESITAN:
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle obtenerArea();//hit box de los objetos (si tienen...)
	//--------------------------------------------------------------------------------------------------
	
	//--------------------------------------METODOS QUE NUESTROS OBJETOS NO NECESITAN(setters y getters):
	public int getX() {//--------------------------------getX
		return x;
	}

	public void setX(int x) {//--------------------------------setX
		this.x = x;
	}

	public int getY() {//--------------------------------getY
		return y;
	}

	public void setY(int y) {//--------------------------------setY
		this.y = y;
	}

	public ID getId() {//--------------------------------getID
		return id;
	}

	public void setId(ID id) {//--------------------------------setID
		this.id = id;
	}
	
	public int getVelX() {//--------------------------------getVelX
		return velX;
	}

	public void setVelX(int velX) {//--------------------------------setVelX
		this.velX = velX;
	}

	public int getVelY() {//--------------------------------getVelY
		return velY;
	}

	public void setVelY(int velY) {//--------------------------------setVelY
		this.velY = velY;
	}
	//-------------------------------------------------------------------------------------------------
}
