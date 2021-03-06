
public class Position{
	private int px, py;
	
	public Position(int px, int py){
		this.px = px;
		this.py = py;
	}
	
	public void setPx(int px){
		this.px = px;
	}
	public void setPy(int py){
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
	
	public boolean isBord() {
		return (this.getPx() == 0 ^ this.getPy() == 0 ^ this.getPx() ==  Jeu.jeu.getSize()-1 ^ this.getPy() == Jeu.jeu.getSize()-1);
	}
	public boolean isDedans() {
		return (this.getPx() > 0 && this.getPy() > 0 && this.getPx() <  Jeu.jeu.getSize()-1 &&  this.getPy() < Jeu.jeu.getSize()-1);
	}
	public boolean equals(Position p) {
		return this.px == p.px && this.py == p.py;
	}
	
	public String toString() {
		return " x : "+this.px+", y : "+this.py;
	}
	
}
