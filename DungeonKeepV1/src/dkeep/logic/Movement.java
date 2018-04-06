package dkeep.logic;

import java.util.Random;

public class Movement {
	public static char wall = 'X';
	public static char door = 'I';
	public static char exit = 'S';
	public static char lever = 'k';
	public static char key = 'k';
	public static char blank = ' ';

	public static char[][] enableExit(char[][] map) 
	{
		for(int i = 0; i <= map[0].length - 1 ;i++)
			if(map[0][i]==door)
				map[0][i] = exit;
		for(int i = 0; i <= map.length - 1 ;i++)
			if(map[i][0]==door)
				map[i][0] = exit;
		for(int i = 0; i <= map[map.length -1].length - 1 ;i++)
			if(map[map.length -1][i]==door)
				map[map.length -1][i] = exit;
		for(int i = 0; i <= map.length - 1 ;i++)
			if(map[i][map.length -1]==door)
				map[i][map.length -1] = exit;
		return map;
	}
	
	public static char[][] moveHero(char[][] map,Hero hero,String direction,int mode) {
		int Y = hero.Y;
		int X = hero.X;
		
		switch(direction) 
		{
			case "left":
				if(map[Y][X-1] == wall || (map[Y][X-1] == door && hero.ch == 'H' ) || X-1 < 0) 
				{
				
				}
				else if(map[Y][X-1] == lever && mode == 0)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[Y][--X];
					map[Y][X]= hero.ch;
					hero.previous = 'k';
					enableExit(map);
				}
				else if(map[Y][X-1] == lever && mode == 1)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[Y][--X];
					map[Y][X]= 'K';
					hero.ch= 'K';
					hero.previous = ' ';
				}
				else if(map[Y][X-1] == exit)
				{
					hero.previous = ' ';
					map[Y][X] = hero.previous;
					hero.previous = map[Y][--X];
					map[Y][X]= hero.ch;
				}
				else if(map[Y][X-1] == door && hero.ch == 'K')
				{
					map[Y][X-1] = 'S';
					hero.ch = 'H';
					map[Y][X] = 'H';
				}
				else 
				{				
					map[Y][X] = hero.previous;
					hero.previous = map[Y][--X];
					map[Y][X]= hero.ch;
				}
				
