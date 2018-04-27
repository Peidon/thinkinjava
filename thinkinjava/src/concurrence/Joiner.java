package concurrence;

public class Joiner extends Thread {
	private Sleeper sleeper;
	Joiner(String name, Sleeper s){
		super(name);
		sleeper = s;
		start();
	}
	public void run(){
		try{
			sleeper.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
		System.out.println(getName()+" join completed");
	}
}
