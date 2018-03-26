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
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}
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
		game.moveHero('a');
		assertEquals(new CellPosition(1, 3), game.getHeroPosition());
		assertEquals(game.mapa.map[3][0],'S');
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
	@Test
	public void testHeroIsCapturedByGuard()
	{
		Map gameMap = new Map(map);
		Game game1 = new Game (gameMap);
		game1.moveHero('d');
		assertFalse(Logic.checkCollison(game1.hero, game1.enemy));
		assertTrue(game1.isGameOver());
	}
}
