package dkeep.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphic extends JPanel {
	
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

	/**
	 * Create the panel.
	 */
	public Graphic() 
	{
		super();
	}
	
	
	public void loadImages() throws IOException 
	{
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

	public void resizeImage(BufferedImage old)
	{
		Image novo = old;
		Image newImage = novo.getScaledInstance(50, 50, 50);
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(Menu, 100, 100, null);
	}
	
	

}
