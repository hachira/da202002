//	Lecture 11
//	�⺻ ���� ���α׷� �ۼ��ϱ�.  (�������� & ��������)
import java.util.Random;		//	random �Լ� ����� ���� ���̺귯��
import java.util.Scanner;		//	Ű���� �Է��� �ϱ� ���� ���̺귯��
public class Main {
	//	�������� �Լ� (v : ������ �迭, n : �迭�� ũ��)
	static void selectionSort(int[] v, int n) {
		//	1. �迭 �ε��� 0���� n-2������ ���ؼ�
		for(int i = 0; i <= n-2; i++) {
			//	2. [i, n-1] ���� �ȿ��� �ּҰ��� ������ �迭 �ε����� ã���ϴ�.
			int min = i;
            for(int j=i+1; j<n; j++) {
                if(v[min]>v[j]) min=j;
            }
			//	3. v[min] �� v[i]�� ���� �¹ٲߴϴ�.
			int tmp = v[min];
			v[min] = v[i];
			v[i] = tmp;
		}
	}
	//	�������� �Լ� (v : ������ �迭, n : �迭�� ũ��)
	static void insertionSort(int[] v, int n) {
		//	1. [1..n-1] ������ ���ؼ� ����
		for(int i = 1; i < n; i++) {
			//	2. v[i] ���� [0..i-1] �迭�� ������ ���� ���� �ִ´�.
			//	2-1. last ���� i������ �ʱ�ȭ�ϰ�, r ������ v[i]���� ����(����)�մϴ�.
			int last = i;
			int r = v[i];
			//	2-2. last ���� 0���� ũ��, v[last-1] �� r ������ ū ���� �� �����۾� ����
			//	2-2-1. v[last-1] ���� ������ �迭������ v[last]�� �̵�
			//	2-2.2. last ���� �ϳ� ����
			while( last > 0 && v[last-1] > r ) {
				v[last] = v[last-1];
				last--;
			}
			//	2-3. v[last]�� r���� ����
			v[last] = r;
		}
	}
	public static void main(String[] args) {
		//	������ ���� �����ϱ� ���Ͽ� Random ������Ʈ�� ����.
		Random rand = new Random(100);
		//	������ �������� ũ�⸦ �Է� �޽��ϴ�.
		System.out.print("Enter the size of array : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		//	ũ�Ⱑ n�� �迭�� �����մϴ�.
		int[] v = new int[n];
		//	ũ�Ⱑ n�� �迭�� ���������� �ֽ��ϴ�.
		for(int i = 0; i < n; i++) {
			v[i] = rand.nextInt(10000);
		}
		//	�ð� ������ ���ؼ� ���� �ð��� �����մϴ�.
		long t = System.currentTimeMillis();
		//	������ �����մϴ�.
		selectionSort(v, n);
		//	�ð� ���� ����� ����մϴ�.
		long elapsed = System.currentTimeMillis()-t;
		System.out.println("Elapsed : " + elapsed + "ms");
		//	�����Ϳ� �°� ���ĵǾ��µ� ���� 20���� �����͸� ����մϴ�.
		for(int i = 0; i < 20; i++) {
			System.out.print(v[i]+" ");
		}
	}
}
