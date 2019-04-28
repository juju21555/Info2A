
public class Prison extends Obstacle{
	
	Particule p_bloque;
	Jeu j;
	
	public Prison(int p, Jeu j){
		super(p,"P");
		this.j = j;
		this.p_bloque = null;
	}
	
	public void action(Particule p){
		p.setMove(false);
		p.setPoids(0);
		if (this.p_bloque != null) {
			j.setParticule(this.p_bloque);
			this.p_bloque.setMove(true);
		}
		this.p_bloque = p;
	}
}
