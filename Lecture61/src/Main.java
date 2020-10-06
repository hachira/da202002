//	자바에서는 객체(오브젝트)를 생성하기 위해서는 객체가 사용할 클래스를 정의해주어야 합니다.
//	클래스는 변수와 함수(메소드)들로 구성이 됩니다.
//	우리가 이미 사용하고 있는 Main 클래스도 객체를 만들 수 있는 클래스입니다.
//	Example 이라는 클래스를 만들어보도록 합니다.
class Example {
	//	클래스 안에 변수도 선언해줄 수 있습니다.
	//	클래스 안에 있는 변수들은 오브젝트마다 서로 저장공간이 달라 독립된 변수들입니다.
	int t;
	//	클래스 이름과 같은 이름의 함수는 생성자라고 합니다.
	//	생성자는 클래스 오브젝트가 생성될 때 자동으로 호출되는 함수입니다.
	//	반환 타입은 없고 이름만 적습니다.
	Example() {
		System.out.println("생성자가 호출되었습니다.");
		t = 0;
	}
	//	함수는 여러개의 파라미터를 둘 수 있습니다.
	//	파라미터는 콤마(,)로 분리되어 나열합니다.
	public void set(int n, int k) {
		t = n*k;
	}
	public void print() {
		System.out.println("현재 t 값은 "+t+"입니다.");
	}
}

//	Stack 자료구조를 사용하기 위해서 Stack이라는 클래스를 제작합니다.
//	Stack은 용도별로 다양하게 사용하기 위해서 템플릿 클래스를 사용합니다.
//	템플릿 클래스는 다양한 변수타입을 클래스 선언할 때 사용하여 하나의 소스를 가지고 다양한 방법의 사용을 제공할 수 
//	있습니다.
//	템플릿 클래스는 클래스 이름 뒤에 < E > 와 같이 꺽시괄호를 이용합니다.
//	템플릿 클래스는 클래스를 사용하는 곳에서 E 대신에 여러가지 변수 타입을 이용해서 해당 클래스를 다양하게 쓸 수 
//	있도록 합니다.  예) 문자열을 담는 스택(Stack<String>), 숫자를 담는 스택(Stack<Integer)).
class Stack<E> {
	//	자바에서 배열을 사용하려면 <변수타입>[] <어레이 변수 이름>; 형태로 선언을 해주어야 합니다.
	E[] data;			//	스택 데이터를 자정할 변수
	int top;			//	스택의 맨 위 데이터를 저장할 변수
	//	생성자
	Stack() {
		//	1. 1024개의 데이터를 저장할 수 있도록 배열 크기를 1024로 잡습니다.
		data = (E[])new Object[1024];
		//	2. top 변수를 -1로 초기화합니다.
		top = -1;
	}
	//	스택에 데이터 v를 넣어주는 함수 push
	public void push(E v) {
		//	1. top 변수를 1 증가시킵니다.
		top++;		//	top = top+1;   top += 1;
		//	2. data 배열에 top 인덱스 위치에 v 값을 저장합니다.
		data[top] = v;
		//	위의 두단계를 한줄에 표현 가능
		//data[++top] = v;
	}
	//	스택에서 최상위 아이템을 제거합니다.
	public void pop() {
		//	0. top가 가르키는 배열값을 null로 저장함으로 해당 데이터가 사라질 수 있게 합니다.
		data[top] = null;
		//	1. top 변수를 1 감소시킵니다.
		top--;
		//	위의 두단계를 한줄에 표현 가능
		//data[top--] = null;
	}
	//	최상위 아이템을 반환합니다.
	public E top() {
		//	1. top 변수의 인덱스의 배열값을 반환합니다.
		return data[top];
	}
	//	스택이 비어있는지 검사한다.
	public boolean empty() {
		//	1. top의 값이 -1이면 true를 반환.  그외엔 false.
		return top == -1;
	}
	public int size() {
		//	1. 스택에 있는 아이템 갯수는 top+1 개가 됨
		return top+1;
	}
}
//	단일 연결 리스트로 스택을 구현합니다.
//	연결리스트는 자료구조로 Node를 사용하기 때문에 Node 클래스를 선언해주어야 합니다.
class Node<E> {
	E value;		//	값을 저장하는 참조형 변수
	Node<E> next;	//	다음 노드를 참조하는 변수
	//	생성자 (주로 초기화 담당)
	Node(E v) { value = v; next = null; }
	//	get next
	public Node<E> getNext() { return next; }
	//	set next
	public void setNext(Node<E> n) { next = n; }
	//	get value
	public E getValue() { return value; }
}
//	단일연결 스택 클래스
class StackL<E> {
	Node<E> head;		//	링크드 리스트의 처음을 참조하는 변수
	StackL() { head = null; }
	public void push(E v) {
		//	1.	새로운 노드를 생성
		Node<E> newNode = new Node(v);
		//	2. 생성한 노드의 다음 노드를 head로 설정
		newNode.setNext(head);
		//	3. head가 참조하는 노드를 newNode로 설정
		head = newNode;
	}
	public void pop() {
		//	1. head가 참조하는 노드의 다음 노드값으로 head값을 바꾼다.
		head = head.getNext();
	}
	public E top() {
		//	1. head가 참조하는 노드의 value 값을 반환한다.
		return head.getValue();
	}
	public int size() {
		//	1. 애석하게도 링크드 리스트를 전부 순회하거나 push, pop할 때, 변수 하나를 증가, 감소시키지
		//	않으면 size를 알기 힘듭니다.
		return 0;
	}
}
public class Main {
	public static void main(String[] args) {
		//	Example 클래스의 객체를 생성하기 위해서는 new라는 키워드를 이용해서 오브젝트를 생성합니다.
		Example obj = new Example();
		//	객체의 함수를 호출하기 위해서는 <객체 이름>.<함수 이름>(); 형태로 합니다.
		obj.set(3, 5);
		obj.print();
		Example obj1 = new Example();
		obj.print();
		obj1.print();
		//	스택 테스트 프로그램
		StackL<String> stack = new StackL();
		stack.push("나팔꽃");
		stack.push("진달래");
		stack.push("국화");
		System.out.println("최상위 아이템 : "+stack.top());
		System.out.println("스택 아이템 갯수 : "+stack.size());
		stack.pop();
		System.out.println("최상위 아이템 : "+stack.top());
		System.out.println("스택 아이템 갯수 : "+stack.size());
		stack.push("개나리");
		System.out.println("최상위 아이템 : "+stack.top());
		System.out.println("스택 아이템 갯수 : "+stack.size());
	}
}
