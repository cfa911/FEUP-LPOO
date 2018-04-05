package dkeep.gui;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import dkeep.logic.*;

public class Images {
	
	private JFrame frame;
	private int width;
	private int height;
	private BufferedImage Menu;
	private BufferedImage wall;
	private BufferedImage ground;
	private BufferedImage door;
	private BufferedImage doorOpen;
	private BufferedImage guard;
	private BufferedImage ogre;
	private BufferedImage weapon;
	private BufferedImage hero;
	private BufferedImage key;
	
	
	
	
	public void loadImages() throws IOException {
		this.Menu = ImageIO.read(new File("images/layout.png"));
		this.wall = ImageIO.read(new File("images/door.png"));
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

	public BufferedImage getWall() {
		return this.wall;
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


}
