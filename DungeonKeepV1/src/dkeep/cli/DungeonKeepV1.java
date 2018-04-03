package dkeep.cli;

import dkeep.cli.*;
import dkeep.logic.*;
public class DungeonKeepV1 
{
	public static void main(String[] args) 
	{
		while(!firstMap());
		//while(!secondMap());
	}
	
	public static boolean firstMap()
	{
		boolean win = true;
		char [][]map1 = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','H',' ',' ','I',' ','X',' ','G','X'},
				{'X','X','X',' ','X','X','X',' ',' ','X'},
				{'X',' ','I',' ','I',' ','X',' ',' ','X'},
				{'X','X','X',' ','X','X','X',' ',' ','X'},
				{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
				{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X','X','X',' ','X','X','X','X',' ','X'},
				{'X',' ','I',' ','I',' ','X','k',' ','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};
		int aux[] = Logic.findChar(map1,'H');
		Hero h= new Hero(aux[1],aux[0],'H');
		int aux1[] = Logic.findChar(map1,'G');
		Guard g= new Guard(aux1[1],aux1[0],'G');
		Commons.printMap(map1);
		while(win) 
		{
			map1 = Movement.moveHero(map1 ,h , Commons.inputHero(),0);
			map1 = Movement.moveGuard(map1 ,g);
			Commons.printMap(map1);
			win = Logic.checkCollison(h, g);
			if(h.previous == 'S') //Exit check
			{	
				System.out.print("\nYou win. Try this map :D!!\n\n");
				return true;
			}
		}
		System.out.print("\nYou lose. Try again!!\n\n");
		return false;
	}
	public static boolean secondMap() {
		boolean win=true;
		boolean win2=true;
		char [][]map2 = {
				{'X','X','X','X','X','X','X','X','X'},
				{'I',' ',' ',' ','O',' ',' ','k','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X','H',' ',' ',' ',' ',' ',' ','X'},
				{'X','X','X','X','X','X','X','X','X'}};
		int aux[] = Logic.findChar(map2,'H');
		Hero h= new Hero(aux[1],aux[0],'H');
		int aux1[] = Logic.findChar(map2,'O');
		Ogre o= new Ogre(aux1[1],aux1[0],'O');
		int aux3[] = Logic.findChar(map2,' ');
		Weapon c= new Weapon(aux3[1],aux3[0],' ');
		Commons.printMap(map2);
		while(win && win2) 
		{
			map2 = Movement.moveHero(map2 ,h , Commons.inputHero(),1);
			map2 = Movement.moveOgre(map2 ,o, Logic.randomDirection());
			map2 = Movement.moveClub(map2 ,o, c,Logic.randomDirection());
			Commons.printMap(map2);
			win = Logic.checkCollison(h, o);
			win2 = Logic.checkCollison(h, c);
			if(h.previous == 'S') //Wall check
			{
				return true;
			}
		}
		System.out.print("\nYou lose. Try again!!\n\n");
		return false;
	}
}
