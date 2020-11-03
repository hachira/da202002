//	Node Ŭ����
//	value ���� ������, prev, next ���۷��� ������ ������, ���� ���� ����Ʈ�� �����ϴ� �ڷᱸ��
class Node<E> {
	public E value;			//	������ ���� �����ϴ� ����
	public Node<E> prev;	//	���� ��� ���� �����ϴ� ����
	public Node<E> next;	//	���� ��� ���� �����ϴ� ����
}
//	Queue Ŭ����
//	���� ���� ����Ʈ�� ������ Queue Ŭ����
//	���׸� Ÿ���� �޾Ƽ� ť�� ���ҷ� ����� �� �ֵ��� ���ø����� �����Ѵ�.
class Queue<E> {
	Node<E> root;			//	���� ���� ����Ʈ�� �߽� �뵵
	//	������
	//	�����ڿ����� Ŭ���� ������ ������� �ʱ�ȭ�Ѵ�.
	//	���⼭�� ���� ���� ����Ʈ�� �����ϴ� �ٽ� ����� root�� �����Ѵ�.
	Queue() {
		//	1. ���ο� ��带 �����ؼ� root�� ����
		root = new Node();
		//	2. ����ִ� ���� ���� ����Ʈ�� �����ϱ� ���ؼ� root.prev & root.next ��ũ ����
		root.prev = root;
		root.next = root;
	}
	//	ť�� ������ v�� �ϳ� �߰��մϴ�.
	public void add(E v) {
		//	1.	v�� ������ ������ node�� �ϳ� �����մϴ�.
		Node<E> newNode = new Node();
		newNode.value = v;
		//	2. ���� ������ node�� root�� root.next ��忡 �����մϴ�.
		newNode.prev = root;
		newNode.next = root.next;
		//	3. root.next ����� ���� ��带 ���� ������ node�� �մϴ�.
		root.next.prev = newNode;
		//	4. root�� ���� ��带 ���� ������ node�� �մϴ�.
		root.next = newNode;
	}
	//	ť���� �����͸� �����մϴ�.
	public void remove() {
		//	1. ������� �ϴ� ��带 tmp �ӽ� ������ �����մϴ�.
		Node<E> tmp = root.prev;
		//	2. tmp ������ ���� ����� next ���� root�� �����ϰ� �մϴ�.
		tmp.prev.next = root;
		//	3. root�� prev ���� tmp ������ ���� ��带 �����ϰ� �մϴ�.
		root.prev = tmp.prev;
	}
	//	ť���� front ���� ��ȯ�մϴ�.
	public E peek() {
		//	1. root�� ���� ����� ���� ��ȯ�մϴ�.
		return root.prev.value;
	}
	//	ť�� ��������� true�� �׷��� ������ false�� ��ȯ�մϴ�.
	public boolean empty() {
		return root.prev == root;
	}
	//	���Ḯ��Ʈ���� size�� ��ȯŽ���ؼ� ������ �� ������.
	//	��ȯ Ž������� �߻��Ѵ�.
	public int size() {
		int size = 0;
		for(Node<E> t = root.next; t != root; t = t.next) size++;
		return size;
	}
}
public class Main {
	public static void main(String[] args) {
		//	ť ������Ʈ�� �����մϴ�.
		Queue<String> q = new Queue();
		//	ť�� �����͸� �߰��մϴ�.
		q.add("��");
		q.add("��");
		q.add("ȣ����");
		System.out.println("PEEK : "+q.peek());
		System.out.println("EMPTY? "+q.empty());
		q.remove();
		q.remove();
		System.out.println("PEEK : "+q.peek());
		System.out.println("EMPTY? "+q.empty());
		q.add("�䳢");
		System.out.println("PEEK : "+q.peek());
		System.out.println("EMPTY? "+q.empty());
		q.remove();
		q.remove();
		System.out.println("PEEK : "+q.peek());
		System.out.println("EMPTY? "+q.empty());
	}
}


