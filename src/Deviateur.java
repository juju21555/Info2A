
public class Deviateur extends Obstacle{
	
	private int dev;
	
	public Deviateur(int p){
		super(p,"D");
		this.dev = (int) (Math.random()*3+1);
	}
	
	public void action(Particule p){
		p.setDirection(p.getDirection().addRot(dev) );
	}
	
	
}
