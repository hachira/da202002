//	Node 클래스
//	value 값을 가지고, prev, next 레퍼런스 변수를 가지고, 이중 연결 리스트를 구성하는 자료구조
class Node<E> {
	public E value;			//	데이터 값을 저장하는 변수
	public Node<E> prev;	//	이전 노드 값을 참조하는 변수
	public Node<E> next;	//	이후 노드 값을 참조하는 변수
}
//	Queue 클래스
//	이중 연결 리스트로 구성된 Queue 클래스
//	제네릭 타입을 받아서 큐의 원소로 사용할 수 있도록 템플릿으로 구성한다.
class Queue<E> {
	Node<E> root;			//	이중 연결 리스트의 중심 노도
	//	생성자
	//	생성자에서는 클래스 변수의 내용들을 초기화한다.
	//	여기서는 이중 연결 리스트를 구성하는 핵심 요소인 root를 구성한다.
	Queue() {
		//	1. 새로운 노드를 생성해서 root에 저장
		root = new Node();
		//	2. 비어있는 이중 연결 리스트를 구성하기 위해서 root.prev & root.next 링크 연결
		root.prev = root;
		root.next = root;
	}
	//	큐에 데이터 v를 하나 추가합니다.
	public void add(E v) {
		//	1.	v를 값으로 가지는 node를 하나 생성합니다.
		Node<E> newNode = new Node();
		newNode.value = v;
		//	2. 새로 생성된 node를 root와 root.next 노드에 연결합니다.
		newNode.prev = root;
		newNode.next = root.next;
		//	3. root.next 노드의 이전 노드를 새로 생성한 node로 합니다.
		root.next.prev = newNode;
		//	4. root의 다음 노드를 새로 생성한 node로 합니다.
		root.next = newNode;
	}
	//	큐에서 데이터를 삭제합니다.
	public void remove() {
		//	1. 지우고자 하는 노드를 tmp 임시 변수에 저장합니다.
		Node<E> tmp = root.prev;
		//	2. tmp 변수의 이전 노드의 next 값을 root를 참조하게 합니다.
		tmp.prev.next = root;
		//	3. root의 prev 값을 tmp 변수의 이전 노드를 참조하게 합니다.
		root.prev = tmp.prev;
	}
	//	큐에서 front 값을 반환합니다.
	public E peek() {
		//	1. root의 이전 노드의 값을 반환합니다.
		return root.prev.value;
	}
	//	큐가 비어있으면 true를 그렇지 않으면 false를 반환합니다.
	public boolean empty() {
		return root.prev == root;
	}
	//	연결리스트에서 size를 순환탐색해서 가져올 수 있지만.
	//	순환 탐색비용이 발생한다.
	public int size() {
		int size = 0;
		for(Node<E> t = root.next; t != root; t = t.next) size++;
		return size;
	}
}
public class Main {
	public static void main(String[] args) {
		//	큐 오브젝트를 생성합니다.
		Queue<String> q = new Queue();
		//	큐에 데이터를 추가합니다.
		q.add("쥐");
		q.add("소");
		q.add("호랑이");
		System.out.println("PEEK : "+q.peek());
		System.out.println("EMPTY? "+q.empty());
		q.remove();
		q.remove();
		System.out.println("PEEK : "+q.peek());
		System.out.println("EMPTY? "+q.empty());
		q.add("토끼");
		System.out.println("PEEK : "+q.peek());
		System.out.println("EMPTY? "+q.empty());
		q.remove();
		q.remove();
		System.out.println("PEEK : "+q.peek());
		System.out.println("EMPTY? "+q.empty());
	}
}


