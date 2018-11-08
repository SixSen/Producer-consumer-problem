public class Proceducer implements Runnable {

	public static Integer count = 0;
	Manager man = null;

	public Proceducer(Manager man) {
		this.man = man;
	}

	public void run() {
		while (true) {
			synchronized (Proceducer.class) {
				count++;
				Product product = new Product(count);
				man.push(product);
			}
		}
	}
}
