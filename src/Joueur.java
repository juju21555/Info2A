
public class Joueur{
	
	private int 				 credit;
	private String 				 pseudo;
	
	public Joueur(int c, String p){
		this.credit = c;
		this.pseudo = p;
	}
	
	public Particule lancerParticule(int pd, Position pos, Jeu p){
		Particule part = null;
		if (pd < this.credit){
			this.credit -= pd;
			part = new Particule(pd,pos,p.getSize(),this);
		}
		return part;
	}
	
	public void addCredit(int i) {
		this.credit += i;
	}
	
	public String getPseudo() {
		return this.pseudo;
	}
	
	public int getCredit() {
		return this.credit;
	}
	
}
