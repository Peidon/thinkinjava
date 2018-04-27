package concurrence;

public class Pair {
	private int x,y;
	public Pair(){
		this(0,0);
	}
	public Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
	public void incrementX(){
		x++;
	}
	public void incrementY(){
		y++;
	}
	public String toString(){
		return "x: " + x + ", y: " + y;
	}
	public class PairValueNotEqual extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public PairValueNotEqual(){
			super("Pair values not equal: " + Pair.this);
		}
	}
	public void checkState(){
		if(x != y)
			throw new PairValueNotEqual();
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
