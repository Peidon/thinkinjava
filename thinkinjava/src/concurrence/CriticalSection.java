package concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
	static void testApproaches(PairManager pman0, PairManager pman1){
		ExecutorService exc = Executors.newCachedThreadPool();
		PairManipulator
			p0 = new PairManipulator(pman0),
			p1 = new PairManipulator(pman1);
		PairChecker 
			pchecker0 = new PairChecker(pman0),
			pchecker1 = new PairChecker(pman1);
		exc.execute(p0);
		exc.execute(p1);
		exc.execute(pchecker1);
		exc.execute(pchecker0);
		try{
			TimeUnit.MILLISECONDS.sleep(500);
		}catch(InterruptedException e){
			System.out.println("Sleep interrupted...");
		}
		System.out.println("Function: "+p0+"\nSegment: "+p1);
		System.exit(0);
	}
	public static void main(String[] args) {
		PairManager 
		pman0 = new PairManager0(),
		pman1 = new PairManager1();
		testApproaches(pman0,pman1);
	}
}
