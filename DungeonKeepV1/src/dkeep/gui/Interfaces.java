package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

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
		
		this.meuTexto.setText("OLA OLA MEU NOME É ANDRÉ");
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		meuTexto = new JTextArea();
		meuTexto.setEditable(false);
		meuTexto.setBounds(21, 21, 385, 227);
		frame.getContentPane().add(meuTexto);
	}
}
