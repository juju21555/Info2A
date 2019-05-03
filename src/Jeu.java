
public class Jeu{
	
	private int size, nObstacles;
	private boolean enjeu;
	private Obstacle[][] plateau;
	private Particule particule;
	
	public Jeu(int s, int nObs){
		this.size 		= s+2;
		this.nObstacles = nObs;
		this.plateau 	= new Obstacle[size][size];
		this.enjeu 		= true;
		this.particule  = null;
		initPlateau();
	}
	
	public int 		     		getSize()		    {return this.size;		}
	public int 		     		getNObstacles() 	{return this.nObstacles;}
	public boolean       		getEnjeu()			{return this.enjeu;     }
	public Obstacle[][]  		getPlateau()		{return this.plateau;   }
	public Particule 			getParticule() 		{return this.particule; }
	
	public void setSize(int s)  	    	{this.size       = s+2; }
	public void setNObstacles(int n) 		{this.nObstacles = n;   }
	public void setParticule(Particule p)   {this.particule  = p;	}

	public void moveParticule() {
		int x, y;
		while (this.particule.getMove()) {
			this.particule.setPosition( this.particule.getPosition().getSuivante( this.particule.getDirection() ) );
			x = this.particule.getPosition().getPx();
			y = this.particule.getPosition().getPy();
			if (this.plateau[x][y] != null && this.plateau[x][y].isHeavier(this.particule.getPoids()))
				this.plateau[x][y].action(this.particule);
			if (this.particule.isBord(this.getSize()))
				this.particule.setMove(false);
		}
	}
	
	private void initPlateau(){
		
		for (int i=0;i<this.size;i++)
			for (int j=0;j<this.size;j++)
				 this.plateau[i][j] = null;
				
		int e = 0, nx, ny, n, p;
		while (e < this.nObstacles){
			nx = (int) (Math.random()*(this.size-2)+1);
			ny = (int) (Math.random()*(this.size-2)+1);
			
			if (this.plateau[nx][ny] == null){
				n = (int) (Math.random()*3);
				p = (int) (Math.random()*10+1);
				switch(n){
					case 0 : {plateau[nx][ny] = new Prison(p,this); break;}
					case 1 : {plateau[nx][ny] = new Deviateur(p); break;}
					case 2 : {plateau[nx][ny] = new Teleporteur(p,this.size); break;} 
				}
			}
			e++;
		}	
	}
	
	public void refreshEnJeu() {
		this.enjeu = false;
		for (int i=0;i<this.getSize();i++)
			for (int j=0;j<this.getSize();j++)
				if (this.plateau[i][j] != null && !this.plateau[i][j].getShow())
					this.enjeu = true;
	}
	
	public String toString(){
		String s = "\n ";
		for (int i=0;i<this.size;i++) {
			if (i < 10)
				s += "  "+i+" ";
			else
				s += " "+i+" ";
		}
		for (int i=0;i<this.size; i++) {
			s += "\n";
			s += i+"";
			for (int j=0; j<this.size; j++)
				if (plateau[i][j] != null)// && plateau[i][j].getShow())
					s += "  "+plateau[i][j].getName()+" ";
				else if (i > 9 && j == 0)
					s += " # ";
				else if (j == 0 || j == this.size-1 || i == 0 || i == this.size-1)
					if (this.particule != null && new Position(i,j).equals(this.particule.getPosition()))
						s += "  0 ";
					else 
						s += "  # ";
				else
					s += "  * ";
		}
		return s;
	}
}
