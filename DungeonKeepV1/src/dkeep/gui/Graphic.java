package dkeep.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dkeep.cli.Commons;
import dkeep.cli.Map;

public class Graphic extends JPanel implements KeyListener{

	//public JFrame frame;
	private int width;
	private int height;
	private char[][] map;
	
	private BufferedImage Menu;
	private BufferedImage ground;
	private BufferedImage chao;
	private BufferedImage door;
	private BufferedImage doorOpen;
	private BufferedImage guard;
	private BufferedImage ogre;
	private BufferedImage weapon;
	private BufferedImage hero;
	private BufferedImage key;
	
	Image Menudois;
	Image doors;
	Image doorsOpens;
	Image grounds;
	Image chaos;
	Image heros;
	Image keys;
	Image ogres;
	Image weapons;
	Image guards;
	

	/**
	 * Create the panel.
	 */
	public Graphic() 
	{
	
		super();
		addKeyListener(this);
		setFocusable(true);
	}
	
	public void setMap(char[][] map)
	{
		this.map = map;
	}


	public void loadImages() throws IOException 
	{
		this.Menu = ImageIO.read(new File("images/layout.png"));
		this.chao = ImageIO.read(new File("images/chao.png"));
		this.ground = ImageIO.read(new File("images/ground.png"));
		this.door = ImageIO.read(new File("images/door.png"));
		this.doorOpen = ImageIO.read(new File("images/doorOpen.png"));
		this.guard = ImageIO.read(new File("images/guard.png"));
		this.ogre = ImageIO.read(new File("images/ogre.png"));
		this.weapon = ImageIO.read(new File("Images/weapon.png"));
		this.hero = ImageIO.read(new File("images/marioFinal.png"));
		this.key = ImageIO.read(new File("images/key.png"));
	}

	public BufferedImage getMenu() {
		return this.Menu;
	}

	public BufferedImage getGround() {
		return this.ground;
	}

	public BufferedImage getDoor() {
		return this.door;
	}

	public BufferedImage getDoorOpen() {
		return this.doorOpen;
	}

	public BufferedImage getGuard() {
		return this.guard;
	}

	public BufferedImage getOgre() {
		return this.ogre;
	}

	public BufferedImage getWeapon() {
		return this.weapon;
	}

	public BufferedImage getHero() {
		return this.hero;
	}

	public BufferedImage getKey() {
		return this.key;
	}

	public Image resizeImage(BufferedImage old)
	{
		Image novo = old;
		Image newImage = novo.getScaledInstance(100, 100, 0);
		return newImage;
	}

	public void printMap(char[][] map) 
	{
		this.map = map;
		
		Menudois = Menu.getScaledInstance(805, 633, 0);
		doors = door.getScaledInstance(70, 70, 0);
		doorsOpens = doorOpen.getScaledInstance(70, 70, 0);
		grounds = ground.getScaledInstance(70, 70, 0);
		chaos = chao.getScaledInstance(70, 70, 0);
		heros = hero.getScaledInstance(70, 70, 0);
		keys = key.getScaledInstance(70, 70, 0);
		ogres = ogre.getScaledInstance(70, 70, 0);
		weapons = weapon.getScaledInstance(70, 70, 0);
		guards = guard.getScaledInstance(70, 70, 0);
		
		repaint();
		
//		Graphics g = null;
//		super.paintComponent(g);
//
//		Image Menudois = Menu.getScaledInstance(805, 633, 0);
//		
//		for(int i = 0; i < map.length(); i++)
//		{	
//			switch(map.charAt(i))
//			{
//			case 'X':
//				g.drawImage(Menudois, 0, 0, null);
//				break;
//			case 'H':
//				g.drawImage(Menudois, 0, 0, null);
//				break;
//			case 'O':
//				g.drawImage(Menudois, 0, 0, null);
//				break;
//			case '*':
//				g.drawImage(Menudois, 0, 0, null);
//				break;
//			case 'K':
//				g.drawImage(Menudois, 0, 0, null);
//				break;
//			case 'S':
//				g.drawImage(Menudois, 0, 0, null);
//				break;
//			case 'I':
//				g.drawImage(Menudois, 0, 0, null);
//				break;
//			default:
//				g.drawImage(Menudois, 0, 0, null);
//				break;
//			}
//		}
//
//		repaint();
	}


	@Override
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		int x = 0;
		int y = 0;

		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
//				y = (i / 10) * 50;
//				x = i*50 - (10 * y);
				x = j*70;
				y = i*70;
				switch(map[i][j])
				{
				case '\0':
					break;
				case 'X':
					g.drawImage(grounds, x, y, null);
					break;
				case 'H':
					g.drawImage(heros, x, y, null);
					break;
				case 'G':
					g.drawImage(guards, x, y, null);
					break;
				case 'O':
					g.drawImage(ogres, x, y, null);
					break;
				case '*':
					g.drawImage(weapons, x, y, null);
					break;
				case 'k':
					g.drawImage(keys, x, y, null);
					break;
				case 'S':
					g.drawImage(doorsOpens, x, y, null);
					break;
				case 'I':
					g.drawImage(doors, x, y, null); 
					break;
				default:
					g.drawImage(chaos, x, y, null); //
					break;
				}
			}
		}
		
//		for(int i = 0; i < map.length(); i++)
//		{	
//			y = (i / 10) * 50;
//			x = i*50 - (10 * y);
//			
//			switch(map.charAt(i))
//			{
//			case 'X':
//				g.drawImage(grounds, x, y, null);
//				break;
//			case 'H':
//				g.drawImage(heros, x, y, null);
//				break;
//			case 'G':
//				g.drawImage(guards, x, y, null);
//				break;
//			case 'O':
//				g.drawImage(ogres, x, y, null);
//				break;
//			case '*':
//				g.drawImage(weapons, x, y, null);
//				break;
//			case 'K':
//				g.drawImage(keys, x, y, null);
//				break;
//			case 'S':
//				g.drawImage(doorsOpens, x, y, null);
//				break;
//			case 'I':
//				g.drawImage(doors, x, y, null); 
//				break;
//			default:
//				g.drawImage(grounds, x, y, null); //
//				break;
//			}
//		}
//		//g.drawImage(Menudois, 0, 0, null);
	}
	
	public void directionHandler(char dir) {
		switch(dir) {
		case 'a':
			Interfaces.game.moveHero('a');
			break;
		case 'w':
			Interfaces.game.moveHero('w');
			break;
		case 's':
			Interfaces.game.moveHero('s');
			break;
		case 'd':
			Interfaces.game.moveHero('d');
			break;
			
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
		case 'a':
			directionHandler('a');
			break;
		case 'w':
			directionHandler('w');
			break;
		case 's':
			directionHandler('s');
			break;
		case 'd':
			directionHandler('d');
			break;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