				break;
			case "right":
				if(map[Y][X+1] == wall || (map[Y][X+1] == door && hero.ch == 'H' ) || X+1 < 0) {
					
				}
				else if(map[Y][X+1] == lever && mode == 0)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[Y][++X];
					map[Y][X]= hero.ch;
					hero.previous = 'k';
					enableExit(map);
				}
				else if(map[Y][X+1] == lever && mode == 1)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[Y][++X];
					map[Y][X]= 'K';
					hero.ch= 'K';
					hero.previous = ' ';
				}
				else if(map[Y][X+1] == exit)
				{
					hero.previous = ' ';
					map[Y][X] = hero.previous;
					hero.previous = map[Y][++X];
					map[Y][X]= hero.ch;
				}
				else if(map[Y][X+1] == door && hero.ch == 'K') {
					map[Y][X+1] = 'S';
					hero.ch = 'H';
					map[Y][X] = 'H';
				}
				else {
					map[Y][X] = hero.previous;
					hero.previous = map[Y][++X];
					map[Y][X]= hero.ch;
					
				}
				break;
			case "down":
				if(map[Y+1][X] == wall || (map[Y+1][X] == door && hero.ch == 'H' ) || Y+1 < 0) {
					
				}
				else if(map[Y+1][X] == lever && mode == 0)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[++Y][X];
					map[Y][X]= hero.ch;
					hero.previous = 'k';
					enableExit(map);
				}
				else if(map[Y+1][X] == lever && mode == 1)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[++Y][X];
					map[Y][X]= 'K';
					hero.ch= 'K';
					hero.previous = ' ';
				}
				else if(map[Y+1][X] == exit)
				{
					hero.previous = ' ';
					map[Y][X] = hero.previous;
					hero.previous = map[++Y][X];
					map[Y][X]= hero.ch;
				}
				else if(map[Y+1][X] == door && hero.ch == 'K') {
					map[Y+1][X] = 'S';
					hero.ch = 'H';
					map[Y][X] = 'H';
				}
				else {
					map[Y][X] = hero.previous;
					hero.previous = map[++Y][X];
					map[Y][X]= hero.ch;
				}
				break;
			case "up":
				if(map[Y-1][X] == wall || (map[Y-1][X] == door && hero.ch == 'H' ) || Y-1 < 0) {
					
				}
				else if(map[Y-1][X] == lever && mode == 0)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[--Y][X];
					map[Y][X]= hero.ch;
					hero.previous = 'k';
					enableExit(map);
				}
				else if(map[Y-1][X] == lever && mode == 1)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[--Y][X];
					map[Y][X]= 'K';
					hero.ch= 'K';
					hero.previous = ' ';
				}
				else if(map[Y-1][X] == exit)
				{
					hero.previous = ' ';
					map[Y][X] = hero.previous;
					hero.previous = map[--Y][X];
					map[Y][X]= hero.ch;
				}
				else if(map[Y-1][X] == door && hero.ch == 'K') {
					map[Y-1][X] = 'S';
					hero.ch = 'H';
					map[Y][X] = 'H';
				}
				else {
					map[Y][X] = hero.previous;
					hero.previous = map[--Y][X];
					map[Y][X]= hero.ch;
				}
				break;
		}
		hero.X = X;
		hero.Y = Y;
		return map;
	}
	
	public static char[][] moveGuardSuspicious(char[][] map,Guard guard) {
		Random rand = new Random();
		int choice = rand.nextInt(6 - 1 + 1) + 1; // Random number from [1,6]
		if(choice == 1) {
			if(guard.mode == true)
				guard.iteration--;
			else if(guard.mode == false)
				guard.iteration++;
			guard.mode = !guard.mode;
			
		}
		return moveGuardMovement(map,guard);
	}
	
	public static char[][] moveGuardDrunken(char[][] map,Guard guard) {
		int Y = guard.Y;
		int X = guard.X;
		Random rand = new Random();
		int choice = rand.nextInt(5 - 1 + 1) + 1; // Random number from [1,5]
		if(choice == 1) {
			guard.ch = 'g';
			map[Y][X] = 'g';
			Random rgen = new Random();
			int value = rgen.nextInt(3 - 1 + 1) + 1;
			guard.wait = value;
		}
		else if(guard.wait == 0) {
			guard.ch = 'G';
			map[Y][X] = 'G';
			Random rgen = new Random();
			int b = rgen.nextInt(4 - 1 + 1) + 1;
			if(b == 1) {
				if(guard.mode == true)
					guard.iteration--;
				else if(guard.mode == false)
					guard.iteration++;
				guard.mode = !guard.mode;

			}
		}
		return moveGuardMovement(map,guard);
	}
	public static char[][] moveGuard(char[][] map,Guard guard) {
		switch(guard.personality) {
			case 0:
				return moveGuardMovement(map,guard); //ROOKIE
			case 1:
				return moveGuardDrunken(map,guard); //DRUNKEN
			case 2:
				return moveGuardSuspicious(map,guard); //SUSPICIOUS
			default:
				return map;
				}
	}
	
	public static char[][] moveGuardMovement(char[][] map,Guard guard) {
		int Y = guard.Y;
		int X = guard.X;
		char[] directions = guard.getMovement();
		int i = guard.iteration;
		if(i == directions.length && guard.mode == true ) {
			i = 0;
			guard.iteration = i;
		}
		if(i == directions.length && guard.mode == false) {
			i = directions.length - 1;
			guard.iteration = i;
		}
		if(i == - 1 && guard.mode == false) {
			i = directions.length - 1;
			guard.iteration = i;
		}
		else if(i == - 1 && guard.mode == true) {
			i = 0;
			guard.iteration = i;
		}
			
		switch(directions[i]) 
			{
				case 'a':
					if((guard.wait == 0 && guard.mode == true) && (map[Y][X-1] != door || map[Y][X-1] != wall))//ROOKIE
					{
						map[Y][X] = guard.previous;
						guard.previous = map[Y][--X];
						map[Y][X]= guard.ch;
						guard.iteration++;
					}
					else if((guard.wait == 0 && guard.mode == false) && (map[Y][X+1] != door || map[Y][X+1] != wall)) //BACKWARDS
					{
						map[Y][X] = guard.previous;
						guard.previous = map[Y][++X];
						map[Y][X]= guard.ch;
						guard.iteration--;
					}
					else{
						map[Y][X] = guard.ch;
						guard.wait--;
					}
					break;
				case 'd':
					if((guard.wait == 0 && guard.mode == true)&& (map[Y][X+1] != door || map[Y][X+1] != wall))//ROOKIE
					{
						map[Y][X] = guard.previous;
						guard.previous = map[Y][++X];
						map[Y][X]= guard.ch;
						guard.iteration++;
					}
					else if((guard.wait == 0 && guard.mode == false) && (map[Y][X-1] != door || map[Y][X-1] != wall))//BACKWARDS
					{
						map[Y][X] = guard.previous;
						guard.previous = map[Y][--X];
						map[Y][X]= guard.ch;
						guard.iteration--;
					}
					else{
						map[Y][X] = guard.ch;
						guard.wait--;
					}
					break;
				case 's':
					if((guard.wait == 0 && guard.mode == true)&& (map[Y+1][X] != door || map[Y+1][X] != wall))//ROOKIE
					{
						map[Y][X] = guard.previous;
						guard.previous = map[++Y][X];
						map[Y][X]= guard.ch;
						guard.iteration++;
					}
					else if((guard.wait == 0 && guard.mode == false) && (map[Y-1][X] != door || map[Y-1][X] != wall)) //BACKWARDS
					{
						map[Y][X] = guard.previous;
						guard.previous = map[--Y][X];
						map[Y][X]= guard.ch;
						guard.iteration--;
					}
					else{
						map[Y][X] = guard.ch;
						guard.wait--;
					}
					break;
				case 'w':
					if((guard.wait == 0 && guard.mode == true) && (map[Y-1][X] != door || map[Y-1][X] != wall))//ROOKIE
					{
						map[Y][X] = guard.previous;
						guard.previous = map[--Y][X];
						map[Y][X]= guard.ch;
						guard.iteration++;
					}
					else if((guard.wait == 0 && guard.mode == false) && (map[Y+1][X] != door || map[Y+1][X] != wall)) //BACKWARDS
					{
						map[Y][X] = guard.previous;
						guard.previous = map[++Y][X];
						map[Y][X]= guard.ch;
						guard.iteration--;
					}
					else {
						map[Y][X] = guard.ch;
						guard.wait--;
					}
					break;
			}

		guard.X = X;
		guard.Y = Y;
		return map;
	}
	public static char[][] moveOgre(char[][] map,Ogre ogre,String direction) {
		int Y = ogre.Y;
		int X = ogre.X;
		if(ogre.previous == '*')
			ogre.previous = blank;
		switch(direction) {
			case "left":
				if(map[Y][X-1] == wall || map[Y][X-1] == door || X-1 < 0) {
				}
				else if(map[Y][X-1] == lever || map[Y][X-1] == '$')
				{
					map[Y][X] = ogre.previous;
					ogre.previous = map[Y][--X];
					map[Y][X]= '$';
					ogre.previous = 'k';
					
				}
				else {				
					map[Y][X] = ogre.previous;
					ogre.previous = map[Y][--X];
					map[Y][X]= ogre.ch;
				}
				break;
			case "right":
				if(map[Y][X+1] == wall || map[Y][X+1] == door || X+1 < 0) {
						
				}
				else if(map[Y][X+1] == lever||map[Y][X+1] == '$')
				{
					map[Y][X] = ogre.previous;
					ogre.previous = map[Y][++X];
					map[Y][X]= '$';
					ogre.previous = 'k';
					
				}
				else {
					map[Y][X] = ogre.previous;
					ogre.previous = map[Y][++X];
					map[Y][X]= ogre.ch;
					
				}
				break;
			case "down":
				if(map[Y+1][X] == wall || map[Y+1][X] == door || Y+1 < 0) {
				}
				else if(map[Y+1][X] == lever || map[Y+1][X] == lever)
				{
					map[Y][X] = ogre.previous;
					ogre.previous = map[++Y][X];
					map[Y][X]= '$';
					ogre.previous = 'k';
					
				}
				else {
					map[Y][X] = ogre.previous;
					ogre.previous = map[++Y][X];
					map[Y][X]= ogre.ch;
				}
				break;
			case "up":
				if(map[Y-1][X] == wall || map[Y-1][X] == door || Y-1 < 0) {
					
				}
				else if(map[Y-1][X] == lever || map[Y-1][X] == lever)
				{
					map[Y][X] = ogre.previous;
					ogre.previous = map[--Y][X];
					map[Y][X]= '$';
					ogre.previous = 'k';
					
				}
				else {
					map[Y][X] = ogre.previous;
					ogre.previous = map[--Y][X];
					map[Y][X]= ogre.ch;
				}
				break;
		}
		ogre.X = X;
		ogre.Y = Y;
		return map;
	}
