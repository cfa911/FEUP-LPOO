package dkeep.logic;



import java.io.PrintStream;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import dkeep.cli.*;
import dkeep.gui.Graphic;
import dkeep.gui.Interfaces;
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
			for(int j = 0;j <= (this.mapa.getMap()[0].length-1);j++) 
			{
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
	
	public boolean isWon()
	{
		if(MODE == 0)
		{
			if(this.hero.previous == 'S')
			{
				return true;
			}
		}
		return false;
	}
	
	public char[][] loadMap (Object output)
	{
		char[][] temp = this.mapa.getMap();
		
		
		if(output instanceof PrintStream)
		{
			Commons.printMap(this.mapa.getMap(), output);
			
			while(!this.isGameOver())
			{
				this.mapa.setMap(Movement.moveHero(this.mapa.getMap() ,this.hero , Commons.inputHero(),0));

				
				if(this.getMode() == 0)
				{
					this.mapa.setMap(Movement.moveGuard(this.mapa.getMap() ,this.guard));
				}
				
				else if(this.getMode() == 1)
				{
					this.mapa.setMap(Movement.moveOgre(this.mapa.getMap() ,this.ogre, Logic.randomDirection()));
				}
				
				else
				{
					this.mapa.setMap(Movement.moveOgre(this.mapa.getMap() ,this.ogre, Logic.randomDirection()));
					this.mapa.setMap(Movement.moveClub(this.mapa.getMap() ,this.ogre, this.weapon,Logic.randomDirection()));
				}
				
				Commons.printMap(this.mapa.getMap(), output);
				
				if(this.hero.previous == 'S') //Exit check
				{	
					System.out.print("\nYou win. Try this map :D!!\n\n");
					break;
				}
				else if (this.isGameOver())
				{
				System.out.print("\nYou lose. Try again!!\n\n");
				System.exit(0);
				}
			}

//			System.out.print("\nYou lose. Try again!!\n\n");
//			System.exit(0);
		}
		else
		{
			/*if(this.isGameOver())
			{
				return null;
				//JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
				//System.exit(0);
				//Interfaces.btnLeft();
			}*/
			
			
			if(this.getMode() == 0)
			{
				this.mapa.setMap(Movement.moveGuard(this.mapa.getMap() ,this.guard));
			}
			
			else if(this.getMode() == 1)
			{
				this.mapa.setMap(Movement.moveOgre(this.mapa.getMap() ,this.ogre, Logic.randomDirection()));
			}
			
			else
			{
				this.mapa.setMap(Movement.moveOgre(this.mapa.getMap() ,this.ogre, Logic.randomDirection()));
				this.mapa.setMap(Movement.moveClub(this.mapa.getMap() ,this.ogre, this.weapon,Logic.randomDirection()));
			}
	
			
			if(this.hero.previous == 'S') //Exit check
			{
				return new char[][] {{'n'}};
				//return "\nYou win. Try this map :D!!\n\n";
				//break;
			}
			
			else
				return temp;
		}
		return null;
	}
}
