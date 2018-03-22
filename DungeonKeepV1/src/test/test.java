package test;

import static org.junit.Assert.*;

import dkeep.cli.Commons;
import dkeep.cli.*;
import dkeep.logic.CellPosition;
import dkeep.cli.Map;
import dkeep.logic.Game;
import dkeep.logic.*;

import org.junit.Test;

public class test {
	
	char [][] map = {
			{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ',' ',' ','X'},
			{'S','k',' ',' ','X'},
			{'X','X','X','X','X'}
			}; 
	
	@Test
	public void testeMoveHeroIntoToFreeCell()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(2, 1), game.getHeroPosition());
	}
	@Test
	public void testeMoveHeroIntoToWall()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('a');
		assertNotEquals(new CellPosition(1, 0), game.getHeroPosition());
	}
	@Test
	public void testeMoveHeroIntoToDoor()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap);
		assertEquals(new CellPosition(1, 1), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(2, 1), game.getHeroPosition());
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
		assertEquals(new CellPosition(2, 1), game.getHeroPosition());
		game.moveHero('s');
		assertEquals(new CellPosition(3, 1), game.getHeroPosition());
		game.moveHero('a');
		assertEquals(new CellPosition(3, 0), game.getHeroPosition());
	}
	@Test
	public void testHeroIsCapturedByGuard()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap);
		//assertFalse(game.isGameOver());
		game.moveHero('d');
		assertFalse(Logic.checkCollison(game.hero, game.enemy));
		//assertTrue(game.isGameOver());
	}
	
}
