package main;

import java.util.Random;

public class Spawner {
	
	private Handler manejador;
	private HUD hud;
	private int seguimentoDePuntaje;
	private Random r;
	
	public Spawner(Handler manejador,HUD hud) {
		r = new Random();
		this.manejador = manejador;
		this.hud = hud;
	}
	int cont = 0;
	public void tick(){
		/*
		seguimentoDePuntaje++;
		if(seguimentoDePuntaje >= 100){
			seguimentoDePuntaje = 0;
			hud.setNivel((int)hud.getNivel()+1);
			manejador.addObjeto(new EnemigoBasico(r.nextInt(Juego.ANCHO-48), r.nextInt(Juego.ALTO-70), ID.EnemigoBasico, manejador));
			if(hud.getNivel() % 5 == 0){
				manejador.addObjeto(new EnemigoRapido(r.nextInt(Juego.ANCHO-60), r.nextInt(Juego.ALTO-60), ID.EnemigoRapido, manejador));
			}
			if(hud.getNivel() == 2){
				manejador.addObjeto(new EnemigoInteligente(r.nextInt(Juego.ANCHO-60), r.nextInt(Juego.ALTO-60), ID.EnemigoInteligente, manejador));
			}
		}
		*/
	}

}
