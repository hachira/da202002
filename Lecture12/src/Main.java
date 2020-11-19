//	Lecture 12 Merge Sort Programming
//	��������(Divide and Conquer) ����� �̿��� �պ�����(Merge Sort) ���α׷��� �ۼ��غ��ϴ�.
import java.util.Scanner;		//	�Է�ó���� ���� ���
import java.util.Random;		//	�������� ������ ���� ���
public class Main {
	//	���������� ���� �Լ�
	static void selectionSort(int[] v, int n) {
		selectionSort(v, 0, n-1);
	}
	//	�������� ������ ���� �Լ� v[a]~v[b] �迭 ��������� �����մϴ�.
	static void selectionSort(int[] v, int a, int b) {
		for(int i=a;i<b;i++) {
			int min = i;
			for(int j=i+1;j<=b;j++) {
				if(v[min]>v[j]) min=j;
			}
			int t = v[i]; v[i] = v[min]; v[min] = t;
		}
	}
	//	�迭�� ��ĥ�� �ӽ÷� ����� �迭
	static int[] tv;
	//	�պ������� ���ؼ� ���� �迭�� ���� �迭�� ��ġ�� ����
	//	v : �ΰ��� ���������� ���ĵ� �迭
	//	v[a]~v[c] : ���ĵ� ���ݺ� �迭
	//	v[c+1]~v[b] : ���ĵ� �Ĺݺ� �迭
	static void merge(int[] v, int a, int b, int c) {
		//	1. �迭�� ���ݺθ� Ž���� ����, �迭�� �Ĺݺθ� Ž���� ����, ������ �ӽ� �迭�� ������ ������ �ʱ�ȭ�մϴ�.
		int i = a, j = c+1, k = a;
		//	2. ���ݺ� �迭���� �Ĺݺ� �迭���� ���ؼ� �ӽ� �迭�� �����մϴ�.
		while(i<=c && j<=b) {
			if(v[i]<v[j]) tv[k++] = v[i++];
			else tv[k++] = v[j++];
		}
		//	3. ¥���� �迭������ �ӽ� �迭�� �����մϴ�.
		while(i<=c) tv[k++] = v[i++];
		while(j<=b) tv[k++] = v[j++];
		//	4. �ӽ� �迭 ������ v �迭�� �����մϴ�.
		for(i=a;i<=b;i++) v[i]=tv[i];
	}
	//	���������� ���� �Լ�
	static void mergeSort(int[] v, int n) {
		//	�ӽ� ���� �迭�� ���⼭ �Ҵ��մϴ�.
		tv = new int[n];
		mergeSort(v, 0, n-1);
	}
	//	�պ����� ������ ���� �Լ�.  v[a]~v[b] �迭 ���밡�� ����
	static void mergeSort(int[] v, int a, int b) {
		//	0. v[a]~v[b] ������ �ִ� �迭 ������ ������ 1�� ������ ���� ���� ���ʿ�
		if(a>=b) return;
		//	1. �߾Ӱ��� ã���ϴ�.
		int c = (a+b)/2;
		//	2. ���ݺ� �迭�� �Ĺݺ� �迭�� ���� �����մϴ�.
		mergeSort(v, a, c);
		mergeSort(v, c+1, b);
		//	3. ���ĵ� �ΰ��� �迭�� ��Ĩ�ϴ�.
		merge(v, a, b, c);
	}
	public static void main(String[] args) {
		//	������ �������� ������ �Է¹޽��ϴ�.
		Scanner scan = new Scanner(System.in);
		System.out.print("�������� ���� �Է� : ");
		int n = scan.nextInt();
		
		//	������ �����͸� ������ �迭�� �Ҵ��մϴ�.
		//	�迭�� �������� ���豺 �ΰ����� ������� �մϴ�.
		//	�������� �̹� �˰� �ִ� �˰������� ó���ؼ� ����� �����ϰ�,
		//	���豺�� ���ο� �˰������� ó���ؼ� ����� �����մϴ�.
		//	�������� ���豺�� ó���� �ð� ��, ��� �񱳸� �մϴ�.
		int[] v1 = new int[n];
		int[] v2 = new int[n];
		
		//	���������� �߻����Ѽ� �迭�� �����մϴ�.
		Random r = new Random(1000);
		for(int i = 0; i < n; i++) v1[i] = v2[i] = r.nextInt(1000000);
		
		//	���������� �̿��Ͽ� ������ �մϴ�.
		long t1 = System.currentTimeMillis();
		selectionSort(v1, n);
		t1 = System.currentTimeMillis()-t1;
		
		//	�պ������� �̿��Ͽ� ������ �մϴ�.
		long t2 = System.currentTimeMillis();
		mergeSort(v2, n);
		t2 = System.currentTimeMillis()-t2;
		
		System.out.println("�������� : "+t1+"ms");
		System.out.println("�պ����� : "+t2+"ms");
		
		//	�����Ͱ� �ùٸ��� �˻��մϴ�.
		boolean isValid = true;
		for(int i=0; i<n; i++) if(v1[i]!=v2[i]) { isValid=false; break; }
		System.out.println(isValid?"�ùٸ� ���� ���":"�߸��� ���� ���");
	}
}
