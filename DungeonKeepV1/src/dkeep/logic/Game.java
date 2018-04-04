package dkeep.logic;



import java.io.PrintStream;

import javax.swing.text.JTextComponent;

import dkeep.cli.*;
import dkeep.logic.*;

public class Game
{
	public Hero hero;
	public Guard guard;
	public Ogre ogre;
	public Weapon weapon;
	public Charac enemy; // type of ogre, guard, key and weapon
	public Map mapa;
	private boolean status;
	private int MODE; // MODE 0 DUNGEON MODE // MODE 1 KEEP MODE // MODE 2 WEAPON MODE
	
//	public static void main(String[] args) 
//	{
//		char [][]map1 = {
//				{'X','X','X','X','X','X','X','X','X','X'},
//				{'X','H',' ',' ','I',' ','X',' ','G','X'},
//				{'X','X','X',' ','X','X','X',' ',' ','X'},
//				{'X',' ','I',' ','I',' ','X',' ',' ','X'},
//				{'X','X','X',' ','X','X','X',' ',' ','X'},
//				{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
//				{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
//				{'X','X','X',' ','X','X','X','X',' ','X'},
//				{'X',' ','I',' ','I',' ','X','k',' ','X'},
//				{'X','X','X','X','X','X','X','X','X','X'}};
//		
//		char [][]map2 = {
//				{'X','X','X','X','X','X','X','X','X'},
//				{'I',' ',' ',' ','O',' ',' ','k','X'},
//				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
//				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
//				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
//				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
//				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
//				{'X','H',' ',' ',' ',' ',' ',' ','X'},
//				{'X','X','X','X','X','X','X','X','X'}};
//		
//		Map first = new Map(map1);
//		Game game = new Game (first);
//		game.loadMap(map1, game);
//		
//		Map second = new Map(map2);
//		Game game2 = new Game(second);
//		game2.loadMap(map2, game2);
//	}
	
	public Game(Map gameMap) 
	{
		//this.mapaIn = gameMap;
		this.mapa = gameMap;
		this.status = true;
		
		int aux[] = Logic.findChar(gameMap.getMap(),'H');
		this.hero = new Hero(aux[1],aux[0],'H');
		
		int aux1[] = Logic.findChar(gameMap.getMap(),'G');
		int aux2[] = Logic.findChar(gameMap.getMap(),'*');
		
		if(aux1[0] != 0 && aux1[1] != 0)
		{
			this.MODE = 0;
			this.guard = new Guard(aux1[1],aux1[0],'G');
		}
		
		else if ( (aux1[0] == 0 && aux1[1] == 0) && (aux2[0] == 0 && aux2[1] == 0) ) //n encontraste guarda nem weapon
		{
			//just an ogre
			this.MODE = 1;
			aux1 = Logic.findChar(gameMap.getMap(),'O');
			this.ogre = new Ogre(aux1[1],aux1[0],'O');
			
		}
		
		else // an ogre with weapon
		{
			this.MODE = 2;
			aux1 = Logic.findChar(gameMap.getMap(),'O');
			this.ogre = new Ogre(aux1[1],aux1[0],'O');
			this.weapon = new Weapon(aux2[0], aux[1], '*');
		}
	}	

	public Object getHeroPosition() {
		return new CellPosition(hero.X,hero.Y);
	}
	
	public Object getOgrePosition()
	{
		return new CellPosition(ogre.X, ogre.Y);
	}
	
	public String printStringMaper() 
	{
		String ret = "";
		for(int i = 0; i <= (this.mapa.getMap().length-1); i++)
		{
			for(int j = 0;j <= (this.mapa.getMap()[0].length-1);j++) {
			ret += this.mapa.getMap()[i][j] + " ";
			}
			ret += "\n";
		}
		return ret;
	}
	
	public int getMode()
	{
		return this.MODE;
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
		mapa.setMap(Movement.moveHero(mapa.getMap(),hero, movement, MODE));
	}
	
	public boolean isGameOver() 
	{
		if(MODE == 0)
		{
			status = Logic.checkCollison(hero, guard);
			return !Logic.checkCollison(hero, guard);
		}
		
		if(MODE == 1)
		{
			status = Logic.checkCollison(hero, ogre);
			return !Logic.checkCollison(hero, ogre);
		}
		
		else
		{
			status = Logic.checkCollison(hero, weapon);
			return !Logic.checkCollison(hero, weapon);
		}
	}
	
