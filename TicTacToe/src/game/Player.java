package game;

public class Player {
	public enum Shape {
		CIRCLE, X;
	}
	
	private final Shape shape;
	
	public Player(Shape shape) {
		this.shape = shape;
	}
	
	public Shape getShape() {
		return shape;
	}
}
