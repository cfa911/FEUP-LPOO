package test;

import static org.junit.Assert.*;

import dkeep.cli.Commons;
import dkeep.cli.Map;
import dkeep.logic.*;
import org.junit.Test;

public class testeAdd {
	
	char [][] keep = {
			{'X','X','X','X','X'},
			{'X','H',' ','O','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}
			};

//	@Test(timeout=1000)
//	public void testMoveOgre()
//	{
//		Map gameMap = new Map(keep);
//		Game game = new Game (gameMap);
////		Ogre o = new Ogre(1, 3, 'O');
////		Weapon t = new Weapon(1,2,'s');
////		Key k = new Key(0, 0, 'w');
//		
//		String r = Logic.randomDirection();
//		//char[][] nMap = Movement.moveOgre(keep, o, r);
//		
//		if(Logic.findChar(game.mapa,'O').equals(1) && Logic.findChar(gameMap, 'O').equals(2))
//		{
//			assertEquals("left", r);
//		}
//		
//		if(Logic.findChar(nMap,'O').equals(2) && Logic.findChar(nMap, 'O').equals(3))
//		{
//			assertEquals("down", r);
//		}
//		
//		if(Logic.findChar(nMap,'O').equals(0) && Logic.findChar(nMap, 'O').equals(3))
//		{
//			assertEquals("up", r);
//		}
//		
//		if(Logic.findChar(nMap,'O').equals(1) && Logic.findChar(nMap, 'O').equals(4))
//		{
//			assertEquals("rigth", r);
//		}
//		
//		if(Logic.findChar(nMap,'O').equals(1) && Logic.findChar(nMap, 'O').equals(3))
//		{
//			assertEquals("null", r);
//		}
//	}
	
	@Test
	public void TestOgreMode()
	{
		Map gameMap = new Map(keep);
		Game game = new Game (gameMap);
		Ogre o = new Ogre(1, 3, 'O');
		assertEquals(game.getMode(), 1);
	}
}
