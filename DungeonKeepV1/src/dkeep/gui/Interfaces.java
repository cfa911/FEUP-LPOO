package dkeep.gui;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import dkeep.cli.Commons;
import dkeep.cli.Map;
import dkeep.logic.Game;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class Interfaces {

	private JFrame frame;
	
	private Game game;
	
	private boolean canPrint = false;
	
	private Graphic panel = new Graphic();
	
	//private Game game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaces window = new Interfaces();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Interfaces() throws IOException {
		initialize();
		
		char [][]map1 = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','H',' ',' ','I',' ','X',' ','G','X'},
				{'X','X','X',' ','X','X','X',' ',' ','X'},
				{'X',' ','I',' ','I',' ','X',' ',' ','X'},
				{'X','X','X',' ','X','X','X',' ',' ','X'},
				{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
				{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X','X','X',' ','X','X','X','X',' ','X'},
				{'X',' ','I',' ','I',' ','X','k',' ','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};
		
		Map [][] meusMapas = {
				
		};
		
		Map level1 = new Map(map1);
		game = new Game(level1);
		
		//meuTexto.setText(game.loadMap(map1, meuTexto));
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new Game(level1);
				canPrint = true;
				panel.repaint();
				//meuTexto.setText(game.loadMap(meuTexto));
			}
		});
		
		btnNewGame.setBounds(595, 693, 141, 29);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(canPrint)
				{
					game.moveHero('w');
					//meuTexto.setText(game.loadMap(meuTexto));
				}
			}
		});
		btnUp.setBounds(180, 645, 141, 35);
		frame.getContentPane().add(btnUp);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(canPrint) 
				{
					game.moveHero('e');
					//meuTexto.setText(game.loadMap(meuTexto));
				}
			}
		});
		btnLeft.setBounds(49, 701, 141, 35);
		frame.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(canPrint) 
				{
					game.moveHero('d');
					//meuTexto.setText(game.loadMap(meuTexto));
				}
			}
		});
		btnRight.setBounds(297, 701, 141, 35);
		frame.getContentPane().add(btnRight);
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(canPrint) 
				{
					game.moveHero('s');
					//meuTexto.setText(game.loadMap(meuTexto));
				}
			}
		});
		btnDown.setBounds(180, 755, 141, 35);
		frame.getContentPane().add(btnDown);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(614, 762, 106, 21);
		frame.getContentPane().add(btnExit);
		
		
		
		panel.setBackground(Color.RED);
//		Graphic panel = new Graphic();
		panel.setBounds(0, 0, 805, 633);
		panel.loadImages();
		frame.getContentPane().add(panel);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 831, 882);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
}
