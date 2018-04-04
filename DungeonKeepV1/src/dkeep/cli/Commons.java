package dkeep.cli;
import dkeep.logic.*;
import java.util.Scanner;
public class Commons {
	public static void printMap(char [][] map) {
		for(int i = 0; i <= (map.length-1); i++)
		{
			for(int j = 0;j <= (map[0].length-1);j++) {
			System.out.print(map[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public static String printStringMap(char [][] map) {
		String ret = "";
		for(int i = 0; i <= (map.length-1); i++)
		{
			for(int j = 0;j <= (map[0].length-1);j++) {
			ret += map[i][j];
			}
			ret += "\n";
		}
		return ret;
	}
	public static String inputHero() {
		String value;
		Scanner s = new Scanner(System.in);
		char input = s.next().charAt(0);
		if(input == 'w')
			value = "up";
		else if(input == 'a')
			value = "left";
		else if(input == 's')
			value = "down";
		else if(input == 'd')
			value = "right";
		else 
			value = "nothing";
		return value;
			
	}
}
