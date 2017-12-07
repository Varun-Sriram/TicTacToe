package game;

public class Tile {
	private final int ROW;
	private final int COL;
	private boolean isMarked;
	private boolean isCircleMark;
	
	public static final int WIDTH = TicTacToeGrid.SCREEN_WIDTH / 3;
	public static final int HEIGHT = TicTacToeGrid.SCREEN_HEIGHT / 3;
	
	public Tile(int row, int col) {
		this.ROW = row;
		this.COL = col;
		this.isMarked = false;
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
	
	public boolean isMarked() {
		return isMarked;
	}
	
	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}
	
	public boolean isCircleMark() {
		return isCircleMark;
	}
	
	public void setCircleMark(boolean isCircleMark) {
		this.isCircleMark = isCircleMark;
	}
	
	@Override
	public String toString() {
		return "Tile=[Row: " + ROW + " Col: " + COL + "]";
	}
}
