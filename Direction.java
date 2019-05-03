
public class Direction{
	private int rot;
	
	public Direction(int r){
		this.setDirection(r);
	}
	
	
	public Position getDirection() {
		switch(this.rot){
			case 0 : {return new Position( 0,-1);}
			case 1 : {return new Position( 1, 0);}
			case 2 : {return new Position( 0, 1);}
			case 3 : {return new Position(-1, 0);}
		}
		return null;
	}
	
	public void setDirection(int rot){
		this.rot = rot%4;
	}
	
	public Direction addRot(int r){
		return new Direction( (this.rot + r)%4 );
	}
}
	
