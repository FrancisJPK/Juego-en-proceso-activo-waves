package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.image.BufferStrategy;
import java.security.AlgorithmConstraints;
import java.util.Random;

import javax.swing.JLabel;

public class Juego extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
	public static int ANCHO = 800,ALTO = 600;
	private String TITULO = "Mi primer juego";
	private HUD hud;
	public static int fpss;
	private Random r;
	
	private Thread hilo;//este va a ser un "single threaded game" pero solo por su simplicidad
	//no es recomendado usar un solo thread
	
	private boolean corriendo;//variable que dictara si el juego corre o no
	
	private Handler manejador;//creamos el manejador de los objetos y lo incializamos en el constructor
	
	private Spawner spawner;
	
	//TEMPORAL
	public static int getAncho(){
		return ANCHO;
	}
	public static int getAlto(){
		return ALTO;
	}
	//---------------------
	//----------------------------------------------------------------------------------CONSTRUCTOR:
	public Juego(){
		manejador = new Handler();
		
		this.addKeyListener(new Teclado(manejador));//le decimos a esta clase que se encargue de analizar si tocamos 
		//alguna tecla
		
		new Ventana(ANCHO, ALTO, TITULO, this);//creamos una ventana
		
		//HUD significa head-up display, una interfaz que se muestra siempre
		//en el juego
		hud = new HUD();
		spawner = new Spawner(manejador,hud);
		r = new Random();
		
		//objetos de juego, spawneo de objetos
		manejador.addObjeto(new Jugador(100,100,ID.Jugador, manejador));
		
		
	}//---------------------------------------------------------------------------------------------
	
	//-------------------------------------------------------------------------------METODO EMPEZAR
	public synchronized void empezar(){
		//ESTE METODO HACE QUE NO TENGAMOS QUE CLICAR PARA QUE EL JUEGO
		//DETECTE QUE ESTAMO
		this.requestFocus();
		hilo = new Thread(this);//incializar el hilo
		hilo.start();//iniciar el hilo
		corriendo = true;
	}//------------------------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------------METODO PARAR
	public synchronized void parar(){
		try {
			hilo.join();
			corriendo = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//-------------------------------------------------------------------------------------------
	
	//--------------------------------------------------------------------METODO RUN (GAME LOOP!!!)
	public void run() {
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(corriendo) {
			
			long now = System.nanoTime(); 
			delta += (now - lastTime) / ns; 
			lastTime = now; 
			
			while(delta >= 1) {
				tick(); 
				delta--; 
			} 
			
			if(corriendo) 
				render();
			frames++; 
			
			if(System.currentTimeMillis() - timer > 1000) {
			timer += 1000;
			System.out.println("FPS: "+ frames); 
			fpss = frames;
			frames = 0; 
			}
		}
		parar();
	}//--------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------METODO TICK
	public void tick(){
		manejador.tick();
		hud.tick();
		spawner.tick();
	}//---------------------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------METODO RENDER
	public void render(){
		//creamos una estrategia buffer, la verdad no entiendo para que se hace esto todavia.
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		
		//------------------------------------------------------------------------------RENDERIZAR ACA!!:
		//creamos una especie de rectangulo del tamaño de una pantalla
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ANCHO, ALTO);
		
		manejador.render(g);//renderizamos los objetos mediante el manejador
		
		hud.render(g);
		
		//------------------------------------------------------------------------------------------------
		
		
		g.dispose();//no se que hace esto
		bs.show();//esto muestra el sighiente buffer disponible
	}//------------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------METODO BARRERA:
	//este metodo lo puede llamar un objeto que no se tenga que salir de la pantalla
	public static int barrera(int valor,int min,int max){
		if(valor < min){
			return valor = min;
		}else if(valor > max){
			return valor = max;
		}else{
			return valor;
		}
	}
	//----------------------------------------------------------------------------METODO MAIN
	public static void main(String[] args) {
		Juego j = new Juego();
	}//-------------------------------------------------------------------------------------

}
