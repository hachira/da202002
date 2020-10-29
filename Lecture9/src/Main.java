//	Queue 자료구조 클래스를 만듭니다.
class Queue<E> {
	int front;		//	큐에서 데이터를 읽거나 삭제하는 위치(인덱스)를 저장
	int rear;		//	큐에서 데이터를 추가할 위치를 저장
	E[] data;		//	큐의 데이터를 저장할 데이터 배열
	int size;		//	큐에 저장할 수 있는 최대 개수를 저장
	//	생성자입니다.
	//	생성자가 하는 역할은 변수의 초기화와 배열변수 할당이 있습니다.
	Queue() {
		//	1. front와 rear값을 0으로 초가화합니다.
		front = rear = 0;
		size = 1000;
		//	2. data 배열 변수에 size 개의 데이터를 할당합니다.
		data = (E[]) new Object[size];
	}
	//	큐에 데이터를 추가하는 함수입니다.
	//	v라는 인자값을 받아서 큐 자료구조에 v를 추가합니다.
	public void add(E v) {
		//	1. rear값에 해당하는 배열 공간에  v값을 저장합니다.
		data[rear] = v;
		//	2. rear값을 1 증가합니다.
		//		rear가 배열의 끝인 경우 맨 앞(인덱스 0)으로 돌려주어야합니다.
		//		이것을 간단하게 해결하기 위해서 나머지 연산자 %를 사용합니다.
		rear = (rear+1)%size;
	}
	//	큐에서 데이터를 삭제하는 함수입니다.
	//	큐 자료구조에서 front가 가르키는 원소의 데이터를 삭제합니다.
	public void remove() {
		//	1. front값에 해당하는 배열 공간에 null 값을 저장합니다.
		data[front] = null;
		//	2. front 값을 1 증가합니다.
		//		add() 함수의 경우와 같이 인덱스 순환을 하도록 합니다.
		front = (front+1)%size;
	}
	//	큐에서 front가 가르키는 원소의 데이터를 반환합니다.
	public E peek() {
		//	1. front값이 가르키는 배열값을 반환합니다.
		return data[front];
	}
	//	큐가 비어있으면 true를 그렇지 않으면 false를 반환합니다.
	public boolean empty() {
		//	1. front값과 rear값이 같은지 검사합니다.
		return front == rear;
	}
	//	큐에 데이터의 개수를 반환합니다.
	public int size() {
		//	1. rear에서 front값을 뺀 값을 반환합니다.
		//if(rear < front) return rear+size-front;
		//return rear-front;
		//	2. Mr. Oh's Method.
		//return rear+size*(int)(rear<front)-front;
		//	3. % 연산자 연산자를 사용하는 방법
		return (rear-front+size)%size;  //<><>
	}
}

public class Main {
	public static void main(String[] args) {
		//	큐 오브젝트 생성
		Queue<String> q = new Queue();
		
		q.add("사과");
		q.add("오렌지");
		q.add("수박");
		System.out.println("큐의 PEEK : "+q.peek());
		System.out.println("큐의 EMPTY? "+q.empty());
		System.out.println("큐의 SIZE : "+q.size());
		q.remove();
		System.out.println("큐의 PEEK : "+q.peek());
		System.out.println("큐의 EMPTY? "+q.empty());
		System.out.println("큐의 SIZE : "+q.size());
		q.add("자몽");
		System.out.println("큐의 PEEK : "+q.peek());
		System.out.println("큐의 EMPTY? "+q.empty());
		System.out.println("큐의 SIZE : "+q.size());
		q.remove();
		q.remove();
		q.remove();
		System.out.println("큐의 PEEK : "+q.peek());
		System.out.println("큐의 EMPTY? "+q.empty());
		System.out.println("큐의 SIZE : "+q.size());
	}
}
