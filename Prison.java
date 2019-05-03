
public class Prison extends Obstacle{
	
	Particule p_bloque;
	
	public Prison(int p){
		super(p,"P");
		this.p_bloque = null;
	}
	
	public void action(Particule p){
		p.setMove(false);
		p.setPoids(0);
		if (this.p_bloque != null) {
			Jeu.jeu.setParticule(this.p_bloque);
			this.p_bloque.setMove(true);
		}
		this.p_bloque = p;
	}
}
