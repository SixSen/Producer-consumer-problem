public class Consumer implements Runnable {

	Manager man = null;

	public Consumer(Manager man) {
		this.man = man;
	}

	public void run() {
		while (true) {
			man.pop();
		}
	}
}
