package concurrence;

public class PairManager0 extends PairManager{

	@Override
	public synchronized void increment() {
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
}
