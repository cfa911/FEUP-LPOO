package dkeep.logic;

public class Movement {
	public static char wall = 'X';
	public static char door = 'I';
	public static char exit = 'S';
	public static char lever = 'k';
	
	public static boolean moveLeft = true;
	public static boolean moveRight = false;
	public static boolean moveUp = false;
	public static boolean moveDown = false;
	
	public static char[][] doorToExit(char[][] map){
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
		switch(direction) {
			case "left":
				if(map[Y][X-1] == wall  || X-1 < 0) {
				
				}
				else if(map[Y][X-1] == lever && mode == 0)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[Y][--X];
					map[Y][X]= hero.ch;
					hero.previous = 'k';
					doorToExit(map);
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
				else if(map[Y][X-1] == door && hero.ch == 'K') {
					map[Y][X-1] = 'S';
				}
				else {				
					map[Y][X] = hero.previous;
					hero.previous = map[Y][--X];
					map[Y][X]= hero.ch;
				}
				
				break;
			case "right":
				if(map[Y][X+1] == wall || map[Y][X+1] == door || X+1 < 0) {
					
				}
				else if(map[Y][X+1] == lever && mode == 0)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[Y][++X];
					map[Y][X]= hero.ch;
					hero.previous = 'k';
					doorToExit(map);
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
				}
				else {
					map[Y][X] = hero.previous;
					hero.previous = map[Y][++X];
					map[Y][X]= hero.ch;
					
				}
				break;
			case "down":
				if(map[Y+1][X] == wall || map[Y+1][X] == door || Y+1 < 0) {
					
				}
				else if(map[Y+1][X] == lever && mode == 0)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[++Y][X];
					map[Y][X]= hero.ch;
					hero.previous = 'k';
					doorToExit(map);
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
				}
				else {
					map[Y][X] = hero.previous;
					hero.previous = map[++Y][X];
					map[Y][X]= hero.ch;
				}
				break;
			case "up":
				if(map[Y-1][X] == wall || map[Y-1][X] == door || Y-1 < 0) {
					
				}
				else if(map[Y-1][X] == lever && mode == 0)
				{
					map[Y][X] = hero.previous;
					hero.previous = map[--Y][X];
					map[Y][X]= hero.ch;
					hero.previous = 'k';
					doorToExit(map);
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
	
	public static char[][] moveGuard(char[][] map,Guard guard) {
		int Y = guard.Y;
		int X = guard.X;
		if(moveLeft == true && moveRight == false)
		{
		    map[Y][X] = guard.previous;
			guard.previous = map[Y][--X];
			map[Y][X]='G';
		    if(map[Y][X-1] == 'X' || map[Y][X-1] == 'I' || map[Y][X-1] == 'S'){
		        moveLeft = false;
		        moveDown = true;
		    }
		}
		else if(moveRight == true && moveLeft == false)
		{
		    map[Y][X] = guard.previous;
			guard.previous = map[Y][++X];
			map[Y][X]='G';
		    if(map[Y][X+1] == 'X' || map[Y][X+1] == 'I' || map[Y][X+1] == 'S'){
		        moveRight = false;
		        moveUp = true;
		    }
		}
		else if(moveUp == true && moveDown == false)
		{
		    map[Y][X] = guard.previous;
			guard.previous = map[--Y][X];
			map[Y][X]='G';
		    if(map[Y-1][X] == 'X' || map[Y-1][X] == 'I' || map[Y-1][X] == 'S'){
		        moveLeft = true;
		        moveUp = false;
		    }
		}
		else if(moveDown == true && moveUp == false)
		{
		    map[Y][X] = guard.previous;
			guard.previous = map[++Y][X];
			map[Y][X]='G';
		    if(map[Y][X-1] != 'X' && map[Y][X-1] != 'I' && map[Y][X-1] != 'S'){
		        moveLeft = true;
		        moveDown = false;
		    }
		    else if(map[Y+1][X] == 'X' || map[Y][X+1] == 'I' || map[Y][X+1] == 'S') {
		        moveRight = true;
		        moveDown = false;
		    }
		}
		guard.X = X;
		guard.Y = Y;
		return map;
	}
	public static char[][] moveOgre(char[][] map,Ogre ogre,String direction) {
		int Y = ogre.Y;
		int X = ogre.X;
		switch(direction) {
			case "left":
				if(map[Y][X-1] == wall || map[Y][X-1] == door || X-1 < 0) {
				
				}
				else if(map[Y][X-1] == lever)
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
				else if(map[Y][X+1] == lever)
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
				else if(map[Y+1][X] == lever)
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
				else if(map[Y-1][X] == lever)
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
	public static char[][] moveClub(char[][] map,Ogre ogre,String direction) {
		int Y = ogre.Y;
		int X = ogre.X;
		switch(direction) {
			case "left":
				if(map[Y][X-1] == wall || map[Y][X-1] == door || X-1 < 0) {
				
				}
				else if(map[Y][X-1] == lever)
				{
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
				else if(map[Y][X+1] == lever)
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
				else if(map[Y+1][X] == lever)
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
				else if(map[Y-1][X] == lever)
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
}
