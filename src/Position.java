
public class Position{
	private int px, py;
	
	public Position(int px, int py){
		this.px = px;
		this.py = py;
	}
	
	public int getPx(){
		return this.px;
	}
	public int getPy(){
		return this.py;
	}
	
	public Position getSuivante(Direction dir){
		return new Position(this.getPx() + dir.getDirection().getPx(), this.getPy() + dir.getDirection().getPy());
	}
	
		
	public boolean equals(Position p) {
		return this.px == p.px && this.py == p.py;
	}
	
	public String toString() {
		return " x : "+this.px+", y : "+this.py;
	}
	
}
