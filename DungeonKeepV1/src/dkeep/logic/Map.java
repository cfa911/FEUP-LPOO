package dkeep.logic;

public class Map {
	private char[][] map;
	public Map(char[][] map) {
	this.setMap(map);
	}
	public char[][] getMap() {
		return map;
	}
	public void setMap(char[][] map) {
		this.map = map;
	}
}
