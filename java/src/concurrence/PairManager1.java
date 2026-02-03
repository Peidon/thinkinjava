package concurrence;

public class PairManager1 extends PairManager {

	@Override
	public void increment() {
		Pair temp = null;
		synchronized(this){
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}
}
