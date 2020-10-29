//	Queue �ڷᱸ�� Ŭ������ ����ϴ�.
class Queue<E> {
	int front;		//	ť���� �����͸� �аų� �����ϴ� ��ġ(�ε���)�� ����
	int rear;		//	ť���� �����͸� �߰��� ��ġ�� ����
	E[] data;		//	ť�� �����͸� ������ ������ �迭
	int size;		//	ť�� ������ �� �ִ� �ִ� ������ ����
	//	�������Դϴ�.
	//	�����ڰ� �ϴ� ������ ������ �ʱ�ȭ�� �迭���� �Ҵ��� �ֽ��ϴ�.
	Queue() {
		//	1. front�� rear���� 0���� �ʰ�ȭ�մϴ�.
		front = rear = 0;
		size = 1000;
		//	2. data �迭 ������ size ���� �����͸� �Ҵ��մϴ�.
		data = (E[]) new Object[size];
	}
	//	ť�� �����͸� �߰��ϴ� �Լ��Դϴ�.
	//	v��� ���ڰ��� �޾Ƽ� ť �ڷᱸ���� v�� �߰��մϴ�.
	public void add(E v) {
		//	1. rear���� �ش��ϴ� �迭 ������  v���� �����մϴ�.
		data[rear] = v;
		//	2. rear���� 1 �����մϴ�.
		//		rear�� �迭�� ���� ��� �� ��(�ε��� 0)���� �����־���մϴ�.
		//		�̰��� �����ϰ� �ذ��ϱ� ���ؼ� ������ ������ %�� ����մϴ�.
		rear = (rear+1)%size;
	}
	//	ť���� �����͸� �����ϴ� �Լ��Դϴ�.
	//	ť �ڷᱸ������ front�� ����Ű�� ������ �����͸� �����մϴ�.
	public void remove() {
		//	1. front���� �ش��ϴ� �迭 ������ null ���� �����մϴ�.
		data[front] = null;
		//	2. front ���� 1 �����մϴ�.
		//		add() �Լ��� ���� ���� �ε��� ��ȯ�� �ϵ��� �մϴ�.
		front = (front+1)%size;
	}
	//	ť���� front�� ����Ű�� ������ �����͸� ��ȯ�մϴ�.
	public E peek() {
		//	1. front���� ����Ű�� �迭���� ��ȯ�մϴ�.
		return data[front];
	}
	//	ť�� ��������� true�� �׷��� ������ false�� ��ȯ�մϴ�.
	public boolean empty() {
		//	1. front���� rear���� ������ �˻��մϴ�.
		return front == rear;
	}
	//	ť�� �������� ������ ��ȯ�մϴ�.
	public int size() {
		//	1. rear���� front���� �� ���� ��ȯ�մϴ�.
		//if(rear < front) return rear+size-front;
		//return rear-front;
		//	2. Mr. Oh's Method.
		//return rear+size*(int)(rear<front)-front;
		//	3. % ������ �����ڸ� ����ϴ� ���
		return (rear-front+size)%size;  //<><>
	}
}

public class Main {
	public static void main(String[] args) {
		//	ť ������Ʈ ����
		Queue<String> q = new Queue();
		
		q.add("���");
		q.add("������");
		q.add("����");
		System.out.println("ť�� PEEK : "+q.peek());
		System.out.println("ť�� EMPTY? "+q.empty());
		System.out.println("ť�� SIZE : "+q.size());
		q.remove();
		System.out.println("ť�� PEEK : "+q.peek());
		System.out.println("ť�� EMPTY? "+q.empty());
		System.out.println("ť�� SIZE : "+q.size());
		q.add("�ڸ�");
		System.out.println("ť�� PEEK : "+q.peek());
		System.out.println("ť�� EMPTY? "+q.empty());
		System.out.println("ť�� SIZE : "+q.size());
		q.remove();
		q.remove();
		q.remove();
		System.out.println("ť�� PEEK : "+q.peek());
		System.out.println("ť�� EMPTY? "+q.empty());
		System.out.println("ť�� SIZE : "+q.size());
	}
}
