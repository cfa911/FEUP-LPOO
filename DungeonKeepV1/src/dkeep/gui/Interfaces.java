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
import java.awt.event.ActionEvent;

public class Interfaces {

	private JFrame frame;
	
	private JTextArea meuTexto;

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
	 */
	public Interfaces() {
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
		
		
		Map level1 = new Map(map1);
		Game game = new Game(level1);
		
		
		
		meuTexto.setText(game.printStringMaper());
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.moveHero('w');
				meuTexto.setText(game.loadMap(map1, meuTexto));
			}
		});
		btnUp.setBounds(206, 641, 141, 35);
		frame.getContentPane().add(btnUp);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.moveHero('e');
				meuTexto.setText(game.loadMap(map1, meuTexto));
			}
		});
		btnLeft.setBounds(49, 701, 141, 35);
		frame.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.moveHero('d');
				meuTexto.setText(game.loadMap(map1, meuTexto));
			}
		});
		btnRight.setBounds(297, 701, 141, 35);
		frame.getContentPane().add(btnRight);
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.moveHero('s');
				meuTexto.setText(game.loadMap(map1, meuTexto));
			}
		});
		btnDown.setBounds(180, 755, 141, 35);
		frame.getContentPane().add(btnDown);
		//this.meuTexto.setText(Commons.printStringMap(Game.mapa));
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 831, 882);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		meuTexto = new JTextArea();
		meuTexto.setFont(new Font("Monospaced", Font.PLAIN, 32));
		meuTexto.setEditable(false);
		meuTexto.setBounds(21, 21, 763, 585);
		frame.getContentPane().add(meuTexto);
	}
}
