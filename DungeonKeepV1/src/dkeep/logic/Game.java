package dkeep.logic;



import dkeep.cli.*;
import dkeep.logic.*;

public class Game
{
	public Hero hero;
	public Charac enemy;
	public Map mapa, mapaIn;
	private boolean status;
	private int MODE; // MODE 0 DUNGEON MODE // MODE 1 KEEP MODE
	
	public Game(Map gameMap) 
	{
		this.mapaIn = gameMap;
		this.mapa = gameMap;
		this.status = true;
		
		int aux[] = Logic.findChar(gameMap.getMap(),'H');
		this.hero = new Hero(aux[1],aux[0],'H');
		
		MODE = 0;
		int aux1[] = Logic.findChar(gameMap.getMap(),'G');
		this.enemy = new Guard(aux1[1],aux1[0],'G');
		
		if(aux1[0] == 0 && aux1[1] == 0) {
			MODE = 1;
			aux1 = Logic.findChar(gameMap.getMap(),'O');
			this.enemy = new Guard(aux1[1],aux1[0],'O');
			
		}
	}	

	public Object getHeroPosition() {
		return new CellPosition(hero.X,hero.Y);
	}

	public void moveHero(char c) {
		// TODO Auto-generated method stub
		String movement = " ";
		switch(c)
		{
			case 'w':
				movement = "up";
				break;
			case 'a':
				movement = "left";
				break;
			case 's':
				movement = "down";
				break;
			case 'd':
				movement = "right";
				break;
		}
		mapa.setMap(Movement.moveHero(mapa.getMap(),hero, movement,MODE));
	}
	
	public boolean isGameOver() 
	{
		status = Logic.checkCollison(hero, enemy);
		return !Logic.checkCollison(hero, enemy);
	}

}
