package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.objetos.size(); i++) {
			ObjetoDeJuego temporal = handler.objetos.get(i);
			
			if(temporal.getId() == ID.Jugador){
				//eventos de keyinput para jugador 1
				
				if(key == KeyEvent.VK_W) temporal.setVelY(-5);
				if(key == KeyEvent.VK_S) temporal.setVelY(5);
				if(key == KeyEvent.VK_A) temporal.setVelX(-5);
				if(key == KeyEvent.VK_D) temporal.setVelX(5);
			}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.objetos.size(); i++) {
			ObjetoDeJuego temporal = handler.objetos.get(i);
			
			if(temporal.getId() == ID.Jugador){
				//eventos de keyinput para jugador 1
				
				if(key == KeyEvent.VK_W) temporal.setVelY(0);
				if(key == KeyEvent.VK_S) temporal.setVelY(0);
				if(key == KeyEvent.VK_A) temporal.setVelX(0);
				if(key == KeyEvent.VK_D) temporal.setVelX(0);
			}
		}
	}
}
