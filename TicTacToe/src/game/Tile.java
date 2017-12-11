package game;

public class Tile {
	private final int ROW;
	private final int COL;
	private Player player;
	
	public static final int WIDTH = TicTacToeGrid.SCREEN_WIDTH / 3;
	public static final int HEIGHT = TicTacToeGrid.SCREEN_HEIGHT / 3;
	
	public Tile(int row, int col) {
		this.ROW = row;
		this.COL = col;
		this.player = null;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public int getRow() {
		return ROW;
	}
	
	public int getCol() {
		return COL;
	}
	
	public int[] getWidthRange() {
		return new int[] {ROW * WIDTH, (ROW + 1) * WIDTH};
	}
	
	public int[] getHeightRange() {
		return new int[] {COL * HEIGHT, (COL + 1) * HEIGHT};
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean isMarked() {
		return (!(player == null));
	}
	
	public void mark(Player p) {
		player = p;
	}
	
	@Override
	public String toString() {
		return "Tile=[Row: " + ROW + " Col: " + COL + "]";
	}
}
