package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter{
	
	private Handler handler;
	private boolean[] teclasPresionadas = new boolean[4];//array que guarda teclas presionadas
	
	public Teclado(Handler handler){
		this.handler = handler;
		
		teclasPresionadas[0] = false;//W
		teclasPresionadas[1] = false;//A
		teclasPresionadas[2] = false;//S
		teclasPresionadas[3] = false;//D
	}
	//cuando una tecla es presionada, la clase que se le haya asignado un key listener invocara este metodo
	public void keyPressed(KeyEvent e){
		//guardamos en una variable de enteros el numero identificador de la tecla
		int key = e.getKeyCode();
		
		//recorremos los objetos que hay en el juego
		for (int i = 0; i < handler.objetos.size(); i++) {
			//hacemos un objeto temporal que de refiere al objeto del indice
			ObjetoDeJuego temporal = handler.objetos.get(i);
			
			//si el objeto que guardamos es de tipo jugador.....
			if(temporal.getId() == ID.Jugador){
				
				//eventos de keyinput para jugador 1 (presionar)
				if(key == KeyEvent.VK_W) {temporal.setVelY(-5); teclasPresionadas[0] = true;}//W
				if(key == KeyEvent.VK_S) {temporal.setVelY(5); teclasPresionadas[1] = true;}//A
				if(key == KeyEvent.VK_A) {temporal.setVelX(-5); teclasPresionadas[2] = true;}//S
				if(key == KeyEvent.VK_D) {temporal.setVelX(5); teclasPresionadas[3] = true;}//D
				
			}
		}
		//si apretamos escape salir
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	//cuando una tecla es soltada, la clase que se le haya asignado un key listener invocara este metodo
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.objetos.size(); i++) {
			ObjetoDeJuego temporal = handler.objetos.get(i);
			
			if(temporal.getId() == ID.Jugador){
				
				//eventos de keyinput para jugador 1 (soltar)
				if(key == KeyEvent.VK_W) teclasPresionadas[0] = false; //temporal.setVelY(0);//release up
				if(key == KeyEvent.VK_S) teclasPresionadas[1] = false; //temporal.setVelY(0);//release down
				if(key == KeyEvent.VK_A) teclasPresionadas[2] = false; //temporal.setVelX(0);//release left
				if(key == KeyEvent.VK_D) teclasPresionadas[3] = false; //temporal.setVelX(0);//release right
				
				//movimiento vertical
				if(!teclasPresionadas[0] && !teclasPresionadas[1]) temporal.setVelY(0);
				
				//movimiento horizontal
				if(!teclasPresionadas[2] && !teclasPresionadas[3]) temporal.setVelX(0);
			}
		}
	}
}
