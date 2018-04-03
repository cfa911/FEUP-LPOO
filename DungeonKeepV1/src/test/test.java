package test;

import static org.junit.Assert.*;

import dkeep.cli.*;
import dkeep.logic.*;

import org.junit.Test;

public class test {
	
	char [][] map = {
			{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}
			};
	char [][] keep = {
			{'X','X','X','X','X'},
			{'X','H',' ','O','X'},
			{'I',' ',' ','*','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}
			};
	char [][] map1 = {
			{'X','X','X','X',' ','X'},
			{'X','H',' ','G',' ','X'},
			{'X',' ',' ',' ',' ','X'},
			{'I',' ',' ',' ',' ','X'},
			{'I','k',' ',' ',' ','X'},
			{'X','X','X','X','X','X'}
			};
	//KEEP TESTS
	@Test
	public void testeMoveHeroIntoToDoorKeep()//Hero moves into the closed Keep's exit door, without the key, and fails to open it
	{
		Map gameMap = new Map(keep);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 2), game.getHeroPosition());
		game.moveHero('a');
		assertNotEquals(new CellPosition(2, 2), game.getHeroPosition());
		
	}
	@Test
	public void testeCatchKeyKeep() //Hero moves into the Keep's exit door key cell and changes its representation to "K".
	{
		Map gameMap = new Map(keep);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 2), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 3), game.getHeroPosition());
		assertEquals('K',game.hero.ch);
	}
	@Test
	public void testeOpenDoor() //Hero moves into the closed Keep's exit door, with the key, and the door opens.
	{			
		Map gameMap = new Map(keep);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 2), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 3), game.getHeroPosition());
		game.moveHero('w');
		assertEquals(new CellPosition(1, 2), game.getHeroPosition());
		game.moveHero('a');
		assertEquals(new CellPosition(1, 2), game.getHeroPosition());
		assertEquals(game.mapa.map[2][0],'S');
	}
	@Test
	public void testeMoveHeroIntoToExitKeep() //Hero moves into the open Keep's exit door and the game ends with victory
	{
		Map gameMap = new Map(keep);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 2), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 3), game.getHeroPosition());
		game.moveHero('a');
		assertEquals(new CellPosition(1, 3), game.getHeroPosition());
		game.moveHero('a');
		assertEquals(new CellPosition(0, 3), game.getHeroPosition());
		assertEquals('S',game.hero.previous);
	}
	@Test
	public void testHeroIsCapturedByOgre()//Hero moves into an adjacent position to the Ogre and the game ends with defeat.
	{
		Map gameMap = new Map(keep);
		Game game = new Game (gameMap);
		game.moveHero('d');
		assertFalse(Logic.checkCollison(game.hero, game.enemy));
		assertTrue(game.isGameOver());
	}
	//DUNGEON TESTS
	@Test
	public void testeMoveHeroIntoToFreeCell()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 2), game.getHeroPosition());
	}
	@Test
	public void testeMoveHeroIntoToWall()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('a');
		assertNotEquals(new CellPosition(0, 1), game.getHeroPosition());
	}
	@Test
	public void testeMoveHeroIntoToDoor()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 2), game.getHeroPosition());
		game.moveHero('a');
		assertNotEquals(new CellPosition(2, 2), game.getHeroPosition());
		
	}
	@Test
	public void testeMoveHeroIntoToExit()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 2), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(1, 3), game.getHeroPosition());
		game.moveHero('a');
		assertEquals(new CellPosition(0, 3), game.getHeroPosition());
		assertEquals('S',game.hero.previous);
	}
//	@Test
//	public void testHeroIsNotCapturedByGuard()
//	{
//		Map gameMap = new Map(map);
//		Game game1 = new Game (gameMap);
//		game1.moveHero('w');
//		assertTrue(Logic.checkCollison(game1.hero, game1.enemy));
//		assertFalse(game1.isGameOver());
//	}
	@Test
	public void testHeroIsCapturedByGuard()
	{
		Map gameMap = new Map(map);
		Game game1 = new Game (gameMap);
		game1.moveHero('d');
		assertFalse(Logic.checkCollison(game1.hero, game1.enemy));
		assertTrue(game1.isGameOver());
	}
	
	@Test
	public void testHeroIsCapturedByGuardv2()
	{
		Map gameMap = new Map(map1);
		Game game1 = new Game (gameMap);
		game1.moveHero('s');
		game1.moveHero('d');
		game1.moveHero('d');
		assertFalse(Logic.checkCollison(game1.hero, game1.enemy));
		assertTrue(game1.isGameOver());
	}
	
	@Test
	public void testHeroIsCapturedByGuardv3()
	{
		Map gameMap = new Map(map1);
		Game game1 = new Game (gameMap);
		game1.moveHero('s');
		game1.moveHero('s');
		game1.moveHero('d');
		game1.moveHero('d');
		game1.moveHero('d');
		game1.moveHero('w');
		game1.moveHero('w');
		assertFalse(Logic.checkCollison(game1.hero, game1.enemy));
		assertTrue(game1.isGameOver());
	}
	
	@Test
	public void testHeroIsCapturedByGuardv4()
	{
		Map gameMap = new Map(map);
		Game game1 = new Game (gameMap);
		game1.moveHero('d');
		game1.moveHero('d');
		assertFalse(Logic.checkCollison(game1.hero, game1.enemy));
		assertTrue(game1.isGameOver());
	}
	@Test
	public void testMoveOgre()
	{
		Map gameMap = new Map(keep);
		Game game = new Game (gameMap);
		Ogre o = new Ogre(1, 3, 'O');
		Weapon t = new Weapon(1,2,'s');
		Key k = new Key(0, 0, 'w');
		
		String r = Logic.randomDirection();
		char[][] nMap = Movement.moveOgre(keep, o, r);
		
		if(Logic.findChar(nMap,'O').equals(1) && Logic.findChar(nMap, 'O').equals(2))
		{
			assertEquals("left", r);
		}
		
		if(Logic.findChar(nMap,'O').equals(2) && Logic.findChar(nMap, 'O').equals(3))
		{
			assertEquals("down", r);
		}
		
		if(Logic.findChar(nMap,'O').equals(0) && Logic.findChar(nMap, 'O').equals(3))
		{
			assertEquals("up", r);
		}
		
		if(Logic.findChar(nMap,'O').equals(1) && Logic.findChar(nMap, 'O').equals(4))
		{
			assertEquals("rigth", r);
		}
		
		if(Logic.findChar(nMap,'O').equals(1) && Logic.findChar(nMap, 'O').equals(3))
		{
			assertEquals("null", r);
		}
	}
}
