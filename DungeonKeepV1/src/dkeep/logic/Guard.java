package dkeep.logic;



public class Guard extends Charac{
	public int iteration;
	public int personality;
	private char[] movement;
	public Guard(int X,int Y,char ch) {
		super(X,Y,'G');
		movement =  new char[] {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w','w'};
		personality = 0;
		iteration = 0;
	}
	public char[] getMovement() {
		return movement;
	}
	public void setMovement(char[] movement) {
		this.movement = movement;
	}
	public void setPersonality(int personality) {
		this.personality = personality;
	}
}
