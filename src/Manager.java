import java.util.LinkedList;

public class Manager {

	private static int size = 6;

	private LinkedList<Product> list = new LinkedList<Product>();

	public synchronized void push(Product p) {

		while (list.size() == size) {
			try {
				System.out.println("仓库已满");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		list.add(p);
		System.out.println("生产者生产了:" + p.getId() + "号产品" + " " + "当前库存:" + list.size());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void pop() {

		while (list.size() == 0) {

			try {
				System.out.println("仓库为空");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.notifyAll();

		System.out.println("消费者消费了:" + list.removeFirst().getId() + "号产品" + " " + "当前库存:" + list.size());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}