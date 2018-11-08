import java.util.LinkedList;

public class Manager {

	private static int size = 6;

	private LinkedList<Product> list = new LinkedList<Product>();

	public synchronized void push(Product p) {

		while (list.size() == size) {
			try {
				System.out.println("�ֿ�����");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		list.add(p);
		System.out.println("������������:" + p.getId() + "�Ų�Ʒ" + " " + "��ǰ���:" + list.size());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void pop() {

		while (list.size() == 0) {

			try {
				System.out.println("�ֿ�Ϊ��");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.notifyAll();

		System.out.println("������������:" + list.removeFirst().getId() + "�Ų�Ʒ" + " " + "��ǰ���:" + list.size());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}