
public class Particule{

	private int poids;
	private boolean move;
	private Direction dir;
	private Position pos;
	
	public Particule(int p, Position pos, int s, Joueur joueur){
		this.poids  = p;
		this.move   = true;
		this.pos    = pos;
		this.dir    = this.getDir(s);
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
	
	public Direction getDir(int s){
		if (this.pos.getPx() == 0)
			return new Direction(1);
		if (this.pos.getPx() == s-1)
			return new Direction(3);
		if (this.pos.getPy() == 0)
			return new Direction(2);
		if (this.pos.getPy() == s-1)
			return new Direction(0);
		return null;
	}
			
	public boolean isBord(int s){
		return (this.pos.getPx() == 0 ^ this.pos.getPy() == 0 ^ this.pos.getPx() ==  s-1 ^ this.pos.getPy() == s-1);
	}
	
	
}
