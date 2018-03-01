package dkeep.logic;

public class Logic {
	public static int[] findChar(char[][] map,char character){
		int col = map[0].length;
		int lin = map.length;
        int k = 0;
        int l = 0;
		for(int i = 0; i <= (col-1); i++)
		{
			for(int j = 0;j <= (lin-1);j++) {
			if(map[i][j] == character)
			{
			    k=i;
			    l=j;
			    break;
			}}
			
		}
		int value[] = {k,l};
		return value;
	}
	public static boolean checkCollison(Hero h,Charac enemy) {
		if(h.X == enemy.X-1 && h.Y == enemy.Y)
			return false;
		else if(h.X == enemy.X+1 && h.Y == enemy.Y)
			return false;
		else if(h.X == enemy.X && h.Y == enemy.Y-1)
			return false;
		else if(h.X == enemy.X && h.Y == enemy.Y+1)
			return false;
		else
			return true;
	}

}
