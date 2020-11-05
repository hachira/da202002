//	Lecture 10-2 �似Ǫ�� ���� Ǯ��
import java.util.Scanner;
public class Main {
	//	�似Ǫ�� �Է� n, k�� �̿��Ͽ�, (n, k) �似Ǫ�� ������ ����մϴ�.
	static void Josepus(int n, int k) {
		//	Queue Ŭ������ ���� �ۼ����� �ʰ� ���α׷� �ȿ��� ���������� �ۼ���� �մϴ�.
		int[] queue = new int[1000000];
		//	Queue���� ����� head�� tail ������ 0���� �ʱ�ȭ�մϴ�.
		int head = 0, tail = 0;
		//	Queue���� ������ �۾��� ���� �����մϴ�.
		//	add(v)
		//	queue[tail] = v; tail = (tail+1)%1000000;
		//	remove()
		//	head = (head+1)%1000000
		//	peek()
		//	queue[head]
		//	empty()?
		//	head == tail?
		
		//	1. 1..n������ ���ڸ� Queue�� �߰��Ѵ�.
		for(int i = 1; i <= n; i++) {
			queue[tail] = i;				//	add(i)
			tail = (tail+1)%1000000;
		}
		
		//	�ð����⵵ ������ ���ؼ� �߿��� �۾� count�� �ϵ��� �մϴ�.
		int count = 0;
		//	2. ť�� ����������� ��, �۾��� �����մϴ�.
		while( head != tail ) {
			//	2-1. k-1���� �����͸� ť���� ������ �ٽ� ť�� �߰��Ѵ�.
			for(int i = 1; i <= k-1; i++ ) {
				int v = queue[head];		//	peek()
				head = (head+1)%1000000;	//	remove()
				queue[tail] = v;			//	add(v)
				tail = (tail+1)%1000000;
				count++;
			}
			
			//	2-2. 1���� �����͸� ť���� ������ �ش� �����͸� ����Ѵ�.
			int v = queue[head];			//	peek()
			head = (head+1)%1000000;		//	remove()
			System.out.println(v);
			count++;
		}
		System.out.println("count = "+count);
	}
	public static void main(String[] args) {
		//	�Է��� �ޱ����� scanner ������Ʈ ����
		Scanner scan = new Scanner(System.in);
		//	n�� k �Է�
		System.out.print("n, k�� �Է��ϼ��� : ");
		int n = scan.nextInt();
		int k = scan.nextInt();
		//	�ۼ��� �似���� �Լ��� �����մϴ�.
		Josepus(n, k);
	}

}
