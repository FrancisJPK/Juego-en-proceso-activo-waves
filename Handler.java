package main;

import java.awt.Graphics;
import java.util.LinkedList;

//esta clase se va a encargar de mantener, o actualizar y renderizar todos los objetos que tengamos en el mapa.
//Si recordas en game maker, teniamos objetos y los mapas y todo eso. Bueno esta clase se va a encargar de pasar(loop)
//y manejar cada uno de estos objetos y los va a actualizar y renderizarlos porque eso no se hace solo, lo tenemos que hacer nosotros

public class Handler {
	//tengo que estudiar mas para entender esto, pero tengo entendido que es como una 
	//lista de objetos (ObjetoDeJuego) y a ella le vamos a añiadir todos los objetos
	//manejados por el Handler(esta clase)
	LinkedList<ObjetoDeJuego> objetos = new LinkedList<ObjetoDeJuego>();
	
	//------------------------------------------------------------------------METODO TICK:
	public void tick(){
		for (int i = 0; i < objetos.size(); i++) {
			//variable temporal
			ObjetoDeJuego objetoTemporal = objetos.get(i);
			
			objetoTemporal.tick();//llamamos al metodo tick del objeto que estemos prosesando en este momento
			
			if(objetoTemporal.x > Juego.getAncho()){
				removeObjeto(objetoTemporal);
			}
			if(objetoTemporal.y > Juego.getAlto()){
				removeObjeto(objetoTemporal);
			}
		}
	}//--------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------METODO RENDER:
	//este metodo recorre todos los objetos que halla en la lista de "objetos"(LinkedList)
	//los obtiene con la vatriable temporal y los renderiza con el metodo render de la clase
	//Objeto de juego
	public void render(Graphics g){
		for (int i = 0; i < objetos.size(); i++) {
			ObjetoDeJuego objetoTemporal = objetos.get(i);
			
			objetoTemporal.render(g);//llamamos al metodo render del objeto que estemos prosesando en este momento
		}
	}//--------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------METODO ADD:
	//este metodo se encarga de añadir objetos al juego, los objetos que se pueden añadir deben
	//ser de tipo ObjetoDeJuego (deben extender esa clase)
	public void addObjeto(ObjetoDeJuego objeto){
		this.objetos.add(objeto);
	}//-------------------------------------------------------------------------------------
	
	//-------------------------------------------------------------------------METODO REMOVE:
	//este metodo se encarga de remover objetos al juego (de nuevo de tipo ObjetoDeJuego)
	public void removeObjeto(ObjetoDeJuego objeto){
		this.objetos.remove(objeto);
	//el trabajo de añadir y remover objetos del juego nos lo facilita la linked list
	//que todavia no conozco y tengo que aprender que es y como se usa
	}//-------------------------------------------------------------------------------------
	
}
