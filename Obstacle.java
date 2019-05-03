
public abstract class Obstacle{
	
	private int poids;
	private String name;
	private boolean show;
	
	public Obstacle(int p, String s){
		this.poids = p;
		this.name = s;
		this.show = false;
	}

	public boolean isHeavier(int p){
		return (p >= this.poids);
	}
	
	public String 	getName()		{return this.name; 	}
	public boolean 	getShow() 		{return this.show;	}
	public int 		getPoids()		{return this.poids;	}
	
	public void setShow(boolean b) {this.show = b;}
	
	abstract void action(Particule p);
	
}

