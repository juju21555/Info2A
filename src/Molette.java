import java.awt.Color;

public class Molette {
	
	private Position pos;
	private Color col;
	private Jeu j;
	
	public Molette(Jeu j) {
		this.pos = new Position(0,0);
		this.col = Color.RED;
		this.jeu = j;
	}
	
	public void nextPosition() {
		if (this.pos.getPx() == 0 && this.pos.getPy() < this.j.size)
	}

}
