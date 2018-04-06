package test;

import static org.junit.Assert.*;

import dkeep.cli.Commons;
import dkeep.cli.Map;
import dkeep.logic.*;
import org.junit.Test;

public class testeAdd {
	
	char [][] keep = {
			{'X','X','X','X','X'},
			{'X','H',' ',' ','X'},
			{'I',' ','O',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}
			};
	
	char [][] map = {
			{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}
			};

	@Test(timeout=1000)
	public void testMoveOgre()
	{
		Map gameMap = new Map(keep);
		Game game = new Game (gameMap);
		String r = Logic.randomDirection();
		Movement.moveOgre(game.mapa.map, game.ogre, r);
		if(game.ogre.Y == 2 && game.ogre.X == 1)
		{
			assertEquals("left", r);			
		}
		
		else if(game.ogre.Y == 3 && game.ogre.X == 2)
		{
			assertEquals("down", r);
		}
		
		else if(game.ogre.Y == 1 && game.ogre.X == 2)
		{
			assertEquals("up", r);
		}
		
		else if(game.ogre.Y == 2 && game.ogre.X == 3)
		{
			assertEquals("right", r);
					}
		
		else if(game.ogre.Y == 2 && game.ogre.X == 2)
		{
			assertEquals("null", r);
			
		}
		
	}
	

	@Test(timeout=1000)
	public void testMoveSuspicious()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap); 
		game.guard.setPersonality(2);
		assertEquals(game.guard.personality,2);
		Movement.moveGuard(game.mapa.map, game.guard);
		if(game.guard.mode == true && game.guard.wait == 0) {
			assertEquals(game.guard.wait,0);
			assertEquals(game.guard.Y, 1);
			assertEquals(game.guard.X, 2);
		}
		else if(game.guard.mode == false && game.guard.wait == 0) {
			assertEquals(game.guard.wait,0);
			assertEquals(game.guard.Y, 2);
			assertEquals(game.guard.X, 3);
		}
	}
	@Test(timeout=1000)
	public void testMoveRookie()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap); 
		game.guard.setPersonality(0);
		assertEquals(game.guard.personality,0);
		Movement.moveGuard(game.mapa.map, game.guard);
		if(game.guard.mode == true && game.guard.wait == 0) {
			assertEquals(game.guard.Y, 1);
			assertEquals(game.guard.X, 2);
		}
	}
	
	@Test(timeout=1000)
	public void testMoveGuardDrunken()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap); 
		game.guard.setPersonality(1);
		assertEquals(game.guard.personality,1);
		Movement.moveGuard(game.mapa.map, game.guard);
		if(game.guard.mode == true && game.guard.wait == 0) {

			assertEquals(new CellPosition(2, 1), game.getGuardPosition());
		}
		else if(game.guard.mode == false && game.guard.wait == 0) {
			assertEquals(new CellPosition(3, 2), game.getGuardPosition());
		}
		else if(game.guard.wait != 0) {
			assertEquals(new CellPosition(2, 2), game.getGuardPosition());
		}
	}
	
	
	@Test
	public void TestSet()
	{
		Map gameMap = new Map(keep);
		Game game = new Game (gameMap);
		assertEquals(game.getMode(), 1);
	}
	@Test
	public void TestOgreMode()
	{
		Map gameMap = new Map(keep);
		Game game = new Game (gameMap);
		assertEquals(game.getMode(), 1);
	}
	
	@Test
	public void TestGuardMode()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap);
		assertEquals(game.getMode(), 0);
	}
}
