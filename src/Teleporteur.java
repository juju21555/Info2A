
public class Teleporteur extends Obstacle{
	
	private Position pos;
	
	public Teleporteur(int p,int s){
		super(p,"T");
		int tx = (int) (Math.random()*(s-1)+1);
		int ty = (int) (Math.random()*(s-1)+1);
		this.pos = new Position(tx, ty);
	}
	
	public void action(Particule p){
		p.setPosition(this.pos);
	}
	
	
}
