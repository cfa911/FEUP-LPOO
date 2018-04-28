package dkeep.gui;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import dkeep.cli.Commons;
import dkeep.cli.Map;
import dkeep.logic.Game;
import sun.awt.RequestFocusController;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class Interfaces {

	private JFrame frame;

	char[][][] temp;

	private boolean canPrint = false;

	private Graphic panel; 
	private JButton btnUp, btnDown, btnLeft, btnRight;

	static Game game;
	int levelIndex = 0;
	String personali;

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

	private void loadnewMap(char[][] map)
	{
		Map level = new Map(map);
		game = new Game(level);
	}

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

		char [][]map2 = {
				{'X','X','X','X','X','X','X','X','X'},
				{'I',' ',' ',' ','O',' ',' ','k','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X','H',' ',' ',' ',' ',' ',' ','X'},
				{'X','X','X','X','X','X','X','X','X'}};

		char[][][] meusMapas = {map1, map2};

		temp = meusMapas;
		loadnewMap(temp[levelIndex]);

		//meuTexto.setText(game.loadMap(map1, meuTexto));

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.requestFocusInWindow();
				canPrint = true;
				temp = meusMapas;
				
				switch(personali)
				{
				case "Rookie":
					game.guard.setPersonality(0);
					break;
				case "Drunken":
					game.guard.setPersonality(1);
					break;
				case "Suspicious":
					game.guard.setPersonality(2);
					break;
				}
				panel.printMap(temp[levelIndex]);
				//meuTexto.setText(game.loadMap(meuTexto));

			}
		});

		btnNewGame.setBounds(602, 862, 141, 29);
		frame.getContentPane().add(btnNewGame);

		btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.requestFocusInWindow();

				if(canPrint)
				{
					panel.directionHandler('w');
					panel.printMap(game.loadMap(panel));
					//meuTexto.setText(game.loadMap(meuTexto));
				}
				checkState();

			}
		});
		btnUp.setBounds(170, 859, 141, 35);
		frame.getContentPane().add(btnUp);
		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel.requestFocusInWindow();

				if(canPrint) 
				{
					panel.directionHandler('a');
					panel.printMap(game.loadMap(panel));
					//meuTexto.setText(game.loadMap(meuTexto));
				}
				checkState();
			}
		});
		btnLeft.setBounds(39, 915, 141, 35);
		frame.getContentPane().add(btnLeft);

		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.requestFocusInWindow();

				if(canPrint) 
				{
					panel.directionHandler('d');
					panel.printMap(game.loadMap(panel));
					//meuTexto.setText(game.loadMap(meuTexto));
				}
				checkState();
			}
		});
		btnRight.setBounds(287, 915, 141, 35);
		frame.getContentPane().add(btnRight);

		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.requestFocusInWindow();

				if(canPrint) 
				{
					panel.directionHandler('s');
					panel.printMap(game.loadMap(panel));
					//meuTexto.setText(game.loadMap(meuTexto));
				}
				checkState();
			}
		});
		btnDown.setBounds(170, 969, 141, 35);
		frame.getContentPane().add(btnDown);


		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.requestFocusInWindow();
				System.exit(0);
			}
		});
		btnExit.setBounds(621, 931, 106, 21);
		frame.getContentPane().add(btnExit);


		panel = new Graphic();
		panel.setBackground(Color.BLACK);
		//		Graphic panel = new Graphic();
		panel.setBounds(0, 0, 700, 700);
		panel.loadImages();
		frame.getContentPane().add(panel);


		panel.setMap(temp[levelIndex]);
		frame.getContentPane().add(panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(721, 60, 152, 29);
		comboBox.addItem("Rookie");
		comboBox.addItem("Drunken");
		comboBox.addItem("Suspicious");
		frame.getContentPane().add(comboBox);
		personali = (String)comboBox.getSelectedItem();

		//JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 1076);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
	}

	public void checkState() 
	{
		if(game.isGameOver())
		{
			JOptionPane.showMessageDialog(null, "GAME OVER");
			btnDown.setEnabled(false);
			btnUp.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(false);
		}
		else if(game.isWon())
		{
			JOptionPane.showMessageDialog(null, "LEVEL 1 COMPLETE!");
			levelIndex++;
			loadnewMap(temp[levelIndex]);
			panel.printMap(temp[levelIndex]);
		}
	}
}
