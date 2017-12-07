package game;

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
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