public static char[][] moveClub(char[][] map,Ogre ogre,Weapon club,String direction) {
	club.Xp = club.X;
	club.Yp = club.Y;
	if(map[club.Y][club.X] != ogre.ch)
		map[club.Y][club.X] = club.previous;
	club.X=ogre.X;
	club.Y=ogre.Y;
	int Y = club.Y;
	int X = club.X;
	switch(direction) {
	case "left":
		if(map[Y][X-1] == wall || map[Y][X-1] == door || X-1 < 0) {
			
		}
		else if(map[Y][X-1] == key)
		{
			club.Xp = X;
			club.Yp = Y;
			map[Y][--X] = '$';
			club.previous = 'k';
		}
		else if(map[Y][X-1] == blank){
			club.Xp = X;
			club.Yp = Y;
			map[Y][--X] = club.ch;
			club.previous = blank;
		}
		break;
	case "right":
		if(map[Y][X+1] == wall || map[Y][X+1] == door || X+1 < 0) {
			
		}
		else if(map[Y][X+1] == key)
		{
			club.Xp = X;
			club.Yp = Y;
			map[Y][++X] = '$';
			club.previous = 'k';
		}
		else if(map[Y][X+1] == blank){
			club.Xp = X;
			club.Yp = Y;
			map[Y][++X] = club.ch;
			club.previous = blank;
		}
		break;
	case "down":
		if(map[Y+1][X] == wall || map[Y+1][X] == door || Y+1 < 0) {
			
		}
		else if(map[Y+1][X] == key)
		{
			club.Xp = X;
			club.Yp = Y;
			map[++Y][X] = '$';
			club.previous = 'k';
		}
		else if(map[Y+1][X] == blank){
			club.Xp = X;
			club.Yp = Y;
			map[++Y][X] = club.ch;
			club.previous = blank;
		}
		break;
	case "up":
		if(map[Y-1][X] == wall || map[Y-1][X] == door || Y-1 < 0) {
			
		}
		else if(map[Y-1][X] == key)
		{
			club.Xp = X;
			club.Yp = Y;
			map[--Y][X] = '$';
			club.previous = 'k';
		}
		else if(map[Y-1][X] == blank){
			club.Xp = X;
			club.Yp = Y;
			map[--Y][X] = club.ch;
			club.previous = blank;
		}
		break;
		}
	club.X = X;
	club.Y = Y;
	return map;
	}
}