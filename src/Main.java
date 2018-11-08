public class Main {

	public static void main(String[] args) {
		Manager man = new Manager();
		Proceducer p1 = new Proceducer(man);
		Proceducer p2 = new Proceducer(man);
		Proceducer p3 = new Proceducer(man);
		Consumer c1 = new Consumer(man);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(c1);
		t1.setPriority(10);
		t2.setPriority(10);
		t3.setPriority(10);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
