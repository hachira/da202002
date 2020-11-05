//	Lecture 10-2 요세푸스 문제 풀기
import java.util.Scanner;
public class Main {
	//	요세푸스 입력 n, k를 이용하여, (n, k) 요세푸스 수열을 출력합니다.
	static void Josepus(int n, int k) {
		//	Queue 클래스를 따로 작성하지 않고 프로그램 안에서 간이형으로 작성토록 합니다.
		int[] queue = new int[1000000];
		//	Queue에서 사용할 head와 tail 변수를 0으로 초기화합니다.
		int head = 0, tail = 0;
		//	Queue에서 같같의 작업은 직접 구현합니다.
		//	add(v)
		//	queue[tail] = v; tail = (tail+1)%1000000;
		//	remove()
		//	head = (head+1)%1000000
		//	peek()
		//	queue[head]
		//	empty()?
		//	head == tail?
		
		//	1. 1..n까지의 숫자를 Queue에 추가한다.
		for(int i = 1; i <= n; i++) {
			queue[tail] = i;				//	add(i)
			tail = (tail+1)%1000000;
		}
		
		//	시간복잡도 예측을 위해서 중요한 작업 count를 하도록 합니다.
		int count = 0;
		//	2. 큐가 비어있지않은 한, 작업을 수행합니다.
		while( head != tail ) {
			//	2-1. k-1개의 데이터를 큐에서 빼내고 다시 큐에 추가한다.
			for(int i = 1; i <= k-1; i++ ) {
				int v = queue[head];		//	peek()
				head = (head+1)%1000000;	//	remove()
				queue[tail] = v;			//	add(v)
				tail = (tail+1)%1000000;
				count++;
			}
			
			//	2-2. 1개의 데이터를 큐에서 빼내고 해당 데이터를 출력한다.
			int v = queue[head];			//	peek()
			head = (head+1)%1000000;		//	remove()
			System.out.println(v);
			count++;
		}
		System.out.println("count = "+count);
	}
	public static void main(String[] args) {
		//	입력을 받기위한 scanner 오브젝트 생성
		Scanner scan = new Scanner(System.in);
		//	n과 k 입력
		System.out.print("n, k를 입력하세요 : ");
		int n = scan.nextInt();
		int k = scan.nextInt();
		//	작성된 요세프수 함수를 실행합니다.
		Josepus(n, k);
	}

}
