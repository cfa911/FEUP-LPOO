package test;

import static org.junit.Assert.*;

import dkeep.cli.Commons;
import dkeep.cli.Map;
import dkeep.logic.*;

import org.junit.Test;

public class test {
	
	char [][] map = {
			{},
			{}
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
	public void testHeroIsCapturedByGuard()
	{
		Map gameMap = new Map(map);
		Game game = new Game (gameMap);
		assertFalse(is.GameOver());
		game.moveHero('d');
		assertTrue(game.isGameOver());
		assertEquals(Game.DEFEAT, game.getEndStatus());
	}
}
