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
	boolean boss = false;
	public void tick(){
		
		seguimentoDePuntaje++;
		if(seguimentoDePuntaje >= 60*3 && hud.VIDA > 0){
			seguimentoDePuntaje = 0;
			hud.setNivel((int)hud.getNivel()+1);
			if(!boss){
				manejador.addObjeto(new EnemigoBasico(r.nextInt(Juego.ANCHO-48), r.nextInt(Juego.ALTO-70), ID.EnemigoBasico, manejador));
				if(hud.getNivel() % 4 == 0){
					manejador.addObjeto(new EnemigoRapido(r.nextInt(Juego.ANCHO-60), r.nextInt(Juego.ALTO-60), ID.EnemigoRapido, manejador));
				}
				if(hud.getNivel() == 7){
					manejador.addObjeto(new EnemigoInteligente(r.nextInt(Juego.ANCHO-60), r.nextInt(Juego.ALTO-60), ID.EnemigoInteligente, manejador));
				}
			}
			if(hud.getNivel() == 20){
				boss = true;
				manejador.limpiarEnemigos();
				manejador.limpiarEnemigos();
				manejador.limpiarEnemigos();
				manejador.addObjeto(new Jefe1((Juego.ANCHO/2)-32, -300, ID.Jefe1, manejador));
			}
		}
		
	}

}