	public String loadMap (char [] [] mapa, Object output)
	{
		String temp = Commons.printMap(mapa, output);
		
		if(output instanceof PrintStream)
		{
			while(!this.isGameOver())
			{
				mapa = Movement.moveHero(mapa ,this.hero , Commons.inputHero(),0);

				
				if(this.getMode() == 0)
				{
					mapa = Movement.moveGuard(mapa ,this.guard);
				}
				
				else if(this.getMode() == 1)
				{
					mapa = Movement.moveOgre(mapa ,this.ogre, Logic.randomDirection());
				}
				
				else
				{
					mapa = Movement.moveOgre(mapa ,this.ogre, Logic.randomDirection());
					mapa = Movement.moveClub(mapa ,this.ogre, this.weapon,Logic.randomDirection());
				}
				
				Commons.printMap(mapa, output);
				
				if(this.hero.previous == 'S') //Exit check
				{	
					System.out.print("\nYou win. Try this map :D!!\n\n");
					
				}
			}
			
			System.out.print("\nYou lose. Try again!!\n\n");
			System.exit(0);
		}
		else
		{
			if(this.isGameOver())
			{
				return "PERDEU O JOGO";
			}
			
			if(this.getMode() == 0)
			{
				mapa = Movement.moveGuard(mapa ,this.guard);
			}
			
			else if(this.getMode() == 1)
			{
				mapa = Movement.moveOgre(mapa ,this.ogre, Logic.randomDirection());
			}
			
			else
			{
				mapa = Movement.moveOgre(mapa ,this.ogre, Logic.randomDirection());
				mapa = Movement.moveClub(mapa ,this.ogre, this.weapon,Logic.randomDirection());
			}
			return temp;
		}
		return null;
	}

	////////////////////////////////
	
//	public static boolean firstMap()
//	{
//		boolean win = true;
//		
//		char [][]map1 = {
//				{'X','X','X','X','X','X','X','X','X','X'},
//				{'X','H',' ',' ','I',' ','X',' ','G','X'},
//				{'X','X','X',' ','X','X','X',' ',' ','X'},
//				{'X',' ','I',' ','I',' ','X',' ',' ','X'},
//				{'X','X','X',' ','X','X','X',' ',' ','X'},
//				{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
//				{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
//				{'X','X','X',' ','X','X','X','X',' ','X'},
//				{'X',' ','I',' ','I',' ','X','k',' ','X'},
//				{'X','X','X','X','X','X','X','X','X','X'}};
//		
//		int aux[] = Logic.findChar(map1,'H');
//		Hero h= new Hero(aux[1],aux[0],'H');
//		int aux1[] = Logic.findChar(map1,'G');
//		Guard g= new Guard(aux1[1],aux1[0],'G');
//		Commons.printMap(map1);
//		
//		while(win) 
//		{
//			map1 = Movement.moveHero(map1 ,h , Commons.inputHero(),0);
//			map1 = Movement.moveGuard(map1 ,g);
//			Commons.printMap(map1);
//			win = Logic.checkCollison(h, g); //se encontrar 
//			
//			if(h.previous == 'S') //Exit check
//			{	
//				System.out.print("\nYou win. Try this map :D!!\n\n");
//				return true;
//			}
//		}
//		
//		System.out.print("\nYou lose. Try again!!\n\n");
//		return false;
//	}
//	
//	
//	public static boolean secondMap()
//	{
////		boolean win=true;
////		boolean win2=true;
////		
////		char [][]map2 = {
////				{'X','X','X','X','X','X','X','X','X'},
////				{'I',' ',' ',' ','O',' ',' ','k','X'},
////				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
////				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
////				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
////				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
////				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
////				{'X','H',' ',' ',' ',' ',' ',' ','X'},
////				{'X','X','X','X','X','X','X','X','X'}};
////		
////		int aux[] = Logic.findChar(map2,'H');
////		Hero h= new Hero(aux[1],aux[0],'H');
////		int aux1[] = Logic.findChar(map2,'O');
////		Ogre o= new Ogre(aux1[1],aux1[0],'O');
////		int aux3[] = Logic.findChar(map2,' ');
////		Weapon c= new Weapon(aux3[1],aux3[0],' ');
////		Commons.printMap(map2);
////		
////		while(win && win2) 
////		{
////			map2 = Movement.moveHero(map2 ,h , Commons.inputHero(),1);
////			map2 = Movement.moveOgre(map2 ,o, Logic.randomDirection());
////			map2 = Movement.moveClub(map2 ,o, c,Logic.randomDirection());
////			Commons.printMap(map2);
////			win = Logic.checkCollison(h, o);
////			win2 = Logic.checkCollison(h, c);
////			
////			if(h.previous == 'S') //Wall check
////			{
////				return true;
////			}
////		}
////		
////		System.out.print("\nYou lose. Try again!!\n\n");
//		return false;
//	}
}
