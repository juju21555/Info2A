
public class Particule{

	private int poids;
	private boolean move;
	private Direction dir;
	private Position pos;
	
	public Particule(int p, Position pos, Joueur joueur){
		this.poids  = p;
		this.move   = true;
		this.pos    = pos;
		this.dir    = this.getDir();
	}
	
	public void setMove(boolean b){
		this.move = b;
	}
	public void setDirection(Direction d){
		this.dir = d;
	}
	public void setPosition(Position p){
		this.pos = p;
	}
	public void setPoids(int p) {
		this.poids = p;
	}
	
	public boolean getMove() {
		return this.move;
	}
	public Direction getDirection(){
		return this.dir;
	}
	public Position getPosition() {
		return this.pos;
	}
	public int getPoids() {
		return this.poids;
	}
	public String toString() {
		return "Poids :"+this.poids+"\nMove :"+this.move;
	}
	
	public Direction getDir(){
		if (this.pos.getPx() == 0)
			return new Direction(1);
		if (this.pos.getPx() == Jeu.jeu.getSize()-1)
			return new Direction(3);
		if (this.pos.getPy() == 0)
			return new Direction(2);
		if (this.pos.getPy() == Jeu.jeu.getSize()-1)
			return new Direction(0);
		return null;
	}
			
	public boolean isBord(){
		return this.pos.isBord();
	}
	
	
}
