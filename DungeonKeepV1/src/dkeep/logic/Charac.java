package dkeep.logic;


public abstract class Charac{
	public int X;
	public int Y;
	public char ch;
	public char previous = ' ';
	
	public Charac(int X,int Y,char ch)
	{
		this.X = X;
		this.Y = Y;
		this.ch = ch;
	}
}

