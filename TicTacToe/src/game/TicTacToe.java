package game;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TicTacToe {
	private JFrame frame;
	private TicTacToeGrid grid;
	
	public static void main(String[] args) {
		new TicTacToe();
	}
	
	public TicTacToe() {
		frame = new JFrame("TicTacToe");
		grid = new TicTacToeGrid();
		
		frame.add(grid);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}